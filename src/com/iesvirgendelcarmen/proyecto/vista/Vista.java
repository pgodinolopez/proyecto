package com.iesvirgendelcarmen.proyecto.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;

public class Vista {

	private JFrame frame;
//	private JTable table;
	private JMenuItem mntmCargarDatos;
	private JScrollPane scrollPane;
	private JTabbedPane tabbedPane;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnDatos = new JMenu("Datos");
		menuBar.add(mnDatos);
		
		mntmCargarDatos = new JMenuItem("Cargar datos");
		mnDatos.add(mntmCargarDatos);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
	//	table = new JTable();
	/*	scrollPane = new JScrollPane();
		tabbedPane.addTab("Tabla", null, scrollPane, null);*/
		
		
		
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
	
}
