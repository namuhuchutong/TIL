import numpy as np

def bs(arr, target):
    left = 0
    right = len(arr) - 1

    while left<=right:
        pivot = (left+right)//2

        if arr[pivot] == target:
            return pivot
        elif arr[pivot] < target:
            left = pivot+1
        else:
            right = pivot-1
    return -1


arr = [1, 3, 4, 5, 13, 324, 423]
print(arr)
result = bs(arr, 13)

if result == -1:
    print("no target")
else:
    print(result+1)