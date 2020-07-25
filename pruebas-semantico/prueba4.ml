%--------------------------------------------------------
Programa escritura;
%--------------------------------------------------------

    booleano b;
	entero e;
	caracter c;

%--------------------------------------------------------
Principio
%--------------------------------------------------------

	b := true;
	e := 10;
	c := "g";
	
	% bien
	escribir(b, entacar(13), entacar(10));
	escribir(false, entacar(13), entacar(10));
	escribir((true) and (b), entacar(13), entacar(10));
	
	% bien
	escribir(5, entacar(13), entacar(10));
	escribir(e, entacar(13), entacar(10));
	escribir(6 + 10, entacar(13), entacar(10));
	
	% bien
	escribir(c, entacar(13), entacar(10));
	escribir("y", entacar(13), entacar(10));
	
	% bien
	escribir("bien", entacar(13), entacar(10));
	
Fin
