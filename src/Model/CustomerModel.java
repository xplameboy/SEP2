package Model;

import DataModel.Customer;
import DataModel.ReservationList;
import Employee_Client.Client;
import Employee_Client.CustomerClient;

import java.util.Date;

public interface CustomerModel {

    void setClient(CustomerClient client);

    void createAccount(String username, String password, String firstName, String lastName, Date dateOfBirth);

    void logIn(String username, String password);

    void makeReservation();

    void deleteReservation();

    void changeUserData();

    ReservationList viewReservations();

}
