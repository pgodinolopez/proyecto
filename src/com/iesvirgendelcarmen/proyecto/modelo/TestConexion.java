package com.iesvirgendelcarmen.proyecto.modelo;

import java.sql.Connection;

public class TestConexion {
	public static void main(String[] args) {
		Connection conexion0 = Conexion.getConexion();
		Connection conexion1 = Conexion.getConexion();
	
		System.out.println(conexion0);
		System.out.println(conexion1);
	}
}
