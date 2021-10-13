#347

import heapq
from collections import defaultdict

def topKFrequent(nums, k):
    if k == 0:
        return []

    count_map = defaultdict(int)

    for num in nums:
        count_map[num] += 1

    topK_heap = []
    for num in count_map:
        heapq.heappush(topK_heap, (count_map[num], num))
        if k < len(topK_heap):
            heapq.heappop(topK_heap)

    topK = []
    for count, num in topK_heap:
        topK.append(num)

    return topK

topK = topKFrequent([1,3,5,3,9,3,7,5], 2)
print(topK)