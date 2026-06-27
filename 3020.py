"""
Question: 
    [Medium]
    You are given an array of positive integers 'nums'.
    You need to select a subset of 'nums' which satisfies the following condition:
        You can place the selected elements in a 0-indexed array such that it follows the pattern: 
            '[x, x2, x4, ..., xk/2, xk, xk/2, ..., x4, x2, x]' (Note that 'k' can be be any non-negative power of '2'). 
            For example, '[2, 4, 16, 4, 2]' and '[3, 9, 3]' follow the pattern while '[2, 4, 8, 4, 2]' does not.
    Return the maximum number of elements in a subset that satisfies these conditions.

Constraints:
    2 <= nums.length <= 10⁵
    1 <= nums[i] <= 10​​​​​​​⁹

Solution stats:
    Runtime: 115 ms
    Memory: 31.7 MB

    Time Complexity: O(n log log M) 
    Space Complexity: O(k)
"""

class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        counts = Counter(nums)
        oneCount = counts.get(1, 0)

        if oneCount % 2 == 1:
            result = oneCount
        else:
            result = oneCount - 1

        counts.pop(1, 0)

        for num in counts:
            length = 0
            x = num

            while x in counts and counts[x] > 1:
                length += 2
                x *= x
            
            if x in counts:
                length += 1
            else:
                length -= 1
            
            result = max(result, length)

        return result