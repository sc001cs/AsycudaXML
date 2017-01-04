package enums;

public enum CodeKindPackageEnum {

	RIFUXHO("00", "Rifuxho"),
	AGREG_KNSTRUK("09", "Agregate, konstruksione"),
	AMB_PLAST_PAKETA("100", "Amb plastik ne paketa"),
	FUCI_METAL("11", "Fuci metalike"),
	AMB_QELQ_PALETA("110", "Amb qelqi me paleta"),
	BID_OSE_FUXHI_PLAST("12", "Bidona ose fuxhi plastike"),
	BOMBL_PRES_LARTE("13", "Bombola presioni te larte"),
	BOMBL_GAZ_DJEG("14", "Bombola gazi te djegshem >=3 ltr"),
	BOMBL_VOGL_NJE_PERDORIM("15", "Bombola te vogla me nje perdorim"),
	KANOCE("18", "Kanoce"),
	KARTONA("21", "Kartona"),
	LIDHJE("31", "Lidhje"),
	RROTULLA("32", "Rrotulla"),
	THASE("41", "Thase"),
	DENGJE("42", "Dengje"),
	ARK_PLAST("51", "Arka plastike"),
	ARK_DERRAS("52", "Arka derrase");
	
	String cod;
	String desc;
	
	private CodeKindPackageEnum(String cod, String desc) {
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
