Program ejemplo_if;
{
Ecribir un programa para leer los coeficientes de una ecuacion de 2 do grado
y calcular las raices de la misma dando los mensajes a cada caso
}
uses crt;

var
 a,b,c,d,x1,x2,x:real;

Begin

clrscr;
Writeln('Dar tres valores : ');
readln(a,b,c);

if a<>0 then
begin
 d:=sqr(b)-4 * a * c;
  if d>0 then
  begin
   x1:=(-b + sqrt (d)) / (2*a);
   x2:=(-b - sqrt (d)) / (2*a);
   writeln('Las raices son ',x1:0:2,'  ',x2:0:2);
  end
  else
  begin
   if d=0 then
   begin
    x:=-b/(2*a);
    writeln('Las raices son iguales a ',x:0:2);
   end
   else
   begin
    writeln('Las raices son complejas');
   end;
  end;
end
else
begin
 writeln('La ecuacion no es de 2o grado');
 x:=-c/b;
 writeln('La unica raiz es : ',x:0:2);
end;
readkey
end.
