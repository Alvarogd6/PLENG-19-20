package lib;

public class Tabla_estadisticas {
	private static final int totalTokens = 47;
	public static enum tokens {
		tPROGRAMA, tPRINCIPIO, tFIN, tSI, tSI_NO, tENT, tFSI, tMQ, tFMQ, tACCION,
		tPCOMA, tCOMA, tENTACAR, tCARAENT, tESCRIBIR, tLEER, tENTERO, tVAR,
		tBOOLEANO, tCARACTER, tVAL, tREF, tNI, tMAI, tMEI, tMAYOR, tMENOR, tIGUAL,
		tNOT, tAND, tOR, tTRUE, tFALSE, tPAREN_DCHA, tPAREN_IZQ, tCOR_DCHA, tCOR_IZQ, 
		tSUMA, tRESTA, tMUL, tDIV, tMOD, tOPAS, tIDENTIFICADOR, tCONSTENTERA, tCONSTCAD, 
		tCONSTCHAR
	};
	private static String[] nombreTokens = {
		"tPROGRAMA", "tPRINCIPIO", "tFIN", "tSI", "tSI_NO", "tENT", "tFSI", "tMQ", 
		"tFMQ", "tACCION", "tPCOMA", "tCOMA", "tENTACAR", "tCARAENT", "tESCRIBIR",
		"tLEER", "tENTERO", "tVAR",	"tBOOLEANO", "tCARACTER", "tVAL", "tREF",
		"tNI", "tMAI", "tMEI", "tMAYOR", "tMENOR", "tIGUAL", "tNOT", "tAND", "tOR",
		"tTRUE", "tFALSE", "tPAREN_DCHA", "tPAREN_IZQ", "tCOR_DCHA", "tCOR_IZQ",
		"tSUMA", "tRESTA", "tMUL", "tDIV", "tMOD", "tOPAS", "tIDENTIFICADOR",
		"tCONSTENTERA", "tCONSTCAD", "tCONSTCHAR"
	};
	public static int table[] = new int[totalTokens];
	
	public Tabla_estadisticas() {
		for(int i = 0; i < totalTokens; ++i) {
		     table[i] = 0;
		}
	}
	
	public static void incrementar(tokens t) {
		++table[t.ordinal()];
	}

	public static void estadisticas() {
		System.out.println("|----------------------------------------------|");
		System.out.println("|-                Estadísticas                -|");
		System.out.println("|----------------------------------------------|");
		System.out.println("|-       Tokens       -|-     Apariciones     -|");
		System.out.println("|----------------------------------------------|");
		System.out.println("|-             Palabras reservadas            -|");
		System.out.println("|----------------------------------------------|");
		for(int i = 0; i < totalTokens; ++i) {
		if(i == 12) {
			System.out.println("|----------------------------------------------|");
		    System.out.println("|-                 Operaciones                -|");
		    System.out.println("|----------------------------------------------|");
		  } else if(i == 16) {
			System.out.println("|----------------------------------------------|");
		    System.out.println("|-               Tipos de datos               -|");
		    System.out.println("|----------------------------------------------|");
		  } else if(i == 22) {
			System.out.println("|----------------------------------------------|");
		    System.out.println("|-             Operadores lógicos             -|");
		    System.out.println("|----------------------------------------------|");
		  } else if(i == 33) {
			System.out.println("|----------------------------------------------|");
		    System.out.println("|-           Operadores aritméticos           -|");
		    System.out.println("|----------------------------------------------|");
		  } else if(i == 43) {
			System.out.println("|----------------------------------------------|");
		    System.out.println("|-                   Valores                  -|");
		    System.out.println("|----------------------------------------------|");
		  }
		  String aux = "| ";
		  aux += String.format("%-19s", nombreTokens[i]) + " -|- ";
		  aux += String.format("%-19d", table[i]) + " -|";
		  System.out.println(aux);
	    }
		System.out.println("|----------------------------------------------|");
	}
}
