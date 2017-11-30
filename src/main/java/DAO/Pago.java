package DAO;


import Conexion.DbUtil;
import VO.FormaPago;
import VO.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Pago {
private Connection connection;

    public Pago() {
        connection = DbUtil.getConnection();
    }

    public void agregarPago(FormaPago fp) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into FormasPago(idP,nombre) values (?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, fp.getId());
            preparedStatement.setString(2, fp.getFormarPago());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public FormaPago extraerPago(String nombre) {
        FormaPago FP = new FormaPago();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from FormasPago where nombre=?");
            preparedStatement.setString(1, nombre);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
               FP.setId(rs.getInt("idP"));
               FP.setFormarPago(rs.getString("nombre"));
                           }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return FP;
    }
    public List<FormaPago> listarFP() {
        List<FormaPago> users = new ArrayList<FormaPago>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from FormasPago");
            while (rs.next()) {
                FormaPago fp = new FormaPago();
               fp.setId(rs.getInt("idP"));
               fp.setFormarPago(rs.getString("nombre"));
              
                users.add(fp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

}
