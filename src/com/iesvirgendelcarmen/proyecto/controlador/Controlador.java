package com.iesvirgendelcarmen.proyecto.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import com.iesvirgendelcarmen.proyecto.vista.Vista;

public class Controlador implements ActionListener {
	private Vista vista;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//agrupamos jmenuitem
		if (e.getSource().getClass() == JMenuItem.class) {
			//System.out.println("pulsado un menú item");
			JMenuItem menuItem = (JMenuItem) e.getSource();
			//identificamos el jmenuitem que genera el evento
			if (menuItem.getText().equals("Cargar datos"))
				lanzarEleccionFichero();
			
		}
	}

/*	private void lanzarEleccionFichero() {
		JFileChooser jFileChooser = new JFileChooser(".");
		int resultado = jFileChooser.showOpenDialog(vista.getFrame());
		if (resultado == jFileChooser.APPROVE_OPTION) {
			path = jFileChooser.getSelectedFile().getPath();
			colectivo = new Colectivo(path);
			listaPersona = colectivo.getListaPersona();
			for (Persona persona : listaPersona) {
				listaReset.add(persona);
				conjutoLenguajes.add(persona.getLenguaje());
				conjutoRazas.add(persona.getRaza());
			}
			//System.out.println("Tamaño lista " + listaLenguajes.size());
			//System.out.println("Tamaño conjunto " + conjutoLenguajes.size());
			for (String string : conjutoLenguajes) {
				vista.getComboBoxLenguaje().addItem(string);
			}
			for (String string : conjutoRazas) {
				vista.getComboBoxRaza().addItem(string);
			}
			colocarFormularioPersona(contador, listaPersona);
			vista.getBotonMas1().setEnabled(true);
			vista.getBotonMas10().setEnabled(true);
			vista.getBotonMenos1().setEnabled(true);
			vista.getBotonMenos10().setEnabled(true);
			vista.getMenuItemCargar().setEnabled(false);
			vista.getComboBoxLenguaje().setEnabled(true);
			vista.getComboBoxRaza().setEnabled(true);
			vista.getBotonReset().setEnabled(true);
			vista.getBotonBuscar().setEnabled(true);
			ModeloTabla mtTabla = new ModeloTabla(colectivo);
			JTable jTable = new JTable(mtTabla);
			jTable.getModel().addTableModelListener(this);
			vista.getScrollPane().setViewportView(jTable);
			
}
		
	}*/

}
