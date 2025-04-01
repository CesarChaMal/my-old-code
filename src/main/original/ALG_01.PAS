Program ejemplo;
{leer la suma de los cuadrados,el producto de los valores dados ,
la suma de los valores dados}
uses crt;

var
 a,b,suma,prod,sumacua:real;

Begin
clrscr;
Writeln('Dar dos valores : ');
readln(a,b);
suma:=a+b;
prod:=a*b;
sumacua:=sqr(a)+sqr(b);
writeln;
writeln('La suma es : ',suma:0:2);
writeln('El producto es : ',prod:0:2);
writeln('La suma de los cuadrados es : ',sumacua:0:2);
readkey
end.