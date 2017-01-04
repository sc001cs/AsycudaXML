package enums;

public enum CodeMValutationEnum {

	MET_TRANS("1", "METODA E TRANSAKSIONIT"),
	MET_MALL_2("2", "METODA E MALLRAVE TE"),
	MET_MALL_3("3", "METODA E MALLRAVE TE"),
	MET_DEDUKTIVE("4", "METODA DEDUKTIVE"),
	MET_LLOG("5", "METODAE LLOGARITJEVE"),
	MET_CMIM("6", "METODA E CMIMEVE RE");
	
	String cod;
	String desc;
	
	private CodeMValutationEnum(String cod, String desc) {
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
