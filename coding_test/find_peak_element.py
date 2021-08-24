import numpy as np

def find(arr):
    left = 0
    right = len(arr) - 1

    if right <= 1:
        return 0
    
    while left < right:
        pivot = (left+right)//2
        num = arr[pivot]
        next = arr[pivot + 1]

        if num < next:
            left = pivot + 1
        else:
            right = pivot
    
    return left

arr = (np.random.randint(0, 10, 15)).tolist()
print(arr)
print(arr[find(arr)])