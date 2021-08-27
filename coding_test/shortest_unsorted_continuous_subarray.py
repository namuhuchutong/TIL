array = [2, 6, 4, 8, 10, 9, 15]

def find_shortest(N):
    lenN, left, right = len(N) - 1, -1, -1
    maxN, minN = N[0], N[lenN]
    for i in range(1, len(N)):
        print(i)
        a, b = N[i], N[lenN-i]
        if a < maxN: 
            right = i
            print("right : ", end=" : ")
            print(right)
        else: 
            maxN = a
            print("maxN : ", end=" : ")
            print(maxN)
        if b > minN: 
            left = i
            print("left : ", end=" : ")
            print(left)
        else: 
            minN = b
            print("minN : ", end=" : ")
            print(minN)
    return max(0, left + right - lenN + 1)

print(find_shortest(array))