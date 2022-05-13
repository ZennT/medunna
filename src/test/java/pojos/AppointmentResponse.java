package pojos;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;

@ToString
public class AppointmentResponse {
    public String createdBy;
    public Date createdDate;
    public int id;
    public Date startDate;
    public Date endDate;
    public String status;
    public Object anamnesis;
    public Object treatment;
    public Object diagnosis;
    public Object prescription;
    public Object description;
    public Object physician;
    public Patient patient;
    public ArrayList<Object> ctests;
}

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */





