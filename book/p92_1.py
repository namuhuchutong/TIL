from typing import Reversible


n, m, k = map(int, input().split())
list_ = list(map(int, input().split()))
list_.sort(reverse=True)

sum = 0
idx = 0
repeat = 0

for _ in range(m):
    if repeat < k:
        sum = sum + list_[idx]
        repeat = repeat + 1
    else:
        sum = sum + list_[idx+1]
        repeat = 0

print(sum)