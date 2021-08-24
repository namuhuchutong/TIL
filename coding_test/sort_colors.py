import numpy as np

def swap(arr):
    i = 0
    idx0 = 0
    idx2 = len(arr) - 1

    while i <= idx2:
        if arr[i] == 0:
            print(arr)
            arr[i], arr[idx0] = arr[idx0], arr[i]
            idx0 = idx0 + 1
            print(arr, end=" ")
            print(i)
        elif arr[i] == 2:
            print(arr)
            arr[i], arr[idx2] = arr[idx2], arr[i]
            idx2 = idx2 - 1
            print(arr, end=" ")
            print(i)
        else:
            i = i + 1
    print(arr)

arr = (np.random.randint(0, 3, 10)).tolist()
print(arr)
swap(arr)