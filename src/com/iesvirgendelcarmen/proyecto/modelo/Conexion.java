package com.iesvirgendelcarmen.proyecto.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.sqlite.SQLiteConfig;


public class Conexion {
	private static Connection conexion;
	
	private Conexion() {
		
		Properties p = new Properties();
		try {
			p.load(new FileReader("BD/BD.properties"));
			String DRIVER = p.getProperty("DRIVER");
			String DB_URL = p.getProperty("DB_URL");
			String BD = p.getProperty("BD");
			Class.forName(DRIVER);
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true);
			try {
				conexion = DriverManager.getConnection(DB_URL + BD,config.toProperties());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	public static Connection getConexion() {
		if(conexion == null) {
			new Conexion();
			Runtime.getRuntime().addShutdownHook(new ShutdownHook());
		}
		return conexion;
	}
	
	static class ShutdownHook extends Thread {

		@Override
		public void run() {
			if (conexion != null)
				try {
					System.out.println("Cerrando conexion");
					conexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		
		}
}
