%--------------------------------------------------------
Programa acciones;
%--------------------------------------------------------

%-------------------------------------------------------------------
accion acciones;
%-------------------------------------------------------------------
  %-------------------------------------------------------------------
  accion a1;
  %-------------------------------------------------------------------
     %-------------------------------------------------------------------
     accion a2;
     %-------------------------------------------------------------------
     principio
      leer(q);
     fin
  principio
   leer(u);
  fin
 principio
  escribir("accion");
 fin 

%-------------------------------------------------------------------
accion while(ref entero n, k, e; val caracter q, a; ref booleano h);
%-------------------------------------------------------------------

 caracter c,ln;

 principio
  c := " ";
  mq (c <> "S") and (c >= "N") and (true)
    escribir("(S/N)?");
    leer(c, ln);
  fmq
  
 fin
 
%-------------------------------------------------------------------
accion sin_ref_ni_val(entero n, k, e; caracter q, a; booleano h);
%-------------------------------------------------------------------
 principio
  escribir("ERROR");
  
 fin

%--------------------------------------------------------
Principio
%--------------------------------------------------------
    acciones;
Fin
