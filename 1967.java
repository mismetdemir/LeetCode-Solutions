/* 
Question: 
    [Easy]
    Given an array of strings 'patterns' and a string 'word', return the number of strings in 'patterns' that exist as a substring in 'word'.

    A substring is a contiguous sequence of characters within a string.

Constraints:
    1 <= patterns.length <= 100
    1 <= patterns[i].length <= 100
    1 <= word.length <= 100
    patterns[i] and 'word' consist of lowercase English letters.

Solution stats:
    Runtime: 1 ms
    Memory: 43.2 MB

    Time Complexity: O(n * m)
    Space Complexity: O(1)
*/

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int result = 0;

        for(String pattern : patterns){
            if(word.contains(pattern)){
                result++;
            }
        }

        return result;
    }
}