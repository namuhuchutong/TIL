def sort(arr):
    for idx in range(0, len(arr)-1):
        for i in range(0, len(arr)-idx-1):
            if arr[i][0] > arr[i+1][0]:
                arr[i],arr[i+1] = arr[i+1],arr[i]
    return arr

print(sort([(7,'a'),(5,'a'),(5,'b'),(7,'b'),(3,'c')]))
