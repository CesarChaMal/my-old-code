from functools import reduce

def read_int(prompt, condition=lambda x: True, error="Entrada invalida."):
    while True:
        try:
            value = int(input(prompt))
            if condition(value):
                return value
        except ValueError:
            pass
        print(error)

def divisors(x):
    return [d for d in range(2, x // 2 + 1) if x % d == 0]

n = read_int("Dar cantidad de numeros: ", lambda x: x > 0, "Debe ser mayor a cero.")

numbers = [
    read_int("Dar un valor entero distinto de cero: ", lambda x: x != 0, "No puede ser cero.")
    for _ in range(n)
]

even_filtered = list(filter(lambda x: x % 2 == 0 and abs(x) % 10 not in [2, 4], numbers))
product_even = reduce(lambda a, b: a * b, even_filtered, 1) if even_filtered else None

odds = list(filter(lambda x: x % 2 != 0, numbers))
max_odd = max(odds) if odds else None

positive_numbers = list(filter(lambda x: x > 0, numbers))

for x in positive_numbers:
    divs = divisors(x)
    list(map(lambda d: print(f"{d} es divisor de {x}"), divs))
    print(f"{x} tuvo {len(divs)} divisores")

print(f"El producto de pares es: {product_even}" if product_even else "No hubo producto de pares")
print(f"El mayor de los impares es: {max_odd}" if max_odd else "No se dieron impares")
