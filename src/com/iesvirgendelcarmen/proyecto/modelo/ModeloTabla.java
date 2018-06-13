package com.iesvirgendelcarmen.proyecto.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {
	CiudadDAOImp manipularCiudades = new CiudadDAOImp();
	Object[][] datos;
	Object[] cabecera;
	int contador = 40;
	
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
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return getValueAt(0, columnIndex).getClass();
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
        int i = ((Integer) datos[rowIndex][0]).intValue();
        double d = ((Double) datos[rowIndex][3]).doubleValue();
        double d2 = ((Double) datos[rowIndex][4]).doubleValue();
        CiudadDTO ciudadActualizar = new CiudadDTO(i,(String) datos[rowIndex][1], (String) datos[rowIndex][2],d, d2);
		manipularCiudades.actualizarCiudad(ciudadActualizar);
        //System.out.println(new datos[rowIndex][0] + "--" + datos[rowIndex][2]);
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	public void deleteRow(int row) {
		contador--;
		//crea objeto de la fila row (data[row][0], data[row][1] ....
		//llamar DAO para borrar  con el objeto anterior
		// Pelicula peliculaBorrar = new Pelicula(data[row][0], data[row][1], ....)
		//peliculaDAO.borrar(peliculaBorrar);
		int in = ((Integer) datos[row][0]).intValue();
        double d = ((Double) datos[row][3]).doubleValue();
        double d2 = ((Double) datos[row][4]).doubleValue();
        CiudadDTO ciudadBorrar = new CiudadDTO(in,(String) datos[row][1], (String) datos[row][2],d, d2);
        
        manipularCiudades.borrarCiudad(ciudadBorrar);
        List<CiudadDTO> listaCiudades = manipularCiudades.listarCiudades();
        
        datos = new Object[listaCiudades.size()][5];
        
		for (int i = 0; i <listaCiudades.size(); i++) {
			datos[i][0] = listaCiudades.get(i).getIdCiudad();
			datos[i][1] = listaCiudades.get(i).getNombreCiudad();
			datos[i][2] = listaCiudades.get(i).getNombrePais();
			datos[i][3] = listaCiudades.get(i).getLatitud();
			datos[i][4] = listaCiudades.get(i).getLongitud();
		}
        
		
		fireTableDataChanged();

	}
	public void annadirDatos() {
		JTextField id = new JTextField();
		JTextField ciudad = new JTextField();
		JTextField pais = new JTextField();
		JTextField latitud = new JTextField();
		JTextField longitud = new JTextField();
		Object[] mensaje = {
				"ID", id,
				"Ciudad", ciudad,
				"Pais", pais,
				"Latitud", latitud,
				"Longitud", longitud
		};
		int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Nueva ciudad", JOptionPane.OK_CANCEL_OPTION);

		if(opcion==JOptionPane.OK_OPTION) {
			
			CiudadDTO ciudadACrear = new CiudadDTO(Integer.parseInt(id.getText()), ciudad.getText(), pais.getText(), Double.parseDouble(latitud.getText()), Double.parseDouble(longitud.getText()));
			
			manipularCiudades.insertarCiudad(ciudadACrear);			
			
			List<CiudadDTO> listaCiudades = manipularCiudades.listarCiudades();
	        
	        datos = new Object[listaCiudades.size()][5];
	        
			for (int i = 0; i <listaCiudades.size(); i++) {
				datos[i][0] = listaCiudades.get(i).getIdCiudad();
				datos[i][1] = listaCiudades.get(i).getNombreCiudad();
				datos[i][2] = listaCiudades.get(i).getNombrePais();
				datos[i][3] = listaCiudades.get(i).getLatitud();
				datos[i][4] = listaCiudades.get(i).getLongitud();
			}
			
			JOptionPane.showMessageDialog(null, "Ciudad insertada correctamente");
			
			
		} else {
			JOptionPane.showMessageDialog(null, "Operacion cancelada");
		}
		fireTableDataChanged();
	}
	
}
