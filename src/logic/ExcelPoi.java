package logic;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelPoi {

	public static String getString(Row rc, int nc) {
		
		if(rc == null) return null;
		
		Cell cc = rc.getCell((short) nc);

		if (cc != null) {
			switch (cc.getCellType()) {
			case Cell.CELL_TYPE_BLANK:
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				break;
			case Cell.CELL_TYPE_ERROR:
				break;
			case Cell.CELL_TYPE_FORMULA:
				break;
			case Cell.CELL_TYPE_NUMERIC:
				return covertCellNumericToString(cc);
			case Cell.CELL_TYPE_STRING:
				return cc.getRichStringCellValue().getString();
			}
		}
		return null;
	}

	private static String covertCellNumericToString(Cell cc) {

		cc.setCellType(Cell.CELL_TYPE_STRING);
		return cc.getRichStringCellValue().getString();
	}

}
