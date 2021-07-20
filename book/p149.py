n, m = map(int, input().split())

list_ = []

for _ in range(n):
    list_.append(list(map(int, input())))

count = 0 

def dfs(x, y):

    print(x, y)

    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False

    if list_[x][y] == 0:
        list_[x][y] = 1
        dfs(x - 1, y)
        dfs(x, y -1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False

for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            count += 1

print(count)