//https://open.kattis.com/problems/server

import sys
import math

(n,T)= map(int, sys.stdin.readline().split())
data = input().split(' ')
task = [int(i) for i in data]
t=0
for i in range(0,int(n)):
	t=t+task[i]
	if t>T:
		print(i)
		break
if t<=T:
	print(n)
