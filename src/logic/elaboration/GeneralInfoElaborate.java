package logic.elaboration;

import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;

import enitity.asycuda.identification_childs.OfficeSegment;
import enitity.asycuda.identification_childs.Type;
import logic.ExcelPoi;

public class GeneralInfoElaborate {

	GeneralInfoValidation genInfoValid = new GeneralInfoValidation();

	/**
	 * @param row
	 * @return Type IdentificationChilds
	 */
	public Type getTypeIdentificationChilds(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int typeDeclaration_TYPE_IDENT = getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "typeDeclaration_TYPE_IDENT");
		int declarGenProcCode_TYPE_IDENT = getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "declarGenProcCode_TYPE_IDENT");
		int typeTransDoc_TYPE_IDENT = getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "typeTransDoc_TYPE_IDENT");

		String typeDeclaration_TYPE_IDENT_String = ExcelPoi.getString(row, typeDeclaration_TYPE_IDENT);
		String declarGenProcCode_TYPE_IDENT_String = ExcelPoi.getString(row, declarGenProcCode_TYPE_IDENT);
		String typeTransDoc_TYPE_IDENT_String = ExcelPoi.getString(row, typeTransDoc_TYPE_IDENT);

		Type type = new Type();
		type.setType_of_declaration(typeDeclaration_TYPE_IDENT_String);
		type.setDeclaration_gen_procedure_code(declarGenProcCode_TYPE_IDENT_String);
		type.setType_of_transit_document(typeTransDoc_TYPE_IDENT_String);

		genInfoValid.validationCellsTypeIdentificationChilds(type);

		return type;
	}

	/**
	 * @param row
	 * @return OfficeSegment IdentificationChilds
	 */
	public OfficeSegment getOfficeSegmentIdentificationChilds(Row row, HashMap<Integer, String> hmGenInfoColsNameAndPosit) {

		int costumTransDoc_OFFICESEGM_IDENT = getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "costumTransDoc_OFFICESEGM_IDENT");
		int costumClearaOffName_OFFICESEGM_IDENT = getKeyByValueHashMap(hmGenInfoColsNameAndPosit, "costumClearaOffName_OFFICESEGM_IDENT");

		String costumTransDoc_OFFICESEGM_IDENT_String = ExcelPoi.getString(row, costumTransDoc_OFFICESEGM_IDENT);
		String costumClearaOffName_OFFICESEGM_IDENT_String = ExcelPoi.getString(row, costumClearaOffName_OFFICESEGM_IDENT);

		OfficeSegment offSegm = new OfficeSegment();
		offSegm.setCustoms_clearance_office_code(costumTransDoc_OFFICESEGM_IDENT_String);
		offSegm.setCustoms_Clearance_office_name(costumClearaOffName_OFFICESEGM_IDENT_String);

		genInfoValid.validationCellsOfficeSegmentIdentificationChilds(offSegm);

		return offSegm;
	}

	private int getKeyByValueHashMap(HashMap<Integer, String> hmGenInfoColsNameAndPosit, String value) {
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
