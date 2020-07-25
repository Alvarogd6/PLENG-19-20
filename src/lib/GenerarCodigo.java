package lib;

import java.io.FileWriter;
import java.io.IOException;
import lib.exceptions.FicheroNoEscribibleException;
import lib.RegistroExpr.Tipo_operador;

public class GenerarCodigo {
	
	private String nombreFichero;
	private String escribir;
	private long numEtiquetas;
	
	public GenerarCodigo() { 
		//inicializado en -1 para que la primera etiqueta sea la 0
		numEtiquetas = -1; 
		escribir = "";
		nombreFichero = "";
	}
	
	public GenerarCodigo(String name) {
		String aux[] = name.split("\\\\(?=[^\\\\]+$)");
		nombreFichero = "";
		if(aux.length > 1) {
			nombreFichero = aux[0];
		}
		int pos = aux.length - 1;
		if(aux[pos].endsWith(".ml")) {
			nombreFichero += "\\" + aux[pos].subSequence(0, aux[pos].length() - 3);
		} else {
			nombreFichero += "\\" + aux[pos];
		}
		nombreFichero += ".code";
		numEtiquetas = -1;
		escribir = "";
	}
	
	public String nueva_etiqueta() {
		++numEtiquetas;
		return "L" + numEtiquetas;
	}
	
	public void escribir(String s) {
		escribir += s + "\n";
	}
	
	public void operador(Tipo_operador t) {
		if(t != null) {
			switch(t) {
				case DIV:
					escribir("\t DIV");
					break;
				case MUL:
					escribir("\t TMS");
					break;
				case MOD:
					escribir("\t MOD");
					break;
				case AND:
					escribir("\t AND");
					break;
				case SUMA:
					escribir("\t PLUS");
					break;
				case RESTA:
					escribir("\t SBT");
					break;
				case OR:
					escribir("\t OR");
					break;
				case NI:
					escribir("\t NEQ");
					break;
				case MAI:
					escribir("\t GTE");
					break;
				case MEI:
					escribir("\t LTE");
					break;
				case MAYOR:
					escribir("\t GT");
					break;
				case MENOR:
					escribir("\t LT");
					break;
				case IGUAL:
					escribir("\t EQ");
					break;
				default:
			}
		}
	}
	
	public void completar() throws FicheroNoEscribibleException {
		try {
			FileWriter file = new FileWriter(nombreFichero);
			file.write(escribir);
			file.close();
			System.out.println("Compilacion finalizada. Se ha generado el fichero " + nombreFichero);
		} catch(IOException e) {
			throw new FicheroNoEscribibleException("No se ha podido escribir en el fichero " + nombreFichero);
		}
	}
	
	public long getNum() {
		return numEtiquetas;
	}
	
}
