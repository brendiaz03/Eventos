package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Prueba {

	@Test
	public void queSePuedaCrearUnCumpleanios() {
		// Preparaci�n
		final String mailOrganizador = "chiquitapia@afa.com", nombreOrganizador = "Chiqui Tapia", mailAgasajado = "lio@Messi.com", nombreAgasajado = "Lionel Messi";
		final Integer edadOrganizador = 55, edadAgasajado = 36;
		final Integer cantidadDeUsuariosEsperados = 2, cantidadDeEventosEsperados = 1, cantidadDeCumpleaniosEsperados = 1, cantidadDeCasamientosEsperados = 0;
		Usuario organizador = new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador);
		// Ejecuci�n
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		principal.add(organizador);
		principal.crear(principal.getUsuario(mailOrganizador), new Cumple(new Agasajado(mailAgasajado, nombreAgasajado, edadAgasajado), "El cumple de Lionel Messi"));
		
		// Validaci�n
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeEventosEsperados, principal.getCantidadDeEventos());
		assertEquals(cantidadDeCumpleaniosEsperados, principal.getCantidadDeCumpleanios());
		assertEquals(organizador, principal.getEvento("El cumple de Lionel Messi").getOrganizador());
		assertEquals(cantidadDeCasamientosEsperados, principal.getCantidadDeCasamientos());
	}
	
	@Test
	public void queSePuedaCrearUnCasamiento() {
		// Preparaci�n
		final String mailOrganizador = "roberto@galan.com", nombreOrganizador = "Roberto Galan", mailAgasajado1 = "luli@salazar.com", nombreAgasajado1 = "Luciana Zalazar", mailAgasajado2 = "rodrigo@redrado.com", nombreAgasajado2 = "Rodrigo Redrado", nombreDelEvento = "El casamiento de Luli y Rodri";
		final Integer edadOrganizador = 101, edadAgasajado1 = 36, edadAgasajado2 = 43;
		final Integer cantidadDeUsuariosEsperados = 3, cantidadDeEventosEsperados = 1, cantidadDeCumpleaniosEsperados = 0, cantidadDeCasamientosEsperados = 1;
		Usuario organizador = new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador);
		// Ejecuci�n
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		principal.add(organizador);
		principal.add(new Usuario(mailAgasajado1, nombreAgasajado1, edadAgasajado1));
		principal.add(new Usuario(mailAgasajado2, nombreAgasajado2, edadAgasajado2));
		principal.crear(principal.getUsuario(mailOrganizador), new Casamiento(nombreDelEvento));
		principal.getEvento(nombreDelEvento).add(new Agasajado(mailAgasajado1, nombreAgasajado1, edadAgasajado1));
		principal.getEvento(nombreDelEvento).add(new Agasajado(mailAgasajado1, nombreAgasajado1, edadAgasajado1));		
		// Validaci�n
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeEventosEsperados, principal.getCantidadDeEventos());
		assertEquals(cantidadDeCumpleaniosEsperados, principal.getCantidadDeCumpleanios());
		assertEquals(organizador, principal.getEvento("El casamiento de Luli y Rodri").getOrganizador());
		assertEquals(cantidadDeCasamientosEsperados, principal.getCantidadDeCasamientos());
	}
	
	@Test
	public void queSePuedaInvitarGenteAUnCumpleanios() {
		// Preparaci�n
		final String mailOrganizador = "chiquitapia@afa.com", nombreOrganizador = "Chiqui Tapia", mailAgasajado = "lio@Messi.com", nombreAgasajado = "Lionel Messi";
		final Integer edadOrganizador = 55, edadAgasajado = 36;
		final Integer cantidadDeUsuariosEsperados = 4, cantidadDeInvitadosEsperados = 2;
		
		// Ejecuci�n
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		principal.add(new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador));
		principal.add(new Usuario("kunaguero@kunisports.com", "Sergio Aguero", 36));
		principal.add(new Usuario("kmbappe@second.com", "Kylian Mbapee", 24));
		Usuario organizadorDelEvento = principal.getUsuario(mailOrganizador);
		Evento elCumpleDeLeo = new Cumple(new Agasajado(mailAgasajado, nombreAgasajado, edadAgasajado), "El cumple de Lionel Messi");
		
		principal.crear(organizadorDelEvento, elCumpleDeLeo);
		principal.invitar(elCumpleDeLeo, new Usuario("kunaguero@kunisports.com", "Sergio Aguero", 36));
		principal.invitar(elCumpleDeLeo, new Usuario("kmbappe@second.com", "Kylian Mbapee", 24));
		
		// Validaci�n
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeInvitadosEsperados, principal.getCantidadDeInvitados(elCumpleDeLeo));
	}
	
	@Test
	public void queUnInvitadoPuedaConfirarSuAsistencia () {
		// Preparaci�n
		final String mailOrganizador = "chiquitapia@afa.com", nombreOrganizador = "Chiqui Tapia", mailAgasajado = "lio@Messi.com", nombreAgasajado = "Lionel Messi";
		final Integer edadOrganizador = 55, edadAgasajado = 36;
		final Integer cantidadDeUsuariosEsperados = 4, cantidadDeInvitadosEsperados = 2, cantidadDeInvitadosConfirmados = 1;
		Usuario elKun = new Usuario("kunaguero@kunisports.com", "Sergio Aguero", 36);
		Usuario elSegundo = new Usuario("kmbappe@second.com", "Kylian Mbapee", 24);
		
		// Ejecuci�n
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		principal.add(new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador));
		principal.add(elKun);
		principal.add(elSegundo);
		Usuario organizadorDelEvento = principal.getUsuario(mailOrganizador);
		
		Agasajado agasajado = new Agasajado(mailAgasajado, nombreAgasajado, edadAgasajado);
		Evento cumpleDeLeo = new Cumple(agasajado, "El cumple de Lio");
		principal.crear(organizadorDelEvento, cumpleDeLeo );
		principal.invitar(cumpleDeLeo, elKun);
		principal.invitar(cumpleDeLeo, elSegundo);
		principal.confirmar(cumpleDeLeo, elKun);
		
		// Validaci�n
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeInvitadosEsperados, principal.getCantidadDeInvitados(cumpleDeLeo));
		assertEquals(cantidadDeInvitadosConfirmados, principal.getCantidadDeInvitadosConfirmados(cumpleDeLeo));
	}

}
