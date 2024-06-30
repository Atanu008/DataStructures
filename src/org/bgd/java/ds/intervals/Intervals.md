## Intervals

---

### Pattern

- Compare new intervals against the latest added in the list of intervals

```
if (result.getLast()[1] < intervals[i][0]) {
  result.add(intervals[i]);
} else {
  result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
  } 
```

- Comparing intervals by start or end time

```
Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
```

### Problems

- [Insert Interval] https://leetcode.com/problems/insert-interval/description/
- [Non Overlapping Intervals] https://leetcode.com/problems/non-overlapping-intervals/editorial/
- [Meeting Rooms II] https://leetcode.com/problems/meeting-rooms-ii
- [Minimum Platforms Needed] https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
