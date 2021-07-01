a = []

for i in range(19):
    tmp = list(map(int, input().split()))
    a.append(tmp)

n = int(input())

for i in range(n):
    x, y = map(int, input().split())
    for j in range(19):
        if(a[j][y-1] == 0):
            a[j][y-1] = 1
        else:
            a[j][y-1] = 0
        
        if(a[x-1][j] == 1):
            a[x-1][j] = 0
        else:
            a[x-1][j] = 1

for i in a:
    for j in i:
        print(j, end=' ')
    print()