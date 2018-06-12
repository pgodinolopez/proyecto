package com.iesvirgendelcarmen.proyecto.vista;

import java.awt.EventQueue;

import javax.swing.JButton;
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
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

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
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnDatos = new JMenu("Datos");
		menuBar.add(mnDatos);
		
		mntmCargarDatos = new JMenuItem("Cargar datos");
		mnDatos.add(mntmCargarDatos);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		splitPane = new JSplitPane();
		tabbedPane.addTab("Filtros", null, splitPane, null);
		
		panelIzquierdo = new JPanel();
		splitPane.setLeftComponent(panelIzquierdo);
		
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
	//	table = new JTable();
	/*	scrollPane = new JScrollPane();
		tabbedPane.addTab("Tabla", null, scrollPane, null);*/
		btnAnadirDatos = new JButton("Anadir datos");
		//panelBotones.add(btnAnadirDatos);
		//btnAnadirDatos.setEnabled(false);
		btnBorrarDatos = new JButton("Borrar datos");
		//panelBotones.add(btnBorrarDatos);
		//btnBorrarDatos.setEnabled(false);
		btnActualizarDatos = new JButton("Actualizar datos");
		//panelBotones.add(btnActualizarDatos);
		//btnActualizarDatos.setEnabled(false);
		
	}

/*	public JTable getTable() {
		return table;
	}*/

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
	
	
}
