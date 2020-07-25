package lib;

import lib.Simbolo.Clase_parametro;
import lib.Simbolo.Tipo_variable;
import lib.exceptions.DesbordamientoEnterosException;
import lib.exceptions.DivisionPorCeroException;
import lib.exceptions.ModuloDeCeroException;
import lib.exceptions.TiposDiferentesException;

public class RegistroExpr {
	
	public static enum Tipo_operador {
		DIV, MUL, MOD, AND, SUMA, RESTA, OR, NI, MAI, MEI, MAYOR, MENOR, IGUAL
	};
	
	private Integer valor;
	private Boolean bool;
	private Character car;
	private Tipo_variable tipo;
	private Clase_parametro clase;
	private Integer nivel;
	private Long dir;
	
	public RegistroExpr() { 
		this.valor = null;
		this.car = null;
		this.bool = null;
		this.tipo = null;
		this.clase = null;
		this.dir = null;
		this.nivel = null;
	}
	
	public RegistroExpr(Simbolo s) {
		if(s.es_parametro()) {
			this.clase = s.getParametro();
		} else {
			this.clase = null;
		}
		this.nivel = s.getNivel();
		this.dir = s.getDir();
		this.tipo = s.getVariable();
		this.valor = null;
		this.car = null;
		this.bool = null;
	}
	
	public void operacion(RegistroExpr r2, Tipo_operador type) throws TiposDiferentesException, DivisionPorCeroException, ModuloDeCeroException, DesbordamientoEnterosException {
		if(tipoCorrecto(type) && operacionOk(r2)) {
			switch(type) {
				case DIV:
					if(r2.getValor() != null) {
						if(r2.getValor() != 0) {
							if(this.valor != null) {
								this.valor = getValor() / r2.getValor();
							}
						} else {
							throw new DivisionPorCeroException("Detectada division entre 0");
						}
					} 
					break;
				case MOD: 
					if(r2.getValor() != null) {
						if(r2.getValor() != 0) {
							if(this.valor != null) {
								this.valor = getValor() % r2.getValor();
							}
						} else {
							throw new ModuloDeCeroException("Detectado modulo de 0");
						}
					} 
					break;
				case MUL:
					if(this.valor != null && r2.getValor() != null) {
					  desbordamientoEnteros(r2, type);
					  this.valor = getValor() * r2.getValor();
					}
					break;
				case SUMA:
					if(this.valor != null && r2.getValor() != null) {
					  desbordamientoEnteros(r2, type);
					  this.valor = getValor() + r2.getValor();
					}
					break;
				case RESTA:
					if(this.valor != null && r2.getValor() != null) {
					  desbordamientoEnteros(r2, type);
					  this.valor = getValor() - r2.getValor();
					}
					break;
				case AND:
					if(this.bool != null && r2.isBool() != null) {
					  this.bool = isBool() && r2.isBool();
					}
					break;
				case OR:
					if(this.bool != null && r2.isBool() != null) {
					  this.bool = isBool() || r2.isBool();
					}
					break;
				default:
					this.tipo = Tipo_variable.BOOLEANO;
			}
		}
	}
	
	public boolean tipoCorrecto(Tipo_operador tipo) throws TiposDiferentesException {
		if((tipo == Tipo_operador.AND || tipo == Tipo_operador.OR) && 
			this.tipo != Tipo_variable.BOOLEANO && this.tipo != Tipo_variable.DESCONOCIDO) {
			throw new TiposDiferentesException("Los dos tipos no concuerdan");
		}
		if((tipo == Tipo_operador.DIV || tipo == Tipo_operador.SUMA || 
			tipo == Tipo_operador.MUL || tipo == Tipo_operador.RESTA ||
			tipo == Tipo_operador.MOD) && this.tipo != Tipo_variable.ENTERO &&
			this.tipo != Tipo_variable.DESCONOCIDO) {
			throw new TiposDiferentesException("Los dos tipos no concuerdan");
		}
		return true;
	}
	
	public boolean operacionOk(RegistroExpr r) throws TiposDiferentesException {
		if(this.tipo != r.getTipo() && this.tipo != Tipo_variable.DESCONOCIDO && r.getTipo() != Tipo_variable.DESCONOCIDO) {
			throw new TiposDiferentesException("Los dos tipos no concuerdan");
		}
		return true;
	}
	
	public void operacionOk(Tipo_variable r) throws TiposDiferentesException {
		if(this.tipo != r && this.tipo != Tipo_variable.DESCONOCIDO && r != Tipo_variable.DESCONOCIDO) {
			throw new TiposDiferentesException("Los dos tipos no concuerdan");
		}
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public void setValor(Long valor) throws DesbordamientoEnterosException {
		desbordamientoEnteros(valor);
		this.valor = valor.intValue();
	}

	public Boolean isBool() {
		return bool;
	}

	public void setBool(Boolean bool) {
		this.bool = bool;
	}

	public Character getCar() {
		return car;
	}

	public void setCar(Character car) {
		this.car = car;
	}

	public Tipo_variable getTipo() {
		return tipo;
	}

	public void setTipo(Tipo_variable tipo) {
		this.tipo = tipo;
	}

	public Clase_parametro getClase() {
		return clase;
	}

	public void setClase(Clase_parametro clase) {
		this.clase = clase;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Long getDir() {
		return dir;
	}

	public void setDir(Long dir) {
		this.dir = dir;
	}

	private void desbordamientoEnteros(RegistroExpr r, Tipo_operador t) throws DesbordamientoEnterosException {
		long aux = Long.valueOf(this.valor);
		switch(t) {
			case SUMA:
				aux += Long.valueOf(r.getValor());
				break;
			case RESTA:
				aux -= Long.valueOf(r.getValor());
				break;
			case MUL:
				aux *= Long.valueOf(r.getValor());
				break;
			default:
				return;
		}
		if(aux > Integer.MAX_VALUE || aux < Integer.MIN_VALUE) {
			throw new DesbordamientoEnterosException("Entero fuera de rango");
		}
	}
	
	private void desbordamientoEnteros(long aux) throws DesbordamientoEnterosException {
		if(aux > Integer.MAX_VALUE || aux < Integer.MIN_VALUE) {
			throw new DesbordamientoEnterosException("Entero fuera de rango");
		}
	}
	
}
