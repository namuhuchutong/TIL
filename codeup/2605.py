board = []

for _ in range(7):
    board.append(list(map(int, input())))

'''
    1 : red
    2 : yellow
    3 : blue
    4 : green
    5 : purple
'''
targets = [1, 2, 3, 4, 5]

def dfs(x, y, target):

    if x < -1 or x > 7 or y < -1 or y > 7:
        return False
    
    if board[x][y] == target:
        dfs(x+1, y, target)
        dfs(x-1, y, target)
        dfs(x, y+1, target)
        dfs(x, y-1, target)
        return True
    return False

def routine(target):
    count = 0
    for i in range(7):
        for j in range(7):
            if dfs(i, j, target):
                count += 1

result = 0
for i in targets:
    if routine(i) > 0:
        result += 1

print(result)
