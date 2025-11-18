# Author:       Cole Boothe
# ULID/Section: C00558477 & section-number 3
# lab14.py

def main():

    namelist = []
    percentlist = []
    touchdownlist = []

    

    infile = open("stats.py","r")
    
    name = infile.readline()
    
    while name != "":

        name = name.strip()

        percent = float(infile.readline())

        touchdowns = int(infile.readline())

        namelist.append(name)
        percentlist.append(percent)
        touchdownlist.append(touchdowns)
        
        name = infile.readline()
        
    infile.close()

    print()
    print("    Name               Pct     TDs")
    print("----------------------------------")
    for i in range(0,len(namelist),1):
        print(f"{namelist[i]:20s} {percentlist[i]:6.2f} {touchdownlist[i]:6d}")

    
    Goodpassers = goodpasserlist(percentlist,namelist)

    goodplayercount = 0

    for i in range(len(Goodpassers)):
        goodplayercount += 1

    print(f"\nThere are {goodplayercount} players with pass completion > 68%")
    print("Here is the list", Goodpassers, "\n\n")


def goodpasserlist(percentlist, namelist):

    goodplayerlist = []
    
    for i in range (len(percentlist)):
        
        if percentlist[i] > 68:
            goodplayerlist.append(namelist[i])
    
    return goodplayerlist

main()
