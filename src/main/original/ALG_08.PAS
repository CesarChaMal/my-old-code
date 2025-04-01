Program arreglo_uni;
{
Se proporciona un arreglo unidimensional de orden N. Escribir un programa para
determinar el elemento mayor de todo el arreglo y la posicion que ocupa ,
calcular el producto de los elementos que tengan posicion par, calcular el
producto de los elementos que tengan valor impar. Cuidar que los productos no
se nulifiquen e imprimir lo solicitado.
}
uses crt;

var
 i,n:integer;
 may,posma,pei,ppp:real;
 banei,banpp:boolean;
 y:array[1..50] of real;

Begin
clrscr;

repeat
 Write('Dar el orden del arreglo : ');
 read(n);
 writeln;
until (n>0) and (n<=50);

Writeln('Dar los elementos uno a uno : ');

for i:=1 to n do
 readln(y[i]);

may:=y[i];
posma:=i;
ppp:=1;
banpp:=false;
pei:=1;
banei:=false;

for i:=1 to n do
begin
 if may<y[i] then
 begin
  may:=y[i];
  posma:=i;
 end;

 if (i mod 2=0) and (y[i]<>0) then
 begin
  ppp:=ppp*y[i];
  banpp:=true;
 end;

 if trunc(y[i]/2)<>(y[i]/2) then
 begin
  pei:=pei*y[i];
  banei:=true;
 end;
end;{fin del for i:=1 to n do}

Writeln('El mayor = ',may:0:2,' su posicion es ',posma:0:0);
if banpp then
begin
 Writeln('Producto de posicion de pares ',ppp:0:2);
end
else
begin
 Writeln('No hubo producto positivo de pares');
end;
if banei then
begin
 Writeln('Producto de elementos impares ',pei:0:2);
end
else
begin
 Writeln('No hubo producto de elementos impares');
end;
readkey
end.