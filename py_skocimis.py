// https://open.kattis.com/problems/skocimis

line = input()
data = line.split(' ')
num = [int(i) for i in data]
a = num[0]
b = num[1]
c = num[2]
count=0
if(c-b>b-a):
    while(b!=c):
        a=b 
        b=a+1 
        count = count +1
else:
    while(b!=a):
        c=b 
        b=c-1 
        count = count +1
print(count-1)
