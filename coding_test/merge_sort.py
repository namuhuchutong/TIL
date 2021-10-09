def mergeSort(nums):
    length = len(nums)
    if length == 1:
        return nums

    mid = length//2

    left_nums = nums[:mid]
    right_nums = nums[mid:]

    sorted_left = mergeSort(nums=left_nums)
    sorted_right = mergeSort(nums=right_nums)

    sorted_nums = []
    idx_l = 0
    idx_r = 0

    while idx_l<len(sorted_left) or idx_r < len(sorted_right):
        if idx_l == len(sorted_left):
            sorted_nums.append(sorted_right[idx_r])
            idx_r = idx_r + 1
            continue

        if idx_r == len(sorted_right):
            sorted_nums.append(sorted_left[idx_l])
            idx_l = idx_l + 1
            continue

        if sorted_right[idx_r] <= sorted_left[idx_l]:
            sorted_nums.append(sorted_right[idx_r])
            idx_r = idx_r + 1
        else:
            sorted_nums.append(sorted_left[idx_l])
            idx_l = idx_l + 1

    return sorted_nums

print(mergeSort(nums=[5,7,9,3,1,2,4]))
