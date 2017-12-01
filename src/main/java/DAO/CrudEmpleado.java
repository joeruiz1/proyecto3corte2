/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DbUtil;
import VO.Empleado;
import VO.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando stiven
 */
public class CrudEmpleado {
        private Connection connection;

    public CrudEmpleado() {
        connection = DbUtil.getConnection();
    }

    public void agregarEmpleado(Empleado Emp) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into Empleado(nombre,cedula,contrasena,usuario) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, Emp.getNombre());
            preparedStatement.setInt(2, Emp.getCedula());
            preparedStatement.setString(3, Emp.getContrasena());
            preparedStatement.setString(4, Emp.getUsuario());
            
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmpleado(int cedula) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from Empleado where cedula=?");
            // Parameters start with 1
            preparedStatement.setInt(1,cedula);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmpleado(Empleado em) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update Empleado set nombre=?, contrasena=?, usuario=?"
                            + "where cedula=?");
            // Parameters start with 1
            preparedStatement.setInt(1, em.getCedula());
            preparedStatement.setString(2, em.getNombre());
            preparedStatement.setString(3, em.getContrasena());
            preparedStatement.setString(4, em.getUsuario());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Empleado> listarEmpleados() {
        List<Empleado> users = new ArrayList<Empleado>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from Empleado");
            while (rs.next()) {
                Empleado li = new Empleado();
               li.setNombre(rs.getString("nombre"));
               li.setCedula(rs.getInt("cedula"));
               li.setContrasena(rs.getString("contrasena"));
               li.setUsuario(rs.getString("usuario"));
              
                users.add(li);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public Empleado extraerEmpleados(int contra) {
        Empleado em=new Empleado();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from Empleado where userid=?");
            preparedStatement.setInt(1, contra);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
               em.setNombre(rs.getString("nombre"));
               em.setCedula(rs.getInt("cedula"));
               em.setContrasena(rs.getString("contrasena"));
               em.setUsuario(rs.getString("usuario"));
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return em;
    }
     public List<Empleado> mostrarEmpladosUsados() {
        List<Empleado> users = new ArrayList<Empleado>();
        try {
            System.out.println("LLegue hasta aca olii");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select empleado.nombre,empleado.cedula,empleado.`contraseña`,empleado.usuario from empleado inner join factura using(cedula) right join libro on(libro.id_libro=factura.idLi) where estado='usado'; ");
            while (rs.next()) {
                Empleado li = new Empleado();
                li.setNombre(rs.getString("nombre"));
                li.setCedula(rs.getInt("cedula"));
                li.setContrasena(rs.getString("contraseña"));
                li.setUsuario(rs.getString("usuario"));

                users.add(li);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }


}

