package configuration.xml;

import javax.xml.bind.annotation.XmlRootElement;

import configuration.xml.general.GeneralConfig;

@XmlRootElement  
public class ConfigXML {

	public static String rootFolder = "C:\\AsycudaConverter";
	public static String xmlFolder = "C:\\AsycudaConverter\\convertedXML";
	public static String configFolder = "C:\\AsycudaConverter\\config";
	public static String assetFolder = "C:\\AsycudaConverter\\asset";
	
	public static String xmlSource = 
			" <configXML> " +
				" <general> " +
					" <data_format_file>dd-MM-yyyy_kk_mm-ss</data_format_file> " +
					" <utf8>UTF-8</utf8> " +
					" <name_file_excel>E:\\MultiItems.xlsx</name_file_excel> " +
					" <name_file_output>asycudaXML_</name_file_output> " +
					" <path_folder>C:\\AsycudaConverter</path_folder> " +
					" <path_folder_xml>C:\\AsycudaConverter\\convertedXML</path_folder_xml> " +
					" <sheet1> -- Faqja e informacioneve te pergjithshme, posizioni i qelizes: </sheet1> " +
					" <sheet2> -- Faqja e procedurave, posizioni i qelizes: </sheet2> " +
					" <alertFillOutCell>Ju lutem plotesoni qelizen e lene bosh: </alertFillOutCell> " +
				" </general> " +
			" </configXML> ";
	
	private GeneralConfig general;

	public GeneralConfig getGeneral() {
		return general;
	}

	public void setGeneral(GeneralConfig general) {
		this.general = general;
	}
	
}
