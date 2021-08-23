import numpy as np

def move(arr):
    zidx = 0
    for idx in range(len(arr)):
        if arr[idx] != 0:
            arr[zidx] = arr[idx]
            zidx = zidx + 1
    for i in range(zidx, len(arr)):
        arr[i] = 0
    print(arr)

arr = (np.random.randint(0, 2, 20)).tolist()
print(arr)
move(arr)