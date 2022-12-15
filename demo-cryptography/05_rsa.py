import sympy

min_n = 1000
max_n = 5000

def get_pq():
  while True:
    p = sympy.randprime(min_n, max_n)
    q = sympy.randprime(min_n, max_n)
    if p != q:
      return p, q

p, q = get_pq()

N = p * q
print(f"p = {p}")
print(f"q = {q}")
print(f"N = p * q = {N}")

r = (p - 1) * (q - 1)
print(f"r = {r}")

e = 65537

def get_d(r):
  for d in range(2, r):
    if d * e % r == 1:
      return d

d = get_d(r)
print(f"d = {d}")

def encrypt(m):
  cipher = m ** e % N
  return cipher

def decrypt(cipher):
  plain_text = cipher ** d % N
  return plain_text

cipher_text = encrypt(m=100)
print(cipher_text)
plain_text = decrypt(cipher_text)
print(plain_text)