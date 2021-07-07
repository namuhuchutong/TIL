n = int(input())
data = input().split()

x = 1
y = 1

for i in data:
    if i == 'R' and x+1 <= 5:
        x = x + 1
    elif i == 'L' and x-1 >= 1:
        x = x - 1
    elif i == 'U' and y-1 >= 1:
        y = y - 1
    elif i == 'D' and y+1 <= 5:
        y = y + 1

print(y, x)