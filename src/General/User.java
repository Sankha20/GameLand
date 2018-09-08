/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import Classes.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {

    public static Employee currentUser = new Employee("!user not defined");

    public static boolean selectUser(String username, String password) {
        boolean success = false;

        String query = String.format(
                "SELECT * FROM admins "
                + "WHERE admin_id = \"%s\" and "
                + "admin_password = \"%s\"",
                username,
                password
        );

        try {

            Connection connection;
            Statement statement;
            ResultSet resultSet;

            connection = Connector.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("admin_name");
                String job = resultSet.getString("admin_job");
                String sales = resultSet.getString("admin_sales");
                
                int intJob = Integer.parseInt(job);
                int intSales = Integer.parseInt(sales);       

                if (!name.isEmpty()) {
                    
                    currentUser = new Employee(name);
                    currentUser.setJob(intJob);
                    currentUser.setSales(intSales);
                    success = true;
                } else {
                    System.out.println("Erro: User > selectUser");
                }
            }

            statement.close();
            connection.close();
            resultSet.close();

        } catch (SQLException e) {
            System.err.println("User > SQLException");
            System.err.println(e);
        }

        return success;
    }
}
