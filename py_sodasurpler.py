//https://open.kattis.com/problems/sodasurpler

line = input()
data = line.split(' ')
num = [int(i) for i in data]
e = num[0]
f = num[1]
c = num[2]
count=0
while(e+f>=c):
    t=int((e+f)/c)
    f=(e+f)%c
    e=t
    count = count+e 
print(int(count))







import sys
import math

(e, f, c) = map(int, sys.stdin.readline().split())
bots = e + f
drunk = 0
while(bots/c >= 1):	
	drunk = drunk + math.floor(bots/c)
	bots = bots % c + math.floor(bots/c)
print(drunk)
