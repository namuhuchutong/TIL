from typing import List

def insertionSort(nums):
    for idx in range(1, len(nums)):
        tmp = nums[idx]
        i = idx-1
        while 0 <= i and tmp < nums[i]:
            nums[i+1] = nums[i]
            i = i - 1
        nums[i+1] = tmp
    return nums

print(insertionSort(nums=[9,3,5,7,1]))