%--------------------------------------------------------
Programa parametros;
%--------------------------------------------------------

  booleano b;
  
%-------------------------------------------------------------------
accion a1(ref entero a; val entero b);
%-------------------------------------------------------------------

 principio
 
  % mal
  leer(b);
  
  % bien
  leer(a);
  
 fin 

%-------------------------------------------------------------------
accion a4(val entero a, b);
%-------------------------------------------------------------------

 principio
  escribir("accion");
 fin

%-------------------------------------------------------------------
accion a2(ref entero a, b);
%-------------------------------------------------------------------

 entero c;

 principio
 
  % bien
  a := 14;
  
  % bien
  a4(a, b);
  
  % bien
  a1(c, a);
  
  % bien
  a1(a, c);
  
  % bien
  escribir(a);
  
  % bien
  c := a + 1;
  
 fin
 
%-------------------------------------------------------------------
accion a3(val entero a, b);
%-------------------------------------------------------------------

 entero c;
 booleano g;

 principio
 
  % mal
  a := 14;
  
  % mal
  a2(a, b);
  
  % bien
  a1(c, a);
  
  % mal
  a1(a, c);
  
  % mal
  a4(c, g);
  
  % mal, faltan parametros
  a1(c);
  
  % mal, exceso de parametros
  a1(c, a, a);
  
  % mal, exceso de parametros pero solo sale una vez el error
  a1(c, a, a, a, a, a);
  
 fin

%--------------------------------------------------------
Principio
%--------------------------------------------------------
	% mal porque no contiene ninguna instruccion
Fin
