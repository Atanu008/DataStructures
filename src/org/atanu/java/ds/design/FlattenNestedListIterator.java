package org.atanu.java.ds.design;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

//Leetcode 341
//https://leetcode.com/problems/flatten-nested-list-iterator/
class NestedInteger {
    public boolean isInteger() {
        return true;
    }

    public Integer getInteger() {
        return 0;
    }

    public List<NestedInteger> getList() {
        return null;
    }
}
public class FlattenNestedListIterator implements Iterator<Integer> {

    Stack<Integer> stack;
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        enStack(nestedList);

    }

    @Override
    public Integer next() {
        return stack.pop();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void enStack(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() -1 ; i>= 0; i--) {
            NestedInteger nestedInteger = nestedList.get(i);
            if(nestedInteger.isInteger()){
                stack.push(nestedInteger.getInteger());
            }
            enStack(nestedInteger.getList());
        }

    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
