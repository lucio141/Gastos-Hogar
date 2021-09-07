package ar.com.cartico.casa.gastos.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/gastos";
    private static String user = "root";
    private static String pass = "";
    private static Connection conn = null;
    private Connector(){}
    public synchronized static Connection getConnection(){
        if(conn==null){
            try {
                Class.forName(driver);
                conn= DriverManager.getConnection(url, user,pass);                
            } catch (Exception e) {System.out.println(e);}
        }
    return conn;}
}
