a, b, c = map(float, input("Dar tres valores : ").split())

if a != 0:
    d = b ** 2 - 4 * a * c
    if d > 0:
        x1 = (-b + d ** 0.5) / (2 * a)
        x2 = (-b - d ** 0.5) / (2 * a)
        print(f"Las raices son {x1:.2f}  {x2:.2f}")
    elif d == 0:
        x = -b / (2 * a)
        print(f"Las raices son iguales a {x:.2f}")
    else:
        print("Las raices son complejas")
else:
    print("La ecuacion no es de 2o grado")
    x = -c / b
    print(f"La unica raiz es : {x:.2f}")
