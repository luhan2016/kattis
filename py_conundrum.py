//conundrum

import sys

count = 0
string = sys.stdin.readline()
for i in range(0,len(string)-1):
	if(i%3==0 and string[i] != 'P'):
		count = count + 1
	elif(i%3==1 and string[i] != 'E'):
		count = count + 1
	elif(i%3==2 and string[i] != 'R'):
		count = count + 1
print(count)
