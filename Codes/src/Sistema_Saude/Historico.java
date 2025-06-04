package Sistema_Saude;

public class Historico {
	private String cod;
	private String consulta;
	private String dataConsulta;
	private String horaConsulta;
	private String exame;
	private String dataExame;
	private String horaExame;
	
	public Historico(String cod,String consulta, String dataConsulta, String horaConsulta, String exame, String dataExame,String horaExame) {
		this.cod = cod;
		this.consulta = consulta;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
		this.exame = exame;
		this.dataExame = dataExame;
		this.horaExame = horaExame;
	}
	
	public Historico() {}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public void setHoraConsulta(String horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}

	public void setHoraExame(String horaExame) {
		this.horaExame = horaExame;
	}

	public String getConsulta() {
		return consulta;
	}

	public String getDataConsulta() {
		return dataConsulta;
	}

	public String getHoraConsulta() {
		return horaConsulta;
	}

	public String getExame() {
		return exame;
	}

	public String getDataExame() {
		return dataExame;
	}

	public String getHoraExame() {
		return horaExame;
	}
	
	public String getCod() {
		return cod;
	}
	
}