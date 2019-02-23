//https://open.kattis.com/problems/sok

import sys
import math

(a, b, c) = map(int, sys.stdin.readline().split())
(i, j, k) = map(int, sys.stdin.readline().split())
x=a/i 
y=b/j 
z=c/k
if(x<=y and x<=z):
    a=0
    b=b-j*x
    c=c-k*x
elif(y<=x and y<=z):
    a=a-i*y
    b=0
    c=c-k*y
elif(z<=x and z<=y):
    a=a-i*z
    b=b-j*z
    c=0
print('{:6f} {:6f} {:6f}'.format(a,b,c))
