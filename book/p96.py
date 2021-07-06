n, m = map(int, input().split())

result = 0

for _ in range(n):
    data = list(map(int, input().split()))
    min_val = min(data)

    result = max(min_val, result)

print(result)