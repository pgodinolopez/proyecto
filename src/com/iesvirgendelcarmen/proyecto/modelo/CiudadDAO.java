package com.iesvirgendelcarmen.proyecto.modelo;

import java.util.List;

public interface CiudadDAO {
	
	List<CiudadDTO> listarCiudades();
	boolean crearBaseDeDatos();
	boolean borrarCiudad(String nombreCiudad, String nombrePais);
	boolean actualizarCiudad(CiudadDTO ciudad);
	boolean insertarCiudad(CiudadDTO ciudad);
	boolean insertarListaCiudades(List<CiudadDTO> listaCiudades);
	
}
