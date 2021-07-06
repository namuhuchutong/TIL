i = int(input())

money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
count = 0

for m in money:
    if i//m != 0:
        count += i//m
        i = i%m

print(count)