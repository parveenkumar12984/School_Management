package sample.Controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.conn;

import javax.swing.*;

public class AdminSignUpController {

    private static int schoolid;

    @FXML
    private JFXButton signUpButton;

    @FXML
    private JFXButton cancelAdmin;

    @FXML
    private JFXTextField userNameAdmin;

    @FXML
    private JFXPasswordField passwordAdmin;

    @FXML
    private JFXTextField firstNameAdmin;

    @FXML
    private JFXTextField lastNameAdmin;

    @FXML
    private JFXTextField locationAdmin;

    @FXML
    private JFXComboBox<String> genderAdmin;

    @FXML
    private JFXTextField contactAdmin;

    @FXML
    private Label schoolnameadmin;

    @FXML
    private Label locationadmin;

    @FXML
    void initialize() {

        try{
            conn c1 = new conn();
            String query= "select * from signup where schoolname='"+new LoginPageController().getSchoolname()+"'";
            ResultSet rs = c1.s.executeQuery(query);
            while(rs.next()){
                schoolid=rs.getInt("schoolid");
                schoolnameadmin.setText(rs.getString("schoolname"));
                locationadmin.setText(rs.getString("location"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        genderAdmin.getItems().addAll("Male","Female");


        signUpButton.setOnAction(event -> {

            String first = firstNameAdmin.getText();
            String last = lastNameAdmin.getText();
            String gender = genderAdmin.getValue();
            String username = userNameAdmin.getText();
            String password = passwordAdmin.getText();
            String location = locationAdmin.getText();
            String contact = contactAdmin.getText();

            try{
                conn c1 = new conn();
                String q1 = "insert into user(firstname,lastname,gender,username,password,location,contact,schoolid) " +
                        "values ('"+first+"','"+last+"','"+gender+"','"+username+"','"+password+"','"+location+"','"+contact+"','"+schoolid+"')";
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Admin Created Successfully!!");
                firstNameAdmin.setText("");lastNameAdmin.setText("");genderAdmin.setValue("Select Gender");userNameAdmin.setText("");passwordAdmin.setText("");
                locationAdmin.setText("");contactAdmin.setText("");

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/view/adminLoginPage.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();

                Stage stage = new Stage();
                stage.setTitle("Admin Login Window");
                stage.setScene(new Scene(root));
                stage.setMaximized(true);

                stage.show();
                signUpButton.getScene().getWindow().hide();

            }
            catch (Exception e){
                e.printStackTrace();
            }


        });

        cancelAdmin.setOnAction(event -> contactAdmin.getScene().getWindow().hide() );


    }
}
