from functools import reduce

def read_positive_int(prompt):
    while True:
        try:
            n = int(input(prompt))
            if n > 0:
                return n
            print("Cantidad invalida. Debe ser mayor que cero.")
        except ValueError:
            print("Entrada invalida. Ingresa un numero entero.")

def read_nonzero_int(prompt):
    while True:
        try:
            x = int(input(prompt))
            if x != 0:
                return x
            print("El numero no debe ser cero.")
        except ValueError:
            print("Entrada invalida. Ingresa un numero entero.")

def main():
    n = read_positive_int("Dar cantidad de numeros: ")
    nums = [read_nonzero_int("Dar un valor entero: ") for _ in range(n)]

    product_even = reduce(lambda a, b: a * b, filter(lambda x: x % 2 == 0, nums), 1)
    valid_odds = list(filter(lambda x: x % 2 != 0 and abs(x) % 10 != 3, nums))
    product_odd = reduce(lambda a, b: a * b, valid_odds, 1) if valid_odds else None

    min_val = min(nums)
    max_val = max(nums)
    pos_max = nums.index(max_val) + 1

    print(f"\nEl producto de pares es : {product_even:.2f}")
    if product_odd is not None:
        print(f"El producto de impares es (menos los terminados en 3) : {product_odd:.2f}")
    else:
        print("No hay impares válidos")
    print(f"El menor : {min_val}         El mayor es : {max_val}")
    print(f"La posicion del mayor es : {pos_max}")

if __name__ == "__main__":
    main()
