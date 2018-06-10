package com.iesvirgendelcarmen.proyecto.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

public class Controlador implements ActionListener {
	private Vista vista;
	private String path=".";
	CiudadDAOImp manipularCiudades = new CiudadDAOImp();
	private List<CiudadDTO> listaCiudades = manipularCiudades.listarCiudades();
	LeerCSVCiudades leerCSV = new LeerCSVCiudades();
	private Object[][] datos;
	private Object[] cabecera = {"id", "ciudad", "pais", "latitud", "logitud"};
	private ModeloTabla mtTable;
	private JTable table;
	private JScrollPane scrollPane;



	public Controlador(Vista vista) {
		this.vista = vista;
		registrarComponentes();
	}

	private void registrarComponentes() {
		vista.getMntmCargarDatos().addActionListener(this);
		vista.getBtnAnadirDatos().addActionListener(this);
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

		//agruparemos jbutton
		if (e.getSource().getClass() == JButton.class) {
			JButton jButton = (JButton) e.getSource();
			String textoBoton = jButton.getText();
			System.out.println(textoBoton);
			switch (textoBoton) {
			case "Anadir datos":
				System.out.println("pulsado " + textoBoton);
				annadirDatos();
				break;

			default:
				break;
			}

		}

	}





	private void annadirDatos() {

		//	int resultado = JOptionPane.showConfirmDialog(null, textFields, "Añadir datos", JOptionPane.OK_CANCEL_OPTION);
		CiudadDTO ciudad = new CiudadDTO(Integer.parseInt(vista.getTextFieldID().getText()), vista.getTextFieldCiudad().getText(), vista.getTextFieldPais().getText(), Double.parseDouble(vista.getTextFieldLatitud().getText()), Double.parseDouble(vista.getTextFieldLongitud().getText()));
		manipularCiudades.insertarCiudad(ciudad);
		
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
		table = new JTable(mtTable);
		scrollPane = new JScrollPane(table);
		vista.getTabbedPane().addTab("Tabla", null, scrollPane, null);

		//	vista.getScrollPane().add(new JButton("hola"));
		table.setFillsViewportHeight(true);

		if(manipularCiudades.listarCiudades().size()<=0) {
			manipularCiudades.crearBaseDeDatos();
			manipularCiudades.insertarListaCiudades(listaCiudades);
			manipularCiudades.completarArrays(listaCiudades);
		}

		/*	for (CiudadDTO ciudadDTO : listaCiudades) {
		 *
		}*/
		//System.out.println("Tamaño lista " + listaLenguajes.size());
		//System.out.println("Tamaño conjunto " + conjutoLenguajes.size());



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
