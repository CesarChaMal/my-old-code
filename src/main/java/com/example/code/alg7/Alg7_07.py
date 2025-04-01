n = int(input("Dar cantidad de numeros: "))
while n <= 0:
    n = int(input("Cantidad invalida, intente otra vez: "))

pp, maxOdd, hasEven, hasOdd = 1, None, False, False

for _ in range(n):
    x = int(input("Dar un valor entero distinto de cero: "))
    while x == 0:
        x = int(input("No puede ser cero, intente otra vez: "))

    if x % 2 == 0 and abs(x % 10) not in [2,4]:
        pp *= x
        hasEven = True
    elif x % 2:
        maxOdd = x if not hasOdd else max(maxOdd, x)
        hasOdd = True

    if x > 0:
        divisors = [d for d in range(2, x//2+1) if x%d == 0]
        for d in divisors: print(f"{d} es divisor de {x}")
        print(f"{x} tuvo {len(divisors)} divisores")

print(f"El producto de pares es: {pp}" if hasEven else "No hubo producto de pares")
print(f"El mayor de los impares es: {maxOdd}" if hasOdd else "No se dieron impares")
