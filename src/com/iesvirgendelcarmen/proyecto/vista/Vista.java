package com.iesvirgendelcarmen.proyecto.vista;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Vista {

	private JFrame frame;
//	private JTable table;
	private JMenuItem mntmCargarDatos;
	private JScrollPane scrollPane;
	private JTabbedPane tabbedPane;
	private JMenu mnDatos;
	private JMenuBar menuBar;
	private JMenuItem menuItemAcercaDe;
	private JMenuItem menuItemSalir;
	private JButton btnAnadirDatos;
	private JButton btnBorrarDatos;
	private JButton btnActualizarDatos;
	private JSplitPane splitPane;
	private JPanel panelIzquierdo;
	private JPanel panelDerecho;
	private JLabel lblId;
	private JTextField textFieldID;
	private JLabel lblCiudad;
	private JTextField textFieldCiudad;
	private JLabel lblPais;
	private JTextField textFieldPais;
	private JLabel lblLatitud;
	private JTextField textFieldLatitud;
	private JLabel lblLongitud;
	private JTextField textFieldLongitud;
	private JPanel panelBotones;
	private JButton botonMenos10;
	private JButton botonMenos1;
	private JButton botonMas1;
	private JButton botonMas10;
	private JPanel panelFiltros;
	private JComboBox<String> comboBoxCiudad;
	private JPanel panelFiltros1;
	private JComboBox<String> comboBoxPais;
	private JPanel panelBotonesIzda;
	private JButton botonBuscar;
	private JButton botonReset;
	
	public JMenuItem getMntmCargarDatos() {
		return mntmCargarDatos;
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 550);
		frame.setResizable(false);
		frame.setTitle("Proyecto de programacion");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnDatos = new JMenu("Datos");
		menuBar.add(mnDatos);
		
		mntmCargarDatos = new JMenuItem("Cargar datos");
		mnDatos.add(mntmCargarDatos);
		
		menuItemSalir = new JMenuItem("Salir");
		mnDatos.add(menuItemSalir);
		
		JMenu mnAcercaDe = new JMenu("Acerca de");
		menuBar.add(mnAcercaDe);
		
		menuItemAcercaDe = new JMenuItem("Acerca de");
		mnAcercaDe.add(menuItemAcercaDe);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		splitPane = new JSplitPane();
		tabbedPane.addTab("Filtros", null, splitPane, null);
		
		panelIzquierdo = new JPanel();
		splitPane.setLeftComponent(panelIzquierdo);
		panelIzquierdo.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelFiltros = new JPanel();
		panelIzquierdo.add(panelFiltros);
		
		JLabel lblCiudad1 = new JLabel("Ciudad");
		panelFiltros.add(lblCiudad1);
		
		panelFiltros1 = new JPanel();
		panelIzquierdo.add(panelFiltros1);
		
		comboBoxCiudad = new JComboBox<String>();
		comboBoxCiudad.setEnabled(false);
		panelFiltros.add(comboBoxCiudad);
		
		JLabel lblPais1 = new JLabel("Pais");
		panelFiltros1.add(lblPais1);
		comboBoxPais = new JComboBox<String>();
		comboBoxPais.setEnabled(false);
		panelFiltros1.add(comboBoxPais);
		
		panelBotonesIzda = new JPanel();
		panelIzquierdo.add(panelBotonesIzda);
		
		botonBuscar = new JButton("Buscar");
		panelBotonesIzda.add(botonBuscar);
		
		botonReset = new JButton("Reset");
		panelBotonesIzda.add(botonReset);
		botonBuscar.setEnabled(false);
		botonReset.setEnabled(false);
		
		panelDerecho = new JPanel();
		splitPane.setRightComponent(panelDerecho);
		panelDerecho.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblId = new JLabel("ID");
		panelDerecho.add(lblId);
		
		textFieldID = new JTextField();
		panelDerecho.add(textFieldID);
		textFieldID.setColumns(10);
		
		lblCiudad = new JLabel("Ciudad");
		panelDerecho.add(lblCiudad);
		
		textFieldCiudad = new JTextField();
		panelDerecho.add(textFieldCiudad);
		textFieldCiudad.setColumns(10);
		
		lblPais = new JLabel("Pais");
		panelDerecho.add(lblPais);
		
		textFieldPais = new JTextField();
		panelDerecho.add(textFieldPais);
		textFieldPais.setColumns(10);
		
		lblLatitud = new JLabel("Latitud");
		panelDerecho.add(lblLatitud);
		
		textFieldLatitud = new JTextField();
		panelDerecho.add(textFieldLatitud);
		textFieldLatitud.setColumns(10);
		
		lblLongitud = new JLabel("Longitud");
		panelDerecho.add(lblLongitud);
		
		textFieldLongitud = new JTextField();
		panelDerecho.add(textFieldLongitud);
		textFieldLongitud.setColumns(10);
		
		panelBotones = new JPanel();
		panelDerecho.add(panelBotones);
		
		botonMenos10 = new JButton("<<");
		panelBotones.add(botonMenos10);
		botonMenos10.setEnabled(false);
		
		botonMenos1 = new JButton("<");
		panelBotones.add(botonMenos1);
		botonMenos1.setEnabled(false);
		
		botonMas1 = new JButton(">");
		panelBotones.add(botonMas1);
		botonMas1.setEnabled(false);
		
		botonMas10 = new JButton(">>");
		panelBotones.add(botonMas10);
		botonMas10.setEnabled(false);
		
		btnAnadirDatos = new JButton("Anadir datos");
		
		btnBorrarDatos = new JButton("Borrar datos");
		
		btnActualizarDatos = new JButton("Actualizar datos");
		
		
	}


	public JFrame getFrame() {
		return frame;
	}
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public JMenu getMnDatos() {
		return mnDatos;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public JButton getBtnAnadirDatos() {
		return btnAnadirDatos;
	}

	public JButton getBtnBorrarDatos() {
		return btnBorrarDatos;
	}

	public JButton getBtnActualizarDatos() {
		return btnActualizarDatos;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public JPanel getPanelIzquierdo() {
		return panelIzquierdo;
	}

	public JPanel getPanelDerecho() {
		return panelDerecho;
	}

	public JLabel getLblId() {
		return lblId;
	}

	public JTextField getTextFieldID() {
		return textFieldID;
	}

	public JLabel getLblCiudad() {
		return lblCiudad;
	}

	public JTextField getTextFieldCiudad() {
		return textFieldCiudad;
	}

	public JLabel getLblPais() {
		return lblPais;
	}


	public JLabel getLblLatitud() {
		return lblLatitud;
	}


	public JLabel getLblLongitud() {
		return lblLongitud;
	}


	public JTextField getTextFieldPais() {
		return textFieldPais;
	}

	public JTextField getTextFieldLatitud() {
		return textFieldLatitud;
	}

	public JTextField getTextFieldLongitud() {
		return textFieldLongitud;
	}

	public JMenuItem getMenuItemAcercaDe() {
		return menuItemAcercaDe;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public JButton getBotonMenos10() {
		return botonMenos10;
	}

	public JButton getBotonMenos1() {
		return botonMenos1;
	}

	public JButton getBotonMas1() {
		return botonMas1;
	}

	public JButton getBotonMas10() {
		return botonMas10;
	}

	public JPanel getPanelFiltros() {
		return panelFiltros;
	}

	public JComboBox<String> getComboBoxCiudad() {
		return comboBoxCiudad;
	}

	public JPanel getPanelFiltros1() {
		return panelFiltros1;
	}

	public JComboBox<String> getComboBoxPais() {
		return comboBoxPais;
	}

	public JPanel getPanelBotonesIzda() {
		return panelBotonesIzda;
	}

	public JButton getBotonBuscar() {
		return botonBuscar;
	}

	public JButton getBotonReset() {
		return botonReset;
	}

	public JMenuItem getMenuItemSalir() {
		return menuItemSalir;
	}
	
	
	
}
