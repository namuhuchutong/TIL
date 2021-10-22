def sort(nums):
    for idx in range(0,len(nums)):
        minN = nums[idx][0]
        minIdx = idx
        for i in range(idx, len(nums)):
            if nums[i][0] < minN:
                minN = nums[i][0]
                minIdx = i
        nums[minIdx], nums[idx] = nums[idx], nums[minIdx]
    return nums

print(sort([(7,'a'),(7,'b'),(5,'a'),(5,'b'),(3,'c')]))
# selection sort is not stable