package org.atanu.java.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	static class OrangeCordinate{
			int x;
			int y;

			public OrangeCordinate(int x, int y){

				this.x = x;
				this.y = y;
			}
		}


		public int orangesRotting(int[][] grid) {

			if(grid == null || grid.length == 0) return 0;

			int row = grid.length;
			int column = grid[0].length;

			Queue<OrangeCordinate> queue = new LinkedList<>();

			int total = 0;
			for(int i = 0; i < row; i++){
				for(int j = 0; j < column; j++){

					if (grid[i][j] == 1 || grid[i][j] == 2){
						++total;
					}
					if(grid[i][j] == 2){

						queue.offer(new OrangeCordinate(i,j));
					}
				}
			}

			// No Oranges
			if(total == 0){
				return 0;
			}
			int count = -1;
			while(!queue.isEmpty()){

				int size = queue.size();
				++count;

				for(int i = 0; i < size; i++){

					OrangeCordinate currentRotten = queue.poll();

					int x = currentRotten.x;
					int y = currentRotten.y;

					if(isValid(grid, x+1 ,y) && grid[x+1][y] == 1){

						grid[x+1][y] = 2;
						queue.offer(new OrangeCordinate(x+1,y));
					}
					if(isValid(grid, x-1 ,y) && grid[x-1][y] == 1){

						grid[x-1][y] = 2;
						queue.offer(new OrangeCordinate(x-1,y));
					}
					if(isValid(grid, x ,y+1) && grid[x][y+1] == 1){

						grid[x][y+1] = 2;
						queue.offer(new OrangeCordinate(x,y+1));
					}
					if(isValid(grid, x,y-1) && grid[x][y-1] == 1){
						grid[x][y-1] = 2;
						queue.offer(new OrangeCordinate(x,y-1));
					}
				}
			}

			for(int i = 0; i < row; i++){
				for(int j = 0; j < column; j++){

					if(grid[i][j] == 1){

						return -1;
					}
				}
			}

			return count;
		}

		public boolean isValid(int[][] grid, int i , int j){

			if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
				return false;
			}
			return true;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
