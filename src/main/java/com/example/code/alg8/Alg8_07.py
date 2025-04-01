n = int(input("Orden (max 50): "))
while n <= 0 or n > 50:
    n = int(input("Orden inválido, intente nuevamente: "))

arr = []
for i in range(n):
    num = float(input(f"Elemento {i+1}: "))
    arr.append(num)

max_val = arr[0]
pos_max = 1
product_even_pos = 1
product_odd_vals = 1
has_even_pos = False
has_odd_vals = False

for i in range(n):
    if arr[i] > max_val:
        max_val = arr[i]
        pos_max = i + 1

    if (i + 1) % 2 == 0 and arr[i] != 0:
        product_even_pos *= arr[i]
        has_even_pos = True

    if arr[i] % 2 != 0:
        product_odd_vals *= arr[i]
        has_odd_vals = True

print(f"El mayor = {max_val:.2f} su posicion es {pos_max}")

if has_even_pos:
    print(f"Producto de posicion de pares {product_even_pos:.2f}")
else:
    print("No hubo producto positivo de pares")

if has_odd_vals:
    print(f"Producto de elementos impares {product_odd_vals:.2f}")
else:
    print("No hubo producto de elementos impares")
