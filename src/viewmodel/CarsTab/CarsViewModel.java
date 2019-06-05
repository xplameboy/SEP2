package viewmodel.CarsTab;

import DataModel.Car;
import DataModel.CarList;
import Model.Employee.EmployeeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.ViewHandler;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;

public class CarsViewModel {

    private EmployeeModel model;
    private ObservableList<Car> cars;
    private ViewHandler viewHandler;

    public CarsViewModel (ViewHandler viewHandler,EmployeeModel model) throws RemoteException {
        cars = FXCollections.observableArrayList();

        this.model = model;
        this.viewHandler = viewHandler;

        getCars();

        model.addListener("CarsUpdated", this::updateCarsList);
    }

    private void updateCarsList(PropertyChangeEvent propertyChangeEvent) {
        cars.clear();

        System.out.println("updated");

        CarList reservationList = (CarList) propertyChangeEvent.getNewValue();

        for (int i = 0; i <reservationList.size(); i++) {
            Car temp = reservationList.getCar(i);
            cars.add(temp);
        }
    }

    private void getCars() {
        try {
            for (int i = 0; i < model.getCars().size(); i++) {
                Car temp = model.getCars().getCar(i);
                cars.add(temp);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(String registrationNumber) throws RemoteException {
        cars.remove(getCarIndex(registrationNumber));
        model.deleteCar(registrationNumber);
        System.out.println("Item deleted");
    }

    public void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException {
        cars.get(getCarIndex(registrationNumber)).setMileage(mileage);
        cars.get(getCarIndex(registrationNumber)).setPrice(price);
        cars.get(getCarIndex(registrationNumber)).setAvailability(availability);
        model.editCar(registrationNumber, mileage, price, availability);
        System.out.println("Item edited");
    }

    public void carAdded(PropertyChangeEvent evt){
        cars.add((Car) evt.getNewValue());
    }

    public void carDeleted(PropertyChangeEvent evt){
        cars.remove((Car) evt.getNewValue());
    }

    public void carEdited(PropertyChangeEvent evt){

    }


    public ObservableList<Car> getCarList() {
        return FXCollections.unmodifiableObservableList(cars);
    }

    public int getCarIndex(String registrationNumber) throws RemoteException {
        System.out.println("The value is: " + model.getCar(registrationNumber));
        for (int i = 0; i < model.getCars().size(); i++) {
            System.out.println(model.getCars().getCar(i));
            if(model.getCar(registrationNumber).getRegistrationNumber().equals(model.getCars().getCar(i).getRegistrationNumber()))
                return i;
        }

        return -1;
    }

    public void openCarDeleted() {
        viewHandler.openCarDeleted();
    }
}
