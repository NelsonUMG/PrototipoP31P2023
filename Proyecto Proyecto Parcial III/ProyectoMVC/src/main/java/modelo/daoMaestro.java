/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsMaestro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
//daoMaestros, Hecho por Nelson Josué Pineda Culajay, 9959-21-10015
public class daoMaestro {

    private static final String SQL_SELECT = "SELECT codigo_maestro, nombre_maestro, direccion_maestro, telefono_maetro, email_maestro, estatus_maestro FROM maestros";
    private static final String SQL_INSERT = "INSERT INTO maestros (codigo_maestro, nombre_maestro, direccion_maestro, telefono_maetro, email_maestro, estatus_maestro) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE maestros SET nombre_maestro=?, direccion_maestro=?, telefono_maetro=?, email_maestro=?, estatus_maestro=? WHERE codigo_maestro = ?";
    private static final String SQL_DELETE = "DELETE FROM maestros WHERE codigo_maestro=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_maestro, nombre_maestro, direccion_maestro, telefono_maetro, email_maestro, estatus_maestro FROM maestros WHERE nombre_maestro = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_maestro, nombre_maestro, direccion_maestro, telefono_maetro, email_maestro, estatus_maestro  FROM maestros WHERE codigo_maestro = ?";    

    public List<clsMaestro> consultaMaestros() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsMaestro> maestros = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cod = rs.getString("codigo_maestro");
                String nombre = rs.getString("nombre_maestro");
                String direccion = rs.getString("direccion_maestro");
                String tel =rs.getString("telefono_maetro");
                String Correo = rs.getString("email_maestro");
                String Estado = rs.getString("estatus_maestro");
                clsMaestro maestro = new clsMaestro();
                maestro.setCodMaestro(cod);
                maestro.setNombreMaestro(nombre);
                maestro.setDireccionMaestro(direccion);
                maestro.setTelMaestro(tel);
                maestro.setEmailMaestro(Correo);
                maestro.setEstatusMaestro(Estado);
                maestros.add(maestro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return maestros;
    }

    public int ingresaMaestros(clsMaestro maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, maestro.getCodMaestro());
            stmt.setString(2, maestro.getNombreMaestro());
            stmt.setString(3, maestro.getDireccionMaestro());
            stmt.setString(4, maestro.getTelMaestro());
            stmt.setString(5, maestro.getEmailMaestro());
            stmt.setString(6, maestro.getEstatusMaestro());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaMaestros(clsMaestro maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, maestro.getNombreMaestro());
            stmt.setString(2, maestro.getDireccionMaestro());
            stmt.setString(3, maestro.getTelMaestro());
            stmt.setString(4, maestro.getEmailMaestro());
            stmt.setString(5, maestro.getEstatusMaestro());
            stmt.setString(6, maestro.getCodMaestro());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarMaestros(clsMaestro maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, maestro.getCodMaestro());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsMaestro consultaMaestrosPorNombre(clsMaestro maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + maestro);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, maestro.getNombreMaestro());
            rs = stmt.executeQuery();
            while (rs.next()) {
            String cod = rs.getString("codigo_maestro");
            String nombre = rs.getString("nombre_maestro");
            String direccion = rs.getString("direccion_maestro");
            String tel =rs.getString("telefono_maetro");
            String Correo = rs.getString("email_maestro");
            String Estado = rs.getString("estatus_maestro");
             //usuario = new clsUsuario();
            maestro.setCodMaestro(cod);
            maestro.setNombreMaestro(nombre);
            maestro.setDireccionMaestro(direccion);
            maestro.setTelMaestro(tel);
            maestro.setEmailMaestro(Correo);
            maestro.setEstatusMaestro(Estado);
                System.out.println(" registro consultado: " + maestro);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return maestro;
    }
  public clsMaestro consultaMaestrosPorId(clsMaestro maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + maestro);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setString(1, maestro.getCodMaestro());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
            String cod = rs.getString("codigo_maestro");
            String nombre = rs.getString("nombre_maestro");
            String direccion = rs.getString("direccion_maestro");
            String tel =rs.getString("telefono_maetro");
            String Correo = rs.getString("email_maestro");
            String Estado = rs.getString("estatus_maestro");

                //usuario = new clsUsuario();
            maestro.setCodMaestro(cod);
            maestro.setNombreMaestro(nombre);
            maestro.setDireccionMaestro(direccion);
            maestro.setTelMaestro(tel);
            maestro.setEmailMaestro(Correo);
            maestro.setEstatusMaestro(Estado);
            System.out.println(" registro consultado: " + maestro);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return maestro;
}
}
