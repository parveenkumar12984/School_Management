package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.conn;

import javax.swing.*;
import java.io.IOException;

public class VerificationController {

    @FXML
    private JFXButton submitVerification;

    @FXML
    private JFXButton cancelVerification;

    @FXML
    private JFXTextField codeVerification;

    @FXML
    private Label incorrectVerification;

    @FXML
    void initialize() {




        submitVerification.setOnAction(event -> {
            int code = Integer.parseInt(codeVerification.getText());

            SignUpController signUpController = new SignUpController();
            int number = signUpController.getNumber();
            if(code==number){

                String schoolname = signUpController.getSchoolname();
                String email = signUpController.getEmailAddress();
                String password = signUpController.getPassword();
                String location = signUpController.getLocation();

                try {
                    conn c1 = new conn();
                    String q1 = "insert into signup(schoolname,email,password,location) " +
                            "values ('" + schoolname + "','" + email + "','" + password + "','" + location + "')";
                    c1.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "User Registered Successfully..");

                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null,e);
                    e.printStackTrace();
                }

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/view/loginPage.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();

                Stage stage = new Stage();
                stage.setTitle("Login Page");
                stage.setScene(new Scene(root));
                stage.setMaximized(true);

                stage.show();
                submitVerification.getScene().getWindow().hide();

            }
            else{
                incorrectVerification.setText("Incorrect Code...Plzz enter valid code.");
                incorrectVerification.setVisible(true);
            }

        });

        cancelVerification.setOnAction(event ->  cancelVerification.getScene().getWindow().hide() );



    }
}
