#code that shows a lista element "1" going up in the list
import os
import time

lista = ["1", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "]
position = 0
cont = 1

while cont < 5:
    for i in range(len(lista)): #used index, because by element value causes the FOR LOOP in the while loop to loop in the backgroound while going through the list even if empty, see explanation below.

        os.system('cls')
        print(lista)
        time.sleep(0.3)

        lista[position] = " " #changes the element value of index "position" to " "

        if position < (len(lista) - 1):
            lista[position + 1] = "1" #position of the next element to obtain value "1"
            position = position + 1 #position of the next lista[position]
        # if the position is equal or higher to lenght of lista
        elif position >= (len(lista) - 1):
            #get rid of "1" at the end of list while in the loop
            lista[10] = " "
            #resets position
            position = 0
            #puts the "1" back in list[0] to loop look nice
            lista[0] = "1"
    cont = cont + 1

print("END")



''' EXPLANATION: 
    By using element value causes so that the FOR LOOP only access the ELEMENT OF VALUE "1" once per while loop, because "1" is in only one place in the list.
    And once the ELEMENT OF VALUE "1" moves, the rest of the FOR LOOP continues, but now all values are " ". Causing so that the cont for while loop reaches 5, causing it to stop altogether, without detecting the "1", since it wasnt there anymore '''

''' Yeah, weird stuff i know '''

''' The old code:

import os
import time

lista = ["1", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "]
position = 0
cont = 1

while cont < 5:
    for i in lista:
        if i == "1":
            os.system('cls')
            print(lista)
            time.sleep(0.2)
            lista[position] = " " #changes the element value of index "position" to " "
            if position < (len(lista) - 1):
                lista[position + 1] = i #position of the next element to obtain value "1"
                position = position + 1 #position of the next lista[position]
            # if the position is equal to lenght of lista
            elif position >= (len(lista) - 1):
                #get rid of "1" at the end of list while in the loop
                lista[10] = " "
                #resets position
                position = 0
    cont = cont + 1

'''