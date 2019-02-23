//https://open.kattis.com/problems/soylent

import sys
import math


n = sys.stdin.readline()
for i in range(0,int(n)):
    x = sys.stdin.readline()
    if int(x)%400 != 0:
        print(int(int(x)/400)+1)
    else:
        print(int(int(x)/400))

