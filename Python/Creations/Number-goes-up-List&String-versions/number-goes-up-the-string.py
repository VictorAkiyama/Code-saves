import os
import time

palavra = " " * 10 #string made of 10 empty spaces
position = 0
cont1 = 1
cont2 = 1

while cont2 < 5:
    for i in range(len(palavra)):

        os.system('cls')
        if cont1 == 1:                               # to display for the 1st time the string with "1" at the start
            palavra = "1" + palavra[0:]
            print(palavra)
            time.sleep(0.3)
        else:                                        # continue
            print(palavra)
            time.sleep(0.3)

        # palavra[:position] -> creates a new string that has elements before index position, excluding the element of index position
        # " " - > empty element in position
        # palavra[position+1:] -> new string that has elements after position
        palavra = palavra[:position] + " " + palavra[position+1:]       # current element in "position", empty

        if position < (len(palavra) - 1):
            palavra = palavra[:position + 1] + "1" + palavra[position+2:]       # next element to obtain "1"
            position = position + 1                                             # position of the next element

        elif position >= (len(palavra) - 1):                # if the position is equal or higher to lenght of palavra
            palavra = palavra[:-1] + " "                    # get rid of "1" at the end of string while in the loop
            position = 0                                    # resets position
            palavra = "1" + palavra[position+1:]            # moves "1" to the start
        
        cont1 += 1
    cont2 += 1

print("END")
