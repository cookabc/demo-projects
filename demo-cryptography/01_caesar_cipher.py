import string

def generate_encryption_key(shift):
  uppercase_letters = string.ascii_letters[26:]
  key = {}
  i = 0
  for c in uppercase_letters:
    key[c] = uppercase_letters[(i + shift) % 26]
    i += 1
  return key

def generate_decryption_key(shift):
  uppercase_letters = string.ascii_letters[26:]
  key = {}
  i = 0
  for c in uppercase_letters:
    key[uppercase_letters[(i + shift) % 26]] = c
    i += 1
  return key

def encypt(key, message):
  cipher_text = ""
  for c in message:
    if c in key:
      cipher_text += key[c]
    else:
      cipher_text += c
  return cipher_text

def decrypt(key, cipher_text):
  message = ""
  for c in cipher_text:
    if c in key:
      message += key[c]
    else:
      message += c
  return message


message = "ATTACK"

key = generate_encryption_key(3)
cipher_text = encypt(key, message)
print(cipher_text)

key = generate_decryption_key(3)
message_text = decrypt(key, cipher_text)
print(message_text)