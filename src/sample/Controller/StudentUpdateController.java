package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import sample.conn;
import javax.swing.*;

public class StudentUpdateController {

    private int id=0;

    @FXML
    private JFXComboBox<Integer> studentidUpdate;

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
    private JFXButton updateStudent;

    @FXML
    private JFXButton resetStudent;


    @FXML
    void initialize() {

        classStudent.getItems().addAll("L.K.G.","U.K.G.","1st","2nd","3rd","4th","5th","6th","7th","8th","9th","10th","11th","12th");
        genderStudent.getItems().addAll("Male","Female");

        try {

            conn c1 = new conn();
            String query = "select * from student";
            ResultSet rs = c1.s.executeQuery(query);
            while (rs.next()){
                studentidUpdate.getItems().addAll(rs.getInt("studentid"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        studentidUpdate.setOnAction(event -> {

            try{
                id = studentidUpdate.getSelectionModel().getSelectedItem();
                conn c1 = new conn();
                String query = "select * from student where studentid='"+id+"'";
                ResultSet rs = c1.s.executeQuery(query);
                while (rs.next()){
                    firstnameStudent.setText(rs.getString("firstname"));
                    lastnameStudent.setText(rs.getString("lastname"));
                    fathernameStudent.setText(rs.getString("fathername"));
                    mothernameStudent.setText(rs.getString("mothername"));
                    classStudent.setValue(rs.getString("class"));
                    genderStudent.setValue(rs.getString("gender"));
                    villageStudent.setText(rs.getString("village"));
                    districtStudent.setText(rs.getString("district"));
                    stateStudent.setText(rs.getString("state"));
                    countryStudent.setText(rs.getString("country"));
                    pincodeStudent.setText(rs.getString("pincode"));
                    contactStudent.setText(rs.getString("contact"));
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

        });

        updateStudent.setOnAction(event -> {

            id = studentidUpdate.getSelectionModel().getSelectedItem();

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
                String query = "update student set firstname='"+firstname+"',lastname='"+lastname+"',fathername='"+fathername+"'," +
                        "mothername='"+mothername+"',class='"+classs+"',gender='"+gender+"',village='"+village+"'," +
                        "district='"+district+"',state='"+state+"',country='"+country+"',pincode='"+pincode+"',contact='"+contact+"' where studentid='"+id+"'";
                c1.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Updated Added");

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