package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Evento {
	private List<Usuario> invitados;
	private List<Usuario> invitaciones;
	private Usuario organizador;
	private String nombreDeEvento;
	private List<Usuario> agasajados;
	
	public Evento(String nombreDeEvento) {
		this.nombreDeEvento= nombreDeEvento;
		this.invitados= new ArrayList<>();
		this.agasajados= new ArrayList<>();
		this.invitaciones=new ArrayList<>();
	}

	public List<Usuario> getInvitados() {
		return invitados;
	}

	public void setInvitados(List<Usuario> invitados) {
		this.invitados = invitados;
	}

	public Usuario getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Usuario organizador) {
		this.organizador = organizador;
	}
	
	public String getNombreDeEvento() {
		return nombreDeEvento;
	}

	public void setNombreDeEvento(String nombreDeEvento) {
		this.nombreDeEvento = nombreDeEvento;
	}
	
	public List<Usuario> getAgasajados() {
		return agasajados;
	}

	public void setAgasajados(List<Usuario> agasajados) {
		this.agasajados = agasajados;
	}

	public void add(Agasajado agasajado) {
		agasajados.add(agasajado);
	}

	public List<Usuario> getInvitaciones() {
		return invitaciones;
	}

	public void setInvitaciones(List<Usuario> invitaciones) {
		this.invitaciones = invitaciones;
	}
	
	public void addInvitaciones(Usuario usuario) {
		invitaciones.add(usuario);
	}
	public void addInvitados(Usuario usuario) {
		invitados.add(usuario);
	}
}
