package view.CreateAccountAndLogIn;

import DataModel.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.ViewHandler;
import viewmodel.AccountAndLogIn.CreateAccountViewModel;
import viewmodel.ViewModelProvider;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CreateAccountView {

    private CreateAccountViewModel viewModel;
    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private DatePicker dateOfBirthField;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void createAccount(ActionEvent event) throws IOException {
        if(dateOfBirthField.getValue().equals(null) || nameField.getText().equals("")|| surnameField.getText().equals("")||
        loginField.getText().equals("") || passwordField.getText().equals("")){
            viewModel.openEmptTextFields();
        }
        LocalDate localDate = dateOfBirthField.getValue();
        Date birthdate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(birthdate);
        System.out.println(nameField.getText());
        System.out.println(surnameField.getText());
        System.out.println(loginField.getText());
        System.out.println(passwordField.getText());

        viewModel.createAccount(loginField.getText(), passwordField.getText(), nameField.getText(), surnameField.getText(), birthdate);
        viewModel.openCreateAccountAndLogIn();
    }

    public void init(CreateAccountViewModel createAccountViewModel) {
        this.viewModel = createAccountViewModel;
    }

}
