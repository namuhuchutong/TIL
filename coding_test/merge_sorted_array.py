import numpy as np

def merge(arr1, arr2):
    idx1 = 2
    idx2 = 2
    wIdx = len(arr1) - 1

    if idx2 < 0:
        return
    
    while 0 <= idx1 and 0 <= idx2:

        num1 = arr1[idx1]
        num2 = arr2[idx2]

        if arr1[idx1] <= arr2[idx2]:
            arr1[wIdx] = num2 
            wIdx = wIdx - 1
            idx2 = idx2 - 1
        else:
            arr1[wIdx] = num1
            wIdx = wIdx - 1
            idx1 = idx1 - 1

    if 0 <= idx2:
        arr1[0:idx2+1] = arr2
    print(arr1)

arr1 = [4, 5, 6, 0, 0, 0]
arr2 = [1, 2, 3]

print(arr1, arr2)
merge(arr1, arr2)

arr1 = [1, 3, 5, 0, 0, 0]
arr2 = [2, 4, 8]

print(arr1, arr2)
merge(arr1, arr2)