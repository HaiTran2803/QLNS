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
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    public TableColumn<Room,String> roomColumn;
    @FXML
    public TableColumn<Room,Integer> numberOfBedColumn;
    @FXML
    public TextField idRoomText;
    @FXML
    public TextField NOBText;
    @FXML
    private TableView<Room> TableRoomView = new TableView<Room>();
    @FXML
    ObservableList<Room> ListRooms = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomColumn.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        numberOfBedColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfBed"));
        TableRoomView.setItems(ListRooms);
        TableRoomView.setOnMouseClicked(mouseEvent -> {
            Room newroom = TableRoomView.getSelectionModel().getSelectedItem();
            idRoomText.setText(newroom.getRoomId());
            NOBText.setText(String.valueOf(newroom.getNumberOfBed()));
        });
    }
    public void AddRoom(ActionEvent actionEvent) {
        Room newRoom = new Room();
        newRoom.setRoomId(idRoomText.getText());
        newRoom.setNumberOfBed(Integer.parseInt(NOBText.getText()));
        if(idRoomText.getText().equals("") || NOBText.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Thông tin cảnh báo");
            alert.setContentText("Nhập sai!");
            alert.show();
        }
        else {
            ListRooms.add(newRoom);
            idRoomText.setText("");
            NOBText.setText("");
            resetroomText();
            write();
        }
    }
    public void EditRoom(ActionEvent actionEvent) {
        Room resetroom= TableRoomView.getSelectionModel().getSelectedItem();
        resetroom.setRoomId(idRoomText.getText());
        resetroom.setNumberOfBed(Integer.parseInt(NOBText.getText()));
        ListRooms.set(ListRooms.indexOf(resetroom),resetroom);
        resetroomText();
    }
    public void RemoveRoom(ActionEvent actionEvent){
        Room x= TableRoomView.getSelectionModel().getSelectedItem();
        ListRooms.remove(x);
        idRoomText.setText("");
        NOBText.setText("");
        resetroomText();
    }
    public void RoomonBack(ActionEvent actionEvent) throws IOException {
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
    private void resetroomText() {
        idRoomText.setText("");
        NOBText.setText("");
    }
    public void write() {
        try {
            WRITE("Room.dat", ListRooms);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void WRITE(String filename, ObservableList<Room> listRooms) throws IOException {
        FileWriter write = new FileWriter(filename);
        for (Room wr : listRooms) {
            write.write(wr.getRoomId() + "," + wr.getNumberOfBed()  + "\n");
        }
        write.close();
    }
    public void StopProgram(){
        System.exit(0);
    }

}

