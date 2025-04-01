from functools import reduce

def functional_matrix():
    # Robust input for dimensions
    while True:
        try:
            m, n = map(int, input("Filas y columnas (1-25): ").split())
            if 1 <= m <= 25 and 1 <= n <= 25:
                break
            else:
                print("Los valores deben estar entre 1 y 25.")
        except ValueError:
            print("Entrada inválida. Ingrese dos números separados por espacio.")

    # Read matrix by columns and transpose
    print("Dar los elementos uno a uno por columnas:")
    by_columns = [[float(input(f"Elemento ({f+1},{c+1}): ")) for f in range(m)] for c in range(n)]
    a = [[by_columns[c][f] for c in range(n)] for f in range(m)]  # transpose

    # Producto de filas impares
    prod_odd = reduce(
        lambda acc, row: acc * reduce(lambda x, y: x * y if y != 0 else x, row, 1),
        [row for idx, row in enumerate(a) if idx % 2 == 0],
        1
    )
    print(f"\nProducto filas impares: {prod_odd:.2f}")

    if m == n:
        diag = reduce(lambda acc, val: acc * val if val != 0 else acc, [a[i][i] for i in range(m)], 1)
        print(f"Producto diagonal principal: {diag:.2f}")
    else:
        print(f"Suma penúltima fila: {sum(a[m-2]):.2f}")

    print("\nMatriz leída:")
    for row in a:
        print(" ".join(f"{val:.2f}" for val in row))

functional_matrix()
