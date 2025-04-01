def procedural_version():
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

    pm3 = 1
    piep = 1
    has_piep = False

    for i in range(len(arr)):
        if (i % 2 == 0) and (arr[i] % 2 == 0) and (arr[i] != 0):
            piep *= arr[i]
            has_piep = True
        if (arr[i] % 3 == 0) and (arr[i] != 0):
            pm3 *= arr[i]

    # Bubble sort manually
    sorted_arr = arr[:]
    for i in range(len(sorted_arr)):
        for j in range(i + 1, len(sorted_arr)):
            if sorted_arr[i] > sorted_arr[j]:
                sorted_arr[i], sorted_arr[j] = sorted_arr[j], sorted_arr[i]

    print("Producto de multiplos de 3:", pm3 if pm3 != 1 else "No hubo")
    print("Producto de posicion impar, valor par:", piep if has_piep else "No hubo")
    print("Arreglo ordenado:", sorted_arr)


procedural_version()
