%--------------------------------------------------------
Programa vector_mal;
%--------------------------------------------------------

  entero a1, a[5], a2;
  caracter b[3];
  
  % mal, vector sin tamano
  booleano c[8], mal[0];

%--------------------------------------------------------
Principio

	a1 := 7;
	a2 := 0;
    
	% mal, desbordamiento underflow
	a[-1] := 3;
	a[5 - 10] := 9;
	a[a1 - 2 * a1] := 4;
	
	% mal, desbordamiento overflow
	c[10] := false;
	c[5 * 5] := true;
	c[2 * a1] := false;
	
	% mal, indice no entero
	b[true] := "t";
	b["c"] := "o";
	b["f" < "y"] := "p";
	
	% mal, variable a2 no es un vector
	a2[3] := 5;
	
	% mal, variable desconocida
	v := 3;
	
	% bien, indice de tipo desconocido
	b[v] := "J";
	
Fin
