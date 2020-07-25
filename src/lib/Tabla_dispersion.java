package lib;

import java.util.*;

import lib.Simbolo.Tipo_simbolo;
import lib.exceptions.SimboloExistenteException;
import lib.exceptions.SimboloNoEncontradoException; 

public class Tabla_dispersion {
	
	//M = nº primo cercano a una potencia de 2 (2^7)
	private final int M = 127; 
	private List<Integer> T = new ArrayList<Integer>();
	private LinkedList<Simbolo>[] tabla = new LinkedList[M];

	public Tabla_dispersion() {
		for(int i = 0; i < 255; ++i) {
			T.add(i);
		}
		Collections.shuffle(T);
		
		for(int i = 0; i < M; ++i) {
			tabla[i] = new LinkedList<Simbolo>();
		}
	}
	
	public void nuevoSimbolo(Simbolo s) {
		tabla[hash(s.getNombre())].addFirst(s);
	}
	
	public Simbolo buscarSimbolo(String n) throws SimboloNoEncontradoException {
		int h = hash(n);
		Simbolo s = null;
		
		for(int i = 0; i < tabla[h].size(); ++i) {
			s = tabla[h].get(i);
			if(s.getNombre().equals(n) && s.isVisible()) {
				return s;
			}
		}
		throw new SimboloNoEncontradoException("El simbolo " + n + " no existe");
	}
	
	public void existeSimbolo(String n, int l) throws SimboloExistenteException {
		int h = hash(n);
		Simbolo s = null;
		
		for(int i = 0; i < tabla[h].size(); ++i) {
			s = tabla[h].get(i);
			if(s.getNombre().equals(n) && s.getNivel() == l && s.isVisible()) {
				throw new SimboloExistenteException("El simbolo " + n + " ya existe");
			}
		}
	}
	
	public void eliminarNivel(int n, Tipo_simbolo t) {
		Simbolo s = null;
		ListIterator<Simbolo> itr;
		
		for(int i = 0; i < M; ++i) {
			itr = tabla[i].listIterator();
			while(itr.hasNext()) {
				s = itr.next();
				if(s.getNivel() == n && s.getTipo() == t) {
					itr.remove();
				}
			}
		}
	}
	
	public void ocultarParametros(int n) {
		Simbolo s = null;
		ListIterator<Simbolo> itr;
		
		for(int i = 0; i < M; ++i) {
			itr = tabla[i].listIterator();
			while(itr.hasNext()) {
				s = itr.next();
				if(s.getNivel() == n && s.getTipo() == Tipo_simbolo.PARAMETRO && s.isVisible()) {
					s.setVisible(false);
				}
			}
		}
	}
	
	public void eliminarParametrosOcultos(int n) {
		Simbolo s = null;
		ListIterator<Simbolo> itr;
		
		for(int i = 0; i < M; ++i) {
			itr = tabla[i].listIterator();
			while(itr.hasNext()) {
				s = itr.next();
				if(s.getNivel() == n && s.getTipo() == Tipo_simbolo.PARAMETRO && !s.isVisible()) {
					itr.remove();
				}
			}
		}
	}
	
	//Pearson, 90
	private int hash(String n) {
		int h = 0;
		for(int i = 0; i < n.length(); ++i) {
			h = T.get((h ^ n.charAt(i)) % 255);
		}
		return h % M;
	}
	
}
