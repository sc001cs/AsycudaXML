package enums;

public enum CodePreferenceEnum {

	MSABE("MSABE", "Marreveshja e perkohshme AL-BE"),
	MTLBA("MTLBA", "Marreveshja CEFTA-Bosnje Hercegovine"),
	MTLEFTA("MTLEFTA", "Marreveshja AL-EFTA"),
	MTLMD("MTLMD", "Marreveshja MD-CEFTA 26/07/2002"),
	MTLME("MTLME", "Marreveshja CEFTA-Mal i Zi"),
	MTLMK("MTLMK", "Marreveshja CEFTA-Maqedoni"),
	MTLTR("MTLTR", "Marreveshja Tregetare me Turqine"),
	MTLXK("MTLXK", "Marreveshja XK-CEFTA 26/07/2007");
	
	String cod;
	String desc;
	
	private CodePreferenceEnum(String cod, String desc) {
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
