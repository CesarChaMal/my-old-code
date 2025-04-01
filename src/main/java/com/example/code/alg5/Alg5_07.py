def is_lucas(n):
    if n < 0:
        return False
    a, b = 2, 1
    while a < n:
        a, b = b, a + b
    return a == n

n = 0
while n <= 0:
    try:
        n = int(input("Dar cantidad de numeros: "))
    except ValueError:
        continue

numbers = []
while len(numbers) < n:
    try:
        x = int(input("Dar un numero: "))
        if x != 0:
            numbers.append(x)
        else:
            print("El número debe ser distinto de cero.")
    except ValueError:
        print("Entrada inválida.")

product3 = 1
sum_even_pos = 0
lucas_count = 0
has_mult3 = False

for i, x in enumerate(numbers):
    if x % 3 == 0:
        product3 *= x
        has_mult3 = True
    if x > 0 and x % 2 == 0:
        sum_even_pos += x
    if is_lucas(x):
        lucas_count += 1
        print(f"{x} es de lucas en la posición {i + 1}")

print(f"\nLa suma de pares positivos: {sum_even_pos}")
print(f"Los numeros pares de lucas fueron: {lucas_count}")
print(f"El producto de los múltiplos de 3 es: {product3}" if has_mult3 else "No hubo múltiplos de 3")
