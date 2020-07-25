%--------------------------------------------------------
Programa vector_bien;
%--------------------------------------------------------

  entero a1, a[5], a2;
  caracter b[3], b1;
  booleano c1, c[8];

%-------------------------------------------------------------------
accion prueba(val entero e1; ref entero e2);
%-------------------------------------------------------------------

 principio
  escribir(e1, " ", e2, entacar (13), entacar (10));
 fin 

%--------------------------------------------------------
Principio
    
	a[1] := 3;
	a[0] := 9;
	a[2 + 2] := 7;
	
	c[2] := false;
	c[0] := true;
	
	b[1] := "t";
	b[2] := "o";
	
	a1 := 7;
	a2 := 0;
	
	b1 := "7";
	
	c1 := false;
	
	escribir("Vectores: ", b[1], b[2], " ", a[1], a[0], " ", c[0], " ", c[2], entacar (13), entacar (10));
	escribir("a[4]: ", a[4], entacar (13), entacar (10));
	escribir("Variables: ", b1, " ", a1, a2, " ", c1, entacar (13), entacar (10));
	
	prueba(a[1], a[0]);
	
Fin
