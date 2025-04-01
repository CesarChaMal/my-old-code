from math import prod  # ✅ import this!

n = int(input("Orden (max 50): "))
while n <= 0 or n > 50:
    n = int(input("Orden inválido, intente nuevamente: "))

arr = [float(input("Elemento: ")) for _ in range(n)]
max_val, pos_max = max((val, idx + 1) for idx, val in enumerate(arr))

even_pos = [x for i, x in enumerate(arr) if (i + 1) % 2 == 0 and x != 0]
odd_vals = [x for x in arr if x % 2 != 0]

print(f"El mayor = {max_val:.2f} su posicion es {pos_max}")
print(f"Producto pares: {prod(even_pos):.2f}" if even_pos else "No hubo producto positivo de pares")
print(f"Producto impares: {prod(odd_vals):.2f}" if odd_vals else "No hubo producto de elementos impares")
