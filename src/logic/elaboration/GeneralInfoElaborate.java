package logic.elaboration;

import org.apache.poi.ss.usermodel.Row;

import enitity.asycuda.identification_childs.Type;
import logic.ExcelPoi;

public class GeneralInfoElaborate {

	GeneralInfoValidation genInfoValid = new GeneralInfoValidation();
	
	/**
	 * @param row
	 * @return Type IdentificationChilds
	 */
	public Type getTypeIdentificationChilds(Row row) {
		
		int typeDeclaration_TYPE_IDENT = GeneralInfoPositionCell.typeDeclaration_TYPE_IDENT;
		int declarGenProcCode_TYPE_IDENT = GeneralInfoPositionCell.declarGenProcCode_TYPE_IDENT;
		int typeTransDoc_TYPE_IDENT = GeneralInfoPositionCell.typeTransDoc_TYPE_IDENT;
		
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
	
	
	
}
