package org.atanu.java.ds.array.set1;

public class Print2DArrayDiagonaly {

	public static void printDiagonaly(int[][] arr) {
		
		int row = arr.length -1;
		int column = arr[0].length;
		
		for (int i = 0; i <= row ; i++) {
			
			int rowIndex = i;
			int columnIndex = 0;
			
			while(rowIndex >= 0 && columnIndex < column) {
				
				//System.out.println();
				System.out.print(arr[rowIndex][columnIndex]+" ");
				
				rowIndex--;
				columnIndex++;
				
			}	
			
			System.out.println();
		}
		
		for (int i = 1; i < column; i++) {
			
			int rowIndex = arr.length -1;
			int columnIndex = i;
			
			while(columnIndex < column) {
				
				System.out.print(arr[rowIndex][columnIndex]+" ");
				columnIndex++;
				rowIndex--;
			}
			
			System.out.println();
		}
	}
	public static void main(String[] args) {

            int arr[][] = { {1, 2, 3, 4}, 
                            {5, 6, 7, 8}, 
                            {9, 10, 11, 12}, 
                            {13, 14, 15, 16}, 
                            {17, 18, 19, 20}, }; 
            
            printDiagonaly(arr);

	}

}
