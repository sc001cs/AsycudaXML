package configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map.Entry;

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

	
	/**
	 * @param hmGenInfoColsNameAndPosit
	 * @param value
	 * @return get key by value
	 */
	public int getKeyByValueHashMap(HashMap<Integer, String> hmGenInfoColsNameAndPosit, String value) {
		hmGenInfoColsNameAndPosit.get(1);
		int index = 999;
		for (Entry<Integer, String> entry : hmGenInfoColsNameAndPosit.entrySet()) {
            if (entry.getValue().equals(value)) {
            	index = entry.getKey();
            	break;
            }
        }
		
		if(index == 999) {
			System.err.println("**** ERROR ****\n "
					+ " Cos Name: " + value + " not found!");
		}
		
		return index;
	}
	
}
