package org.atanu.java.ds.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindAllKDistanceNode {


    public static void findAllKDistanceNode(TreeNode root, TreeNode node, int kDistance) {


        Map<TreeNode, TreeNode> nodeToParentMap = new HashMap();

        //nodeToParentMap.forEach((k,v) -> System.out.println(k+" "+v ));

        populateparent(root, nodeToParentMap, null);

        //nodeToParentMap.forEach((k,v) -> System.out.println(k+" "+v ));

        Set<TreeNode> seenSet = new HashSet<>();
        seenSet.add(node);

        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(node);

        int nodeDistance = 0;
        while (!queue.isEmpty()) {
            if (nodeDistance == kDistance) {
                printNodes(queue);
            }

            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                TreeNode popped = queue.poll();

                if (popped.left != null && !seenSet.contains(popped.left)) {

                    seenSet.add(popped.left);
                    queue.add(popped.left);
                }


                if (popped.right != null && !seenSet.contains(popped.right)) {

                    seenSet.add(popped.right);
                    queue.add(popped.right);
                }

                TreeNode parentOfCurrentNode = nodeToParentMap.get(popped);
                if (parentOfCurrentNode != null && !seenSet.contains(parentOfCurrentNode)) {
                    seenSet.add(parentOfCurrentNode);
                    queue.add(parentOfCurrentNode);
                }

            }

            nodeDistance++;

        }

    }

    private static void printNodes(Deque<TreeNode> queue) {

        queue.forEach(a -> System.out.println(a.val));

    }

    public static void populateparent(TreeNode node, Map<TreeNode, TreeNode> parentmap, TreeNode parent) {

        if (node == null) {

            return;
        }

        parentmap.put(node, parent);

        populateparent(node.left, parentmap, node);
        populateparent(node.right, parentmap, node);
    }

    public static void main(String[] args) {

		/* Construct below tree
        1
      /   \
     /     \
    2       3
   / \      / \
  /   \    /   \
 4     5  6     7
         / \
        /   \
       8     9
		 */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);

        findAllKDistanceNode(root, root.right, 2);

    }

}
