package dev.rynwllngtn;

import dev.rynwllngtn.db.Db;
import dev.rynwllngtn.db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    static void main() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Db.getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE seller " +
                        "SET BaseSalary = BaseSalary + ? " +
                        "WHERE DepartmentId = ? ");

            preparedStatement.setDouble(1, 500);
            preparedStatement.setInt(2, 1);

            int rows = preparedStatement.executeUpdate();
            IO.println(rows + " linhas alteradas!");
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            Db.closeStatement(preparedStatement);
            Db.closeConnection();
        }
    }

}