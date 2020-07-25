%%------------------------------------------------------
programa comentario_doble;
%------------------------------------------------------%%
programa prueba-comen

    entero _r, g2;

    %------------------------------------------------------
    accion prueba;
    %------------------------------------------------------
    entero j;
    booleano divisible;
	principio
	
		%%
		escribir(.);
		si not divisible ent
			leer (j);
		si_no si j mod 2 = 0
			escribir (entacar(j));
		fsi
		%%
		
		escribir(.);
		si not divisible ent
			leer (j);
		si_no si j mod 2 = 0
			escribir (entacar(j));
		fsi
	fin
	

%------------------------------------------------------
principio
%------------------------------------------------------
  n := 100;
  mq n <= 200
	 prueba;
	 n := n + 1;
  fmq
fin

