decoy_Text = ""                         # the decoy text
key = 0                                 # key to make it complex
code = 0                                # code to convert
actual_Letter = ""                      # actual letter in actual text
actual_Text = ""                        # actual text

decoy_Text = str(input("Type the text here: "))
key = 3

for letter in decoy_Text:
    code = ord(letter)                  # code becomes a number that represents a letter from decoy_Text
    code = code - key                   # subtract key from code value
    actual_Letter = chr(code)           # actual_Letter becomes a character that represents the code
    actual_Text += actual_Letter        # put actual_Letter in actual_Text

print(actual_Text)                      # the actual text itself
