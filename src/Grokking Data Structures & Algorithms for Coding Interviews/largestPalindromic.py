class Solution:
    def largestPalindromic(self, num: str) -> str:
        num_count = [0] * 10
        for n in num:
            num_count[int(n)] += 1
        idx = 0
        res = []
        while idx < 10:
            while num_count[idx] - 2 >= 0:
                res.insert(0,idx)
                res.append(idx)
                num_count[idx] -= 2
                print(res)
            idx += 1
        idx = 9
        while idx > -1:
            if num_count[idx] == 1:
                res.insert(len(res) //2,idx)
                break
            idx -= 1
        while res[0] == 0:
            res.pop(0)
        while res[-1] == 0:
            res.pop()
        return ''.join(map(str,res))

s = Solution()
print(s.largestPalindromic("00001105"))
