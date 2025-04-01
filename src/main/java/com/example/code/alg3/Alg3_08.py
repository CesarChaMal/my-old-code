def read_positive_int(prompt):
    while True:
        try:
            n = int(input(prompt))
            if n > 0:
                return n
            print("El numero que diste es cero o negativo")
        except ValueError:
            print("Entrada invalida")

def read_grade():
    while True:
        try:
            c = int(input("Dar una calificacion: "))
            if 0 < c <= 100:
                return c
            print("El numero que diste es cero, negativo o mayor que 100")
        except ValueError:
            print("Entrada invalida")

def main():
    n = read_positive_int("Dar cantidad de calificaciones: ")
    grades = [read_grade() for _ in range(n)]

    rep = len(list(filter(lambda x: x <= 69, grades)))
    cce78 = len([x for x in grades if 71 <= x <= 79])
    cce89 = len([x for x in grades if 81 <= x <= 89])
    cce910 = len([x for x in grades if 91 <= x <= 99])
    exacta = len([x for x in grades if x in {70, 80, 90, 100}])
    ce = grades.count(100)
    avg = sum(grades) / n

    print(f"\nEl numero de reprobados son : {rep}")
    print(f"El numero de calificaciones entre 70 y 80 son : {cce78}")
    print(f"El numero de calificaciones entre 80 y 90 son : {cce89}")
    print(f"El numero de calificaciones entre 90 y 100 son : {cce910}")
    print(f"El numero de calificaciones excelentes son : {ce}")
    print(f"El numero de calificaciones exactas son : {exacta}")
    print(f"El promedio del grupo es : {avg:.2f}")

if __name__ == "__main__":
    main()
