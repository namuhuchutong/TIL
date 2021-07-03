n, m, k = map(int, input().split())

_list = list(map(int, input().split()))
_list.sort(reverse=True)

sum = 0
idx = 0
flag = 0

for i in range(m):
    if flag < k:
        sum += _list[idx]
        flag += 1
    else:
        sum += _list[idx+1]
        flag = 0

print(sum)