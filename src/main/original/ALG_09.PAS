Program arreglo_dos;
{
Se proporciona un arreglo unidimensional de orden L que debe contener valores
enteros ,escribir un programa para leer dicho arreglo y calcular el producto
de los elementos multiplos de 3, calcular el producto de los elementos que
tengan posicion impar y valor par y poner en orden dicho arreglo.
}
uses crt;

var
 j,i,L,temp:integer;
 piep,pm3:real;
 banei:boolean;
 y:array[1..50] of integer;

Begin
clrscr;

repeat
 Write('Dar el orden del arreglo : ');
 read(L);
 writeln;
until (L>0) and (L<=50);

Writeln('Dar los elementos uno a uno : ');

for i:=1 to L do
 readln(y[i]);

pm3:=1;
piep:=1;
banei:=false;

for i:=1 to L do
begin
 if (i mod 2<>0) and ((y[i] mod 2)=0) and (y[i]<>0) then
 begin
  piep:=piep*y[i];
  banei:=true;
 end;
 if ((y[i] mod 3)=0) and (y[i]<>0) then
 begin
  pm3:=pm3*y[i];
 end;
end;{fin del for i:=1 to L do}

writeln;

if banei then
begin
 Writeln('Producto de posicion impar, valor par ',piep:0:2);
end
else
begin
 Writeln('No hubo producto de posicion impar, valor par ');
end;

if pm3<>1 then
begin
 Writeln('Producto de multiplos de 3 : ',pm3:0:2);
end
else
begin
 Writeln('No hubo producto de multiplos de 3');
end;


for i:=1 to L do
begin
 for j:=i+1 to L do
 begin
  if y[i]>y[j] then
  begin
   temp:=y[i];
   y[i]:=y[j];
   y[j]:=temp;
  end;{fin del if y[i]>y[j] then}
 end;{fin del for j:=i+1 to L do}
end;{fin del for 1:=1 to L do}

writeln;
Writeln('El arreglo ordenado es : ');

for i:=1 to L do
 writeln(y[i]);

readkey
end.