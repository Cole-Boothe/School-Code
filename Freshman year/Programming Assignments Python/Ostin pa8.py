# Author:          Ostin Duncan
# ULID:            C00531687
# Course/Section:  CMPS 150 – Lecture Section # 003
# Assignment:      pa8
# Date Assigned:   Wednesday, November 27, 2024
# Date/Time Due:   Wednesday, December 4, 2024, 11:59 PM
#
# Description:     This program reads an input file of employee vacation day requests
#                  and appends the data to lists. It offers a menu of options that
#                  allows the user to display data in various formats and allows
#                  them to search the data. All data is displayed neatly in formatted
#                  tables.
#
#
# Certification of Authenticity:
# I certify that this assignment is entirely my own work.


# Function for the menu

def menu():

    print("\n\n")
    print("Vacation Manager Menu of Options")
    print("--------------------------------")
    print("1. Display all vacation requests and max days (file order)")
    print("2. Display requests by month (month order)")
    print("3. Search for a name")
    print("4. Search for a date")
    print("5. Quit")
    
    choice = input("Enter selection: ")

    return choice


# Function to print the table in order of infile

def printtable(nameList, startList, daysList):

    infile = open("Vacation.py",'r')

    name = infile.readline()

    while name != '':
        
        name = name.strip()
        start = infile.readline().strip()
        days = int(infile.readline())
    

        nameList.append(name)
        startList.append(start)
        daysList.append(days)
                
        name = infile.readline()

    infile.close()

            
    print()
    print("Name            Start Date      Num Days")
    print("----------------------------------------")
    for i in range (len(nameList)):
        print(f"{nameList[i]:16s}{startList[i]:18s}{daysList[i]}")

        
# Function to read vacation requests and display max number of days

def maxdays(nameList, startList, daysList):

    infile = open("Vacation.py",'r')

    name = infile.readline()

    largestdays = []
    maxvacation = 0

    while name != '':
        
        name = name.strip()
        start = infile.readline().strip()
        days = int(infile.readline())

        maxvacation = max(maxvacation, days)

        nameList.append(name)
        startList.append(start)
        daysList.append(days)

        name = infile.readline()

    for i in range(len(nameList)):
        if daysList[i] == maxvacation:
            largestdays.append((nameList[i], startList[i], daysList[i]))
        
    if largestdays:
        print(f"\nThe largest number of vacation days is {maxvacation} taken by:")
        for name, start, days in largestdays:
            print(f"  ● {name:15s}{start}")


# Function to display infile information in month order

def monthorder(nameList, startList, daysList):

    infile = open("Vacation.py",'r')

    nameList = []
    startList = []
    daysList = []

    name = infile.readline()

    while name != '':
        name = name.strip()
        start = infile.readline().strip()
        days = int(infile.readline())

        nameList.append(name)
        startList.append(start)
        daysList.append(days)

        name = infile.readline()

    for i in range(len(startList) - 1):
        currentMinIndex = i
        for j in range(i + 1, len(startList)):
            if startList[j] < startList[currentMinIndex]:
                currentMinIndex = j

        if currentMinIndex != i:
            startList[i], startList[currentMinIndex] = startList[currentMinIndex], startList[i]
            nameList[i], nameList[currentMinIndex] = nameList[currentMinIndex], nameList[i]
            daysList[i], daysList[currentMinIndex] = daysList[currentMinIndex], daysList[i]
          

    

    print()
    print("Name            Start Date      Num Days")
    print("----------------------------------------")

    previousmonth = None
    
    for i in range (len(nameList)):
        currentmonth = int(startList[i][:2])
        if currentmonth != previousmonth:
            print()
        previousmonth = currentmonth
        print(f"{nameList[i]:16s}{startList[i]:18s}{daysList[i]}")


def searchname(infile, search):

    infile = open("Vacation.py",'r')

    nameList = []
    startList = []
    daysList = []

    name = infile.readline()

    while name != '':
        name = name.strip()
        start = infile.readline().strip()
        days = int(infile.readline())

        nameList.append(name)
        startList.append(start)
        daysList.append(days)
        
        name = infile.readline()

    infile.close()

    for i in range(len(nameList)):
        if nameList[i].lower() == search.lower():
            print(f"\nName........ {nameList[i]}")
            print(f"Start Date.. {startList[i]}")
            print(f"Num Days.... {daysList[i]}")
            return
    print(f"\nEmployee {search} not found.")


def searchdate(infile, search):

    infile = open("Vacation.py",'r')

    nameList = []
    startList = []
    daysList = []

    name = infile.readline()

    while name != '':
        name = name.strip()
        start = infile.readline().strip()
        days = int(infile.readline())

        nameList.append(name)
        startList.append(start)
        daysList.append(days)
        
        name = infile.readline()

    infile.close()

    for i in range(len(startList)):
        if startList[i] == search:
            print(f"\nName........ {nameList[i]}")
            print(f"Start Date.. {startList[i]}")
            print(f"Num Days.... {daysList[i]}")
            return
    print(f"\nDate {search} not found.")
    
    
def main():

    choice = menu()
    
    while True:

        print()

        if choice == '1':

            nameList = []
            startList = []
            daysList = []

            table = printtable(nameList, startList, daysList)

            lnameList = []
            lstartList = []
            ldaysList = []

            maxvacation = maxdays(lnameList, lstartList, ldaysList)

            choice = menu()

        elif choice == '2':

            nameList = []
            startList = []
            daysList = []

            monthtable = monthorder(nameList, startList, daysList)

            choice = menu()

        elif choice == '3':

            infile = open("Vacation.py",'r')

            search = input("Enter name to search: ")

            namesearch = searchname(infile, search)

            choice = menu()

        elif choice == '4':

            infile = open("Vacation.py",'r')

            search = input("Enter search date: ")

            datesearch = searchdate(infile, search)

            choice = menu()

    
        elif choice == '5':

            print()
            print("Thank you for using the Vacation Manager System.")
            break

        else:
            print("Invalid selection. Try again.")

            choice = menu()       

main()
            
    
