package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)


public class RoomApiRequest {
   /*
{ "createdBy": "string",
 "createdDate": "2022-04-04T21:17:54.334Z",
 "description": "string",
 "id": 0,
 "price": 0,
 "roomNumber": 0,
 "roomType": "TWIN",
 "status": true
}
 */

 private String createdBy;
 private String description;
 private int id;
 private double price;
 private int roomNumber;
 private String roomType;
 private boolean status;

    public RoomApiRequest() {

    }

    public RoomApiRequest(String createdBy, String description, int id, double price, int roomNumber, String roomType, boolean status) {
        this.createdBy = createdBy;
        this.description = description;
        //this.id = id;
        this.price = price;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   // public int getId() {
    //    return id;
    //}

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoomApiRequest{" +
                "createdBy='" + createdBy + '\'' +
                ", description='" + description + '\'' +
                //", id=" + id +
                ", price=" + price +
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", status=" + status +
                '}';
    }
}
