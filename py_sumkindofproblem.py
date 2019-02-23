//https://open.kattis.com/problems/sumkindofproblem


import sys
import math


n = sys.stdin.readline()
for i in range(0,int(n)):
    (no,num) = map(int, sys.stdin.readline().split())
    a=(1+num)*num/2
    b=num*num
    c=(2+2*num)*num/2
    print('{} {} {} {}'.format(no,int(a),int(b),int(c)))

