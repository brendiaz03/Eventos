package ar.edu.unlam.pb2;

public class Usuario {
	private String mailOrganizador;
	private String nombreOrganizador;
	private Integer edadOrganizador;
	
	
	public Usuario(String mailOrganizador, String nombreOrganizador, Integer edadOrganizador) {
		this.mailOrganizador = mailOrganizador;
		this.nombreOrganizador = nombreOrganizador;
		this.edadOrganizador = edadOrganizador;
	}


	public String getMailOrganizador() {
		return mailOrganizador;
	}


	public void setMailOrganizador(String mailOrganizador) {
		this.mailOrganizador = mailOrganizador;
	}


	public String getNombreOrganizador() {
		return nombreOrganizador;
	}


	public void setNombreOrganizador(String nombreOrganizador) {
		this.nombreOrganizador = nombreOrganizador;
	}


	public Integer getEdadOrganizador() {
		return edadOrganizador;
	}


	public void setEdadOrganizador(Integer edadOrganizador) {
		this.edadOrganizador = edadOrganizador;
	}
	
	

}
