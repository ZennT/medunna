package pojos;

import lombok.ToString;

import java.util.Date;

@ToString
public class Patient{
    public String createdBy;
    public Date createdDate;
    public int id;
    public String firstName;
    public String lastName;
    public Date birthDate;
    public String phone;
    public Object gender;
    public Object bloodGroup;
    public Object adress;
    public String email;
    public Object description;
    public User user;
    public Object inPatients;
    public Object country;
    public Object cstate;
}