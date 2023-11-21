package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlanificadorDeEventos {
	
	private List<Usuario> usuarios;
	private HashMap<Usuario, Evento> eventos;
	
	public PlanificadorDeEventos(){
		this.usuarios= new ArrayList<>();
		this.eventos= new HashMap<>();
	}

	public Boolean add(Usuario usuario) {
		if(usuario == null) {
			return false;
		}else {
			usuarios.add(usuario);
			return true;
		}
	}

	public Usuario getUsuario(String mailOrganizador) {
		for(Usuario e: usuarios) {
			if(e.getMailOrganizador().equals(mailOrganizador)) {
				return e;
			}
		}
		return null;
	}

	public void crear(Usuario usuario, Evento nuevo) {
		if(nuevo instanceof Cumple) {
		Cumple c = (Cumple)nuevo;
		for(Usuario a : c.getAgasajados()) {
			usuarios.add(a);
		}
		c.setOrganizador(usuario);
		eventos.put(usuario, nuevo);
		}else {
			nuevo.setOrganizador(usuario);
			eventos.put(usuario, nuevo);
		}
	}

	public Integer getCantidadDeUsuarios() {
		Integer contados = 0;
		for(Usuario u: usuarios) {
			contados++;
		}
		return contados;
	}

	public Integer getCantidadDeEventos() {
		Integer contadorE = 0;
		for (Map.Entry<Usuario, Evento> entry : eventos.entrySet()) {
            Usuario clave = entry.getKey();
            Evento Evento = entry.getValue();
            contadorE++;
        }
		return contadorE;
	}

	public Integer getCantidadDeCumpleanios() {
		Integer contadorC = 0;
		for (Map.Entry<Usuario, Evento> entry : eventos.entrySet()) {
			Evento e = entry.getValue();
			if(e instanceof Cumple) {
				contadorC++;
			}
        }
		return contadorC;
	}

	public Evento getEvento(String nombreDelEvento) {
		List<Cumple> cumples = new ArrayList<>();
		for (Map.Entry<Usuario, Evento> entry : eventos.entrySet()) {
			Evento e = entry.getValue();
			if(e.getNombreDeEvento().equals(nombreDelEvento)){
				return e;
			}
		}
		return null;
	}

	public Integer getCantidadDeCasamientos() {
		Integer contadorCa = 0;
		for (Map.Entry<Usuario, Evento> entry : eventos.entrySet()) {
			Evento e = entry.getValue();
			if(e instanceof Casamiento) {
				contadorCa++;
			}
        }
		return contadorCa;
	}

	public void invitar(Evento evento, Usuario usuario) {
		if(getEvento(evento.getNombreDeEvento()) != null){
			getEvento(evento.getNombreDeEvento()).addInvitaciones(usuario);
		}
	}

	public Integer getCantidadDeInvitados(Evento evento) {
		Integer contadorInvitaciones = 0;
		for(Usuario u : getEvento(evento.getNombreDeEvento()).getInvitaciones()){
			contadorInvitaciones++;
		}
		return contadorInvitaciones++;
	}

	public void confirmar(Evento evento, Usuario usuario) {
		if(getEvento(evento.getNombreDeEvento()) != null){
			getEvento(evento.getNombreDeEvento()).addInvitados(usuario);
		}
		
	}

	public Integer getCantidadDeInvitadosConfirmados(Evento evento) {
		Integer contadorInvitados = 0;
		for(Usuario u : getEvento(evento.getNombreDeEvento()).getInvitados()){
			contadorInvitados++;
		}
		return contadorInvitados++;
	}


}
