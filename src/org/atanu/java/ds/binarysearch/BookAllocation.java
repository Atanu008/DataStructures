package org.atanu.java.ds.binarysearch;

//Video : https://www.youtube.com/watch?v=okP-e2VpI_g&t=3317s
//https://www.geeksforgeeks.org/allocate-minimum-number-pages/
public class BookAllocation {

    public int allocatePages(int[] books, int students) {

        int sum = 0;
        int max = 0;

        for (int a : books) {
            sum += a;
            max = Math.max(max, a);
        }

        // Low can not be less than the maximum elemnt of the Array
        // Can be set to zero
        int low = max;
        // If one day then the max range would be summation of all the elements
        int high = sum;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(books, mid, students)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] books, int mid, int students) {

        int requiredStudent = 1;
        int sum = 0;
        for (int i = 0; i < books.length; i++) {
            sum += books[i];
            if (sum > mid) {
                //we need more days to accomodate the mid
                //Add this weight to sum
                requiredStudent++;
                sum = books[i];
            }
        }
        return requiredStudent <= students;
    }

    public static void main(String[] args) {
        BookAllocation bookAllocation = new BookAllocation();
        //Number of pages in books
        int[] books = {12, 34, 67, 90};

        int students = 2; //No. of students
        System.out.println("Minimum number of pages = " +
                bookAllocation.allocatePages(books, students));
    }
}
