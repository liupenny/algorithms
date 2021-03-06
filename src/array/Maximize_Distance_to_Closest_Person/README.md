### 849. Maximize Distance to Closest Person

[Description](https://leetcode.com/problems/maximize-distance-to-closest-person/description/)[Hints](https://leetcode.com/problems/maximize-distance-to-closest-person/hints/)[Submissions](https://leetcode.com/problems/maximize-distance-to-closest-person/submissions/)[Discuss](https://leetcode.com/problems/maximize-distance-to-closest-person/discuss/)[Solution](https://leetcode.com/problems/maximize-distance-to-closest-person/solution/)

[Pick One](https://leetcode.com/problems/random-one-question/)

------

In a row of `seats`, `1` represents a person sitting in that seat, and `0` represents that the seat is empty. 

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to closest person.

**Example 1:**

```
Input: [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
```

**Example 2:**

```
Input: [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat, the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
```

**Note:**

1. `1 <= seats.length <= 20000`
2. `seats` contains only 0s or 1s, at least one `0`, and at least one `1`.

####  思路：

1：首尾如果都是0，此时最大距离是离首尾最近的1的位置 到  首尾的距离

2：中间两个相邻的1，此时最大距离是两个相邻的1的位置差/2