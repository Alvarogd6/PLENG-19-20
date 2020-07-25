%--------------------------------------------------------
Programa condiciones;
%--------------------------------------------------------

%-------------------------------------------------------------------
accion while;
%-------------------------------------------------------------------

 caracter c,ln;

 principio
  c := " ";
  mq (c <> "S") and (c >= "N") and (true)
    escribir("(S/N)?");
    leer(c, ln);
  fmq
  
  mq (c <= "S") and (c > "N") and (false)
    escribir("(S/N)?");
    leer(c, ln);
  fmq
  
  mq (c < "S") and (c = "N") and (4 = 4)
    escribir("(S/N)?");
    leer(c, ln);
  fmq
  
  mq (c = c) and ("e" = "e") and (true = true)
    escribir("(S/N)?");
    leer(c, ln);
  fmq
  
 fin

%--------------------------------------------------------
Principio
    while;
    escribir("fichero sin errores");
Fin
