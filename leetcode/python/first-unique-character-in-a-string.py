def firstUniqChar(self, s: str) -> int:
        count = {}
        for c in s:
            crnt_count = count.get(c)
            if crnt_count is None:
                count[c] = 1
                continue
            count[c] += 1
            
        for idx, c in enumerate(s):
            if count[c] == 1:
                return idx
            
        return -1