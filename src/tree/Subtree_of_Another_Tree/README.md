### 572. Subtree of Another Tree

[Description](https://leetcode.com/problems/subtree-of-another-tree/description/)[Hints](https://leetcode.com/problems/subtree-of-another-tree/hints/)[Submissions](https://leetcode.com/problems/subtree-of-another-tree/submissions/)[Discuss](https://leetcode.com/problems/subtree-of-another-tree/discuss/)[Solution](https://leetcode.com/problems/subtree-of-another-tree/solution/)

[Pick One](https://leetcode.com/problems/random-one-question/)

------

Given two non-empty binary trees **s** and **t**, check whether tree **t** has exactly the same structure and node values with a subtree of **s**. A subtree of **s** is a tree consists of a node in **s** and all of this node's descendants. The tree **s**could also be considered as a subtree of itself.

**Example 1:**
Given tree s:

```
     3
    / \
   4   5
  / \
 1   2
```

```
   4 
  / \
 1   2
```

 

true

**Example 2:**
Given tree s:

```
     3
    / \
   4   5
  / \
 1   2
    /
   0
```

```
   4
  / \
 1   2
```

 

false