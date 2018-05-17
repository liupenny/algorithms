### 309. Best Time to Buy and Sell Stock with Cooldown

[Description](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/)[Hints](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/hints/)[Submissions](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/)[Discuss](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/)[Solution](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/)

[Pick One](https://leetcode.com/problems/random-one-question/)

------

Say you have an array for which the *i*th element is the price of a given stock on day *i*.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

- You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
- After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

**Example:**

```
prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
```