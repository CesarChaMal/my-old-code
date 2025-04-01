n = int(input("Dar cantidad de numeros: "))
while n <= 0:
    n = int(input("Cantidad invalida, intenta otra: "))

pp = 1
pim = 1
band = False
cont = 0
men = may = pmay = None

for i in range(n):
    while True:
        x = int(input("Dar un valor entero: "))
        if x != 0:
            break

    if cont == 0:
        men = may = x
        pmay = 1

    if x % 2 == 0:
        pp *= x
    elif abs(x) % 10 != 3:
        pim *= x
        band = True

    if x < men:
        men = x
    if x > may:
        may = x
        pmay = i + 1

    cont += 1

print(f"El producto de pares es : {pp:.2f}")
print(f"El producto de impares es (menos los terminados en 3) : {pim:.2f}" if band else "No hay impares válidos")
print(f"El menor : {men}         El mayor es : {may}")
print(f"La posicion del mayor es : {pmay}")
