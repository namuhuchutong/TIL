#23

import heapq

def mergeKsortedLists(lists):
    merged_list = []
    heap = []

    for n in lists:
        if len(n) == 0:
            continue
        # (num, idx, list)
        heapq.heappush(heap, (n[0], 0, n))
    
    while heap:
        num, idx, nth_list = heapq.heappop(heap)
        merged_list.append(num)
        idx += 1
        if idx < len(nth_list):
            heapq.heappush(heap, (nth_list[idx], idx, nth_list))

    return merged_list

lists = [[1,5,7,9],[2,6,8],[3,4,10]]

print(mergeKsortedLists(lists))