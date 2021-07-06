a, b = map(int, input().split())

times = abs(a-b)//10

rest = abs(a-b)%10

if rest == 1 or rest == 5:
    times += 1
elif rest == 2 or rest == 4 or rest == 6 or rest == 9:
    times += 2
elif rest == 3 or rest == 7 or rest == 8:
    times += 3

print(times)