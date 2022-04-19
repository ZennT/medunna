package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTxt {


    public static List<String> getSSNIDs(){
        List <String > list = new ArrayList<>();

        try{

            //identify file location
            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("database_registrant_data"));

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();//856-45-6789,

            while(line != null){

                String ssn = line.split(",")[0];
                list.add(ssn);

                line = br.readLine();
            }
        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }


    public static List<String> getTestItemNames(){
        List<String> list=new ArrayList<>();
        try {
            //We are just identifying file location to read
            FileReader fileReader=new FileReader(ConfigurationReader.getProperty("created_testItem_records"));
            // we are reading the records of the file in given location here
            BufferedReader br=new BufferedReader(fileReader);
            String line=br.readLine();


            while (line !=null){
                String name=line.split(",")[0];
                list.add(name);
                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> getApiTestItemNames(){
        List<String> list=new ArrayList<>();
        try {
            //We are just identifying file location to read
            FileReader fileReader=new FileReader(ConfigurationReader.getProperty("testItems_All_records"));
            // we are reading the records of the file in given location here
            BufferedReader br=new BufferedReader(fileReader);
            String line=br.readLine();
            while (line !=null){
                String name=line.split(",")[0];
                list.add(name);
                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static List<String> getDBTestItemNames(){
        List<String> list=new ArrayList<>();
        try {
            FileReader fileReader=new FileReader(ConfigurationReader.getProperty("DB_testItems_data"));
            BufferedReader br=new BufferedReader(fileReader);
            String line=br.readLine();
            while (line !=null){
                String name=line.split(",")[0];
                list.add(name);
                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }




















    public static List<String> getPatients(){
        List <String > list = new ArrayList<>();
        try{
            //identify file location
            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("patients_All_records"));
            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();//856-45-6789,
            while(line != null){
                String ssn = line.split(",")[2];
                list.add(ssn);
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static List<String> getPatientsNames(){
        List<String> list=new ArrayList<>();
        try {
            //We are just identifying file location to read
            FileReader fileReader=new FileReader(ConfigurationReader.getProperty("patients_records"));
            // we are reading the records of the file in given location here
            BufferedReader br=new BufferedReader(fileReader);
            String line=br.readLine();
            while (line !=null){
                String name=line.split(",")[0];
                list.add(name);
                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static List<String> getDoctorAppointment_1(){
        List<String> list=new ArrayList<>();
        try {
            //We are just identifying file location to read
            FileReader fileReader=new FileReader(ConfigurationReader.getProperty("DoctorAppointment_data_1"));
            // we are reading the records of the file in given location here
            BufferedReader br=new BufferedReader(fileReader);
            String line=br.readLine();


            while (line !=null){
                String name=line.split(",")[0];
                list.add(name);
                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static List<String> getDoctorAppointment_2(){
        List<String> list=new ArrayList<>();
        try {
            //We are just identifying file location to read
            FileReader fileReader=new FileReader(ConfigurationReader.getProperty("DoctorAppointment_data_2"));
            // we are reading the records of the file in given location here
            BufferedReader br=new BufferedReader(fileReader);
            String line=br.readLine();


            while (line !=null){
                String name=line.split(",")[0];
                list.add(name);
                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }






























    public static List<String> getRoomData(){
        List<String> list=new ArrayList<>();
        try {
            //We are just identifying file location to read
            FileReader fileReader=new FileReader(ConfigurationReader.getProperty("room_records"));
            // we are reading the records of the file in given location here
            BufferedReader br=new BufferedReader(fileReader);
            String line=br.readLine();


            while (line !=null){
                String name=line.split(",")[0];
                list.add(name);
                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> getApiRoomData(){
        List<String> list=new ArrayList<>();
        try {
            //We are just identifying file location to read
            FileReader fileReader=new FileReader(ConfigurationReader.getProperty("room_records"));
            // we are reading the records of the file in given location here
            BufferedReader br=new BufferedReader(fileReader);
            String line=br.readLine();
            while (line !=null){
                String name=line.split(",")[0];
                list.add(name);
                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> getRoomApiData(){
        List<String> list=new ArrayList<>();
        try {
            //We are just identifying file location to read
            FileReader fileReader=new FileReader(ConfigurationReader.getProperty("room_api_records"));
            // we are reading the records of the file in given location here
            BufferedReader br=new BufferedReader(fileReader);
            String line=br.readLine();


            while (line !=null){
                String name=line.split(",")[0];
                list.add(name);
                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    // yeni olusturulan room records icin
    public static List<String> getRoomApiiData(){
        List<String> list=new ArrayList<>();
        try {
            //We are just identifying file location to read
            FileReader fileReader=new FileReader(ConfigurationReader.getProperty("room_api_records"));
            // we are reading the records of the file in given location here
            BufferedReader br=new BufferedReader(fileReader);
            String line=br.readLine();


            while (line !=null){
                String name=line.split(",")[0];
                list.add(name);
                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    // databasedeki tum room recordlari icin
    public static List<String> getApiiRoomData(){
        List<String> list=new ArrayList<>();
        try {
            //We are just identifying file location to read
            FileReader fileReader=new FileReader(ConfigurationReader.getProperty("allRooms_records"));
            // we are reading the records of the file in given location here
            BufferedReader br=new BufferedReader(fileReader);
            String line=br.readLine();
            while (line !=null){
                String name=line.split(",")[0];
                list.add(name);
                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }



















































}