package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.conn;

import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;

public class LoginPageController {

    public int flag;
    private static String name;
    private static String schoolname;

    @FXML
    private JFXButton signIn;

    @FXML
    private JFXComboBox<String> schoolnamelogin;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton signUp;

    @FXML
    private JFXButton cancel;

    private FXMLLoader loader;

    @FXML
    void initialize() {

        try{
            conn c1 = new conn();
            String query = "select * from signup";
            ResultSet rs = c1.s.executeQuery(query);
            while (rs.next()){
                schoolnamelogin.getItems().addAll(rs.getString("schoolname"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        signIn.setOnAction(event -> {

            String scname = schoolnamelogin.getValue();
            String pasword = password.getText();

            try{
                if(!scname.equals("")&& !pasword.equals("")){

                    conn c1 = new conn();
                    String query = "select * from signup where schoolname='"+scname+"' and password = '"+pasword+"'";
                    ResultSet resultSet = c1.s.executeQuery(query);

                    while (resultSet.next()){
                        if(resultSet.getString("schoolname").equals(scname) && resultSet.getString("password").equals(pasword)){

                            flag=1;

                            schoolname = resultSet.getString("schoolname");

                            FXMLLoader loader = new FXMLLoader();

                            loader.setLocation(getClass().getResource("/sample/view/adminLoginPage.fxml"));
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
                            signIn.getScene().getWindow().hide();
                        }
                    }

                    if(flag==0){
                        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50),schoolnamelogin);
                        translateTransition.setFromX(0f);
                        translateTransition.setByX(10f);
                        translateTransition.setCycleCount(6);
                        translateTransition.setAutoReverse(true);
                        translateTransition.playFromStart();

                        TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(50),password);
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

        signUp.setOnAction(event -> {

            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/signUp.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();

            Stage stage = new Stage();
            stage.setTitle("Sign Up Window");
            stage.setScene(new Scene(root));
            stage.setMaximized(true);

            stage.show();
            signIn.getScene().getWindow().hide();

        });

        cancel.setOnAction(event ->  System.exit(0));
    }

    public String getName() {
        return name;
    }

    public String getSchoolname() {
        return schoolname;
    }
}
