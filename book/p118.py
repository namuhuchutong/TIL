n, m = map(int, input().split())
# location and direction 
x, y, direction = map(int, input().split()) 

# current position
d = [[0] * m for _ in range(n)]
d[x][y] = 1
map_ = []

# directions
# up, right, down, left
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for _ in range(n):
    map_.append(list(map(int, input().split())))

def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3

count = 1
turn_time = 0

while True:
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]

    if d[nx][ny] == 0 and map_[nx][ny] == 0:
        d[nx][ny] = 1
        x = nx
        y = ny
        count += 1
        turn_time = 0
        continue
    else:
        turn_time += 1
    
    if turn_time == 4:
        nx = x - dx[direction]
        ny = y - dy[direction]

        if map_[nx][ny] == 0:
            x = nx
            y = ny
        else:
            break
        turn_time = 0
print(count)