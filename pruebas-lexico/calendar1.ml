%-----------------------------------------------------------
PROGRAMA calendario;

% Tras introducir un mes y un anio devuelve por pantalla el calendari
% correspondientea ese mes y a ese anio,siempre que el anho sea posterior a 1900
%-----------------------------------------------------------

entero mes,anho,dia1anho,dia1mes,anhade;
caracter ln;
    
%-----------------------------------------------------------
ACCION primer_dia_anho;

% Calcula el dia de la semana en el cual cayo el dia uno de Eero
%  de ese anio
%-----------------------------------------------------------

       entero bisiestos;
       booleano bisiestos_validos,cien,cuatro;

       % Distingue los anhos que a pesar de ser divisibles por
       % cuatro no son bisiestos

       principio
           anho:=anho-1900;
           cuatro:=(anho MOD 4=0) AND (anho MOD 100<>0);
           cien:=anho MOD 400=0;
           bisiestos_validos:=cuatro OR cien;
           bisiestos:=anho DIV 4;
           si bisiestos_validos
              ent    dia1anho:=(anho-1+bisiestos) MOD 7;
              si_no  dia1anho:=(anho+bisiestos) MOD 7;
           fsi
       fin

%-----------------------------------------------------------
ACCION primer_dia_mes;

% Calcula el dia de la semana en el cual cayo 
el dia uno d ese mes
% en ese anio
%-----------------------------------------------------------

       booleano bisiestos_validos,cien,cuatro;

       principio
           anho:=anho-1900;
           cien:=(anho MOD 4=0) AND (anho MOD 100<>0);
           cuatro:=anho MOD 400=0;
           bisiestos_validos:=cien OR cuatro;
           si bisiestos_validos
              ent   anhade:=1;
              si_no anhade:=0;
           fsi
           si mes=1 ent dia1mes:=dia1anho;
           si_no
              si mes=2 ent dia1mes:=(dia1anho+31) MOD 7;
           si_no
              si mes=3 ent dia1mes:=(dia1anho+59+anhade) MOD 7;
           si_no
              si mes=4 ent dia1mes:=(dia1anho+90+anhade) MOD 7;
           si_no
              si mes=5 ent dia1mes:=(dia1anho+120+anhade) MOD 7; 
           si_no
              si mes=6 ent dia1mes:=(dia1anho+151+anhade) MOD 7; 
           si_no
              si mes=7 ent dia1mes:=(dia1anho+181+anhade) MOD 7; 
           si_no
              si mes=8 ent dia1mes:=(dia1anho+212+anhade) MOD 7;
           si_no
              si mes=9 ent dia1mes:=(dia1anho+243+anhade) MOD 7;
           si_no
              si mes=10 ent dia1mes:=(dia1anho+273+anhade) MOD 7;
           si_no
              si mes=11 ent dia1mes:=(dia1anho+304+anhade) MOD 7 ;
           si_no
              si mes=12 ent dia1mes:=(dia1anho+334+anhade) MOD 7;
           si_no
              escribir("Has introducido el mes mal"); 
           fsi
           fsi
           fsi
           fsi
           fsi
           fsi
           fsi
           fsi
           fsi
           fsi
           fsi
           fsi

       fin

%-----------------------------------------------------------
% Principal: Devuelve el día de la semana en el que cayó el primero
% de mes del mes en el año especificado
%-----------------------------------------------------------

PRINCIPIO
          
     escribir("CALENDARIO");
     escribir("Introduce un mes en cifras:");
     leer(mes, ln);
     escribir("Introduce un anio en cifras:");
     leer(anho, ln);
     primer_dia_anho;
     primer_dia_mes;
     escribir(dia1mes);    

FIN
