def is_lucas(n):
    a, b = 1, 3
    while a < n:
        a, b = b, a + b
    return a == n

def read_inputs(n):
    inputs = []
    while len(inputs) < n:
        x = float(input("Dar un numero : "))
        if x != int(x):
            print("error numero decimal")
        else:
            inputs.append(int(x))
    return inputs

n = 0
while n <= 0:
    n = int(input("Dar cantidad de numeros : "))

nums = read_inputs(n)

supap = sum(x for x in nums if x > 0 and x % 2 == 0)
mult3s = [x for x in nums if x != 0 and x % 3 == 0]
pm3 = 1
for x in mult3s:
    pm3 *= x

lucas_evens = [
    (i, x) for i, x in enumerate(nums, 1)
    if x > 0 and is_lucas(x)
]

for pos, val in lucas_evens:
    print(f"{val:.2f} es de lucas")
    print(f"En la posicion : {pos}")

print(f"La suma de pares positivos : {supap:.2f}")
print(f"Los numeros pares de lucas fueron : {sum(1 for _, x in lucas_evens if x % 2 == 0)}")
print(f"El producto de los multiplos de 3 es : {pm3:.2f}" if mult3s else "No hubo producto de multiplos de 3")
