package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import sample.conn;

import javax.swing.*;

public class TeacherUpdateController {

    private int id = 0;

    @FXML
    private JFXComboBox<Integer> teacheridUpdate;

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
    private JFXTextField stateTeacher;

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
    private JFXTextField subjectTeacher;

    @FXML
    private JFXTextField experienceTeacher;

    @FXML
    private JFXButton updateTeacher;

    @FXML
    private JFXButton resetTeacher;

    @FXML
    void initialize() {

        qualificationTeacher.getItems().addAll("B.A","BBA","BCA","B.Sc","M.A","MBA","MCA","M.Sc.","M.Phil","Ph.D");
        genderTeacher.getItems().addAll("Male","Female");

        try {

            conn c1 = new conn();
            String query = "select * from teacher";
            ResultSet rs = c1.s.executeQuery(query);
            while (rs.next()){
                teacheridUpdate.getItems().addAll(rs.getInt("teacherid"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        teacheridUpdate.setOnAction(event -> {

            try{
                id = teacheridUpdate.getSelectionModel().getSelectedItem();
                conn c1 = new conn();
                String query = "select * from teacher where teacherid='"+id+"'";
                ResultSet rs = c1.s.executeQuery(query);
                while (rs.next()){
                    firstnameTeacher.setText(rs.getString("firstname"));
                    lastnameTeacher.setText(rs.getString("lastname"));
                    fathernameTeacher.setText(rs.getString("fathername"));
                    mothernameTeacher.setText(rs.getString("mothername"));
                    qualificationTeacher.setValue(rs.getString("qualification"));
                    genderTeacher.setValue(rs.getString("gender"));
                    villageTeacher.setText(rs.getString("village"));
                    districtTeacher.setText(rs.getString("district"));
                    stateTeacher.setText(rs.getString("state"));
                    countryTeacher.setText(rs.getString("country"));
                    pincodeTeacher.setText(rs.getString("pincode"));
                    contactTeacher.setText(rs.getString("contact"));
                    subjectTeacher.setText(rs.getString("subject"));
                    experienceTeacher.setText(rs.getString("experience"));
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

        });

        updateTeacher.setOnAction(event -> {

            id = teacheridUpdate.getSelectionModel().getSelectedItem();

            String firstname = firstnameTeacher.getText();
            String lastname = lastnameTeacher.getText();
            String fathername = fathernameTeacher.getText();
            String mothername = mothernameTeacher.getText();
            String qualification = qualificationTeacher.getValue();
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
                String query = "update teacher set firstname='"+firstname+"',lastname='"+lastname+"',fathername='"+fathername+"'," +
                        "mothername='"+mothername+"',qualification='"+qualification+"',gender='"+gender+"',village='"+village+"'," +
                        "district='"+district+"',state='"+state+"',country='"+country+"',pincode='"+pincode+"',contact='"+contact+"',subject='"+subject+"',experience='"+experience+"' where teacherid='"+id+"'";
                c1.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Teacher Updated Successully.");

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
