m = 2 ** 31
a = 1103515245
c = 12345

def lcg(a, c, m,  seed):
  return (a * seed + c) % m

seed = 1

for _ in range(10):
  rand_n = lcg(a, c, m, seed)
  print(rand_n)
  seed = rand_n