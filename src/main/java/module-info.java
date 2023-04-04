module com.example.btl_java_k1n2_2021 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.btl_java_k1n2_2021 to javafx.fxml;
    exports com.example.btl_java_k1n2_2021;
}