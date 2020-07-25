%--------------------------------------------------------
Programa escribir_y_leer;
%--------------------------------------------------------

%--------------------------------------------------------
Principio
%--------------------------------------------------------

		entero n,x,y,z; %error, tendria que estar definido antes que principio

        escribir("Distintas posibilidades de argumentos para escribir y leer");
		
		leer(n,x,y,z);
		
		leer("ERROR");
		leer(caraent("3"));
		leer(caraent(65));
		leer(entacar(65));
		leer(n);
		leer("2");
		
		escribir(entacar(34), "no da error esta línea", n);
		
		escribir(entacar(n), "bien");
		escribir(entacar("bien"));
Fin
