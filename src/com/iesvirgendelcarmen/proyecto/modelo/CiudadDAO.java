package com.iesvirgendelcarmen.proyecto.modelo;

import java.util.List;

public interface CiudadDAO {
	
	List<CiudadDTO> listarCiudades();
	boolean borrarCiudad(String nombreCiudad, String nombrePais);
	boolean actualizarCiudad(CiudadDTO ciudad, String nombreCiudad);
	boolean insertarCiudad(CiudadDTO libro);
	boolean insertarListaCiudades(List<CiudadDTO> listaCiudades);
}
