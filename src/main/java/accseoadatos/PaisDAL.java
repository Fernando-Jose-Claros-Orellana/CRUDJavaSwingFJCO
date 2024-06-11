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
}
