import random
def quickSort(nums, first, last):
    length = last - first + 1
    if length <= 1:
        return nums
    
    pivotIdx = random.randrange(first, last)
    nums[pivotIdx], nums[last] = nums[last], nums[pivotIdx]
    leftIdx = 0
    rightIdx = last - 1
    pivot = nums[last]

    while leftIdx <= rightIdx:
        if nums[leftIdx] <= pivot:
            leftIdx = leftIdx + 1
            continue

        if pivot < nums[rightIdx]:
            rightIdx = rightIdx - 1
            continue

        if pivot < nums[leftIdx] and nums[rightIdx] <= pivot:
            nums[leftIdx], nums[rightIdx] = nums[rightIdx], nums[leftIdx]
            continue 
    nums[leftIdx], nums[last] = nums[last], nums[leftIdx]

    quickSort(nums, leftIdx+1, last)
    quickSort(nums, first, leftIdx-1)

    return nums

nums = [5,7,9,3,1,5,5,2,4]
quickSort(nums, 0, len(nums)-1)
print(nums)