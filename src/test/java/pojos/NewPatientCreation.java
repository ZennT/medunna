package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)


public class NewPatientCreation {


    private String firstname;
    private String lastname;
    private String birthdate;
    private String email;
    private String phone;
    private String gender;
    private String bloodGroup;
    private String address;
    private String description;
//    private String user;



    public NewPatientCreation(){


    }
    public NewPatientCreation(String firstname, String lastname, String birthdate, String email, String phone, String gender, String bloodGroup, String address, String description) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.address = address;
        this.description = description;
//        this.user = user;
//        this.country = country;
    }

    //  private String country;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getUser() {
//        return user;
//    }

//    public void setUser(String user) {
//        this.user = user;
//    }
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }


    @Override
    public String toString() {
        return "NewPatientCreation{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
//                ", user='" + user + '\'' +
//                ", country='" + country + '\'' +
                '}';
    }
}
