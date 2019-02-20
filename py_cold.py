//https://open.kattis.com/problems/cold

days = input()
data = input()

temperature = data.split(' ')
degree = [int(i) for i in temperature]
day = int(days)
count = 0
for i in range(0,day):
    if degree[i]<0:
        count = count +1
print(count)
