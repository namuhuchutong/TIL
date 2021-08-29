def add(num1:str, num2:str) -> str:
    result = "" 

    n = len(num1) - 1
    m = len(num2) - 1

    carry = 0

    while n >= 0 or m >= 0 or carry:

        e1 = int(num1[n]) if n >=0 else 0
        e2 = int(num2[m]) if m >=0 else 0

        tmp = e1 + e2 + carry

        carry = tmp // 10
        result = str(tmp%10) + result

        n -= 1
        m -= 1

    return result


num1 = "11"
num2 = "123"

print(add(num1, num2))