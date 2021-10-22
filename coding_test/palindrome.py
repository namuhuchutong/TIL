# 125

def find(text: str) -> bool:
    txt = ''.join(c for c in text if c.isalnum())
    txt = txt.lower()
    print(txt)

    n = len(txt) - 1

    for i in range(0, n):
        if i == n-i:
            break
        if txt[i] == txt[n-i]:
            print(txt[i] + " - " +txt[n-i])
            continue
        else:
            return False

    return True 

def find2(text: str) -> bool:
    txt = ''.join(c for c in text if c.isalnum())
    txt = txt.lower()

    n = len(txt) - 1
    right = n
    left = 0
    cnt = 0

    for i in range(0, n):
        if i > n-i:
            break
        if txt[left] == txt[right] and cnt < 2:
            left = left + 1
            right = right - 1
            continue
        elif txt[left+1] == txt[right] and cnt < 2:
            left = left + 1
            cnt = cnt + 1
            continue
        elif txt[left] == txt[right-1] and cnt < 2:
            right = right - 1
            cnt = cnt + 1
            continue
        else:
            return False

    return True

s1 = "A man, a plan, a canal: Panama"
s2 = "race a car"

#print(find(s1))
#print(find(s2))
#print(find("0P"))

print(find2("aabdeenddbaagbddeedbaa"))
print(len("aa bd ee (n) dd baa g b dd ee db aa"))