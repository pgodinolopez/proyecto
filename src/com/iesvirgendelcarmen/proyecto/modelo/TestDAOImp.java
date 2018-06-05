package com.iesvirgendelcarmen.proyecto.modelo;

public class TestDAOImp {
	public static void main(String[] args) {
		CiudadDAOImp ciudad = new CiudadDAOImp();
		
		CiudadDTO ciudad1 = new CiudadDTO(1, "YO", "SAVITE", 1.345, 2.222);
		CiudadDTO ciudad2 = new CiudadDTO(1, "CAVITE", "SAVITE", 1.345, 2.222);
		CiudadDTO ciudad3 = new CiudadDTO(2, "LA GRANDE", "SAVITE", 1.341, 2.223);
		//System.out.println(ciudad.crearBaseDeDatos());
		//System.out.println(ciudad.insertarCiudad(ciudad3));
		//System.out.println(ciudad.borrarCiudad("YO", "SAVITE"));
		//System.out.println(ciudad.actualizarCiudad(ciudad2));
		//System.out.println(ciudad.listarCiudades());
	}
}
