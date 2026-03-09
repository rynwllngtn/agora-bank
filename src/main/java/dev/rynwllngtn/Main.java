package dev.rynwllngtn;

import dev.rynwllngtn.db.Db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    static void main() {

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Connection connection = Db.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM department");

            while (resultSet.next()) {
                IO.println(resultSet.getInt("Id") + "," + resultSet.getString("Name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Db.closeResultSet(resultSet);
            Db.closeStatement(statement);
            Db.closeConnection();
        }
    }

}