package sample.Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class teacherDetail {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty firstname;
    private final SimpleStringProperty lastname;
    private final SimpleStringProperty fathername;
    private final SimpleStringProperty mothername;
    private final SimpleStringProperty qualification;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty village;
    private final SimpleStringProperty district;
    private final SimpleStringProperty state;
    private final SimpleStringProperty country;
    private final SimpleStringProperty pincode;
    private final SimpleStringProperty contact;
    private final SimpleStringProperty subject;
    private final SimpleStringProperty experience;

    public teacherDetail(int id, String firstname, String lastname, String fathername, String mothername, String qualification, String gender, String village, String district, String state, String country, String pincode, String contact,String subject,String experience) {
        this.id = new SimpleIntegerProperty(id);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.fathername = new SimpleStringProperty(fathername);
        this.mothername = new SimpleStringProperty(mothername);
        this.qualification = new SimpleStringProperty(qualification);
        this.gender = new SimpleStringProperty(gender);
        this.village = new SimpleStringProperty(village);
        this.district = new SimpleStringProperty(district);
        this.state = new SimpleStringProperty(state);
        this.country = new SimpleStringProperty(country);
        this.pincode = new SimpleStringProperty(pincode);
        this.contact = new SimpleStringProperty(contact);
        this.subject = new SimpleStringProperty(subject);
        this.experience = new SimpleStringProperty(experience);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getFathername() {
        return fathername.get();
    }

    public void setFathername(String fathername) {
        this.fathername.set(fathername);
    }

    public String getMothername() {
        return mothername.get();
    }

    public void setMothername(String mothername) {
        this.mothername.set(mothername);
    }

    public String getQualification() {
        return qualification.get();
    }

    public void setQualification(String qualification) {
        this.qualification.set(qualification);
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getVillage() {
        return village.get();
    }

    public void setVillage(String village) {
        this.village.set(village);
    }

    public String getDistrict() {
        return district.get();
    }

    public void setDistrict(String district) {
        this.district.set(district);
    }

    public String getState() {
        return state.get();
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getCountry() {
        return country.get();
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public String getPincode() {
        return pincode.get();
    }

    public void setPincode(String pincode) {
        this.pincode.set(pincode);
    }

    public String getContact() {
        return contact.get();
    }

    public void setContact(String contact) {
        this.contact.set(contact);
    }

    public String getSubject() {
        return subject.get();
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    public String getExperience() {
        return experience.get();
    }

    public void setExperience(String experience) {
        this.experience.set(experience);
    }
}
