/* 
Question: 
    [Hard]
    You are given an integer array 'nums' and an integer 'target'.
    Return the number of subarrays of 'nums' in which 'target' is the majority element.
    The majority element of a subarray is the element that appears strictly more than half of the times in that subarray.

Constraints:
    1 <= nums.length <= 10⁵
    1 <= nums[i] <= 10​​​​​​​⁹
    1 <= target <= 10⁹

Solution stats:
    Runtime: 2 ms
    Memory: 87.7 MB

    Time Complexity: O(n)
    Space Complexity: O(n)
*/

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] frequencies = new int[n * 2 + 1];
        frequencies[n] = 1;

        int offsetIndex = n;

        long result = 0;
        long smallerPrefixCount = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                smallerPrefixCount += frequencies[offsetIndex];
                offsetIndex++;
                frequencies[offsetIndex]++;
            } else {
                offsetIndex--;
                smallerPrefixCount -= frequencies[offsetIndex];
                frequencies[offsetIndex]++;
            }

            result += smallerPrefixCount;
        }
        return result;
    }
}