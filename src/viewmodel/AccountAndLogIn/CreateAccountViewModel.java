package viewmodel.AccountAndLogIn;

import DataModel.Customer;
import Model.Customer.CustomerModel;
import view.ViewHandler;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;

public class CreateAccountViewModel {
    private ViewHandler viewHandler;
    private CustomerModel model;
    private Customer customer;

    public CreateAccountViewModel(ViewHandler viewHandler, CustomerModel model){
        this.viewHandler = viewHandler;
        this.model = model;
    }
    public void openCreateAccountAndLogIn() throws IOException {
        viewHandler.openCreateAccountAndLogIn();
    }

    public void createAccount(String username, String password, String firstName, String lastName, Date dateOfBirth) throws RemoteException {
        model.createAccount(username, password, firstName, lastName, dateOfBirth);
    }

    public void openEmptyTextFields() {
        viewHandler.openEmptyTextFields();
    }
}
