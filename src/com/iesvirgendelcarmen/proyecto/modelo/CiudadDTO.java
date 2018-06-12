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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCiudad;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CiudadDTO other = (CiudadDTO) obj;
		if (idCiudad != other.idCiudad)
			return false;
		return true;
	}
	
	
	
}
