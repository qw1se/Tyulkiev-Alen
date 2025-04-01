package org.example.homeworknumber1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        Button button = new Button("Загрузите файл");
        root.getChildren().add(button);

        button.setOnAction(e ->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel", "*.xlsx", "*.xls"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            try{
                readExcelFile(selectedFile);
            }catch (IOException | InvalidFormatException ex){
                ex.printStackTrace();

            }

        });

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static void readExcelFile(File file) throws IOException, InvalidFormatException {
        //Логика чтения Excel
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        for(int i = 0; i <= sheet.getLastRowNum(); i++){
            int id = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
            String name = sheet.getRow(i).getCell(1).getStringCellValue();
            double price = sheet.getRow(i).getCell(2).getNumericCellValue();
            int quantity =  (int) sheet.getRow(i).getCell(3).getNumericCellValue();
            double finalPrice = sheet.getRow(i).getCell(4).getNumericCellValue();

            Product product = new Product(id, name, price, quantity, finalPrice, null);
            products.add(product);



        }
        System.out.println(products.get(4).getName);
        System.out.println(products.get(4).getPrice);
        System.out.println(products.size());


    }

    public static void main(String[] args) {
        launch();
    }
}