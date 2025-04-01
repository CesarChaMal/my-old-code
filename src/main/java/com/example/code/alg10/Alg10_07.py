def procedural_matrix():
    while True:
        try:
            m, n = map(int, input("Filas y columnas (1-25): ").split())
            if 1 <= m <= 25 and 1 <= n <= 25:
                break
            else:
                print("Valores fuera de rango. Intente nuevamente.")
        except ValueError:
            print("Entrada inválida. Debe ingresar dos números separados por espacio.")

    print("Dar los elementos uno a uno por columnas:")
    a = [[0.0] * n for _ in range(m)]
    for c in range(n):
        for f in range(m):
            a[f][c] = float(input(f"Elemento ({f+1},{c+1}): "))

    prod_odd = 1
    has_prod = False
    for f in range(0, m, 2):
        for c in range(n):
            if a[f][c] != 0:
                prod_odd *= a[f][c]
                has_prod = True
    print(f"\nProducto filas impares: {prod_odd:.2f}" if has_prod else "No hay producto filas impares")

    if m == n:
        diag = 1
        has_diag = False
        for i in range(m):
            if a[i][i] != 0:
                diag *= a[i][i]
                has_diag = True
        print(f"Producto diagonal principal: {diag:.2f}" if has_diag else "No hay producto diagonal principal")
    else:
        print(f"Suma penúltima fila: {sum(a[m-2]):.2f}")

    print("\nMatriz leída:")
    for row in a:
        print(" ".join(f"{x:.2f}" for x in row))

procedural_matrix()
