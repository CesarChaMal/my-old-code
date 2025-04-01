def is_lucas(n):
    a, b = 1, 3
    while a < n:
        a, b = b, a + b
    return a == n

n = 0
while n <= 0:
    n = int(input("Dar cantidad de numeros : "))

count = 0
supap = 0.0
pm3 = 1.0
cluc = 0
has_mult3 = False

while count < n:
    while True:
        x = float(input("Dar un numero : "))
        if x != int(x):
            print("error numero decimal")
        else:
            x = int(x)
            break

    count += 1

    if x > 0 and x % 2 == 0:
        supap += x

    if x != 0 and x % 3 == 0:
        pm3 *= x
        has_mult3 = True

    if x > 0 and is_lucas(x):
        cluc += 1
        print(f"{x:.2f} es de lucas")
        print(f"En la posicion : {count}")

print(f"La suma de pares positivos : {supap:.2f}")
print(f"Los numeros pares de lucas fueron : {cluc}")
if has_mult3:
    print(f"El producto de los multiplos de 3 es : {pm3:.2f}")
else:
    print("No hubo producto de multiplos de 3")
