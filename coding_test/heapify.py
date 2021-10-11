def swap(arr, rootIdx):
    largeIdx = rootIdx
    leftChild = 2 * rootIdx + 1
    rightChild = 2 * rootIdx + 2

    if leftChild < len(arr) and arr[largeIdx] < arr[leftChild]:
        largeIdx = leftChild

    if rightChild < len(arr) and arr[largeIdx] < arr[rightChild]:
        largeIdx = rightChild

    if largeIdx != rootIdx:
        arr[rootIdx], arr[largeIdx] = arr[largeIdx], arr[rootIdx]
        swap(arr, largeIdx)

def heapify(arr):
    for idx in range(len(arr)//2, -1, -1):
        swap(arr, idx)

arr = [1,3,5,2,4,8,6,7,9]
heapify(arr)
print(arr)