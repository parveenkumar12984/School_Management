package sample.Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.conn;

public class StudentDetailController implements Initializable {

    @FXML
    private TableView<studentDetail> tableviewStudent;

    @FXML
    private TableColumn<studentDetail, Integer> studentidStudentColumn;

    @FXML
    private TableColumn<studentDetail, String> firstnameStudentColumn;

    @FXML
    private TableColumn<studentDetail, String> lastnameStudentColumn;

    @FXML
    private TableColumn<studentDetail, String> fathernameStudentColumn;

    @FXML
    private TableColumn<studentDetail, String> mothernameStudentColumn;

    @FXML
    private TableColumn<studentDetail, String> classStudentColumn;

    @FXML
    private TableColumn<studentDetail, String> genderStudentColumn;

    @FXML
    private TableColumn<studentDetail, String> villageStudentColumn;

    @FXML
    private TableColumn<studentDetail, String> districtStudentColumn;

    @FXML
    private TableColumn<studentDetail, String> stateStudentColumn;

    @FXML
    private TableColumn<studentDetail, String> countryStudentColumn;

    @FXML
    private TableColumn<studentDetail, String> pincodeStudentColumn;

    @FXML
    private TableColumn<studentDetail, String> contactStudentColumn;

    private ObservableList<studentDetail> data;

    @FXML
    public void initialize(URL location, ResourceBundle resource) {

        data = FXCollections.observableArrayList();

        try{
            conn c1 = new conn();
            String query = "select * from student";
            ResultSet rs = c1.s.executeQuery(query);
            while (rs.next()){
                data.add(new studentDetail(
                        rs.getInt("studentid"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("fathername"),
                        rs.getString("mothername"),
                        rs.getString("class"),
                        rs.getString("gender"),
                        rs.getString("village"),
                        rs.getString("district"),
                        rs.getString("state"),
                        rs.getString("country"),
                        rs.getString("pincode"),
                        rs.getString("contact")

                        ));

                studentidStudentColumn.setCellValueFactory(new PropertyValueFactory("id"));
                firstnameStudentColumn.setCellValueFactory(new PropertyValueFactory("firstname"));
                lastnameStudentColumn.setCellValueFactory(new PropertyValueFactory("lastname"));
                fathernameStudentColumn.setCellValueFactory(new PropertyValueFactory("fathername"));
                mothernameStudentColumn.setCellValueFactory(new PropertyValueFactory("mothername"));
                classStudentColumn.setCellValueFactory(new PropertyValueFactory("classs"));
                genderStudentColumn.setCellValueFactory(new PropertyValueFactory("gender"));
                villageStudentColumn.setCellValueFactory(new PropertyValueFactory("village"));
                districtStudentColumn.setCellValueFactory(new PropertyValueFactory("district"));
                stateStudentColumn.setCellValueFactory(new PropertyValueFactory("state"));
                countryStudentColumn.setCellValueFactory(new PropertyValueFactory("country"));
                pincodeStudentColumn.setCellValueFactory(new PropertyValueFactory("pincode"));
                contactStudentColumn.setCellValueFactory(new PropertyValueFactory("contact"));

                tableviewStudent.setItems(data);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }




    }
}