//https://open.kattis.com/problems/zoo

import sys
import math

animal_dict = {}
li = 0
while True:
	n = sys.stdin.readline()
	li = li + 1
	if n=='0' or n=="0" or n=="0\n":
		break
	for i in range(0,int(n)):
		description = input().split(' ')
		animal = [str(a) for a in description]
		if animal[-1].lower() in animal_dict:
			animal_dict[animal[-1].lower()] = animal_dict[animal[-1].lower()] + 1
		else:
			animal_dict[animal[-1].lower()]  = 1
	print("List {}:".format(li))
	for key, value in sorted(animal_dict.items()):
		print("{} | {}".format(key,value))
	animal_dict.clear()
