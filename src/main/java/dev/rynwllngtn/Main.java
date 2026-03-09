package dev.rynwllngtn;

import dev.rynwllngtn.db.Db;
import dev.rynwllngtn.db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    static void main() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Db.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO seller" +
                        "(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                        "VALUES" +
                        "(?, ?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, "Username");
            preparedStatement.setString(2, "user@email.com");
            preparedStatement.setDate(3, new java.sql.Date(dateFormat.parse("07/01/2002").getTime()));
            preparedStatement.setDouble(4, 5000);
            preparedStatement.setInt(5, 1);

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    IO.println("Novo item com id " + id);
                }
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        finally {
            Db.closeStatement(preparedStatement);
            Db.closeConnection();
        }
    }

}