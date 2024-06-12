/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accseoadatos;

import entidades.Ciudades;
import entidades.Paises;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author FJ
 */
public class CiudadDAL {
    
    public static int crear(Ciudades ciudad) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "INSERT INTO Ciudades (Nombre, Descripcion, Poblacion, PaisID) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, ciudad.getNombre());
                statement.setString(2, ciudad.getDescripcion());
                statement.setInt(3, ciudad.getPoblacion());
                statement.setInt(4, ciudad.getPaisID());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el registro", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public static int modificar(Ciudades ciudad) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "UPDATE Ciudades SET Nombre=?, Descripcion=?, Poblacion=?, PaisID=? WHERE ID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, ciudad.getNombre());
                statement.setString(2, ciudad.getDescripcion());
                statement.setInt(3, ciudad.getPoblacion());
                statement.setInt(4, ciudad.getPaisID());
                statement.setInt(5, ciudad.getId());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el registro", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public static int eliminar(Ciudades ciudad) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "DELETE FROM Ciudades WHERE ID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, ciudad.getId());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el registro", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public static ArrayList<Ciudades> buscar(Ciudades ciudadesSearch) {
        ArrayList<Ciudades> ciudades = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT p.ID, p.Nombre, p.Descripcion, p.Poblacion, p.PaisID, c.Nombre AS NombreCiu FROM Ciudades p";
             sql+=" INNER JOIN Paises c ON c.ID= p.PaisID  ";
            sql+=" WHERE p.Nombre LIKE ? ";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, "%" + ciudadesSearch.getNombre() + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Ciudades ciudad = new Ciudades();
                        ciudad.setId(resultSet.getInt("ID"));
                        ciudad.setNombre(resultSet.getString("Nombre"));
                        ciudad.setDescripcion(resultSet.getString("Descripcion"));
                        ciudad.setPoblacion(resultSet.getInt("Poblacion"));
                        ciudad.setPaisID(resultSet.getInt("PaisID"));
                        Paises pais= new Paises();
                        pais.setNombre(resultSet.getString("NombreCiu"));
                        ciudad.setPais(pais);
                        ciudades.add(ciudad);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al buscar productos", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return ciudades;
    }
    
}
