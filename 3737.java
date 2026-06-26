/* 
Question: 
    [Medium]
    You are given an integer array 'nums' and an integer 'target'.
    Return the number of subarrays of 'nums' in which 'target' is the majority element.
    The majority element of a subarray is the element that appears strictly more than half of the times in that subarray.

Constraints:
    1 <= nums.length <= 1000
    1 <= nums[i] <= 10​​​​​​​⁹
    1 <= target <= 10⁹

Solution stats:
    Runtime: 34 ms
    Memory: 46.9 MB

    Time Complexity: O(n²)
    Space Complexity: O(1)
*/

class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int subarrayCount = 0;
        int n = nums.length;

        for (int start = 0; start < n; start++) {
            int targetCount = 0;

            for (int end = start; end < n; end++) {
                if (nums[end] == target) {
                    targetCount++;
                }

                int length = end - start + 1;

                if (targetCount * 2 > length) {
                    subarrayCount++;
                }
            }
        }

        return subarrayCount;
    }
}