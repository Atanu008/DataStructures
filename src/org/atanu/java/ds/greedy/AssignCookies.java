package org.atanu.java.ds.greedy;

import java.util.Arrays;

//https://leetcode.com/problems/assign-cookies/description/
//Leetcode 455
public class AssignCookies {
    public int findContentChildren(int[] greed, int[] cookies) {
        //Sort both Greed and Cookies
        Arrays.sort(greed);
        Arrays.sort(cookies);

        int i = 0;
        int j = 0;
        int count = 0;
        while(i < greed.length){
            //run this while we can not make content children
            while(j < cookies.length && cookies[j] < greed[i]){
                j++;
            }
            //if this satishfy then the ith Child is content
            //Also the previous j, i,e cookeis will be able to satishfy the next child as the atr less and could not content the iTh one
            if(j < cookies.length && cookies[j] >= greed[i]){
                count++;
                j++;
            }

            i++; //Try for the next child/greed
        }

        return count;
    }

    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        int[] greed = {1,2,3}, cookies = {1,1};
        int contentChildren = assignCookies.findContentChildren(greed, cookies);
        //Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
        //And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
        //You need to output 1.
        System.out.println(contentChildren);

        greed = new int[]{1, 2};
        cookies = new int[]{1, 2, 3};
        contentChildren = assignCookies.findContentChildren(greed, cookies);
        //Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
        //You have 3 cookies and their sizes are big enough to gratify all of the children,
        //You need to output 2.
        System.out.println(contentChildren);

    }
}
