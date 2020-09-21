package controllers;

import connection.Database;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Students;

public class DBOperations implements Operations {

    Database database = new Database();
    Students students = new Students();

    @Override
    public boolean Insert(Object object, InputStream image)
    {
        students = (Students) object;
        Connection connection;
        PreparedStatement PStatement;
        String sql = "INSERT INTO STUDENTS VALUE(?, ?, ?, ?, ?)";

        try {
            Class.forName(database.getDriver());
            connection = DriverManager.getConnection(
                    database.getUrl(),
                    database.getUsername(),
                    database.getPassword()
            );

            PStatement = connection.prepareStatement(sql);
            PStatement.setNull(1, students.getId());
            PStatement.setString(2, students.getUsername());
            PStatement.setString(3, students.getSubject());
            PStatement.setInt(4, students.getYear_of_entry());
            PStatement.setBlob(5, image);

            int rows = PStatement.executeUpdate();
            if (rows > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }

        } catch (SQLException | ClassNotFoundException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;
        }
    }

    @Override
    public boolean Delete(Object object)
    {
        students = (Students) object;
        Connection connection;
        PreparedStatement PStatement;
        String sql = "DELETE FROM STUDENTS WHERE ID = ?";

        try {
            Class.forName(database.getDriver());
            connection = DriverManager.getConnection(
                    database.getUrl(),
                    database.getUsername(),
                    database.getPassword()
            );

            PStatement = connection.prepareStatement(sql);
            PStatement.setInt(1, students.getId());

            int rows = PStatement.executeUpdate();
            if (rows > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }

        } catch (SQLException | ClassNotFoundException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;
        }
    }

    @Override
    public boolean Update(Object object)
    {
        students = (Students) object;
        Connection connection;
        PreparedStatement PStatement;
        String sql = "UPDATE STUDENTS SET USERNAME = ?, SUBJECT = ?, YEAR_OF_ENTRY = ? WHERE ID = ?";

        try {
            Class.forName(database.getDriver());
            connection = DriverManager.getConnection(
                    database.getUrl(),
                    database.getUsername(),
                    database.getPassword()
            );

            PStatement = connection.prepareStatement(sql);
            PStatement.setString(1, students.getUsername());
            PStatement.setString(2, students.getSubject());
            PStatement.setInt(3, students.getYear_of_entry());
            PStatement.setInt(4, students.getId());

            int rows = PStatement.executeUpdate();
            if (rows > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }

        } catch (SQLException | ClassNotFoundException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Object[]> Select()
    {
        ArrayList<Object[]> data = new ArrayList<>();
        Connection connection;
        PreparedStatement PStatement;
        ResultSet result;
        String sql = "SELECT * FROM STUDENTS";

        try {
            Class.forName(database.getDriver());
            connection = DriverManager.getConnection(
                    database.getUrl(),
                    database.getUsername(),
                    database.getPassword()
            );
            PStatement = connection.prepareStatement(sql);
            result = PStatement.executeQuery();

            while (result.next()) {
                Object[] row = new Object[4];

                for (int i = 0; i < 4; i++) {
                    row[i] = result.getObject(i + 1);
                }
                data.add(row);
            }

            connection.close();
        } catch (SQLException | ClassNotFoundException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        } finally {
            return data;
        }
    }

    @Override
    public void searchData(String searchQuery, JTable table, JFrame frame)
    {
        ResultSet result;
        Connection connection;
        try {
            connection = DriverManager.getConnection(
                    database.getUrl(),
                    database.getUsername(),
                    database.getPassword()
            );

            try {
                String query = searchQuery;
                PreparedStatement pStatement = connection.prepareStatement(query);
                result = pStatement.executeQuery();

                //Get Table Model
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0);

                if (result.isBeforeFirst()) {
                    while (result.next()) {
                        Object personObject[] = {
                            result.getInt("id"),
                            result.getString("username"),
                            result.getString("subject"),
                            result.getString("year_of_entry")
                        };

                        tableModel.addRow(personObject);
                    }
                }

            } catch (Exception error) {
                JOptionPane.showMessageDialog(frame, "Erro: " + error.getMessage());
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(frame, "Erro de conexão: " + error.getMessage());
        }
    }

    @Override
    public String getImage(String id)
    {
        Statement statement = null;
        Connection connection = null;
        String pathImage = "C:\\Users\\corre\\Documents\\NetBeansProjects\\UsersManager\\image";
        
        try {
            Class.forName(database.getDriver());
            connection = DriverManager.getConnection(
                    database.getUrl(), 
                    database.getUsername(), 
                    database.getPassword()
            );
            
            String sql = "select * from students where id='" + id + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            if (result.next()) {
                Blob test = result.getBlob("image");
                InputStream input = test.getBinaryStream();
                int size = input.available();
                OutputStream output = new FileOutputStream(
                        pathImage + id + ".jpg"
                );
                
                byte b[] = new byte[size];
                input.read(b);
                output.write(b);
            }
        } catch (Exception e) {
            System.out.println("Exception :" + e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return pathImage;
    }
}

