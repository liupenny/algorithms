### 341. Flatten Nested List Iterator

[Description](https://leetcode.com/problems/flatten-nested-list-iterator/description/)[Hints](https://leetcode.com/problems/flatten-nested-list-iterator/hints/)[Submissions](https://leetcode.com/problems/flatten-nested-list-iterator/submissions/)[Discuss](https://leetcode.com/problems/flatten-nested-list-iterator/discuss/)[Solution](https://leetcode.com/problems/flatten-nested-list-iterator/solution/)

[Pick One](https://leetcode.com/problems/random-one-question/)

------

Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

**Example 1:**
Given the list `[[1,1],2,[1,1]]`,

By calling *next* repeatedly until *hasNext* returns false, the order of elements returned by *next* should be: `[1,1,2,1,1]`.

**Example 2:**
Given the list `[1,[4,[6]]]`,

By calling *next* repeatedly until *hasNext* returns false, the order of elements returned by *next* should be: `[1,4,6]`.