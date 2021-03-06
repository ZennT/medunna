package utilities;

import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.*;

public class DatabaseUtility {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void createConnection() {
//        String url = ConfigurationReader.getProperty("database_url");
//        String user = ConfigurationReader.getProperty("database_user");
//        String password = "Techpro_@126";
        String url = ConfigurationReader.getProperty("db_credentials_url");
        String user = ConfigurationReader.getProperty("db_username");
        String password = ConfigurationReader.getProperty("db_password");

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" , "Medunnadb_@129");
//        System.out.println(getColumnData("Select * FROM jhi_user", "first_name"));
//        closeConnection();
//    }

    public static Statement getStatement() {
        return statement;
    }

    public static void main(String[] args) throws Exception {
        createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" , "Medunnadb_@129");
//        System.out.println(getColumnData("Select * FROM jhi_user", "id"));
//        System.out.println(getColumnData2("Select * FROM jhi_user", 1));
//        System.out.println(getQueryResultMap("Select * FROM jhi_user order by id limit 2"));
//        System.out.println(getQueryResultMap("Select id FROM jhi_user order by id limit 2"));
//        System.out.println(getColumnNames("Select * FROM jhi_user"));
//        System.out.println(getCellValuewithRowsAndCells("Select * FROM jhi_user",8,6));
//        executeQuery("Select id FROM jhi_user");
//        System.out.println(getRowCount());


        closeConnection();

    }

    public static void createConnection(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @param query
     * @return returns a single cell value. If the results in multiple rows and/or
     *         columns of data, only first column of the first row will be returned.
     *         The rest of the data will be ignored
     */
    public static Object getCellValue(String query) {
        return getQueryResultList(query).get(0).get(0);
    }
    /**
     *
     * @param query
     * @return returns a list of Strings which represent a row of data. If the query
     *         results in multiple rows and/or columns of data, only first row will
     *         be returned. The rest of the data will be ignored
     */
    public static List<Object> getRowList(String query) {
        return getQueryResultList(query).get(0);
    }
    /**
     *
     * @param query
     * @return returns a map which represent a row of data where key is the column
     *         name. If the query results in multiple rows and/or columns of data,
     *         only first row will be returned. The rest of the data will be ignored
     */
    public static Map<String, Object> getRowMap(String query) {
        return getQueryResultMap(query).get(0);
    }
    /**
     *
     * @param query
     * @return returns query result in a list of lists where outer list represents
     *         collection of rows and inner lists represent a single row
     */


    /*
    *
    * Person
    * id | firstName| lastName | age | salary
    * 1   Ahmet         h        10     1000
    * 2   Mehmet         t        30    1000
    *
    *
    * select * from Person where id = 1;
    *
    * [
        * [1,Ahmet,h,t,10,1000],
        * [2,Mehmet,t,30,1000]
    * ]
    *
    * 1   Ahmet         h        10     1000
    *
    *
    * */
    public static List<List<Object>> getQueryResultList(String query) {
        executeQuery(query);
        List<List<Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.add(resultSet.getObject(i));
                }
                rowList.add(row);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowList;
    }
    /**
     *
     * @param query
     * @param column
     * @return list of values of a single column from the result set
     */
    public static List<Object> getColumnData(String query, String column) {
        executeQuery(query);
        List<Object> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                rowList.add(resultSet.getObject(column));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowList;
    }

    public static List<Object> getColumnData2(String query, int column) {
        executeQuery(query);
        List<Object> rowList = new ArrayList<>();

        try {

            while (resultSet.next()) {
                rowList.add(resultSet.getObject(column));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rowList;
    }
    /**
     *
     * @param query
     * @return returns query result in a list of maps where the list represents
     *         collection of rows and a map represents represent a single row with
     *         key being the column name
     */
    public static List<Map<String, Object>> getQueryResultMap(String query) {
        executeQuery(query);
        List<Map<String, Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> colNameValueMap = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                }
                rowList.add(colNameValueMap);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowList;
    }
    /**
     *
     * @param query
     * @return List of columns returned in result set
     */
    public static List<String> getColumnNames(String query) {
        executeQuery(query);
        List<String> columns = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return columns;
    }


//    txt dosyasina yazdirmadigimiz zaman bu metod ile butun room id lerini List in icine atiyoruz
    public static List<Long> getRoomResult() throws SQLException {
        List<Long> allRoomIds = new ArrayList<>();
        while (resultSet.next()){
              allRoomIds.add((long)resultSet.getObject("id"));
        }


        return allRoomIds;
    }

    public static void executeQuery(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void deleteQuery(String query) throws SQLException {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(query);
            System.out.println("Record successfully deleted");
        } catch (PSQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void executeDelete(String query){
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);;
            int rowAffacted = statement.executeUpdate(query);
            if (rowAffacted != 0) {
                System.out.println("Record deleted successfully!");
            }else{
                System.out.println("No Affected Rows!");
            }
        } catch (PSQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void executeDelete2(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             statement.executeUpdate(query);
                System.out.println("Record deleted successfully!");

            } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static int deleteRows(String tableName, Long id) throws SQLException {

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);;
        int rowsDeleted = 0;
        String sql = "";
        sql = "select * from " + tableName;
        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()) {
            sql = "delete from  " + tableName+ " where id=" +id;
            rowsDeleted = statement.executeUpdate(sql);
            System.out.println("Room number "+id+" deleted successfully.");

        }
        return rowsDeleted;
    }

    public static void DeleteRoomRow(Long id) {
        try {

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);;
            statement.executeUpdate("DELETE FROM room WHERE id = " + id + ";");

            System.out.println("Room number "+id+" deleted successfully.");
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static int getRowCount() throws Exception {
        resultSet.last();
        int rowCount = resultSet.getRow();
        return rowCount;
    }

    public static void executeInsertion(String query) {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            boolean done = statement.execute(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static int getMaxCountryId (String query,String column){
        int max = 0;
        List<Object> allIds = getColumnData(query, column);
        for (int i=0; i<allIds.size();i++){
            int num = Integer.parseInt(allIds.get(i).toString().trim());
            if(max <= num)
                max=num;
        }
        return max;
    }

    public static List<Long>  getResult() throws SQLException {
        List<Long> allRoomsIds= new ArrayList<>();
        while (resultSet.next()){
        allRoomsIds.add((long)resultSet.getObject("id"));
        }
          return allRoomsIds;
    }
    public static Object getCellValuewithRowsAndCells(String query,int row,int cell) {
        return getQueryResultList(query).get(row).get(cell);
    }

//    public static int getMaxCountryId (String query,String column){
//        int max = 0;
//        List<Object> allIds = getColumnData(query, column);
//        for (int i=0; i<allIds.size();i++){
//            int num = Integer.parseInt(allIds.get(i).toString().trim());
//            if(max <= num)
//                max=num;
//        }
//        return max;
//    }
//    public static Object getCellValuewithRowsAndCells(String query,int row,int cell) {
//
//        return getQueryResultList(query).get(row).get(cell);
//    }

//    public static Object getCellValuewithRowsAndCells(String query,int row,int cell){
//
//    }


    public static List<Object> getRowListWithParam(String query,int row) {
        return getQueryResultList(query).get(row);
    }
}