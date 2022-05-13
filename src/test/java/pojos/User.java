package pojos;


import lombok.ToString;

import java.util.Date;

@ToString
public class User{
    public String createdBy;
    public Date createdDate;
    public int id;
    public String login;
    public String firstName;
    public String lastName;
    public String email;
    public boolean activated;
    public Object langKey;
    public Object imageUrl;
    public Object resetDate;
    public String ssn;
}