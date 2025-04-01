n = int(input("Dar cantidad de calificaciones: "))
while n <= 0:
    print("El numero que diste es cero o negativo")
    n = int(input("Da otro valor: "))

rep = cce78 = cce89 = cce910 = exacta = ce = sumc = 0

for _ in range(n):
    while True:
        c = int(input("Dar una calificacion: "))
        if 0 < c <= 100:
            break
        print("El numero que diste es cero, negativo o mayor que 100")

    if c <= 69:
        rep += 1
    elif c in [70, 80, 90]:
        exacta += 1
    elif c == 100:
        exacta += 1
        ce += 1
    elif 71 <= c <= 79:
        cce78 += 1
    elif 81 <= c <= 89:
        cce89 += 1
    elif 91 <= c <= 99:
        cce910 += 1

    sumc += c

avg = sumc / n
print(f"\nEl numero de reprobados son : {rep}")
print(f"El numero de calificaciones entre 70 y 80 son : {cce78}")
print(f"El numero de calificaciones entre 80 y 90 son : {cce89}")
print(f"El numero de calificaciones entre 90 y 100 son : {cce910}")
print(f"El numero de calificaciones excelentes son : {ce}")
print(f"El numero de calificaciones exactas son : {exacta}")
print(f"El promedio del grupo es : {avg:.2f}")
