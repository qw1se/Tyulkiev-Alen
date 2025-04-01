module org.example.homeworknumber1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;


    opens org.example.homeworknumber1 to javafx.fxml;
    exports org.example.homeworknumber1;
}