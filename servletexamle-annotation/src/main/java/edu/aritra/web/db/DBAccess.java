package edu.aritra.web.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBAccess {
    private String host;
    private String port;
    private String userName;
    private String password;
    private String databaseName;

    public DBAccess(String host, String port, String databaseName, String userName, String password) {
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
        this.userName = userName;
        this.password = password;
    }

    public List<Student> getData() {
        List<Student> retList = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://" + host + ":" + port + "/" + databaseName, userName, password);
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery("select * from public.students")) {

            while (rs.next()) {
                Student student = new Student(rs.getString("name"), rs.getString("branch"));
                retList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retList;
    }
}
