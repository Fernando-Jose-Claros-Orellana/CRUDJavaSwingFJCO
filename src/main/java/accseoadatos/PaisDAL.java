/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accseoadatos;

import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author FJ
 */
public class PaisDAL {
    public static ArrayList<Paises> obtenerTodos() {
        ArrayList<Paises> paises = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT ID, Nombre, Descripcion, Continente FROM Paises";           
            try (PreparedStatement statement = conn.prepareStatement(sql)) {                              
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int Id = resultSet.getInt("ID");
                        String nombre = resultSet.getString("Nombre");
                        String descripcion = resultSet.getString("Descripcion");
                        String continente = resultSet.getString("Continente");
                        Paises pais = new Paises(Id,nombre,descripcion,continente);
                        paises.add(pais);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al obtener los paises", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return paises;
    }
    
    //Nuevo codigo CRUD
     public static int crear(Paises pais) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "INSERT INTO Paises (Nombre, Descripcion, Continente) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, pais.getNombre());
                statement.setString(2, pais.getDescripcion());
                statement.setString(3, pais.getContinente());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el registro", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public static int modificar(Paises pais) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "UPDATE Paises SET Nombre=?, Descripcion=?, Continente=? WHERE ID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                 statement.setString(1, pais.getNombre());
                statement.setString(2, pais.getDescripcion());
                statement.setString(3, pais.getContinente());
                statement.setInt(4, pais.getId());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el registro", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public static int eliminar(Paises pais) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "DELETE FROM Paises WHERE ID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, pais.getId());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el registro", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public static ArrayList<Paises> buscar(Paises paisSearch) {
        ArrayList<Paises> paises = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT ID, Nombre, Descripcion, Continente FROM Paises ";
            sql+=" WHERE Nombre LIKE ? ";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, "%" + paisSearch.getNombre() + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Paises pais = new Paises();
                        pais.setId(resultSet.getInt("ID"));
                        pais.setNombre(resultSet.getString("Nombre"));
                        pais.setDescripcion(resultSet.getString("Descripcion"));
                        pais.setContinente(resultSet.getString("Continente"));
                        //Paises pais= new Paises();
                        //pais.setNombre(resultSet.getString("NombreCiu"));
                        //ciudad.setPais(pais);
                        paises.add(pais);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al buscar productos", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return paises;
    }
}
