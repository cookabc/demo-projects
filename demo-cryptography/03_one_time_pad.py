import random

def generate_keys(n):
  return bytes([random.randrange(256) for i in range(n)])

def xor(key, message):
  return bytes([key[i] ^ message[i] for i in range(len(message))])

message = b'ATTACK'

key = generate_keys(len(message))
print(key)
cipher = xor(key, message)
print(cipher)

# decrypt
plain_text = xor(key, cipher)
print(plain_text)