
import java.awt.EventQueue;

import com.iesvirgendelcarmen.proyecto.controlador.Controlador;

import com.iesvirgendelcarmen.proyecto.vista.Vista;

public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					new Controlador(window);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
