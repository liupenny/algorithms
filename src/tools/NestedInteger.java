package tools;

import java.util.List;

/**
 * Created by PennyLiu on 2018/5/8.
 */
public interface NestedInteger
{
    boolean isInteger();
    /*
    @return true if this NestedInteger holds a single integer, rather than a nested list.
     */

    Integer getInteger();
    /*
    @return the single integer that this NestedInteger holds, if it holds a single integer
    Return null if this NestedInteger holds a nested list
     */


    List<NestedInteger> getList();
    /*
    @return the nested list that this NestedInteger holds, if it holds a nested list
    Return null if this NestedInteger holds a single integer
     */
}

