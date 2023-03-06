package org.atanu.java.ds.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/design-an-ordered-stream/description/
//Leetcode 1656
public class DesignAnOrderedStream {
    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc"));
        System.out.println(os.insert(1, "aaaaa"));
        System.out.println(os.insert(2, "bbbbb"));
        System.out.println(os.insert(5, "eeeee"));
        System.out.println(os.insert(4, "ddddd"));
    }

    static class OrderedStream {
        //Problem Statement is too bad
        //Basically, the idea is that you need to return a longest list that start at index of ptr. if ptr is not pointing an element, you need to return a empty list.
        Map<Integer, String> map;
        int pointer;
        public OrderedStream(int n) {
            pointer = 1;//Initially the pointer is at 1
            map = new HashMap<>();
        }

        public List<String> insert(int idKey, String value) {
            List<String> result = new ArrayList<>();
            map.put(idKey, value);
            if(pointer == idKey){
                while(map.containsKey(pointer)){
                    result.add(map.get(pointer++));
                }
            }

            return result;
        }
    }
}
