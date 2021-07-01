h, w = map(int, input().split())

a = [[0 for i in range(w)] for j in range(h)]

n = int(input())

for i in range(n):
    l, d, x, y = map(int, input().split())
    x = x - 1
    y = y - 1
    if(d == 0):
        for i in range(l):
            if(a[x][y+i] == 1):
                a[x][y+i] = 0
            else:
                a[x][y+i] = 1
    else:
        for i in range(l):
            if(a[x+i][y] == 1):
                a[x+i][y] = 0
            else:
                a[x+i][y] = 1

for i in a:
    for j in i:
        print(j, end=' ')
    print()