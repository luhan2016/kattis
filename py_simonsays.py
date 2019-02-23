//https://open.kattis.com/problems/simonsays

import sys

n = sys.stdin.readline()
for i in range(0,int(n)):
	say = sys.stdin.readline()
	if say.find("Simon says")>=0:
		new_str = say.replace("Simon says","")
		print(new_str)
