# Author:         Cole Boothe
# ULID:           C00558477
# Course/Section: CMPS 150 – Lecture Section # 3
# Assignment:     pa7
# Date Assigned:  Thursday, November 21, 2024
# Date/Time Due:  Tuesday, November 26, 2024 –- 11:59 pm
#
# Description:    This program reads a file containing dates in various formats and
#                 converts them to a standardized MM-DD-YYYY format.
#
# Certification of Authenticity:
# I certify that this assignment is entirely my own work.



def main():
    header()

    infile = open("dates.py",'r')

    date = infile.readline()

    while date != "":
        
        date = date.strip()

        formate(date)

        print(f"{date:.<20s}")

        date = infile.readline()




def processslash(date):

    return date

def reformatslash()


def header():
    print("Converting Dates to MM-DD-YYYY Format\n")
    print("Original:            Formatted:")
    print("-------------------------------")


main()
