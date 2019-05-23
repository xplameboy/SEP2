package server;

import DataModel.CarList;
import DataModel.ReservationList;
import database.Database;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class ServerModel implements IServerModel{

    Database database;

    public ServerModel() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 1099);
        database = new Database();
    }

    @Override
    public void addCar(String registration, String make, int mileage, String color, int productionYear, int availability) throws RemoteException {
        database.addCar(registration, make, mileage, color, productionYear, availability);
    }

    @Override
    public void deleteCar(String carRegistrationNumber) throws RemoteException{
        database.deleteCar(carRegistrationNumber);
    }

    @Override
    public CarList getCars() throws RemoteException {
        return database.getCars();
    }

    @Override
    public void addReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) throws RemoteException {
        database.addReservation(reservationId, carRegNo, username, dateFrom, dateTo, navigation, childseat, firstName, lastName, age, price, insurance, status);
    }

    @Override
    public void deleteReservation(String reservationId) throws RemoteException {
        database.deleteReservation(reservationId);
    }

    @Override
    public ReservationList getReservations() throws RemoteException {
        return database.getReservations();
    }

    @Override
    public void addCustomer(String username, String password) {
        database.addCustomer(username, password);
    }
}
