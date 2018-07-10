### 856. Score of Parentheses

[Description](https://leetcode.com/problems/score-of-parentheses/description/)[Hints](https://leetcode.com/problems/score-of-parentheses/hints/)[Submissions](https://leetcode.com/problems/score-of-parentheses/submissions/)[Discuss](https://leetcode.com/problems/score-of-parentheses/discuss/)[Solution](https://leetcode.com/problems/score-of-parentheses/solution/)

[Pick One](https://leetcode.com/problems/random-one-question/)

------

Given a balanced parentheses string `S`, compute the score of the string based on the following rule:

- `()` has score 1
- `AB` has score `A + B`, where A and B are balanced parentheses strings.
- `(A)` has score `2 * A`, where A is a balanced parentheses string.

 

**Example 1:**

```
Input: "()"
Output: 1
```

**Example 2:**

```
Input: "(())"
Output: 2
```

**Example 3:**

```
Input: "()()"
Output: 2
```

**Example 4:**

```
Input: "(()(()))"
Output: 6
```

 