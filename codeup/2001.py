data = []

for _ in range(5):
    data.append(int(input()))

min_pasta = min(data[:3])
min_beverage = min(data[3:])

result = (min_pasta+min_beverage)*0.1 + (min_beverage+min_pasta)

print(result)