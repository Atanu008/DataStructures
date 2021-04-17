package org.atanu.java.ds.design;

import java.util.List;
import java.util.Stack;

public class FlattenNestedListIteratorII {
    Stack<NestedInteger> stack;
    public FlattenNestedListIteratorII(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        enstack(nestedList);
    }

    private void enstack(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }

        if(!stack.isEmpty() && !stack.peek().isInteger()) {
            enstack(stack.pop().getList());
        }
    }

    public Integer next() {
        Integer res = stack.pop().getInteger();
        if (!stack.isEmpty() && !stack.peek().isInteger()) {
            enstack(stack.pop().getList());
        }
        return res;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    static class NestedInteger {
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
}
