package com.iesvirgendelcarmen.proyecto.modelo;

public class CiudadDTO {
	
	private int idCiudad;
	private String nombreCiudad;
	private String nombrePais;
	private double latitud;
	private double longitud;
	
	public CiudadDTO(int idCiudad, String nombreCiudad, String nombrePais, double latitud, double longitud) {
		this.idCiudad = idCiudad;
		this.nombreCiudad = nombreCiudad;
		this.nombrePais = nombrePais;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	
	
	public int getIdCiudad() {
		return idCiudad;
	}



	public String getNombreCiudad() {
		return nombreCiudad;
	}



	public String getNombrePais() {
		return nombrePais;
	}



	public double getLatitud() {
		return latitud;
	}



	public double getLongitud() {
		return longitud;
	}



	@Override
	public String toString() {
		return "CiudadesDTO [idCiudad=" + idCiudad + ", nombreCiudad=" + nombreCiudad + ", nombrePais=" + nombrePais
				+ ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	
	
	
}
