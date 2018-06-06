package com.iesvirgendelcarmen.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {
	
	String[] cabecera;
	Object[][] datos;
	
	String path = "datos/ciudades.csv";
	
	List<CiudadDTO> lista = LeerCSVCiudades.obtenerListaCiudadesCSV(path);
	
	
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
