# Prompt for valid matrix dimensions
while True:
    try:
        entrada = input("Filas y Columnas (max 25): ").split()
        if len(entrada) != 2:
            raise ValueError("Debe ingresar exactamente dos números.")
        m, n = map(int, entrada)
        if not (1 <= m <= 25 and 1 <= n <= 25):
            raise ValueError("Ambos valores deben estar entre 1 y 25.")
        break
    except ValueError as e:
        print("Entrada inválida:", e)

# Input matrix elements
arr = []
for i in range(m):
    fila = []
    for j in range(n):
        val = float(input(f"Elemento ({i+1},{j+1}): "))
        fila.append(val)
    arr.append(fila)

# Process matrix
pkfila = 1
menor = arr[0][0]
for i in range(m):
    for j in range(n):
        if i == m - 1:
            pkfila *= arr[i][j]
        if arr[i][j] < menor:
            menor = arr[i][j]

# Output results
print(f"Producto fila {m}: {pkfila:.2f}")
print(f"Menor elemento: {menor:.2f}")
