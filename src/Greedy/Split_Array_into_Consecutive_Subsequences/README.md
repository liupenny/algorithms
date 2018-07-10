### 659. Split Array into Consecutive Subsequences

[Description](https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/)[Hints](https://leetcode.com/problems/split-array-into-consecutive-subsequences/hints/)[Submissions](https://leetcode.com/problems/split-array-into-consecutive-subsequences/submissions/)[Discuss](https://leetcode.com/problems/split-array-into-consecutive-subsequences/discuss/)[Solution](https://leetcode.com/problems/split-array-into-consecutive-subsequences/solution/)

[Pick One](https://leetcode.com/problems/random-one-question/)

------

You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into several subsequences, where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.

**Example 1:**

```
Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5
```

**Example 2:**

```
Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5
```

**Example 3:**

```
Input: [1,2,3,4,4,5]
Output: False
```

**Note:**

1. The length of the input is in range of [1, 10000]