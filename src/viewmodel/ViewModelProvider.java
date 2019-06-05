package viewmodel;



import Model.*;
import Model.Customer.CustomerModel;
import Model.Employee.EmployeeModel;
import view.ViewHandler;
import viewmodel.AccountAndLogIn.CreateAccountAndLogInViewModel;
import viewmodel.AccountAndLogIn.CreateAccountViewModel;
import viewmodel.AccountAndLogIn.LogInViewModel;
import viewmodel.AccountTab.AccountViewModel;
import viewmodel.AccountTab.LogOutViewModel;
import viewmodel.CarsTab.AddCarViewModel;
import viewmodel.CarsTab.CarsViewModel;

import viewmodel.MakeReservationTab.MakeReservationViewModel;
import viewmodel.ReservationsTab.ReservationsViewModel;
import viewmodel.UsersTab.UsersViewModel;
import viewmodel.ViewReservationsTab.ViewReservationsViewModel;

import java.io.Serializable;
import java.rmi.RemoteException;

public class ViewModelProvider implements Serializable {

    private LogInViewModel logInViewModel;
    private CreateAccountAndLogInViewModel createAccountAndLogInViewModel;
    private CreateAccountViewModel createAccountViewModel;
    private AddCarViewModel addCarViewModel;
    private CarsViewModel carsViewModel;
    private AccountViewModel accountViewModel;
    private MakeReservationViewModel makeReservationViewModel;
    private ReservationsViewModel reservationsViewModel;
    private UsersViewModel usersViewModel;
    private ViewReservationsViewModel viewReservationsViewModel;
    private LogOutViewModel logOutViewModel;

    private CustomerModel cm;
    private EmployeeModel em;
    private ModelProvider modelProvider;

    public ViewModelProvider(ModelProvider modelProvider) {
        this.modelProvider = modelProvider;
        cm = modelProvider.getCustomerModel();
        em = modelProvider.getEmployeeModel();
    }

    public void instantiateLogInViewModel(ViewHandler viewHandler) {
        if (logInViewModel == null) {
            logInViewModel = new LogInViewModel(viewHandler, cm);
        }
    }
    public void instantiateLogOutViewModel(ViewHandler viewHandler){
        if(logOutViewModel == null){
            logOutViewModel = new LogOutViewModel(viewHandler);
        }
    }

    public void instantiateCreateAccountAndLogInViewModel(ViewHandler viewHandler) {
        if (createAccountAndLogInViewModel == null) {
            createAccountAndLogInViewModel = new CreateAccountAndLogInViewModel(viewHandler);
        }
    }

    public void instantiateCreateAccountViewModel(ViewHandler viewHandler) {
        if (createAccountViewModel == null) {
            createAccountViewModel = new CreateAccountViewModel(viewHandler, cm);
        }
    }

    public void instantiateAddCarViewModel(ViewHandler viewHandler) {
        if (addCarViewModel == null) {
            addCarViewModel = new AddCarViewModel(viewHandler,em);
        }
    }

    public void instantiateCarsViewModel(ViewHandler viewHandler) throws RemoteException {
        if (carsViewModel == null) {
            carsViewModel = new CarsViewModel(viewHandler,em);
        }
    }

    public void instantiateAccountViewModel(ViewHandler viewHandler) {
        if (accountViewModel == null) {
            accountViewModel = new AccountViewModel(viewHandler, cm);
        }
        accountViewModel.setUserName(logInViewModel.getUsername());
    }


    public void instantiateMakeReservationViewModel(ViewHandler viewHandler) throws RemoteException {
        if (makeReservationViewModel == null) {
            makeReservationViewModel = new MakeReservationViewModel(viewHandler, cm);
        }
        makeReservationViewModel.setUserName(logInViewModel.getUsername());
    }

    public void instantiateReservationsViewModel(ViewHandler viewHandler) throws RemoteException {
        if (reservationsViewModel == null) {
            reservationsViewModel = new ReservationsViewModel(viewHandler,em);
        }
    }

    public void instantiateUsersViewModel() throws RemoteException {
        if (usersViewModel == null) {
            usersViewModel = new UsersViewModel(em);
        }
    }

    public void instantiateViewReservationsViewModel(ViewHandler viewHandler) throws RemoteException {
        if (viewReservationsViewModel == null) {
            viewReservationsViewModel = new ViewReservationsViewModel(viewHandler,cm);
        }
    }


    public LogInViewModel getLogInViewModel() {
        return logInViewModel;
    }

    public CreateAccountAndLogInViewModel getCreateAccountAndLogInViewModel() {
        return createAccountAndLogInViewModel;
    }

    public CreateAccountViewModel getCreateAccountViewModel() {
        return createAccountViewModel;
    }

    public AddCarViewModel getAddCarViewModel() {
        return addCarViewModel;
    }

    public CarsViewModel getCarsViewModel() {
        return carsViewModel;
    }

    public AccountViewModel getAccountViewModel() {
        return accountViewModel;
    }

    public MakeReservationViewModel getMakeReservationViewModel() {
        return makeReservationViewModel;
    }

    public ReservationsViewModel getReservationsViewModel() {
        return reservationsViewModel;
    }

    public UsersViewModel getUsersViewModel() {
        return usersViewModel;
    }

    public ViewReservationsViewModel getViewReservationsViewModel() {
        return viewReservationsViewModel;
    }

    public LogOutViewModel getLogOutViewModel() {
        return logOutViewModel;
    }

}

