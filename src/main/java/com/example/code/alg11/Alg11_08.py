from functools import reduce

def valid_pair():
    while True:
        try:
            entrada = input("Filas y Columnas (max 25): ").split()
            if len(entrada) != 2:
                raise ValueError("Se requieren dos valores.")
            a, b = map(int, entrada)
            if 1 <= a <= 25 and 1 <= b <= 25:
                return a, b
            else:
                raise ValueError("Los valores deben estar entre 1 y 25.")
        except ValueError as e:
            print("Entrada inválida:", e)

m, n = valid_pair()

arr = [[float(input(f"Elemento ({i+1},{j+1}): ")) for j in range(n)] for i in range(m)]

pkfila = reduce(lambda a, b: a * b, arr[m - 1], 1)
menor = min(x for row in arr for x in row)

print(f"Producto fila {m}: {pkfila:.2f}")
print(f"Menor elemento: {menor:.2f}")
