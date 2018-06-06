package com.iesvirgendelcarmen.proyecto.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.iesvirgendelcarmen.proyecto.modelo.CiudadDAOImp;
import com.iesvirgendelcarmen.proyecto.modelo.CiudadDTO;
import com.iesvirgendelcarmen.proyecto.modelo.LeerCSVCiudades;
import com.iesvirgendelcarmen.proyecto.modelo.ModeloTabla;
import com.iesvirgendelcarmen.proyecto.vista.Vista;

public class Controlador implements ActionListener, TableModelListener {
	private Vista vista;
	private String path=".";
	CiudadDAOImp manipularCiudades = new CiudadDAOImp();
	private List<CiudadDTO> listaCiudades;
	LeerCSVCiudades leerCSV = new LeerCSVCiudades();



	public Controlador(Vista vista) {
		this.vista = vista;
		registrarComponentes();
	}

	private void registrarComponentes() {
		vista.getMntmCargarDatos().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//agrupamos jmenuitem
		if (e.getSource().getClass() == JMenuItem.class) {
			//System.out.println("pulsado un menu item");
			JMenuItem menuItem = (JMenuItem) e.getSource();
			//identificamos el jmenuitem que genera el evento
			if (menuItem.getText().equals("Cargar datos"))
				lanzarEleccionFichero();

		}
	}

	private boolean lanzarEleccionFichero() {
		JFileChooser jFileChooser = new JFileChooser("./datos");
		int resultado = jFileChooser.showOpenDialog(vista.getFrame());
		if (resultado == jFileChooser.APPROVE_OPTION) {
			path = jFileChooser.getSelectedFile().getPath();
			if(listaCiudades==null) {
				listaCiudades = leerCSV.obtenerListaCiudadesCSV(path);

			}

			if(manipularCiudades.listarCiudades().size()<=0) {
				manipularCiudades.crearBaseDeDatos();
				manipularCiudades.insertarListaCiudades(listaCiudades);
				manipularCiudades.completarArrays(listaCiudades);
			}

			for (CiudadDTO ciudadDTO : listaCiudades) {

			}
			//System.out.println("Tamaño lista " + listaLenguajes.size());
			//System.out.println("Tamaño conjunto " + conjutoLenguajes.size());



			vista.getTable().setEnabled(true);
			//ModeloTabla mtTabla = new ModeloTabla(manipularCiudades);
			//JTable jtable = new JTable(mtTabla);
			//jtable.getModel().addTableModelListener(this);
			//vista.getScrollPane().setViewportView(jtable);
			vista.getMntmCargarDatos().setEnabled(true);
			JScrollPane scrollPane = new JScrollPane(vista.getTable(),JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

			pintarDatosTabla();
		}
		return true;
		

	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub

	}

	private void pintarDatosTabla() {
		List<CiudadDTO> listaCiudades = manipularCiudades.listarCiudades();
		manipularCiudades.completarArrays(listaCiudades);
		DefaultTableModel mode1 = new DefaultTableModel(manipularCiudades.getDatos(), manipularCiudades.getCabecera()) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return column > 0;
			}


		};
		vista.getTable().setModel(mode1);
		
	}

}
