package org.atanu.java.ds.graph;

// https://leetcode.com/problems/find-all-groups-of-farmland/description/
// Leetcode 1992

import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsOfFarmland_v2 {

    public int[][] findFarmland(int[][] land) {

        int m = land.length;
        int n = land[0].length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 1){

                    int colIndex = j;
                    //Find right most column of rectangle
                    while(colIndex < n && land[i][colIndex] == 1){
                        colIndex++;
                    }
                    //Find bottom most row of rectangle
                    int rowIndex = i;
                    while(rowIndex < m && land[rowIndex][j] == 1){
                        rowIndex++;
                    }
                    // just a edge case check
                    int bottomRowIndex = rowIndex == 0 ? rowIndex : rowIndex - 1;
                    int bottomRightColmnIndex = colIndex == 0 ? colIndex : colIndex - 1;

                    list.add(new int[]{i, j,bottomRowIndex, bottomRightColmnIndex});
                    //Now, mark the covered land with 0 so that we don't consider them later
                    for(int x = i; x <=  bottomRowIndex; x++){
                        for(int y = j; y <= bottomRightColmnIndex; y++){
                            land[x][y] = 0;
                        }
                    }
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
