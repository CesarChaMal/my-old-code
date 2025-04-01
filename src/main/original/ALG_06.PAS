Program ejemplo_for;
{
Se proporciona un N numeros enteros que deben ser distintos de cero. Escribir
un programa para leer dichos numeros y calcular el producto de los pares
excepto los terminados en dos ,cuantos pares pertenecen a la secuencia de
Lucas y cuantos impares dados son primos.
}
uses crt;

var
 x,n,k,d,cluc,cpri,p,seg,sig,cd,cimp,cpar:integer;
 pp:real;
Begin
clrscr;

n:=0;
repeat
 Write('Dar cantidad de numeros : ');
 read(n);
 writeln;
until n>0;
pp:=1;
cluc:=0;
cpri:=0;
cpar:=0;
for k:=1 to n do
begin
 repeat
  write('Dar un valor entero : ');
  read(x);
 until x<>0;

 if x mod 2=0 then
 begin
  cpar:=cpar+1;
  if (abs(x) mod 10)<>2 then
  begin
   pp:=pp*x;
  end;

  if x>0 then
  begin
   p:=1;
   seg:=3;

   while p<x do
   begin
    sig:=p+seg;
    p:=seg;
    seg:=sig;
   end;

   if p=x then
   begin
    cluc:=cluc+1;
   end;
  end;
 end
 else
 begin
  cimp:=cimp+1;
  if x>1 then
  begin
   cd:=0;

   for d:=3 to (x div 3) do
   begin
    if x mod d=0 then
    begin
     cd:=cd+1;
    end;
   end;
   if cd=0 then
   begin
    cpri:=cpri+1;
   end;
  end;{fin del if x>1}
 end;{fin del x mod 2=0}
end;{fin de for k:=1 to n do}

   writeln;
   writeln('Fueron ',cpar,' numeros pares y fueron ',cimp,' numeros impares');
   writeln;
   writeln('Fueron ',cluc,' pares de Lucas',' y fueron ',cpri,' primos');
   writeln('Los divisores fueron ',cd);
   if pp<>1 then
   begin
    writeln('Producto de pares = ',pp:0:2);
   end
   else
   begin
    writeln('No hay producto de pares');
   end;{fin del if pp<>1}
readkey
end.