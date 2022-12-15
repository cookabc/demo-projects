from Crypto.PublicKey import RSA
from hashlib import sha512

key_pair = RSA.generate(bits=1024)
print("public key:")
print(f" N = {hex(key_pair.n)}")
print(f" e = {hex(key_pair.e)}")
print(f" d = {hex(key_pair.d)}")

def sign():
  print()
  msg = b'A message for signing'
  hash = int.from_bytes(sha512(msg).digest(), byteorder='big')
  signature = pow(hash, key_pair.d, key_pair.n)
  print(f"signature:\n {hex(signature)}")
  return signature

def verify(signature):
  print()
  msg = b'A message for signing'
  hash = int.from_bytes(sha512(msg).digest(), byteorder='big')
  hash_from_signature = pow(signature, key_pair.e, key_pair.n)
  if hash == hash_from_signature:
    print("signature is valid")
    return True
  else:
    print("signature is invalid")
    return False

verify(sign())