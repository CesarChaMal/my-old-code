Program ejemplo_case;
{
Se proporciona un grupo de N calificaciones que deben ser legales.
Escribir un programa para calcular el promedio de un grupo, determinar la
cantidad de calificaciones reprobadas,la cantidad de calificaciones
comprendidas entre 70-80 , 80-90 y 90-100. La cantidad de calificaciones
Excelentes y las calificaciones exactas 70,80,90,100.
}
uses crt;

var
 c,rep,cont,cce78,cce89,cce910,exacta,ce,n,sumc:integer;
 pg:real;

Begin
clrscr;
Write('Dar cantidad de calificaciones : ');
read(n);
writeln;
while n<=0 do
Begin
 clrscr;
 writeln('El numero que diste es cero o negativo');
 writeln;
 write('Da otro valor : ');
 read(n);
 writeln;
end;
cont:=0;
rep:=0;
ce:=0;
sumc:=0;
cce78:=0;
cce89:=0;
cce910:=0;
exacta:=0;
while cont<n do
begin
 write('Dar una calificacion : ');
 read(c);

 while (c<=0) or (c>100) do
 Begin
  writeln;
  writeln('El numero que diste es cero,negativo o mayor que 100');
  writeln;
  write('Dame otra calificacion : ');
  read(c);
 end;
 cont:=cont+1;

 case c of
      0..69:rep:=rep+1;
     71..79:cce78:=cce78+1;
     81..89:cce89:=cce89+1;
     91..99:cce910:=cce910+1;
   70,80,90:exacta:=exacta+1;
        100:Begin
             exacta:=exacta+1;
             ce:=ce+1;
            end;
 end;{fin del case}
 sumc:=sumc+c;
end;{fin del while}
pg:=sumc/n;
writeln;
writeln('El numero de reprobados son : ',rep);
writeln('El numero de calificaciones entre 70 y 80 son : ',cce78);
writeln('El numero de calificaciones entre 80 y 90 son : ',cce89);
writeln('El numero de calificaciones entre 90 y 100 son : ',cce910);
writeln('El numero de calificaciones excelentes son : ',ce);
writeln('El numero de calificaciones exactas son : ',exacta);
writeln('El promedio del grupo es : ',pg:0:2);
readkey
end.