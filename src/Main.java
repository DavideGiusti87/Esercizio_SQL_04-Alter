/*
SQL 04 - Alter
Exercise - SQL-alter

before doing this exercise, you have to complete the following exercises:
0-SQL-installation-and-user-permissions
SQL-table
SQL-select
use JDBC for executing a query on the jdbc:mysql://localhost:3306/newdb database that:
adds a new string column of 30 chars called country to the students table
populate the new column with Italy for 2 students and Germany for the other 2 students
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = MySQLJDBCUtil.getConnection()){

            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "ALTER TABLE students " +
                    "ADD COLUMN country VARCHAR(30);"
            );
            System.out.println("The table students has been changed");

            statement.executeUpdate(
                    "UPDATE `newdb`.`students` " +
                            "SET `country` = 'Italy' " +
                            "WHERE (`student_id` = '1');"
            );
            statement.executeUpdate(
                    "UPDATE `newdb`.`students` " +
                            "SET `country` = 'Germay' " +
                            "WHERE (`student_id` = '2');"
            );
            statement.executeUpdate(
                    "UPDATE `newdb`.`students` " +
                            "SET `country` = 'Italy' " +
                            "WHERE (`student_id` = '3');"
            );
            statement.executeUpdate(
                    "UPDATE `newdb`.`students` " +
                            "SET `country` = 'Germay' " +
                            "WHERE (`student_id` = '4');"
            );

            System.out.println("The values in the country column were added successfully");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
