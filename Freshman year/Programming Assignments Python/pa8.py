# Author:          Cole Boothe
# ULID:            C00558477
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

def main():

    pick = selection()

    while pick != "":

        if pick == '1':

            namelist = []
            datelist = []
            numdayslist = []

            table(namelist, datelist, numdayslist)

            mostname = []
            mostdate = []
            mostdays = []

            mostvdays(mostname,mostdate,mostdays)

            pick = selection()


        if pick == '2':
            namelist = []
            datelist = []
            numdayslist = []

            monthtable(namelist, datelist, numdayslist)

            pick = selection()

            
        if pick == '3':
            infile = open("Vacation.py",'r')

            look = input("\nEnter a name to search for :")

            namelook(infile, look)

            pick = selection()

        if pick == '4':

            infile = open("vacation.py", 'r')

            look = input("\nEnter a date to search for :")

            datelook(infile,look)

            pick = selection()
            

        if pick == '5':
            
            print("\nThank you for using the Vacation Manager System.")
            
            break





def selection():

    print("\n\n")
    print("Vacation Manager Menu of Options")
    print("--------------------------------")
    print("1. Display all vacation requests and max days (file order)")
    print("2. Display requests by month (month order)")
    print("3. Search for a name")
    print("4. Search for a date")
    print("5. Quit")


    pick = input("Enter a selection :")

    return pick


    
def table(namelist, datelist, numdayslist):
    infile = open("Vacation.py", 'r')

    name = infile.readline()
    
    while name != '':

        name = name.strip()
        date = infile.readline()
        date = date.strip()
        numdays = int(infile.readline())

        namelist.append(name)
        datelist.append(date)
        numdayslist.append(numdays)

        name = infile.readline()

    infile.close()

    print()
    print("Name            Start Date      Num Days")
    print("----------------------------------------")

    for i in range (len(namelist)):
        print(f"{namelist[i]:16s}{datelist[i]:18s}{numdayslist[i]:6}")

def mostvdays(namelist, datelist, numdayslist):
    infile = open("Vacation.py", 'r')

    name = infile.readline()
    biggestdays = []
    biggestnum = 0
    
    while name != '':

        name = name.strip()
        date = infile.readline()
        date = date.strip()
        numdays = int(infile.readline())

        biggestnum = max(biggestnum, numdays)

        namelist.append(name)
        datelist.append(date)
        numdayslist.append(numdays)

        name = infile.readline()

    for i in range(len(namelist)):
        if numdayslist[i] == biggestnum:
            biggestdays.append((namelist[i], datelist[i], numdayslist[i]))

    print(f"\nThe largest number of vacation days is {biggestnum} taken by:")
    for name, date, numdays in biggestdays:
        print(f"  ● {name:15s}{date}")

def monthtable(namelist,datelist,numdayslist):
    infile = open("Vacation.py", 'r')

    name = infile.readline()
    
    while name != '':

        name = name.strip()
        date = infile.readline()
        date = date.strip()
        numdays = int(infile.readline())

        namelist.append(name)
        datelist.append(date)
        numdayslist.append(numdays)

        name = infile.readline()

    for i in range(len(datelist)):
        currentMinIndex = i
        for j in range(i + 1, len(datelist)):
            if datelist[j] < datelist[currentMinIndex]:
                currentMinIndex = j

        if currentMinIndex != i:
            datelist[i], datelist[currentMinIndex] = datelist[currentMinIndex], datelist[i]
            namelist[i], namelist[currentMinIndex] = namelist[currentMinIndex], namelist[i]
            numdayslist[i], numdayslist[currentMinIndex] = numdayslist[currentMinIndex], numdayslist[i]
          

    

    print()
    print("Name            Start Date      Num Days")
    print("----------------------------------------")

    previousmonth = None
    
    for i in range (len(namelist)):
        currentmonth = int(datelist[i][:2])
        if currentmonth != previousmonth:
            print()
        previousmonth = currentmonth
        print(f"{namelist[i]:16s}{datelist[i]:18s}{numdayslist[i]}")



def namelook(infile, look):
    infile = open("Vacation.py", 'r')

    namelist = []
    datelist = []
    numdayslist = []

    name = infile.readline()
    
    while name != '':

        name = name.strip()
        date = infile.readline()
        date = date.strip()
        numdays = int(infile.readline())

        namelist.append(name)
        datelist.append(date)
        numdayslist.append(numdays)

        name = infile.readline()

    infile.close()

    for i in range(len(namelist)):
        if namelist[i].lower() == look.lower():
            print(f"\nName.............. {namelist[i]}")
            print(f"Starting Date..... {datelist[i]}")
            print(f"Number of Days.... {numdayslist[i]}")
            return
        
    print(f"\nEmployee {look} not found.")


def datelook(infile, look):
    infile = open("Vacation.py", 'r')

    namelist = []
    datelist = []
    numdayslist = []

    name = infile.readline()
    
    while name != '':

        name = name.strip()
        date = infile.readline()
        date = date.strip()
        numdays = int(infile.readline())

        namelist.append(name)
        datelist.append(date)
        numdayslist.append(numdays)

        name = infile.readline()

    infile.close()

    for i in range(len(datelist)):
        if datelist[i] == look:
            print(f"\nName.............. {namelist[i]}")
            print(f"Starting Date..... {datelist[i]}")
            print(f"Number of Days.... {numdayslist[i]}")
            return
        
    print(f"\nDate {look} not found.")


main()
