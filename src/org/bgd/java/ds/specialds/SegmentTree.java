package org.bgd.java.ds.specialds;

public class SegmentTree {
    int[] tree;
    int[] array;

    SegmentTree(int[] array) {
        this.array = array;
        int n = array.length;
        this.tree = new int[this.array.length * 4];
        build(1, 0, n - 1);
    }

    int build(int node, int s, int e) {
        if (s == e) {
            tree[node] = array[s];
            return array[s];
        }
        int m = (s + e) / 2;
        tree[node] = build(node * 2, s, m) + build(node * 2 + 1, m + 1, e);
        return tree[node];
    }

    int query(int qs, int qe, int s, int e, int node) {
        if (node >= qs && node <= qe) {
            return tree[node];
        }
        if (s > qs || e < qe) {
            return 0;
        }

        int mid = (s + e) / 2;
        return query(qs, qe, s, mid, node * 2) + query(qs, qe, mid + 1, e, node * 2 + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        SegmentTree segmentTree = new SegmentTree(arr);
        int r = segmentTree.query(0, 3, 0, arr.length - 1, 0);
        System.out.println(r);
    }

}
