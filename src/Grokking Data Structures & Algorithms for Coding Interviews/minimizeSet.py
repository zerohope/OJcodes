class Solution:
    def minimizeSet(self, divisor1: int, divisor2: int, uniqueCnt1: int, uniqueCnt2: int) -> int:
        arr1 = set()
        arr2 = set()
        temp = 1
        while len(arr1) < uniqueCnt1:
            if temp % divisor1 != 0:
                arr1.add(temp)
            temp += 1
        res = temp - 1
        temp = 1
        while len(arr2) < uniqueCnt2:
            if temp % divisor2 != 0:
                if temp not in arr1:
                    arr2.add(temp)
            temp += 1
        res = max(temp - 1,res)
        print(arr1)
        print(arr2)
        return res

solve = Solution()
print(solve.minimizeSet(12,3,2,10))