from functools import reduce

def functional_version():
    while True:
        try:
            L = int(input("Dar el orden del arreglo (max 50): "))
            if 0 < L <= 50:
                break
        except ValueError:
            pass

    arr = []
    for i in range(L):
        while True:
            try:
                x = int(input(f"Elemento {i + 1}: "))
                arr.append(x)
                break
            except ValueError:
                print("Entrada inválida, intente de nuevo.")

    pm3_list = list(filter(lambda x: x % 3 == 0 and x != 0, arr))
    piep_list = [arr[i] for i in range(0, len(arr), 2) if arr[i] % 2 == 0 and arr[i] != 0]

    pm3 = reduce(lambda a, b: a * b, pm3_list, 1) if pm3_list else None
    piep = reduce(lambda a, b: a * b, piep_list, 1) if piep_list else None
    sorted_arr = sorted(arr)

    print("Producto de multiplos de 3:", pm3 if pm3 else "No hubo")
    print("Producto de posicion impar, valor par:", piep if piep else "No hubo")
    print("Arreglo ordenado:", sorted_arr)


functional_version()
