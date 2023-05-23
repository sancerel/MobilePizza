package com.example.mobilepizza.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.PreparedStatement;

public class DatabaseHandler {       //String telephone = data.get("user_telephone");
    //String email = data.get("user_email");
    //String password = data.get("user_password");
    //String SQL = "INSERT INTO employees VALUES (telephone, email, password)"+ "VALUES " + "(" + telephone + ", " + email + ", " + password + ")";
    //String SQL = "INSERT INTO employees VALUES (telephone, fullname , birthday, address,email, password,position ,employeestatus ,firstworkdate , lastworkdate, )"+ "VALUES " + "(" + telephone + "," + null + "," + null + ", " + email + ", " + password + "," + null + "," + null + "," + null + "," + null + ")";
//        String telephone = args[0];
//        String email = args[1];
//        String password = args[2];
        /*try {
        //Connection connection = DriverManager.getConnection(url, user, pass);
        System.out.println("Подключено");
        //Statement st = connection.createStatement();
        String insertQuery = "INSERT INTO Employees (employeeid, telephone, fullName, birthDate, address, email, password, position, employeeStatus, firstWorkDate, lastWorkDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, "001");
        preparedStatement.setString(2, "+79623155115");
        preparedStatement.setString(3, "Test User");
        preparedStatement.setString(4, "01-01-2000");
        preparedStatement.setString(5, "ekb");
        preparedStatement.setString(6, "asd@asd.ru");
        preparedStatement.setString(7, "qwerty");
        preparedStatement.setString(8, "courier");
        preparedStatement.setString(9, "fired");
        preparedStatement.setString(10, "2023-05-23");
        preparedStatement.setString(11, "2023-05-23");
        preparedStatement.executeUpdate();

        System.out.println("Данные добавлены");

        connection.close();
    } catch (Exception e) {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
    }*/

}
