package lib;

import java.util.LinkedList;

public class Simbolo {
	
	public static enum Tipo_simbolo {
		PROGRAMA, ACCION, VARIABLE, PARAMETRO
	};
	
	public static enum Clase_parametro {
		REF, VAL
	};
	
	public static enum Tipo_variable {
		DESCONOCIDO, ENTERO, BOOLEANO, CHAR, CADENA
	};
	
	private String nombre;
	private int nivel;
	private Integer tam;
	private Tipo_simbolo tipo;
	private Tipo_variable variable;
	private Clase_parametro parametro;
	private boolean visible;
	private LinkedList<Simbolo> lista_parametros;
	private Long dir;
	
	public Simbolo() { }
	
	public void introducir_programa(String name, Long d) {
		nivel = 0;
		nombre = name;
		variable = null;
		parametro = null;
		lista_parametros = null;
		tipo = Tipo_simbolo.PROGRAMA;
		visible = true;
		dir = d;
		tam = null;
	}
	
	public void introducir_accion(String name, int level, Long d) {
		nivel = level;
		nombre = name;
		variable = null;
		parametro = null;
		lista_parametros = new LinkedList<Simbolo>();
		tipo = Tipo_simbolo.ACCION;
		visible = true;
		dir = d;
		tam = null;
	}
	
	public void introducir_variable(String name, Tipo_variable var, int level, Long d) {
		nivel = level;
		nombre = name;
		variable = var;
		parametro = null;
		lista_parametros = null;
		tipo = Tipo_simbolo.VARIABLE;
		visible = true;
		dir = d;
		tam = null;
	}
	
	public void introducir_vector(String name, Tipo_variable var, int t, int level, Long d) {
		nivel = level;
		nombre = name;
		variable = var;
		parametro = null;
		lista_parametros = new LinkedList<Simbolo>();
		tipo = Tipo_simbolo.VARIABLE;
		visible = true;
		dir = d;
		tam = t;
		
		Simbolo aux;
		Long auxDir = d;
		for(int i = 0; i < tam; ++i) {
			++auxDir;
			aux = new Simbolo();
			aux.introducir_variable(name, var, level, auxDir);
			lista_parametros.add(aux);
		}
	}
	
	public void introducir_parametro(String name, Tipo_variable var, Clase_parametro par, int level, Long d) {
		nivel = level;
		nombre = name;
		variable = var;
		parametro = par;
		lista_parametros = null;
		tipo = Tipo_simbolo.PARAMETRO;
		visible = true;
		dir = d;
		tam = null;
	}
	
	public boolean compararParametros(Simbolo s) {
		for(int i = 0; i < this.numeroParametros(); ++i) {
			Simbolo s1 = this.lista_parametros.get(i),
					s2 = s.getLista_parametros().get(i);
			if(s1.getParametro() != s2.getParametro() ||
			   s1.getTipo() != s2.getTipo() ||
			   s1.getVariable() != s2.getVariable()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean es_variable() {
		return tipo == Tipo_simbolo.VARIABLE;
	}
	
	public boolean es_parametro() {
		return tipo == Tipo_simbolo.PARAMETRO;
	}
	
	public boolean es_accion() {
		return tipo == Tipo_simbolo.ACCION;
	}
	
	public boolean es_desconocido() {
		return variable == Tipo_variable.DESCONOCIDO;
	}
	
	public boolean es_entero() {
		return variable == Tipo_variable.ENTERO;
	}
	
	public boolean es_booleano() {
		return variable == Tipo_variable.BOOLEANO;
	}
	
	public boolean es_caracter() {
		return variable == Tipo_variable.CHAR;
	}
	
	public boolean es_cadena() {
		return variable == Tipo_variable.CADENA;
	}
	
	public boolean es_valor() {
		return parametro == Clase_parametro.VAL;
	}
	
	public boolean es_referencia() {
		return parametro == Clase_parametro.REF;
	}
	
	public boolean es_leible() {
		return (es_variable() || (es_parametro() && es_referencia())) && (es_entero() || es_caracter() || es_desconocido());
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public int getNivel(int i) {
		return lista_parametros.get(i).nivel;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public Tipo_simbolo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo_simbolo tipo) {
		this.tipo = tipo;
	}
	
	public Tipo_variable getVariable() {
		return variable;
	}
	
	public void setVariable(Tipo_variable variable) {
		this.variable = variable;
	}
	
	public Clase_parametro getParametro() {
		return parametro;
	}
	
	public void setParametro(Clase_parametro parametro) {
		this.parametro = parametro;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public LinkedList<Simbolo> getLista_parametros() {
		return lista_parametros;
	}
	
	public void setLista_parametros(LinkedList<Simbolo> lista_parametros) {
		this.lista_parametros = lista_parametros;
	}
	
	public Simbolo getNum(int i) {
		return this.lista_parametros.get(i);
	}
	
	public Long getDir() {
		return dir;
	}
	
	public Long getDir(int i) {
		return lista_parametros.get(i).dir;
	}
	
	public void setDir(Long dir) {
		this.dir = dir;
	}
	
	public Integer getTam() {
		return tam;
	}

	public void setTam(Integer tam) {
		this.tam = tam;
	}

	public int numeroParametros() {
		return this.lista_parametros.size();
	}
	
}
