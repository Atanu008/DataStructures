package org.atanu.java.ds.stack;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/simplify-path/description/
// Leetcode 71
public class SimplifyPath {

    public String simplifyPath(String path) {

        String[] paths = path.split("\\/");
        Deque<String> queue = new LinkedList<>();

        for(String node : paths){
            if(node.isEmpty() || node.equals(".")){
                continue;
            }
            else if(node.equals("..")){
                if(!queue.isEmpty()){
                    queue.pollLast();
                }
            }
            else{
                queue.add(node);
            }
        }

        if(queue.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.insert(0,"/"+queue.pollLast());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        String path = "/home/";
        //Output: "/home"
        //Explanation: Note that there is no trailing slash after the last directory name.
        System.out.println(simplifyPath.simplifyPath(path));

        path = "/../";
        //Output: "/"
        //Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
        System.out.println(simplifyPath.simplifyPath(path));

        path = "/home//foo/";
        //Output: "/home/foo"
        //Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
        System.out.println(simplifyPath.simplifyPath(path));

    }
}
