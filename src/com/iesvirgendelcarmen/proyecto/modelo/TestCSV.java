package com.iesvirgendelcarmen.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

public class TestCSV {
	public static void main(String[] args) {
		String path = "datos/ciudades.csv";
		
		
		List<CiudadDTO> lista = new ArrayList<>();
		lista = LeerCSVCiudades.obtenerListaCiudadesCSV(path);
		
		System.out.println(lista.get(1).getNombreCiudad());
	}
}
