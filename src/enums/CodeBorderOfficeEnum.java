package enums;

public enum CodeBorderOfficeEnum {

	BERATI("343", "Berati"),
	KAKAVIJA("3511", "Kakavija"),
	SARANDA("352", "Saranda"),
	QAFE_BOTA("3521", "Qafe Bota"),
	TRE_URAT("353", "Tre Urat"),
	TVSH_KOMP("900", "TVSH Kompesim"),
	DERG_TE_KRYER("7", "Dergesa te kryera"),
	SHKODRA("AL010000", "Shkodra"),
	HANI_HOTIT("AL020000", "Hani i Hotit");
	
	String cod;
	String desc;
	
	private CodeBorderOfficeEnum(String cod, String desc) {
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
