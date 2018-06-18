package com.iesvirgendelcarmen.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

public class TestDAOImp {
	public static void main(String[] args) {
		CiudadDAOImp ciudad = new CiudadDAOImp();
		List<CiudadDTO> listaCiudades = new ArrayList<>();
		CiudadDTO ciudad1 = new CiudadDTO(1, "YO", "SAVITE", 1.345, 2.222);
		CiudadDTO ciudad2 = new CiudadDTO(2000, "CAVITE", "SAVITE", 1.345, 2.222);
		CiudadDTO ciudad3 = new CiudadDTO(2, "LA PEQUENA", "SAVITE", 1.341, 2.223);
		CiudadDTO ciudad4 = new CiudadDTO(3, "JAEN", "ESPANA", 1.3412, 2.21223);
		CiudadDTO ciudad5 = new CiudadDTO(4, "MICIUDAD", "UN PAIS", 1.11341, 2.234223);
		//System.out.println(ciudad.crearBaseDeDatos());
		//System.out.println(ciudad.insertarCiudad(ciudad2));
		//System.out.println(ciudad.borrarCiudad(ciudad2));
		//System.out.println(ciudad.actualizarCiudad(ciudad2));
		System.out.println(ciudad.listarCiudades());
		//listaCiudades.add(ciudad4);
		//listaCiudades.add(ciudad5);
		//System.out.println(ciudad.insertarListaCiudades(listaCiudades));
	}
}
