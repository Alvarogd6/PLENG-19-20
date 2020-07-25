package lib;

import lib.Simbolo.Clase_parametro;
import lib.Simbolo.Tipo_simbolo;
import lib.Simbolo.Tipo_variable;
import lib.exceptions.SimboloExistenteException;
import lib.exceptions.SimboloNoEncontradoException; 

public class Tabla_simbolos {
	
	private Tabla_dispersion tabla;

	public Tabla_simbolos() {
		inicializar_tabla();
	}
	
	public void inicializar_tabla() {
		tabla = new Tabla_dispersion();
	}
	
	public Simbolo buscar_simbolo(String nombre) throws SimboloNoEncontradoException {
		return tabla.buscarSimbolo(nombre);
	}
	
	public Simbolo introducir_programa(String nombre, Long dir) {
		Simbolo s = new Simbolo();
		s.introducir_programa(nombre, dir);
		tabla.nuevoSimbolo(s);
		
		return s;
	}
	
	public Simbolo introducir_variable(String nombre, Tipo_variable variable, 
			int nivel, Long dir) throws SimboloExistenteException {
		tabla.existeSimbolo(nombre, nivel);
		
		Simbolo s = new Simbolo();
		s.introducir_variable(nombre, variable, nivel, dir);
		tabla.nuevoSimbolo(s);
		
		return s;
	}
	
	public Simbolo introducir_vector(String nombre, Tipo_variable variable, 
			int tam, int nivel, Long dir) throws SimboloExistenteException {
		tabla.existeSimbolo(nombre, nivel);
		
		Simbolo s = new Simbolo();
		s.introducir_vector(nombre, variable, tam, nivel, dir);
		tabla.nuevoSimbolo(s);
		
		return s;
	}
	
	public Simbolo introducir_accion(String nombre, int nivel, Long dir)
			throws SimboloExistenteException {
		tabla.existeSimbolo(nombre, nivel);
		
		Simbolo s = new Simbolo();
		s.introducir_accion(nombre, nivel, dir);
		tabla.nuevoSimbolo(s);
		
		return s;
	}
	
	public Simbolo introducir_parametro(String nombre, Tipo_variable variable, 
			Clase_parametro parametro, int nivel, Long dir) throws SimboloExistenteException {
		tabla.existeSimbolo(nombre, nivel);
		
		Simbolo s = new Simbolo();
		s.introducir_parametro(nombre, variable, parametro, nivel, dir);
		tabla.nuevoSimbolo(s);
		
		return s;
	}
	
	public void eliminar_programa() {
		tabla.eliminarNivel(0, Tipo_simbolo.PROGRAMA);
	}
	
	public void eliminar_variables(int nivel) {
		tabla.eliminarNivel(nivel, Tipo_simbolo.VARIABLE);
	}
	
	public void ocultar_parametros(int nivel) {
		tabla.ocultarParametros(nivel);
	}
	
	public void eliminar_parametros_ocultos(int nivel) {
		tabla.eliminarParametrosOcultos(nivel);
	}
	
	public void eliminar_acciones(int nivel) {
		tabla.eliminarNivel(nivel + 1,  Tipo_simbolo.PARAMETRO);
		tabla.eliminarNivel(nivel, Tipo_simbolo.ACCION);
	}
	
}
