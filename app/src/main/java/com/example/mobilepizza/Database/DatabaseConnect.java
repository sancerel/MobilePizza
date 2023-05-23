package com.example.mobilepizza.Database;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.UUID;
import java.sql.*;

public class DatabaseConnect {

    private Connection connection;
    private final String host = "77.223.99.19";

    private final String database = "postgres";
    private final int port = 5432;
    private final String user = "postgres";
    private final String pass = "@W#@aEeGzMxE8MPHPZia";
    private String url = "jdbc:postgresql://77.223.99.19:5432/postgres";

    private boolean status;

    public DatabaseConnect()
    {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        //this.disconnect();
        System.out.println("connection status:" + status);
    }

    private void connect()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected:" + status);
                }
                catch (Exception e)
                {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try
        {
            thread.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            this.status = false;
        }
    }

    public Connection getExtraConnection()
    {
        Connection c = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return c;
    }
    public class InsertUserAsync extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
                try
                {
                    String insertQuery = "INSERT INTO Employees (employeeid, telephone, fullName, birthDate, address, email, password, position, employeeStatus, firstWorkDate, lastWorkDate) VALUES ( '"+java.util.UUID.randomUUID().toString()+"' , ? , ?, '2020-01-01', ?, ?, ?, 'courier', 'fired', '2023-05-23', '2023-05-23')";
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                    preparedStatement.setString(1, "+79623155115");
                    preparedStatement.setString(2, "Test User");
                    preparedStatement.setString(3, "ekb");
                    preparedStatement.setString(4, "asd@mail.ru");
                    preparedStatement.setString(5, "qwerty");
                    preparedStatement.executeUpdate();

                    System.out.println("Данные добавлены");
                }
                catch(Exception ex){
                    System.out.println("Connection failed...");

                    System.out.println(ex);
                }

            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {

        }
        @Override
        protected void onPostExecute(Void result) {

        }
    }

    public void InsertUser () {
        new InsertUserAsync().execute();
    }
}