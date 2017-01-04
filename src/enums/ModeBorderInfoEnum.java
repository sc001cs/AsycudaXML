package enums;

public enum ModeBorderInfoEnum {

	DETARE("10", "Detare"),
	DETAR_RIF("11", "Detar rifuxho"),
	DETAR_BAG("12", "Detar gabaljere"),
	DETAR_KAM_HAPUR("13", "Detar kamion i hapur"),
	DETAR_TRAJ_HAPUR("14", "Detar trajler i hapur"),
	DETAR_CDO_MJET_HAPUR("15", "Detar cdo mjet tjeter i hapur"),
	HEKURUDHE("20", "Hekurudhe"),
	TRAILER("31", "Trailer"),
	KAMION("32", "Kamion"),
	FURGON("33", "Furgon"),
	VETURE("34", "Veture"),
	TRANSP_RRUG_HAPUR("35", "Transport rrugor i hapur"),
	TRANSP_RRUG_CISTERNA("36", "Transport rrugor me cisterna"),
	AJRORE("40", "Ajrore"),
	POSTE("50", "Poste"),
	MULTIMODALE("60", "Multimodale"),
	INST_FIKSUAR("70", "Instalime te fiksuara"),
	TUBACIONE("75", "Me tubacione"),
	LIQEN("80", "Liqen"),
	VETELEVIZJE("90", "Me vetelevizje");
	
	String cod;
	String desc;
	
	private ModeBorderInfoEnum(String cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
