package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)


public class AppointmentCase07 {

//    "createdDate": "2022-03-26T10:02:03.632563Z",
//            "appoSpeciality": "yyyyyyy",
//            "firstName": "Elif",
//            "lastName": "Ellifcan",
//            "birthDate": null,
//            "phone": "892-871-8909",
//            "gender": "male",
//            "snumber": "555-68-5675",
//            "ssn": "555-65-8887",
//            "email": "Jordane_xxxxh@test.com",
//            "startDate": "2022-04-01"}

    private String createdBy;
    private String firstName;
    private String lastName;
    private String ssn;
    private String eMail;
    private String phone;
    private String startDate;

    public AppointmentCase07() {

    }

    public AppointmentCase07(String createdBy, String firstName, String lastName, String ssn, String eMail, String phone, String startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.eMail = eMail;
        this.phone = phone;
        this.startDate = startDate;
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "AppointmentCase07{" +
                "createdBy='" + createdBy + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", eMail='" + eMail + '\'' +
                ", phone='" + phone + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}

