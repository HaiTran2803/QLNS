package com.example.btl_java_k1n2_2021;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    @FXML
    public TableColumn<Customer,String> iDcolumn;
    @FXML
    public TableColumn<Customer,String> namecolumn;
    @FXML
    public TableColumn<Customer,String> emailcolumn;
    @FXML
    public TableColumn<Customer,String> phonecolumn;
    @FXML
    public TextField idText;
    @FXML
    public TextField nameText;
    @FXML
    public TextField emailText;
    @FXML
    public TextField phoneText;
    @FXML
    private TableView<Customer> tableView = new TableView<Customer>();
    @FXML
    ObservableList<Customer> ListCust = FXCollections.observableArrayList();
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iDcolumn.setCellValueFactory(new PropertyValueFactory<>("identity"));
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        emailcolumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phonecolumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        tableView.setItems(ListCust);
        tableView.setOnMouseClicked(mouseEvent -> {
            Customer x= tableView.getSelectionModel().getSelectedItem();
            idText.setText(x.getIdentity());
            nameText.setText(x.getCustomerName());
            emailText.setText(x.getEmail());
            phoneText.setText(x.getPhoneNumber());
        });
    }
    @FXML
    public void BookingCus(ActionEvent e){
        Customer newCus = new Customer();
        newCus.setIdentity((idText.getText()));
        newCus.setCustomerName(nameText.getText());
        newCus.setEmail(emailText.getText());
        newCus.setPhoneNumber(phoneText.getText());
        if(idText.getText().equals("") || nameText.getText().equals("")||emailText.getText().equals("") || phoneText.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Thông tin cảnh báo");
            alert.setContentText("Nhập sai!");
            alert.show();
        }
        else {
            ListCust.add(newCus);
            idText.setText("");
            nameText.setText("");
            emailText.setText("");
            phoneText.setText("");
            resetText();
            write();
        }
    }
    public void EditCus(ActionEvent e){
        Customer resetcus = tableView.getSelectionModel().getSelectedItem();
        resetcus.setIdentity(idText.getText());
        resetcus.setCustomerName(nameText.getText());
        resetcus.setEmail(emailText.getText());
        resetcus.setPhoneNumber(phoneText.getText());
        ListCust.set(ListCust.indexOf(resetcus),resetcus);
        resetText();
    }
    public void CheckOutCus(ActionEvent e){
        Customer x= tableView.getSelectionModel().getSelectedItem();
        ListCust.remove(x);
        idText.setText("");
        nameText.setText("");
        emailText.setText("");
        phoneText.setText("");
        resetText();
    }
    public void write() {
        try {
            WRITE(ListCust);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void WRITE(ObservableList<Customer> listCustomers) throws IOException {
        FileWriter write = new FileWriter("Cus.dat");
        for (Customer staff : listCustomers) {
            write.write(staff.getIdentity() + "," + staff.getCustomerName() + "," + staff.getEmail() + "," + staff.getPhoneNumber() + "\n");
        }
        write.close();
    }
    private void resetText() {
        idText.setText("");
        nameText.setText("");
        emailText.setText("");
        phoneText.setText("");
    }
    public void CustomeronBack(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Menu-view.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void StopProgram(){
        System.exit(0);
    }
    /*private static List<Customer> readCustomer(String filename) throws IOException {
        List<Customer> Customerlist = new ArrayList<>();
        String temp;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Cus.dat")));
        while ((temp = reader.readLine()) != null) {
            String[] s = temp.split(",");
            Customerlist.add(new Customer(s[0], s[1], s[2], s[3]));
        }
        return Customerlist;
    }
    public List<Customer> readList() {
        List<Customer> inputEmp = null;
        try {
            inputEmp = readCustomer("Cus.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputEmp;
    }*/
}