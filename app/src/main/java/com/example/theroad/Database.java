package com.example.theroad;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database  {

    Connection conn = null;

    public Connection ConnectDB() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://SQL5043.site4now.net/DB_A4BF05_roadroad057", "DB_A4BF05_roadroad057_admin", "road2020");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //íÓÊÎÏã áááÇÖÇÝÉ æ ÇáÊÚÏíá æ ÇáÍÐÝ
    public String RUNDML(String st) {
        try {
            Statement nour = conn.createStatement();
            nour.executeUpdate(st);
            return "Ok";
        } catch (SQLException exp) {
            return exp.getMessage();
        }

    }

    //to search
    public ResultSet RunSearch(String st) {
        ResultSet bola;
        try {
            Statement migo = conn.createStatement();
            bola = migo.executeQuery(st);
            return bola;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
