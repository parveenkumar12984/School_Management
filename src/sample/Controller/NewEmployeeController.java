package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import sample.conn;

import javax.swing.*;

public class NewEmployeeController {

    @FXML
    private JFXTextField firstnameEmployee;

    @FXML
    private JFXTextField lastnameEmployee;

    @FXML
    private JFXTextField mothernameEmployee;

    @FXML
    private JFXTextField villageEmployee;

    @FXML
    private JFXTextField fathernameEmployee;

    @FXML
    private JFXTextField stateEmployee;

    @FXML
    private JFXTextField contactEmployee;

    @FXML
    private JFXTextField pincodeEmployee;

    @FXML
    private JFXTextField districtEmployee;

    @FXML
    private JFXTextField countryEmployee;

    @FXML
    private JFXComboBox<String> qualificationEmployee;

    @FXML
    private JFXComboBox<String> genderEmployee;

    @FXML
    private JFXButton saveEmployee;

    @FXML
    private JFXButton resetEmployee;

    @FXML
    private JFXTextField postEmployee;

    @FXML
    private JFXTextField experienceEmployee;

    @FXML
    void initialize() {

        qualificationEmployee.getItems().addAll("B.A","BBA","BCA","B.Sc","M.A","MBA","MCA","M.Sc.","M.Phil","Ph.D");
        genderEmployee.getItems().addAll("Male","Female");

        saveEmployee.setOnAction(event -> {

            String firstname = firstnameEmployee.getText();
            String lastname = lastnameEmployee.getText();
            String fathername = fathernameEmployee.getText();
            String mothername = mothernameEmployee.getText();
            String  qualification = qualificationEmployee.getValue();
            String gender = genderEmployee.getValue();
            String village = villageEmployee.getText();
            String district = districtEmployee.getText();
            String state = stateEmployee.getText();
            String country = countryEmployee.getText();
            String pincode = pincodeEmployee.getText();
            String contact = contactEmployee.getText();
            String post = postEmployee.getText();
            String experience = experienceEmployee.getText();

            try{
                conn c1 = new conn();
                String query = "insert into employee (firstname,lastname,fathername,mothername,qualification,gender,village,district,state,country,pincode,contact,post,experience)" +
                        " values('"+firstname+"','"+lastname+"','"+fathername+"','"+mothername+"','"+qualification+"','"+gender+"'" +
                        ",'"+village+"','"+district+"','"+state+"','"+country+"','"+pincode+"','"+contact+"','"+post+"','"+experience+"')";
                c1.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Successfully Added");

            }
            catch(Exception e){
                e.printStackTrace();
            }


        });

        resetEmployee.setOnAction(event -> {

            firstnameEmployee.setText("");            lastnameEmployee.setText("");
            fathernameEmployee.setText("");            mothernameEmployee.setText("");
            qualificationEmployee.setValue("Select Qualification");
            genderEmployee.setValue("Select Gender");
            villageEmployee.setText("");            districtEmployee.setText("");
            stateEmployee.setText("");            countryEmployee.setText("");
            pincodeEmployee.setText("");            contactEmployee.setText("");
            postEmployee.setText("");            experienceEmployee.setText("");

        });

    }
}
