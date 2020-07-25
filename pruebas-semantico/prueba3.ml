%--------------------------------------------------------
Programa desconocido_y_leer;
%--------------------------------------------------------

  entero r;
  caracter c;
  booleano b;

%-------------------------------------------------------------------
accion sin;
%-------------------------------------------------------------------

 principio
  escribir("accion");
 fin 

%--------------------------------------------------------
Principio
    % mal, simbolo no encontrado
	m := 54;
	
	% bien, simbolo introducido como DESCONOCIDO
	m := "2";
	m := false;
	r := caraent(m);
	c := entacar(m);
	
	% mal
	a;
	
	% bien
	a;
	
	% bien
	a(r, c);
	
	% bien
	sin;
	sin();
	
	% bien
	leer(m);
	
	% bien
	leer(c);
	
	% mal
	leer(b);
	
	% mal
	leer(sin);
	
	% mal
	escribir(sin);
	
	% mal
	leer(4 + 1);
	
Fin
