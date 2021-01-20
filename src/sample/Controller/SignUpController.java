package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class SignUpController {

    private static String schoolname;
    private static String emailAddress;
    private static String password;
    private static String location;
    private static int number;

    @FXML
    private JFXButton signUpButton;

    @FXML
    private JFXTextField emailSignUp;

    @FXML
    private JFXPasswordField passwordSignUp;

    @FXML
    private JFXButton cancelSignUp;

    @FXML
    private JFXTextField schoolNameSignUp;

    @FXML
    private JFXTextField locationSignUp;

    @FXML
    void initialize() {

        signUpButton.setOnAction(event -> {

            schoolname = schoolNameSignUp.getText();
            emailAddress = emailSignUp.getText();
            password = passwordSignUp.getText();
            location = locationSignUp.getText();

                    Random rnd = new Random();
                    number = rnd.nextInt(999999);

                    Properties properties = new Properties();
                    properties.put("mail.smtp.auth","true");
                    properties.put("mail.smtp.starttls.enable","true");
                    properties.put("mail.smtp.host","smtp.gmail.com");
                    properties.put("mail.smtp.port","587");

                    String myAccountmail="12984parveen@gmail.com";
                    String mailPassword = "homeloan838";

                    Session session = Session.getInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(myAccountmail,mailPassword);
                        }
                    });

                    try{
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(myAccountmail));
                        message.setRecipient(Message.RecipientType.TO,new InternetAddress(emailAddress));
                        message.setSubject("User Email Verification");
                        message.setText("Please verify your account using this code to Registered successfully: " + number);
                        Transport.send(message);
                        JOptionPane.showMessageDialog(null,"Message send Successfully!! Plzz Verify Your  Account.");
                        System.out.println("Message send Successfully!! Plzz Verify Your  Account.");

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/sample/view/verification.fxml"));

                        try {
                            loader.load();
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null,e);
                            e.printStackTrace();
                        }

                        Parent root = loader.getRoot();

                        Stage stage = new Stage();
                        stage.setTitle("Verification Page");
                        stage.setScene(new Scene(root));
                        stage.setMaximized(true);

                        stage.show();
                        signUpButton.getScene().getWindow().hide();

                    }
                    catch (Exception e){
                        JOptionPane.showMessageDialog(null,e);
                        e.printStackTrace();
                    }

        });

        cancelSignUp.setOnAction(event -> cancelSignUp.getScene().getWindow().hide() );

    }

    public String getSchoolname() {
        return schoolname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getLocation() {
        return location;
    }

    public int getNumber() {
        return number;
    }
}
