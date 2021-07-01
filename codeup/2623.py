a, b = map(int, input().split())

m = max(a, b)
n = min(a, b)
gcd = 1
for i in range(n, 1, -1):
    if(m%i == 0 and n%i == 0):
        if gcd < i:
            gcd = i
print(gcd)