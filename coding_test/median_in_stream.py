#295

import heapq

class MedianFinder:
    def __init__(self) -> None:
        self._maxHeap = []
        self._minHeap = []

    def addNum(self, num):
        if len(self._minHeap) == 0 and len(self._maxHeap) == 0:
            heapq.heappush(self._minHeap, num)
            return
        
        median = self.findMedian()
        if median < num:
            heapq.heappush(self._minHeap, num)
        else:
            heapq.heappush(self._maxHeap, -1 * num)

        if len(self._maxHeap) + 1 < len(self._minHeap):
            pop_num = heapq.heappop(self._minHeap)
            heapq.heappush(self._maxHeap, -1 * pop_num)
        
        elif len(self._minHeap) + 1 < len(self._maxHeap):
            pop_num = -1 * heapq.heappop(self._maxHeap)
            heapq.heappush(self._minHeap, pop_num)

    def findMedian(self):
        if len(self._minHeap) < len(self._maxHeap):
            small_med =  -1 * self._maxHeap[0]
            return small_med
        elif len(self._maxHeap) < len(self._minHeap):
            large_med = self._minHeap[0]
            return large_med
        else:
            small_med = -1 * self._maxHeap[0]
            large_med = self._minHeap[0]
            med = (small_med + large_med)/2
            return med

    def clear(self):
        self._maxHeap.clear()
        self._minHeap.clear()

median_finder = MedianFinder()
median_finder.clear()
median_finder.addNum(1)
print("[1]", "median: ", median_finder.findMedian())
median_finder.addNum(3)
print("[1,3]", "median: ", median_finder.findMedian())
median_finder.addNum(5)
print("[1,3,5]", "median: ", median_finder.findMedian())
median_finder.addNum(5)
print("[1,3,5,5]", "median: ", median_finder.findMedian())
median_finder.addNum(4)
print("[1,3,5,5,4]", "median: ", median_finder.findMedian())
median_finder.addNum(8)
print("[1,3,5,5,4,8]", "median: ", median_finder.findMedian())
median_finder.addNum(5)
print("[1,3,5,5,4,8,5]", "median: ", median_finder.findMedian())
median_finder.addNum(1)
print("[1,3,5,5,4,8,5,1]", "median: ", median_finder.findMedian())
median_finder.addNum(2)
print("[1,3,5,5,4,8,5,1,2]", "median: ", median_finder.findMedian())