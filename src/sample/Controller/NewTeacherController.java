package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import sample.conn;

import javax.swing.*;

public class NewTeacherController {

    @FXML
    private JFXTextField stateTeacher;

    @FXML
    private JFXTextField firstnameTeacher;

    @FXML
    private JFXTextField lastnameTeacher;

    @FXML
    private JFXTextField mothernameTeacher;

    @FXML
    private JFXTextField villageTeacher;

    @FXML
    private JFXTextField fathernameTeacher;

    @FXML
    private JFXTextField contactTeacher;

    @FXML
    private JFXTextField pincodeTeacher;

    @FXML
    private JFXTextField districtTeacher;

    @FXML
    private JFXTextField countryTeacher;

    @FXML
    private JFXComboBox<String> qualificationTeacher;

    @FXML
    private JFXComboBox<String> genderTeacher;

    @FXML
    private JFXButton saveTeacher;

    @FXML
    private JFXButton resetTeacher;

    @FXML
    private JFXTextField subjectTeacher;

    @FXML
    private JFXTextField experienceTeacher;

    @FXML
    void initialize() {

        qualificationTeacher.getItems().addAll("B.A","BBA","BCA","B.Sc","M.A","MBA","MCA","M.Sc.","M.Phil","Ph.D");
        genderTeacher.getItems().addAll("Male","Female");

        saveTeacher.setOnAction(event -> {

            String firstname = firstnameTeacher.getText();
            String lastname = lastnameTeacher.getText();
            String fathername = fathernameTeacher.getText();
            String mothername = mothernameTeacher.getText();
            String  qualification = qualificationTeacher.getValue();
            String gender = genderTeacher.getValue();
            String village = villageTeacher.getText();
            String district = districtTeacher.getText();
            String state = stateTeacher.getText();
            String country = countryTeacher.getText();
            String pincode = pincodeTeacher.getText();
            String contact = contactTeacher.getText();
            String subject = subjectTeacher.getText();
            String experience = experienceTeacher.getText();

            try{
                conn c1 = new conn();
                String query = "insert into teacher (firstname,lastname,fathername,mothername,qualification,gender,village,district,state,country,pincode,contact,subject,experience)" +
                        " values('"+firstname+"','"+lastname+"','"+fathername+"','"+mothername+"','"+qualification+"','"+gender+"'" +
                        ",'"+village+"','"+district+"','"+state+"','"+country+"','"+pincode+"','"+contact+"','"+subject+"','"+experience+"')";
                c1.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Teacher Successfully Added");

            }
            catch(Exception e){
                e.printStackTrace();
            }


        });

        resetTeacher.setOnAction(event -> {

            firstnameTeacher.setText("");            lastnameTeacher.setText("");
            fathernameTeacher.setText("");            mothernameTeacher.setText("");
            qualificationTeacher.setValue("Select Qualification");
            genderTeacher.setValue("Select Gender");
            villageTeacher.setText("");            districtTeacher.setText("");
            stateTeacher.setText("");            countryTeacher.setText("");
            pincodeTeacher.setText("");            contactTeacher.setText("");
            subjectTeacher.setText("");            experienceTeacher.setText("");

        });

    }
}
