Program ejemplo_for;
{
Se proporciona un N numeros enteros que deben ser distintos de cero. Escribir
un programa para leer dichos numeros y calcular el producto de los pares
excepto los terminados en 2 y 4 ,determinar el mayor de los impares y por
ultimo encontrar cuales y cuantos divisores tiene cada numero positivo
exceptuando la unidad y el mismo numero
}
uses Newdelay,crt;

var
 k,n,d,x,cd,cimp,mayim:integer;
 pp:real;
Begin
PatchCrt(Crt.delay);
clrscr;

repeat
 Write('Dar cantidad de numeros : ');
 read(n);
 writeln;
until n>0;
pp:=1;
cd:=0;
for k:=1 to n do
begin
 repeat
  write('Dar un valor entero : ');
  read(x);
 until x<>0;

 if x mod 2=0 then
 begin
  if ((abs(x) mod 10)<>2) and ((abs(x) mod 10)<>4) then
  begin
   pp:=pp*x;
  end;
 end
 else
 begin
  cimp:=cimp+1;
  if cimp=1 then
  begin
   mayim:=x;
  end
  else
  begin
   if mayim<x then
    mayim:=x;
  end;
 end;{fin del x mod 2=0}

 if x>0 then
 begin
  cd:=0;
  for d:=2 to (x div 2) do
  begin
   if (x mod d)=0 then
   begin
    writeln(d,' es divisor de ',x);
    cd:=cd+1;
   end;
  end;{fin del for d:=2 to (x div 2) do}
 writeln(x,' tuvo ',cd,' divisores');
 end;{if x>0 then}
end;{fin del for k:=1 to n do}

if pp<>1 then
begin
 writeln('El prod de pares = ',pp:0:2);
end
else
begin
 writeln('No hubo producto de pares');
end;

if cimp>0 then
begin
 writeln('El mayor de los impares es ',mayim);
end
else
begin
 writeln('No se dieron impares');
end;

readkey
end.