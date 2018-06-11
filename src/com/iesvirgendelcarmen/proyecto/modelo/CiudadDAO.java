package com.iesvirgendelcarmen.proyecto.modelo;

import java.util.List;

public interface CiudadDAO {
	
	List<CiudadDTO> listarCiudades();
	boolean crearBaseDeDatos();
	boolean borrarCiudad(CiudadDTO ciudad);
	boolean actualizarCiudad(CiudadDTO ciudad);
	boolean insertarCiudad(CiudadDTO ciudad);
	boolean insertarListaCiudades(List<CiudadDTO> listaCiudades);
	void completarArrays(List<CiudadDTO> listaCiudades);
}
