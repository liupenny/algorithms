### 761. Special Binary String

[Description](https://leetcode.com/problems/special-binary-string/description/)[Hints](https://leetcode.com/problems/special-binary-string/hints/)[Submissions](https://leetcode.com/problems/special-binary-string/submissions/)[Discuss](https://leetcode.com/problems/special-binary-string/discuss/)[Solution](https://leetcode.com/problems/special-binary-string/solution/)

[Pick One](https://leetcode.com/problems/random-one-question/)

------

*Special* binary strings are binary strings with the following two properties:

The number of 0's is equal to the number of 1's.

Every prefix of the binary string has at least as many 1's as 0's.

Given a special string `S`, a *move* consists of choosing two consecutive, non-empty, special substrings of `S`, and swapping them. *(Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.)*

At the end of any number of moves, what is the lexicographically largest resulting string possible?

**Example 1:**

```
Input: S = "11011000"
Output: "11100100"
Explanation:
The strings "10" [occuring at S[1]] and "1100" [at S[3]] are swapped.
This is the lexicographically largest string possible after some number of swaps.
```

**Note:**

1. `S` has length at most `50`.
2. `S` is guaranteed to be a *special* binary string as defined above.