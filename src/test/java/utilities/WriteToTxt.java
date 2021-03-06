package utilities;

import pages.DoctorAppointment;
import pojos.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriteToTxt {


    public static void saveRegistrantData(Registrant registrant) {
        try {
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("api_registrant_data"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);


            writer.append(registrant + "\n");


            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void saveAppointData(Appointment appointment) {

        try {

            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("appointment_records"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(appointment + "\n");


            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void saveRegistrantData(List<Object> SSNIds) {
        try {
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("database_registrant_data"), false);

            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (Object eachSSN : SSNIds) {
                writer.append(eachSSN + ",\n");
            }

            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveTestItemInfo(CreateUpdateDeleteTestItem createUpdateDeleteTestItem) {
        try {
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("created_testItem_records"), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.append(createUpdateDeleteTestItem.getName() + "," + createUpdateDeleteTestItem.getDescription() + "," + createUpdateDeleteTestItem.getPrice() + "," +
                    createUpdateDeleteTestItem.getDefaultValMin() + "," + createUpdateDeleteTestItem.getDefaultValMax() + "," + createUpdateDeleteTestItem.getCreatedDate() + "\n");
//writer.append(createUpdateDeleteTestItem+"\n");


            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void saveAllTestItems(CreateUpdateDeleteTestItem[] createUpdateDeleteTestItem) {
        try {
            //we make it FALSE because we will update all data whenever we make a get request for all.
            // Every time we will get all data
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("testItems_All_records"), false);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (int i = 0; i < createUpdateDeleteTestItem.length; i++) {
                writer.append(createUpdateDeleteTestItem[i].getName() + "," + createUpdateDeleteTestItem[i].getDescription() + "," +
                        createUpdateDeleteTestItem[i].getPrice() + "," + createUpdateDeleteTestItem[i].getDefaultValMin() + "," +
                        createUpdateDeleteTestItem[i].getDefaultValMax() + "," + createUpdateDeleteTestItem[i].getCreatedDate() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void savePatientData(NewPatientCreation[] np){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("patients_records"), false);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for(int i=0; i< np.length;i++) {
                writer.append(np[i].getFirstname()+","+ np[i].getLastname()+","+np[i].getAddress()+","+np[i].getEmail()+
                        np[i].getBloodGroup()+","+np[i].getPhone()+ "\n");
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveDBTestItemsData(List<Object> testItems) {
        try {
            //we make it FALSE to add updated data
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("DB_testItems_data"), false);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (Object eachTestItem : testItems) {
                writer.append(eachTestItem + ",\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void saveApiAppointment(DoctorAppointment doctorAppointment) {
        try {
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("API_doctorAppointment_data"), true);


            BufferedWriter writer = new BufferedWriter(fileWriter);



            writer.append(doctorAppointment + "\n");



            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
        }




        }




    public static void saveRoomData(RoomCreateUpdateDelete room) {
        try {
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("room_records"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.append(room + "\n");
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void saveAllRoomData(RoomCreateUpdateDelete[] room) {
        try {
            //we make it FALSE because we will update all data whenever we make a get request for all.
            // Every time we will get all data
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("room_All_records"), false);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (int i = 0; i < room.length; i++) {
                writer.append(room[i] + "\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveNewRoomData(RoomCreateUpdateDelete room) {
        try {
            //we make it FALSE because we will update all data whenever we make a get request for all.
            // Every time we will get all data
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("room_All_records"), false);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.append(room.getCreatedBy() + "," + room.getDescription() + "," +
                        room.getPrice() + "," + room.getRoomNumber() + "," +
                        room.getRoomType() + "," + room.isStatus() + "\n");

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void saveRoomApiData(RoomApiRequest roomApi) {
        try {
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("room_api_records"), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.append(roomApi + "\n");
            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}