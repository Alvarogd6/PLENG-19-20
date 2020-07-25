%--------------------------------------------------------
Programa desbordamiento_y_operaciones;
%--------------------------------------------------------

entero e, r;
caracter c;

%--------------------------------------------------------
Principio
%--------------------------------------------------------

	% mal, desbordamiento de enteros
	e := 2147483649;
	
	% mal, desbordamiento de enteros
	e := -2147483649;
	
	% mal, desbordamiento de enteros
	e := 214748364 * 11;
	
	% mal, desbordamiento de enteros
	e := 2147483641 + 11;
	
	% mal, desbordamiento de enteros
	e := -2147483641 - 11;
	
	% bien
	c := entacar(200);
	
	% mal, desbordamiento ASCII
	c := entacar(256);
	
	% mal, desbordamiento ASCII
	c := entacar(-5);
	
	% bien
	r := 0 / 10;
	
	% mal
	r := 10 / 0;
	
	% bien
	r := 0 div 10;
	
	% mal
	r := 10 div 0;
	
	% bien
	r := 0 mod 10;
	
	% mal
	r := 10 mod 0;

	% bien
	r := caraent("2");
	
Fin
