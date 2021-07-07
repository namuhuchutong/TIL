n = input()

d = {
    'a':1,
    'b':2,
    'c':3,
    'd':4,
    'e':5,
    'f':6,
    'g':7,
    'h':8,
}

w = d.get(n[0])
h = int(n[1])



knight = [
    (-2, -1), (-2, 1), 
    (2, -1), (2, 1), 
    (-1, 2), (1, 2), 
    (-1, -2), (-1, -2)
]

count = 0
for i in knight:
    if i[0] + w >= 1 and i[1] + h >= 1 and i[0] + w <= 9 and i[1] + h <= 9:
        count += 1
print(count)