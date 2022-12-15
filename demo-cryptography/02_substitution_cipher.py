import string
import random

def generate_keys():
  letters = [l for l in string.ascii_letters[26:]]
  random.shuffle(letters)

  return dict(zip(string.ascii_letters[26:], letters))

def encypt(key, message):
  cipher = ""
  for l in message:
    if l in key:
      cipher += key[l]
    else:
      cipher += l
  return cipher

key = generate_keys()
print(key)

print(encypt(key, "ATTACK"))