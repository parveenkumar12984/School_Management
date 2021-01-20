package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import sample.conn;

import javax.swing.*;


public class NewStudentController {

    @FXML
    private JFXTextField firstnameStudent;

    @FXML
    private JFXTextField lastnameStudent;

    @FXML
    private JFXTextField mothernameStudent;

    @FXML
    private JFXTextField villageStudent;

    @FXML
    private JFXTextField fathernameStudent;

    @FXML
    private JFXTextField stateStudent;

    @FXML
    private JFXTextField contactStudent;

    @FXML
    private JFXTextField pincodeStudent;

    @FXML
    private JFXTextField districtStudent;

    @FXML
    private JFXTextField countryStudent;

    @FXML
    private JFXComboBox<String> classStudent;

    @FXML
    private JFXComboBox<String> genderStudent;

    @FXML
    private JFXButton saveStudent;

    @FXML
    private JFXButton resetStudent;

    @FXML
    void initialize() {

        classStudent.getItems().addAll("L.K.G.","U.K.G.","1st","2nd","3rd","4th","5th","6th","7th","8th","9th","10th","11th","12th");
        genderStudent.getItems().addAll("Male","Female");

        saveStudent.setOnAction(event -> {

            String firstname = firstnameStudent.getText();
            String lastname = lastnameStudent.getText();
            String fathername = fathernameStudent.getText();
            String mothername = mothernameStudent.getText();
            String classs = classStudent.getValue();
            String gender = genderStudent.getValue();
            String village = villageStudent.getText();
            String district = districtStudent.getText();
            String state = stateStudent.getText();
            String country = countryStudent.getText();
            String pincode = pincodeStudent.getText();
            String contact = contactStudent.getText();

            try{
                conn c1 = new conn();
                String query = "insert into student (firstname,lastname,fathername,mothername,class,gender,village,district,state,country,pincode,contact)" +
                        " values('"+firstname+"','"+lastname+"','"+fathername+"','"+mothername+"','"+classs+"','"+gender+"'" +
                        ",'"+village+"','"+district+"','"+state+"','"+country+"','"+pincode+"','"+contact+"')";
                c1.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Successfully Added");

            }
            catch(Exception e){
                e.printStackTrace();
            }


        });

        resetStudent.setOnAction(event -> {

            firstnameStudent.setText("");            lastnameStudent.setText("");
            fathernameStudent.setText("");            mothernameStudent.setText("");
            classStudent.setValue("Select Class");
            genderStudent.setValue("Select Gender");
            villageStudent.setText("");            districtStudent.setText("");
            stateStudent.setText("");            countryStudent.setText("");
            pincodeStudent.setText("");            contactStudent.setText("");

        });

    }

}
