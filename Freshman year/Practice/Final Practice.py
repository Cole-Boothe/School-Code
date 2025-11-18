# Final Practice





# Pactice question 1

# Credit Hours Earned = CHE
# Quality Point = QP
# Honors Level Earned = HLE

def main():
    CHE = 3
    QP = 12
    HLE = Honers (CHE,QP)
    print("Honers Level Earned :", HLE)

    

def Honers (CHE,QP):
    
    StudentGPA = QP / CHE

    if StudentGPA >= 3.9:
        return 3
    elif StudentGPA >= 3.7:
        return 2
    elif StudentGPA >= 3.5:
        return 1
    else: return 0
main()




# Practice Question 2

def main():
    CreditH = int(3)
    
    CPCH = int(20)
    
    FF = float(30.2)

    computedcost = ComputeCost (CreditH, CPCH, FF)

    print("\nComputed Cost is :", computedcost)


def ComputeCost (CreditH, CPCH, FF):
    cost = CreditH * CPCH

    cost = cost + FF
    return cost

main ()


# Practice Question 3

def main():
    word = input("\nPlease enter a word :")
    
    letter = input("\nPlease enter a signle letter :")

    countofletter = CountLetters(word,letter)

    if countofletter == 0:
        print("\nYour letter does not appear in the word you typed")

    elif countofletter > 0:
        print("\nYour letter ocurred", countofletter, "Times in the word you typed")



def CountLetters(word,letter):
    count = 0
    for i in range(len(word)):
        if word[i] == letter:
            count = count + 1
            
    return count


main()


# Practice question 5


def main():

    numlist = []

    playernames = []

    infile = open("Players.py", 'r')

    num = infile.readline()
    while num != "": 
        num = num.strip()
        num = int(num)

        name = infile.readline()
        name = name.strip()


        numlist.append(num)
        playernames.append(name)

        num = infile.readline()
        
    searchJersey = eval(input("\nEnter jersey number to search for: "))

    for i in range(len(numlist)):
        if numlist[i] == searchJersey:
            print("\nJersey Numner:",numlist[i])
            print("\nPlayers name :",playernames[i])
            break
            
    if numlist[i] != searchJersey:
        print("\nJersey not found")

    infile.close()


main()

# Practice Problem 6


def main():
    
    gradelist = [88,99,67,34,97,95,80,70]

    passcount = LetterGrades(gradelist)

    print(f"\nNumber of passing grades is {passcount}")


def LetterGrades (gradelist):

    gradepasscount = 0

    for i in range(len(gradelist)):
        if gradelist[i] >= 70:
            gradepasscount += 1

    else: gradepasscount = gradepasscount

    return gradepasscount


main()

# Practice problem 7
def main():

    numlist = [3,5,2,8,5,99,109,54,67,32,1000, 1524]

    maxnumer = FindMax(numlist)

    print("\nThe biggest number from the list is:", maxnumer)

def FindMax (numlist):
    maxnum = 0

    for i in range(len(numlist)):
        if numlist[i] > maxnum:
            maxnum = numlist[i]
            
        else:maxnum = maxnum

    return maxnum

main()



# Practice quesiton 4



def TryThis(num1,num2,x,y):
    answer = num1 + num2
    for i in range(num2,num1,-3):
        temp = x
        x = y
        y = temp
        x = x + 1
        print(i,x,y)
    return x


def main():
    a = 40
    b = 30
    c = 5
    d = 13
    print(a,b,c,d)
    answer = TryThis(a,b,c,d)
    print(answer,c,d)


main()














    
