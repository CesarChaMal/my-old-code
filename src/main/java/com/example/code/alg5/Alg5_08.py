from functools import reduce

def is_lucas(n):
    if n < 0:
        return False
    a, b = 2, 1
    while a < n:
        a, b = b, a + b
    return a == n

def read_int(prompt, nonzero=False):
    while True:
        try:
            val = int(input(prompt))
            if not nonzero or val != 0:
                return val
        except ValueError:
            pass

n = read_int("Dar cantidad de numeros: ")
while n <= 0:
    n = read_int("Cantidad invalida, intenta de nuevo: ")

nums = [read_int("Dar un numero: ", nonzero=True) for _ in range(n)]

product3 = reduce(lambda a, b: a * b, filter(lambda x: x % 3 == 0, nums), 1)
sum_even = sum(filter(lambda x: x > 0 and x % 2 == 0, nums))
lucas_even_count = sum(1 for x in nums if x % 2 == 0 and is_lucas(x))

print(f"\nLa suma de pares positivos: {sum_even}")
print(f"Los numeros pares de lucas fueron: {lucas_even_count}")
print(f"El producto de los múltiplos de 3 es: {product3}" if any(x % 3 == 0 for x in nums) else "No hubo múltiplos de 3")
