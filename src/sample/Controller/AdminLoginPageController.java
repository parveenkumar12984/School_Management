package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.conn;

import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;

public class AdminLoginPageController {

    public int flag;
    private static int schoolid;
    private static String name;

    @FXML
    private Label schoolnameAdminLoginPage;

    @FXML
    private Label locationAdminLoginPage;

    @FXML
    private JFXPasswordField passwordAdminLoginPage;

    @FXML
    private JFXButton signUpAdminLoginPage;

    @FXML
    private JFXButton cancelAdminLoginPage;

    @FXML
    private JFXButton signInAdminLoginPage;

    @FXML
    private JFXComboBox<String> nameAdminLoginPage;

    @FXML
    void initialize() {

        try{
            conn c1 = new conn();
            String query= "select * from signup where schoolname='"+new LoginPageController().getSchoolname()+"'";
            ResultSet rs = c1.s.executeQuery(query);
            while(rs.next()){
                schoolid=rs.getInt("schoolid");
                schoolnameAdminLoginPage.setText(rs.getString("schoolname"));
                locationAdminLoginPage.setText(rs.getString("location"));
            }

            try{
                c1 = new conn();
                String query1= "select * from user where schoolid='"+schoolid+"'";
                ResultSet rss = c1.s.executeQuery(query1);
                while(rss.next()){
                    nameAdminLoginPage.getItems().addAll(rss.getString("username"));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        signInAdminLoginPage.setOnAction(event -> {

            String username=nameAdminLoginPage.getValue();
            String password = passwordAdminLoginPage.getText();

            try{
                if(!username.equals("")&& !password.equals("")){

                    conn c1 = new conn();
                    String query = "select * from user where username='"+username+"' and password = '"+password+"'";
                    ResultSet resultSet = c1.s.executeQuery(query);

                    while (resultSet.next()){
                        if(resultSet.getString("username").equals(username) && resultSet.getString("password").equals(password)){

                            flag=1;

                            String firstname = resultSet.getString("firstname");
                            String lastname = resultSet.getString("lastname");
                            name = firstname+" "+ lastname;

                            FXMLLoader loader = new FXMLLoader();

                            loader.setLocation(getClass().getResource("/sample/view/homePage.fxml"));
                            try{
                                loader.load();
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }

                            Parent root = loader.getRoot();

                            Scene scene=new Scene(root);
                            Stage stage=new Stage();
                            stage.setTitle("Home Page");
                            stage.setMaximized(true);
                            stage.setScene(scene);

                            stage.show();
                            signInAdminLoginPage.getScene().getWindow().hide();
                        }
                    }

                    if(flag==0){
                        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50),nameAdminLoginPage);
                        translateTransition.setFromX(0f);
                        translateTransition.setByX(10f);
                        translateTransition.setCycleCount(6);
                        translateTransition.setAutoReverse(true);
                        translateTransition.playFromStart();

                        TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(50),passwordAdminLoginPage);
                        translateTransition1.setFromX(0f);
                        translateTransition1.setByX(10f);
                        translateTransition1.setCycleCount(6);
                        translateTransition1.setAutoReverse(true);
                        translateTransition1.playFromStart();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Plzz Enter details!!!!");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

        });

        signUpAdminLoginPage.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/adminSignup.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();

            Stage stage = new Stage();
            stage.setTitle("Admin SignUp Window");
            stage.setScene(new Scene(root));
            stage.setMaximized(true);

            stage.show();
            signUpAdminLoginPage.getScene().getWindow().hide();

        });

        cancelAdminLoginPage.setOnAction(event -> cancelAdminLoginPage.getScene().getWindow().hide());

    }

    public static String getName() {
        return name;
    }
}
