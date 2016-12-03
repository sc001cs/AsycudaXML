package logic.elaboration;

import enitity.asycuda.identification_childs.Type;

public class GeneralInfoValidation {

	public void validationCellsTypeIdentificationChilds(Type type) {

		if(type.getType_of_declaration() == null || 
				type.getType_of_declaration().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: typeDeclaration_TYPE_IDENT -- Sheet1 Cell 0");
		}

		if(type.getDeclaration_gen_procedure_code() == null && 
				type.getDeclaration_gen_procedure_code().equals("")) {

			System.err.println("***** ERROR *****\n "
					+ "Please fill out: declarGenProcCode_TYPE_IDENT -- Sheet1 Cell 1");
		}

	}

}
