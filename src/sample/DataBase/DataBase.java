package sample.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static Connection connection= null;
    private  final  static  String url = "jdbc:sqlserver://localhost:1433;databaseName=Application";
    private  final  static   String userName = "admin1";
    private final static String password = "123qweR";
    public static Connection DataBaseConnection()
    {
        try
        {
            connection = DriverManager.getConnection(url, userName, password);
            return connection;
        }catch (SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }





}
