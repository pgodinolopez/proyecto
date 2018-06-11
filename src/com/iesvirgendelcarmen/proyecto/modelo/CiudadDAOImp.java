package com.iesvirgendelcarmen.proyecto.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAOImp implements CiudadDAO {
	Connection conexion = Conexion.getConexion();
	private String[] cabecera = {"id", "ciudad", "pais", "latitud", "longitud"};
	private Object[][] datos;
	

	@Override
	public List<CiudadDTO> listarCiudades() {
		List<CiudadDTO> listaCiudades = new ArrayList<>();
		String sql = "SELECT * FROM ciudades;";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);) {
			ResultSet resulSet = preparedStatement.executeQuery();
			while(resulSet.next()) {
				CiudadDTO ciudad = new CiudadDTO(resulSet.getInt(1), resulSet.getString(2), resulSet.getString(3), resulSet.getDouble(4), resulSet.getDouble(5));
				listaCiudades.add(ciudad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaCiudades;
	}

	@Override
	public boolean crearBaseDeDatos() {
		String sql = "DROP TABLE IF EXISTS ciudades;" 
				+ "CREATE TABLE ciudades " 
				+ "(id INTEGER PRIMARY KEY NOT NULL, "
				+ "ciudad TEXT,"
				+ "pais TEXT,"
				+ "latitud DOUBLE,"
				+ "longitud DOUBLE);";
		try {
			Statement st = conexion.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			return false;
		}
		
		
	}

	@Override
	public boolean borrarCiudad(CiudadDTO ciudad) {
		int resultado = 0;
		//String sql = "DELETE FROM ciudades WHERE ciudad = ? AND pais = ?;";
		String sql = "DELETE FROM ciudades WHERE id = ? AND ciudad = ? AND pais = ? AND latitud = ? AND longitud = ?;";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);) {
			
			preparedStatement.setInt(1, ciudad.getIdCiudad());
			preparedStatement.setString(2, ciudad.getNombreCiudad());
			preparedStatement.setString(3, ciudad.getNombrePais());
			preparedStatement.setDouble(4, ciudad.getLatitud());
			preparedStatement.setDouble(5, ciudad.getLongitud());
			
			resultado = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado != 0;
	}

	@Override
	public boolean insertarCiudad(CiudadDTO ciudad) {
		int resultado = 0; 
		String sql = "INSERT INTO ciudades (id, ciudad, pais, latitud, longitud) VALUES (?,?,?,?,?);";
		try (PreparedStatement pStatement = conexion.prepareStatement(sql);) {
			pStatement.setInt(1, ciudad.getIdCiudad());
			pStatement.setString(2, ciudad.getNombreCiudad());
			pStatement.setString(3, ciudad.getNombrePais());
			pStatement.setDouble(4, ciudad.getLatitud());
			pStatement.setDouble(5, ciudad.getLongitud());
			resultado = pStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Datos insertados");
		return resultado!=0;
	}

	@SuppressWarnings("finally")
	@Override
	public boolean insertarListaCiudades(List<CiudadDTO> listaCiudades) {
		try {
			conexion.setAutoCommit(false);
			for (CiudadDTO ciudadDTO : listaCiudades) {
				insertarCiudad(ciudadDTO);
				
			}
			conexion.commit();
			conexion.setAutoCommit(true);
			return true;
			
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				System.out.println("No se han podido insertar los datos de la lista");
				try {
					conexion.setAutoCommit(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return false;
			}
		}
		
		
	}

	@Override
	public boolean actualizarCiudad(CiudadDTO ciudad) {
		int resultado = 0;
		String sql = "UPDATE ciudades SET ciudad = ?, pais = ?, latitud = ?, longitud = ? WHERE id = ?;";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);) {
			
			preparedStatement.setString(1, ciudad.getNombreCiudad());
			preparedStatement.setString(2, ciudad.getNombrePais());
			preparedStatement.setDouble(3, ciudad.getLatitud());
			preparedStatement.setDouble(4, ciudad.getLongitud());
			preparedStatement.setInt(5, ciudad.getIdCiudad());
			
			resultado = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado != 0;
	}
	
	@Override
	public void completarArrays(List<CiudadDTO> listaCiudades) {
		datos = new Object[listaCiudades.size()][5];
		int contador = 0;
		for (CiudadDTO ciudadDTO : listaCiudades) {
			datos[contador][0] = ciudadDTO.getIdCiudad();
			datos[contador][1] = ciudadDTO.getNombreCiudad();
			datos[contador][2] = ciudadDTO.getNombrePais();
			datos[contador][3] = ciudadDTO.getLatitud();
			datos[contador][4] = ciudadDTO.getLongitud();
			contador++;
		}
	}
	
	public String[] getCabecera() {
		return cabecera;
	}

	public Object[][] getDatos() {
		return datos;
	}

	
}
