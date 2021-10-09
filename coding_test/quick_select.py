import random

def quickSelect(nums, k):
    length = len(nums)
    if length == 1:
        return nums[0]

    pivotIdx = random.randrange(length)
    lastIdx = length-1

    nums[pivotIdx], nums[lastIdx] = nums[lastIdx], nums[pivotIdx]
    leftIdx = 0
    rightIdx = length-2
    pivot = nums[-1]
    while leftIdx <= rightIdx:
        if nums[leftIdx] <= pivot:
            leftIdx += 1
            continue

        if pivot < nums[rightIdx]:
            rightIdx -= 1
            continue

        if pivot < nums[leftIdx] and nums[rightIdx] <= pivot:
            nums[leftIdx], nums[rightIdx] = nums[rightIdx], nums[leftIdx]
            continue

    nums[leftIdx], nums[lastIdx] = nums[lastIdx], nums[leftIdx]
    if leftIdx == length - k:
        return nums[leftIdx]
    elif leftIdx < length-k:
        return quickSelect(nums=nums[leftIdx+1:], k=k)
    elif length-k < leftIdx:
        return quickSelect(nums=nums[:leftIdx], k=k-(length-leftIdx))

print(quickSelect(nums=[5,7,9,3,1,2,4],k=2))