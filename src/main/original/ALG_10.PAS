Program matrices;
{
Se proporciona un arreglo bidimensional de orden N por M. Escribir un programa
para leer dicho arreglo en orden de columna. Calcular el producto de los
elementos de filas impares, si el arreglo es cuadrado , calcular el producto
de los elementos de la diagonal principal, caso contrario calcular la suma de
los elementos de la penultima fila. Cuidar que los productos no se nulifiquen
e imprimir lo solicitado.
}
uses crt;

var
 fila,columna,m,n:integer;
 pfi,supf,pdp:real;
 banfi,bandp:boolean;
 a:array[1..25,1..25] of real;

Begin
clrscr;

repeat
 Writeln('Dar el orden del arreglo (Filas x Columnas): ');
 readln(m,n);
 writeln;
until (m>0) and (m<=25) and (n>0) and (n<=25);

Writeln('Dar los elementos de uno a uno por columnas : ');

for columna:=1 to n do
begin
 for fila:=1 to m do
 begin
  readln(a[fila,columna]);
 end;
end;

pfi:=1;
banfi:=false;

for fila:=1 to m do
begin
 if(fila mod 2)<>0 then
 begin
  for columna:=1 to n do
  begin
   if a[fila,columna]<>0 then
   begin
    pfi:=pfi*a[fila,columna];
    banfi:=true;
   end;
  end;
 end;
end;

if banfi then
begin
 writeln;
 writeln('Producto de Filas impares : ',pfi:0:2);
end
else
begin
 writeln('No hay producto de Filas impares');
end;

if m=n then
begin
 pdp:=1;
 bandp:=false;
 for fila:=1 to m do
 begin
  if a[fila,fila]<>0 then
  begin
   pdp:=pdp*a[fila,fila];
   bandp:=true;
  end;
 end;

 if bandp then
 begin
  writeln;
  writeln('Producto de la diagonal principal es : ',pdp:0:2);
 end
 else
 begin
  writeln('No hay producto de la diagonal principal');
 end;

end
else
begin
 supf:=0;
 for columna:=1 to n do
 begin
  supf:=supf+a[m-1,columna];
 end;
 writeln('La suma de la penultima fila es : ',supf:0:2);
end;

writeln;
writeln('El arreglo leido es : ');
writeln;

for fila:=1 to m do
begin
 for columna:=1 to n do
 begin
  write(a[fila,columna]:0:2,' ');
 end;
end;

writeln;
writeln;

for fila:=1 to m do
begin
 for columna:=1 to n do
 begin
  write(a[fila,columna]:0:2,'     ');
 end;
 writeln;
 writeln;
end;

readkey
end.
