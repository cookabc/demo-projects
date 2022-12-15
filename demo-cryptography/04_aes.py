from cryptography.fernet import Fernet

def encrypt(key, plain_text):
  f = Fernet(key)
  return f.encrypt(plain_text)

def decrypt(key, cipher_text):
  f = Fernet(key)
  return f.decrypt(cipher_text)

key = Fernet.generate_key()
print(f"key={key}")
cipher_text = encrypt(key, plain_text=b"attack")
print(cipher_text)
plain_text = decrypt(key, cipher_text)
print(plain_text)