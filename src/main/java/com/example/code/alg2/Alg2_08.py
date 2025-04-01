def solve_quadratic(a, b, c):
    if a != 0:
        d = b ** 2 - 4 * a * c
        if d > 0:
            return f"Las raices son {((-b + d ** 0.5) / (2 * a)):.2f}  {((-b - d ** 0.5) / (2 * a)):.2f}"
        elif d == 0:
            return f"Las raices son iguales a {(-b / (2 * a)):.2f}"
        else:
            return "Las raices son complejas"
    else:
        return f"La ecuacion no es de 2o grado\nLa unica raiz es : {(-c / b):.2f}"

print(solve_quadratic(1, 2, 1))
