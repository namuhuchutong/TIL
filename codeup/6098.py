a = []
for _ in range(10):
    tmp = list(map(int, input().split()))
    a.append(tmp)

go = 0
bl = 1
tg = 2
n = 1
for i in range(1, 9):
    for j in range(n, 10):
        if(a[i][j] == go):
            a[i][j] = 9
            continue
        elif(a[i][j] == bl):
            break
        elif(a[i][j] == tg):
            a[i][j] = 9
            break
    if(a[i+1][j-1] == tg):
        a[i+1][j-1] = 9
        break
    elif(a[i+1][j-1] == bl):
        break
    elif(a[i][j] == tg):
        break
    else:
        a[i+1][j-1] = 9
        n = j - 1
    

for i in a:
    for j in i:
        print(j, end=' ')
    print()