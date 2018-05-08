package Stack.NestedIterator;

import tools.NestedInteger;
import java.util.Iterator;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/7.
 */
public class NestedIterator implements Iterator<Integer> {
    private List<NestedInteger> list;
    private NestedIterator iter;
    private int next;
    private int i;

    public NestedIterator(List<NestedInteger> nestedList)
    {
        list = nestedList;
        iter = null;
        i = 0;
    }

    @Override
    public Integer next() {
        return next;
    }

    @Override
    public boolean hasNext() {
        if(iter != null && iter.hasNext())
        {
            next = iter.next();
            return true;
        }

        if(i >= list.size())
        {
            return false;
        }

        NestedInteger n = list.get(i++);
        if(!n.isInteger())
        {
            iter = new NestedIterator(n.getList());
            if(iter.hasNext())
            {
                next = iter.next();
            }
            else
            {
                return hasNext();
            }
        }
        else
        {
            next = n.getInteger();
        }
        return true;
    }


 }
