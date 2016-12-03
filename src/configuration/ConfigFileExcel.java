package configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigFileExcel {


	/**
	 * Convert the file Excel to byte array
	 * @param pathExcel
	 * @return byte array of Excel converted
	 */
	public byte[] getByteFromFile(String pathExcel) {

		if(pathExcel == null && pathExcel.equals(""))
			return null;

		Path path = Paths.get(pathExcel);
		byte[] data = null;

		try {
			data = Files.readAllBytes(path);
		} catch (IOException e) {
			System.out.println("SYSTEM EXIT");

			System.err.println("***ERROR**** \n " + 
					"Template Excel with name: " + pathExcel + 
					"\n Not found!");

			System.exit(0);
		}

		return data;
	}

}
