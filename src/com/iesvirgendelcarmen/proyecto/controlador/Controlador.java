package com.iesvirgendelcarmen.proyecto.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
	private int contador = 0;
	private Set<String> conjutoCiudades = new HashSet<>();
	private Set<String> conjutoPaises = new HashSet<>();
	List<CiudadDTO> listaReset = new ArrayList<>();


	public Controlador(Vista vista) {
		this.vista = vista;
		registrarComponentes();
	}

	private void colocarFormularioCiudad(int i, List<CiudadDTO> lista) {

		if(listaCiudades.size()>0) {
			vista.getTextFieldID().setText(
					listaCiudades.get(i).getIdCiudad()+"");
			vista.getTextFieldCiudad().setText(
					listaCiudades.get(i).getNombreCiudad());
			vista.getTextFieldPais().setText(
					listaCiudades.get(i).getNombrePais()+"");
			vista.getTextFieldLatitud().setText(
					listaCiudades.get(i).getLatitud()+"");
			vista.getTextFieldLongitud().setText(
					listaCiudades.get(i).getLongitud()+"");

		}

	}


	private void registrarComponentes() {

		vista.getMntmCargarDatos().addActionListener(this);
		vista.getMenuItemAcercaDe().addActionListener(this);

		vista.getBtnAnadirDatos().addActionListener(this);
		vista.getBtnBorrarDatos().addActionListener(this);
		vista.getBotonMas1().addActionListener(this);
		vista.getBotonMas10().addActionListener(this);
		vista.getBotonMenos1().addActionListener(this);
		vista.getBotonMenos10().addActionListener(this);
		vista.getBotonBuscar().addActionListener(this);
		vista.getBotonReset().addActionListener(this);

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

			case ">":
				System.out.println("pulsado " + textoBoton);
				contador++;

				break;

			case ">>":
				System.out.println("pulsado " + textoBoton);
				contador+=10;

				break;	

			case "<":
				System.out.println("pulsado " + textoBoton);
				contador--;

				break;

			case "<<":
				System.out.println("pulsado " + textoBoton);
				contador-=10;

				break;	

			case "Buscar":
				List<CiudadDTO> listaFiltrada = new ArrayList<>();

				String ciudad = (String) vista.getComboBoxCiudad().getSelectedItem();
				String pais = (String) vista.getComboBoxPais().getSelectedItem();
				
				if(ciudad.equals("")&&pais.equals("")) {
					JOptionPane.showMessageDialog(null, "Debes introducir al menos un parametro de busqueda");
				} else {
				for (CiudadDTO ciudad1 : listaCiudades) {
					
					if ((ciudad1.getNombreCiudad().equals(ciudad) ||
							ciudad1.getNombrePais().equals(pais))) {
						listaFiltrada.add(ciudad1);
					}
				}
				listaCiudades = listaFiltrada;
				contador = 0;
				
				}
				break;	

			case "Reset" :
				listaCiudades = listaReset;
				contador = 0;
				break;	
			default:
				break;
			}
			if(listaCiudades.size()>=1) {
			contador = contador % listaCiudades.size();
			contador %= listaCiudades.size();  
			if (contador < 0)
				contador += listaCiudades.size();
			colocarFormularioCiudad(contador, listaCiudades);
			} else {
				JOptionPane.showMessageDialog(null, "La ciudad especificada no existe");
			}
			
		}

	}

	private void desplegarInformacion() {
		JOptionPane jpJOptionPane = new JOptionPane();
		jpJOptionPane.showMessageDialog(vista.getFrame(), 
				"Creado por Pedro Javier Godino Lopez 1º DAM", "Informacion autor",
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

		panelBotones.add(vista.getBtnBorrarDatos());

		panelTablas.add(panelBotones);

		table.setFillsViewportHeight(true);
		vista.getBtnActualizarDatos().setEnabled(true);
		vista.getBtnAnadirDatos().setEnabled(true);
		vista.getBtnBorrarDatos().setEnabled(true);

		if(manipularCiudades.listarCiudades().size()<=0) {
			manipularCiudades.crearBaseDeDatos();
			manipularCiudades.insertarListaCiudades(listaCiudades);
			manipularCiudades.completarArrays(listaCiudades);
		}

		for (CiudadDTO ciudad : listaCiudades) {
			conjutoCiudades.add(ciudad.getNombreCiudad());
			conjutoPaises.add(ciudad.getNombrePais());
			listaReset.add(ciudad);
		}

		vista.getComboBoxCiudad().addItem("");
		for (String string : conjutoCiudades) {
			vista.getComboBoxCiudad().addItem(string);
		}
		vista.getComboBoxPais().addItem("");
		for (String string : conjutoPaises) {
			vista.getComboBoxPais().addItem(string);
		}
		colocarFormularioCiudad(contador, listaCiudades);
		vista.getBotonMas1().setEnabled(true);
		vista.getBotonMas10().setEnabled(true);
		vista.getBotonMenos1().setEnabled(true);
		vista.getBotonMenos10().setEnabled(true);
		vista.getBotonReset().setEnabled(true);
		vista.getBotonBuscar().setEnabled(true);
		vista.getComboBoxCiudad().setEnabled(true);
		vista.getComboBoxPais().setEnabled(true);

		return true;


	}


}
