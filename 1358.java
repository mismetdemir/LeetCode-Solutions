/* 
Question: 
    [Medium]
    Given a string 's' consisting only of characters a, b and c.
    Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Constraints:
    3 <= s.length <= 5 x 10⁴
    's' only consists of a, b or c characters.

Solution stats:
    Runtime: 15 ms
    Memory: 46.2 MB

    Time Complexity: O(n)
    Space Complexity: O(1)
*/

class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int n = s.length();
        int[] chars = new int[3];
        int start = 0;

        for (int end = 0; end < n; end++) {
            char endChar = s.charAt(end);
            chars[endChar - 'a']++;

            while (chars[0] > 0 && chars[1] > 0 && chars[2] > 0) {
                count += n - end;
                char startChar = s.charAt(start);
                chars[startChar - 'a']--;
                start++;
            }
        }

        return count;
    }
}