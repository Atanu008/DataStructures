# KMP Algorithm for String Pattern Matching

---------

#### Sliding Window pattern solves this case efficiently

```
haystack = "badgoodbabbad"
needle = "good"

output = 4
```

- Runtime : `O(m*n)`

#### KMP Algorithm is optimal here

```
haystack = "aaaxaaax"
needle = "aaaa"
```

- Checks all `a`'s to find that final letter does not match.
- Runtime  : `O(n+m)`

### Longest Prefix Suffix

- Find the longest prefix that is also a suffix in the string
- Creates a **LPS** array
- Keep on checking characters from needle and haystack
- When there is a mismatch, check if there is a suffix which is also a prefix in the `needle`
- If there is a match, ignore prefix and start the comparison from the character following the prefix
- Else when there is no match, start from 0th index of needle

#### Algorithm

- Preprocess the `needle`  and build the LPS array
- Initialise pointers on `needle` and `haystack`
- Examine the haystack characters :
    - On match, increment both pointers
    - if the very first character of `needle` does not match, increment `haystack` pointer by 1
    - for partial matching
        - no change in `haystack` pointer
        - set `needle` pointer to `lps[needle_pointer-1]`
        - continue check for match

### Code

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();

        if (n < m)
            return -1;

        // PREPROCESSING
        // longest prefix suffix array
        int[] longest_border = new int[m];
        // Length of Longest Border for prefix before it.
        int prev = 0;
        // Iterating from index-1. longest_border[0] will always be 0
        int i = 1;

        while (i < m) {
            if (needle.charAt(i) == needle.charAt(prev)) {
                // Length of Longest Border Increased
                prev += 1;
                longest_border[i] = prev;
                i += 1;
            } else {
                // Only empty border exist
                if (prev == 0) {
                    longest_border[i] = 0;
                    i += 1;
                }
                // Try finding longest border for this i with reduced prev
                else {
                    prev = longest_border[prev - 1];
                }
            }
        }

        // SEARCHING
        // Pointer for haystack
        int haystackPointer = 0;
        // Pointer for needle.
        // Also indicates number of characters matched in current window.
        int needlePointer = 0;

        while (haystackPointer < n) {
            if (haystack.charAt(haystackPointer) == needle.charAt(needlePointer)) {
                // Matched Increment Both
                needlePointer += 1;
                haystackPointer += 1;
                // All characters matched
                if (needlePointer == m) {
                    // m characters behind last matching will be start of window
                    return haystackPointer - m;
                }
            } else {
                if (needlePointer == 0) {
                    // Zero Matched
                    haystackPointer += 1;
                } else {
                    // Optimally shift left needlePointer. Don't change haystackPointer
                    needlePointer = longest_border[needlePointer - 1];
                }
            }
        }

        return -1;
    }
}
```
