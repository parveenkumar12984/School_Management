package sample.Controller;

import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.conn;

public class TeacherDetailController {

    @FXML
    private TableView<teacherDetail> tableViewTeacher;

    @FXML
    private TableColumn<teacherDetail, Integer> idTeacher;

    @FXML
    private TableColumn<teacherDetail, String> firstnameTeacher;

    @FXML
    private TableColumn<teacherDetail, String> lastnameTeacher;

    @FXML
    private TableColumn<teacherDetail, String> fathernameTeacher;

    @FXML
    private TableColumn<teacherDetail, String> mothernameTeacher;

    @FXML
    private TableColumn<teacherDetail, String> qualificationTeacher;

    @FXML
    private TableColumn<teacherDetail, String> genderTeacher;

    @FXML
    private TableColumn<teacherDetail, String> villageTeacher;

    @FXML
    private TableColumn<teacherDetail, String> districtTeacher;

    @FXML
    private TableColumn<teacherDetail, String> stateTeacher;

    @FXML
    private TableColumn<teacherDetail, String> countryTeacher;

    @FXML
    private TableColumn<teacherDetail, String> pincodeTeacher;

    @FXML
    private TableColumn<teacherDetail, String> contactTeacher;

    @FXML
    private TableColumn<teacherDetail, String> subjectTeacher;

    @FXML
    private TableColumn<teacherDetail, String> experienceTeacher;

    private ObservableList<teacherDetail> data;

    @FXML
    void initialize() {

        data = FXCollections.observableArrayList();
        try{
            conn c1 = new conn();
            String query = "select * from teacher";
            ResultSet rs = c1.s.executeQuery(query);
            while (rs.next()){
                data.add(new teacherDetail(

                        rs.getInt("teacherid"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("fathername"),
                        rs.getString("mothername"),
                        rs.getString("qualification"),
                        rs.getString("gender"),
                        rs.getString("village"),
                        rs.getString("district"),
                        rs.getString("state"),
                        rs.getString("country"),
                        rs.getString("pincode"),
                        rs.getString("contact"),
                        rs.getString("subject"),
                        rs.getString("experience")


                ));

                idTeacher.setCellValueFactory(new PropertyValueFactory("id"));
                firstnameTeacher.setCellValueFactory(new PropertyValueFactory("firstname"));
                lastnameTeacher.setCellValueFactory(new PropertyValueFactory("lastname"));
                fathernameTeacher.setCellValueFactory(new PropertyValueFactory("fathername"));
                mothernameTeacher.setCellValueFactory(new PropertyValueFactory("mothername"));
                qualificationTeacher.setCellValueFactory(new PropertyValueFactory("qualification"));
                genderTeacher.setCellValueFactory(new PropertyValueFactory("gender"));
                villageTeacher.setCellValueFactory(new PropertyValueFactory("village"));
                districtTeacher.setCellValueFactory(new PropertyValueFactory("district"));
                stateTeacher.setCellValueFactory(new PropertyValueFactory("state"));
                countryTeacher.setCellValueFactory(new PropertyValueFactory("country"));
                pincodeTeacher.setCellValueFactory(new PropertyValueFactory("pincode"));
                contactTeacher.setCellValueFactory(new PropertyValueFactory("contact"));
                subjectTeacher.setCellValueFactory(new PropertyValueFactory("subject"));
                experienceTeacher.setCellValueFactory(new PropertyValueFactory("experience"));

                tableViewTeacher.setItems(data);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
