import heapq

nums = [1,3,5,7,9,11]
print(nums)

largest = []

for num in nums:
    heapq.heappush(largest, num)
    if 3 < len(largest):
        heapq.heappop(largest)

print(largest)    