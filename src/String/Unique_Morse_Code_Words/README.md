### 804. Unique Morse Code Words

[Description](https://leetcode.com/problems/unique-morse-code-words/description/)[Hints](https://leetcode.com/problems/unique-morse-code-words/hints/)[Submissions](https://leetcode.com/problems/unique-morse-code-words/submissions/)[Discuss](https://leetcode.com/problems/unique-morse-code-words/discuss/)[Solution](https://leetcode.com/problems/unique-morse-code-words/solution/)

[Pick One](https://leetcode.com/problems/random-one-question/)

------

International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: `"a"`maps to `".-"`, `"b"` maps to `"-..."`, `"c"` maps to `"-.-."`, and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

```
[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
```

Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

```
Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
```