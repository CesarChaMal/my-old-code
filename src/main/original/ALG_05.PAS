Program ejemplo_repeat;
{
Se proporciona un N numeros que deben ser enteros. Escribir un programa y
calcular el producto de los multiplos de 3,calcular la suma de los numeros
pares positivos y determinar cuantos numeros pares son lucas.
}
uses crt;

var
 n,cont,cluc:integer;
 x,pm3,p,seg,sig,supap:real;
 band:boolean;
Begin
clrscr;
pm3:=1;
repeat
 Write('Dar cantidad de numeros : ');
 read(n);
 writeln;
until n>0;

cont:=0;
band:=false;
repeat
 repeat
  write('Dar un numero : ');
  read(x);

  if x<>trunc(x) then
  writeln('error numero decimal');

 until x=trunc(x);

 cont:=cont+1;

 if (2*trunc(x/2)=x) and (x>0) then
  supap:=supap+x;

 if (trunc(x/3)=(x/3)) and (x<>0) then
 begin
  pm3:=pm3*x;
  band:=true;
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
   writeln;
   writeln(x:0:2,'  es de lucas');
   writeln('En la posicion : ',cont)
   end;
 end;
until cont=n;
writeln;
writeln('La suma de pares positivos : ',supap:0:2);
writeln('Los numeros pares de lucas fueron : ',cluc);
if band=true then
begin
writeln('El producto de los multiplos de 3 es : ',pm3:0:2);
end
else
begin
writeln('No hubo producto de multiplos de 3')
end;
readkey
end.