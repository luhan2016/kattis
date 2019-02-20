//https://open.kattis.com/problems/numberfun

N = input()
n = int(N)
for i in range(0,n):
    num_string = input()
    numbers = num_string.split(' ')
    num = [int(i) for i in numbers]
    res = False
    if (num[0]+num[1]==num[2] or num[0]-num[1]==num[2] or num[1]-num[0]==num[2] \
    or num[0]*num[1]==num[2] or num[0]/num[1]==num[2] or num[1]/num[0]==num[2]):
        res = True
    if res == True:
        print("Possible")
    else:
        print("Impossible")
        
