%--------------------------------------------------------
Programa comparacion;
%--------------------------------------------------------

entero e1, e2;
caracter c1, c2;
booleano b1, b2;

%--------------------------------------------------------
Principio
%--------------------------------------------------------
        e1 := 0;
		e2 := 5;
		c1 := "r";
		c2 := "t";
		b1 := true;
		b2 := false;
        
        Si b1 ent
            escribir("bien");
        fsi
		
		Si not b2 ent
            escribir("bien");
        fsi

		mq (e1 <> e2) and (b1 <> b2) and (c1 <> c2)
			escribir("bien");
		fmq
		
		mq (e1 <> c2) and (b1 <> e2) and (c1 <> b2)
			escribir("mal");
		fmq
		
		Si e1 + e2 > "c" ent
            escribir("mal");
        fsi
		
		% mal
		c1 := e1; 
		
		% bien
		b1 := e1 < e2;
		
		% mal
		e2 := b1 and b2;
Fin
