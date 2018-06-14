package com.iesvirgendelcarmen.proyecto.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;

import com.iesvirgendelcarmen.proyecto.modelo.CiudadDAOImp;
import com.iesvirgendelcarmen.proyecto.modelo.CiudadDTO;
import com.iesvirgendelcarmen.proyecto.modelo.LeerCSVCiudades;
import com.iesvirgendelcarmen.proyecto.modelo.ModeloTabla;
import com.iesvirgendelcarmen.proyecto.vista.Vista;

public class Controlador implements ActionListener {
	private Vista vista;
	private String path=".";
	CiudadDAOImp manipularCiudades = new CiudadDAOImp();
	private List<CiudadDTO> listaCiudades = manipularCiudades.listarCiudades();
	LeerCSVCiudades leerCSV = new LeerCSVCiudades();
	private Object[][] datos;
	private Object[] cabecera = {"id", "ciudad", "pais", "latitud", "longitud"};
	private static ModeloTabla mtTable;
	private JTable table;
	private JScrollPane scrollPane;



	public Controlador(Vista vista) {
		this.vista = vista;
		registrarComponentes();
	}

	private void registrarComponentes() {
		vista.getMntmCargarDatos().addActionListener(this);
		vista.getBtnAnadirDatos().addActionListener(this);
		vista.getBtnBorrarDatos().addActionListener(this);
		vista.getMenuItemAcercaDe().addActionListener(this);
		//vista.getBtnActualizarDatos().addActionListener(this);
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
			else if (menuItem.getText().equals("Acerca de"))
				desplegarInformacion();

		}

		//agruparemos jbutton
		if (e.getSource().getClass() == JButton.class) {
			JButton jButton = (JButton) e.getSource();
			String textoBoton = jButton.getText();
			System.out.println(textoBoton);
			switch (textoBoton) {
			case "Anadir datos":
				System.out.println("pulsado " + textoBoton);
				mtTable.annadirDatos();

				break;
			case "Borrar datos":
				System.out.println("pulsado " + textoBoton);
				borrarFila();

				break;

				/*case "Actualizar datos":
				System.out.println("pulsado " + textoBoton);
				actualizarFila();
				break;*/

			default:
				break;
			}

		}

	}

	private void desplegarInformacion() {
		JOptionPane jpJOptionPane = new JOptionPane();
		jpJOptionPane.showMessageDialog(vista.getFrame(), 
				"Creado por PJGL", "Información autor",
				JOptionPane.INFORMATION_MESSAGE);

	}

	private void borrarFila() {

		if(table.getRowCount()>0) {
			if(table.getSelectedRowCount()>0) {
				/*int filaSeleccionada = table.getSelectedRow();
				id = (int) table.getValueAt(filaSeleccionada, 0);
				ciudad = (String) table.getValueAt(filaSeleccionada, 1);
				pais = (String) table.getValueAt(filaSeleccionada, 2);
				latitud = (double) table.getValueAt(filaSeleccionada, 3);
				longitud = (double) table.getValueAt(filaSeleccionada, 4);

				CiudadDTO ciudadABorrar = new CiudadDTO(id, ciudad, pais, latitud, longitud);
				manipularCiudades.borrarCiudad(ciudadABorrar);
				mtTable.fireTableDataChanged();*/
				int filaSeleccionada = table.getSelectionModel().getMinSelectionIndex();
				mtTable.deleteRow(filaSeleccionada);
			}
		}
	}



	private boolean lanzarEleccionFichero() {

		if(listaCiudades.size() == 0) {
			JFileChooser jFileChooser = new JFileChooser("./datos");
			int resultado = jFileChooser.showOpenDialog(vista.getFrame());
			if (resultado == jFileChooser.APPROVE_OPTION) {
				path = jFileChooser.getSelectedFile().getPath();
				listaCiudades = leerCSV.obtenerListaCiudadesCSV(path);

			}
		}
		vista.getMntmCargarDatos().setEnabled(false);
		datos = new Object[listaCiudades.size()][5];

		for (int i = 0; i <listaCiudades.size(); i++) {
			datos[i][0] = listaCiudades.get(i).getIdCiudad();
			datos[i][1] = listaCiudades.get(i).getNombreCiudad();
			datos[i][2] = listaCiudades.get(i).getNombrePais();
			datos[i][3] = listaCiudades.get(i).getLatitud();
			datos[i][4] = listaCiudades.get(i).getLongitud();
		}

		mtTable = new ModeloTabla(datos, cabecera);
		JPanel panelTablas = new JPanel();
		table = new JTable(mtTable);
		scrollPane = new JScrollPane(table);
		panelTablas.add(scrollPane);
		vista.getTabbedPane().addTab("Tabla", null, panelTablas, null);
		JPanel panelBotones = new JPanel();


		panelBotones.add(vista.getBtnAnadirDatos());

		//JButton btnBorrarDatosTabla = new JButton("Borrar datos");
		panelBotones.add(vista.getBtnBorrarDatos());

		//JButton btnActualizarDatosTabla = new JButton("Actualizar datos");
		//panelBotones.add(vista.getBtnActualizarDatos());

		panelTablas.add(panelBotones);


		//	vista.getScrollPane().add(new JButton("hola"));
		table.setFillsViewportHeight(true);
		vista.getBtnActualizarDatos().setEnabled(true);
		vista.getBtnAnadirDatos().setEnabled(true);
		vista.getBtnBorrarDatos().setEnabled(true);

		if(manipularCiudades.listarCiudades().size()<=0) {
			manipularCiudades.crearBaseDeDatos();
			manipularCiudades.insertarListaCiudades(listaCiudades);
			manipularCiudades.completarArrays(listaCiudades);
		}

		/*	for (CiudadDTO ciudadDTO : listaCiudades) {
		 *
		}*/
		//System.out.println("Tamano lista " + listaLenguajes.size());
		//System.out.println("Tamano conjunto " + conjutoLenguajes.size());



		//	vista.getTable().setEnabled(true);


		///	vista.getMntmCargarDatos().setEnabled(true);
		//	JScrollPane scrollPane = new JScrollPane(vista.getTable(),JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


		//	pintarDatosTabla();
		//ModeloTabla mtTabla = new ModeloTabla(manipularCiudades);
		//JTable jtable = new JTable(mtTabla);
		//jtable.getModel().addTableModelListener(this);


		return true;


	}


}
