## Linked Lists

### Reverse LinkedList Template

```
private ListNode reverse(ListNode head, int k) {
    ListNode curr = head, prev = null;
    while (k > 0) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        k--;
    }
    return prev;
}
```

### Slow Fast Pointers - Middle of LinkedList/Cycle in LinkedList

```
ListNode getMid(ListNode head) {
    ListNode midPrev = null;

    while (head != null && head.next != null) {
        midPrev = midPrev == null ? head : midPrev.next;
        head = head.next.next;
    }
    ListNode m = midPrev.next;
    midPrev.next = null;
    return m;
}
```

### Important Problems

- Reverse in K Groups
- Sorting
- Segregate Odd Even Nodes
- Remove Duplicates from Unsorted Linked List
- Remove Nodes in Groups of Even Lengths