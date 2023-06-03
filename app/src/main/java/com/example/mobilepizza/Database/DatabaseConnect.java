package com.example.mobilepizza.Database;


import android.os.AsyncTask;

import com.example.mobilepizza.MainActivity;
import com.example.mobilepizza.Order.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.UUID;
import java.sql.*;
import java.util.concurrent.ExecutionException;

public class DatabaseConnect extends MainActivity {

    private static Connection connection;
    private final String host = "77.223.99.19";

    private final String database = "postgres";
    private final int port = 5432;
    private final String user = "postgres";
    private final String pass = "@W#@aEeGzMxE8MPHPZia";
    private String url = "jdbc:postgresql://77.223.99.19:5432/postgres";

    public static int queryResult = 0;

    private boolean status;

    //Для заказов
    ArrayList<Order> ORDERS;
    private String TEL;
    private String PAS;
    private String FULLNAME = "";
    private boolean isUserExists = false;

    public DatabaseConnect()
    {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        //this.disconnect();
        System.out.println("connection status:" + status);
    }

    private void connect()
    {
        //Toast toast = Toast.makeText(this, "Hellooo", Toast.LENGTH_LONG);
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
    UUID a = java.util.UUID.randomUUID();
    String email = "";
    String fullname="";
    String address="";
    String password="";
    String telephone="";
    public class InsertUserAsync extends AsyncTask<Void, Integer, Void> {
        @Override
        protected  Void doInBackground(Void... voids) {
            try
               {
                    String insertQuery = "INSERT INTO Employees (employeeid, telephone, fullName, birthDate, address, email, password, position, employeeStatus, firstWorkDate, lastWorkDate) VALUES ( '"+a.toString()+"' , ? , ?, '2020-01-01', ?, ?, ?, 'courier', 'fired', '2023-05-23', '2023-05-23')";
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                    preparedStatement.setString(1, MainActivity.user.telephone);
                    preparedStatement.setString(2, MainActivity.user.fullname);
                    preparedStatement.setString(3, MainActivity.user.address);
                    preparedStatement.setString(4, MainActivity.user.email);
                    preparedStatement.setString(5, MainActivity.user.password);
                    preparedStatement.executeUpdate();
                    queryResult = 1;
               }
            catch(Exception ex){
                    System.out.println("Connection failed...12345");
                System.out.println(ex);
                queryResult = 2;
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
    public class upgradeTollAsync extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try{
                String insertQuery = "UPDATE employees SET fullname = '"+MainActivity.user.fullname+"',birthdate='"+MainActivity.user.date+"' WHERE email = '"+MainActivity.user.email+"'";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.executeUpdate();

                System.out.println("Данные обновлены");

            } catch (Exception ex) {
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
    public void upgradeToll () {
        new upgradeTollAsync().execute();
    }


    /* Обработка заказов */
    public class getOrdersAsync extends AsyncTask<Object, Integer, Object> {
        @Override
        protected ArrayList<Order> doInBackground(Object... params) {
            try{
                String insertQuery = "SELECT * FROM orders";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                ResultSet rs= preparedStatement.executeQuery();
                while(rs.next()){
                    String uuid = rs.getString("orderid");
                    String cost = rs.getString("cost");
                    String address = rs.getString("address");
                    Date date = rs.getDate("createdate");
                    Order or = new Order(UUID.fromString(uuid),cost,address,date);
                    if(ORDERS == null)
                        ORDERS = new ArrayList<Order>();
                    if(!ORDERS.contains(or) )
                         ORDERS.add(or);
                }
                System.out.println("Заказы получены");
            } catch (Exception ex) {
                System.out.println("Connection failed...");
                System.out.println(ex);
            }
            return ORDERS;
        }
        @Override
        protected void onPostExecute(Object result) {
            super.onPostExecute(result);
        }
    }
    public ArrayList<Order> getOrders () {
        AsyncTask<Object, Integer, Object> task = new getOrdersAsync();
        task.execute();
        try {
            task.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ORDERS;
    }

    public class userVerificationAsync extends AsyncTask<Object, Integer, Boolean> {
        @Override
        protected Boolean doInBackground(Object... params) {
            try{
                String insertQuery = "SELECT * FROM employees WHERE telephone='"+TEL+"' AND password = '"+PAS+"'";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                ResultSet rs= preparedStatement.executeQuery();
                while (rs.next()){
                    FULLNAME = rs.getString("fullname");
                    isUserExists= true;
                }
                System.out.println("Заказы получены");
            } catch (Exception ex) {
                System.out.println("Connection failed...");
                System.out.println(ex);
            }
            return isUserExists;
        }
        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
        }
    }

    public boolean userVerification (String PAS, String TEL) {
        this.PAS=PAS;
        this.TEL=TEL;
        AsyncTask<Object, Integer, Boolean> task = new userVerificationAsync();
        task.execute();
        try {
            task.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.PAS=null;
        this.TEL=null;
        MainActivity.user.fullname =FULLNAME;
        return isUserExists;
    }
}