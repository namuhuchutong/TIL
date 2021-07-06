n, k = map(int, input().split())

times = 0

while True:

    if n == 1:
        break

    if n%k != 0:
        n = n - 1
        times += 1
        continue

    n = n//k
    times += 1

print(times)