package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sample.conn;

import java.io.IOException;
import java.sql.ResultSet;

public class HomePageController {

    @FXML
    private Label schoolnamehomepage;

    @FXML
    private Label locationhomepage;

    @FXML
    private Label welcome;

    @FXML
    private AnchorPane studentRegPane;

    @FXML
    private JFXButton home;

    @FXML
    private JFXButton newStudentReg;

    @FXML
    private JFXButton newEmployee;

    @FXML
    private JFXButton teacherDetails;

    @FXML
    private JFXButton newTeacher;

    @FXML
    private JFXButton studentDetail;

    @FXML
    private JFXButton updateStudent;

    @FXML
    private JFXButton updateTeacher;

    @FXML
    private JFXButton logout;

    @FXML
    void initialize() {

        try{
            conn c1 = new conn();
            String query= "select * from signup where schoolname='"+new LoginPageController().getSchoolname()+"'";
            ResultSet rs = c1.s.executeQuery(query);
            while(rs.next()){
                schoolnamehomepage.setText(rs.getString("schoolname"));
                locationhomepage.setText(rs.getString("location"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        welcome.setText("Welcome: "+new AdminLoginPageController().getName());


        home.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/home.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root1 = loader.getRoot();

            studentRegPane.getChildren().setAll(root1);
        });

        newStudentReg.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/newStudent.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root1 = loader.getRoot();

            studentRegPane.getChildren().setAll(root1);

        });

        studentDetail.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/studentDetails.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root2 = loader.getRoot();

            studentRegPane.getChildren().setAll(root2);

        });

        newTeacher.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/newTeacher.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root3 = loader.getRoot();

            studentRegPane.getChildren().setAll(root3);

        });

        teacherDetails.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/teacherDetails.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root4 = loader.getRoot();

            studentRegPane.getChildren().setAll(root4);

        });

        newEmployee.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/newEmployee.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root5 = loader.getRoot();

            studentRegPane.getChildren().setAll(root5);

        });

        updateStudent.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/updateStudent.fxml"));
            try {
                loader.load();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            Parent root6 = loader.getRoot();

            studentRegPane.getChildren().setAll(root6);

        });

        updateTeacher.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/updateTeacher.fxml"));
            try {
                loader.load();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            Parent root6 = loader.getRoot();

            studentRegPane.getChildren().setAll(root6);

        });

        logout.setOnAction(event -> System.exit(0));
    }

}
