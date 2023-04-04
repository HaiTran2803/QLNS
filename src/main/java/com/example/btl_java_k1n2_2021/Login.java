package com.example.btl_java_k1n2_2021;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class Login {
    public TextField username;
    public TextField pass;
    public void SceneLogin(ActionEvent actionEvent) throws Exception {
        try {
            if (username.getText().equals("hai") && pass.getText().equals("2803")) {
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu-view.fxml")));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Tài khoản và mật khẩu không đúng, vui lòng kiểm tra lại");
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void SceneCancel(ActionEvent actionEvent) {
        System.exit(0);
    }
}
