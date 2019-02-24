//https://blog.csdn.net/lose__way/article/details/78382962

import sys

n1 = sys.stdin.readline()
n2 = sys.stdin.readline()
angle = int(n2)-int(n1)
if angle<0:
	angle = angle+360
elif angle>360:
	angle = angle-360
if(angle>360-angle):
	print(angle-360)
else:
	print(angle)
