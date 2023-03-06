package org.atanu.java.ds.string;

//https://leetcode.com/problems/delete-columns-to-make-sorted/description/
//Leetcode 944
public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {

        int row = strs.length;
        int column = strs[0].length();
        int deleteCount = 0;

        for(int i = 0; i < column; i++){
            for(int j = 0; j < row - 1; j++){
                if(strs[j].charAt(i) > strs[j+1].charAt(i)){
                    deleteCount++;
                    break;
                }
            }
        }

        return deleteCount;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSorted deleteColumnsToMakeSorted = new DeleteColumnsToMakeSorted();
        String[] strs = {"cba","daf","ghi"};
        //Output: 1
        //Explanation: The grid looks as follows:
        //  cba
        //  daf
        //  ghi
        //Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.
        System.out.println(deleteColumnsToMakeSorted.minDeletionSize(strs));

        strs = new String[]{"zyx","wvu","tsr"};
        //Output: 3
        //Explanation: The grid looks as follows:
        //  zyx
        //  wvu
        //  tsr
        //All 3 columns are not sorted, so you will delete all 3.
        System.out.println(deleteColumnsToMakeSorted.minDeletionSize(strs));
    }
}
