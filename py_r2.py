//https://open.kattis.com/problems/r2

import sys
 
for line in sys.stdin:
    read = line.split()
    r1 = int(read[0])
    s = int(read[1])
    print(2*s-r1)
