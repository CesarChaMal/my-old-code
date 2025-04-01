from functools import reduce

a = float(input("Dar dos valores : "))
b = float(input())

suma = lambda x, y: x + y
prod = lambda x, y: x * y
sumacua = lambda x, y: x**2 + y**2

print(f"La suma es : {suma(a, b):.2f}")
print(f"El producto es : {prod(a, b):.2f}")
print(f"La suma de los cuadrados es : {sumacua(a, b):.2f}")
