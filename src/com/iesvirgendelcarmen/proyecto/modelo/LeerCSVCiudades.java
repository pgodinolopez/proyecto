package com.iesvirgendelcarmen.proyecto.modelo;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


public class LeerCSVCiudades {
	private static List<CiudadDTO> listaCiudades = new ArrayList<>();
	
	public static List<CiudadDTO> obtenerListaCiudadesCSV(String csvFilePath) {
	
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
			
			String[] nextRecord;
            
			while ((nextRecord = csvReader.readNext()) != null) {
               listaCiudades.add(new CiudadDTO(Integer.parseInt(nextRecord[0]), nextRecord[1], nextRecord[2], Double.parseDouble(nextRecord[3]), Double.parseDouble(nextRecord[4])));
            }
			
			
		} catch (IOException e) {
			System.out.println("Error IO");
		}
        
	return listaCiudades;
	}
}


