Program matrices;
{
Se proporciona un arreglo bidimensional de orden M x N hacer el programa que
lea dicho arreglo y calcular el producto de los elementos de la K-esima fila
y determinar el menor de los elementos del arreglo.
}
uses crt;

var
 i,j,m,n:integer;
 pkfila,men:real;
 a:array[1..25,1..25] of real;

Begin
	clrscr;

	repeat
		Writeln('Dar el orden del arreglo (Filas x Columnas): ');
		readln(m,n);
		writeln;
	until (m>0) and (m<=25) and (n>0) and (n<=25);

	Writeln('Dar los elementos de uno a uno por columnas : ');

	for i:=1 to m do
		for j:=1 to n do
			readln(a[i,j]);

	pkfila:=1;
	men:=a[i,j];

	for i:=1 to m do
	begin
		for j:=1 to n do
		begin
			if i=m then
				pkfila:=pkfila*a[i,j];
			if a[i,j]<men then
				men:=a[i,j];
		end;
	end;

	writeln;
	writeln('El producto de la K-esima fila fue : ',pkfila:0:2);
	writeln('El menor elemento fue : ',men:0:2);

	readkey
end.
