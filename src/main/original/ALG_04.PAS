Program ejemplo_repeat;
{
Se proporciona un N numeros enteros que deben ser distintos de cero. Escribir
un programa para leer dichos numeros calcular el producto de los pares, el
producto de los impares. Excepto los terminados en 3 ,determinar el menor de
todos , determinar el mayor de todos y la posicion en la cual se proporciona
}
uses Newdelay,crt;

var
 n,x,men,may,pmay,cont:integer;
 pp,pim:real;
 band:boolean;

Begin
PatchCrt(Crt.delay);
clrscr;
repeat
Write('Dar cantidad de numeros : ');
read(n);
writeln;
until n>0;

cont:=0;
pp:=1;
pim:=1;
band:=false;

repeat
 repeat
  write('Dar un valor entero : ');
  readln(x);
 until x<>0;
 cont:=cont+1;

 if x mod 2=0 then
 begin
  pp:=pp*x;
 end
 else
 begin
  if (abs(x)mod 10) <>3 then
  begin
   pim:=pim*x;
   band:=true;
  end;
 end;

 if cont=1 then
 begin
  men:=x;
  may:=x;
 end
 else
 begin
  if x<men then
  begin
   men:=x;
  end
  else
  begin
   if x>may then
   begin
    may:=x;
    pmay:=cont;
   end;
  end;
 end;
until cont=n;
writeln;
writeln('El producto de pares es : ',pp:0:2);
writeln('El producto de impares es (menos los terminados en 3 son) : ',pim:0:2);
writeln('El menor : ',men,
'         El mayor es : ',may);
writeln('La posicion del mayor es : ',pmay);
readkey
end.