package enums;

public enum Nature24Enum {

	SHIT_BLERJE("1", "Shitje/Blerje"),
	RIDERG_PAS_REGJ("2", "Ridergim pas regjistrimit me kod 1"),
	TRANSF_PAS_PA_KOMPESIM("3", "Transferim pasurie pa kompesim"),
	OPERAC_PERP_OSE_RIPARIM("4", "Operacion per perpunimin ose riparimin"),
	OPERAC_PAS_PERP_OSE_RIPAR("5", "Operac pas perpunimit ose riparimit"),
	TRANS_PA_TRANSF_PAS("6", "Transaksion pa transferim pasurie"),
	DERG_TE_KRYER("7", "Dergesa te kryera"),
	FURNIZ_MATER_PER_NDERTIM("8", "Furniz mater dhe paj per ndertim"),
	LLOJ_TJ_TRANS("9", "Lloje te tjera transaksionesh");
	
	String cod;
	String desc;
	
	private Nature24Enum(String cod, String desc) {
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
