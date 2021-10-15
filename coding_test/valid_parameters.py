#20

from collections import deque

def isVaild(s: str) -> bool:
    dq = deque()

    if len(s) == 1 or len(s) == 0:
        return False

    for c in s:
        if c == '(' or c == '[' or c == '{':
            dq.append(c)
        else:
            popped = dq.pop()
            if popped == '(' and c == ')':
                continue
            elif popped == '{' and c == '}':
                continue
            elif popped == '[' and c == ']':
                continue
            else:
                return False
            
    if len(dq) != 0:
        return False 
    
    return True

print(isVaild("){"))