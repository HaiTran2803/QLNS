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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookingController implements Initializable {
    @FXML
    public TableColumn<Booking,String> roomColumn;
    @FXML
    public TableColumn<Booking,Integer> numberOfBedColumn;
    @FXML
    public TableColumn<Booking,String> iDcolumn;
    @FXML
    public TableColumn<Booking,String> namecolumn;
    @FXML
    public TableColumn<Booking,String> emailcolumn;
    @FXML
    public TableColumn<Booking,String> phonecolumn;
    @FXML
    public TextField idRoomText;
    @FXML
    public TextField NOBText;
    @FXML
    public TextField idText;
    @FXML
    public TextField nameText;
    @FXML
    public TextField emailText;
    @FXML
    public TextField phoneText;
    @FXML
    private TableView<Booking> BookingView = new TableView<Booking>();
    ObservableList<Booking> ListBooking = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomColumn.setCellValueFactory(new PropertyValueFactory<>("ID Room"));
        numberOfBedColumn.setCellValueFactory(new PropertyValueFactory<>("NOB"));
        iDcolumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        emailcolumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
        phonecolumn.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        BookingView.setItems(ListBooking);
        BookingView.setOnMouseClicked(mouseEvent -> {
            Booking x= BookingView.getSelectionModel().getSelectedItem();

        });
    }

}

