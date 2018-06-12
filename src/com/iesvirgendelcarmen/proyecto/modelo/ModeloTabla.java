package com.iesvirgendelcarmen.proyecto.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {
	Object[][] datos;
	Object[] cabecera;
	
	public ModeloTabla(Object[][] datos, Object[] cabecera) {
		this.datos = datos;
		this.cabecera = cabecera;
		
	}

	
	
	
	
	
	

	

	//String path = "datos/ciudades.csv";
	
	//List<CiudadDTO> lista = LeerCSVCiudades.obtenerListaCiudadesCSV(path);
	
	
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cabecera.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return datos[row][col];
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) cabecera[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (columnIndex < 2)
			return false;
		
		return true;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		datos[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
	}
	
}
