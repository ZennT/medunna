package pojos;


import lombok.*;

@Data

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString


public class RoomApiResponse {
    private String createdDate;
    private String createdBy;
    private String description;
    private int id;
    private double price;
    private int roomNumber;
    private String roomType;
    private boolean status;

}
