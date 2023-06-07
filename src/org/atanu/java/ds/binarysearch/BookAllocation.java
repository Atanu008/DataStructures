package org.atanu.java.ds.binarysearch;

//Video : https://www.youtube.com/watch?v=okP-e2VpI_g&t=3317s (just check few minutes after 52 minute)
//https://www.geeksforgeeks.org/allocate-minimum-number-pages/

// Given a number of pages in N different books and M students.
// The books are arranged in ascending order of the number of pages.
// Every student is assigned to read some consecutive books.
// The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.

//Input : pages[] = {12, 34, 67, 90} , m = 2
//Output : 113
//Explanation: There are 2 number of students. Books can be distributed in following fashion :
//1) [12] and [34, 67, 90]
//Max number of pages is allocated to student ‘2’ with 34 + 67 + 90 = 191 pages
//2) [12, 34] and [67, 90] Max number of pages is allocated to student ‘2’ with 67 + 90 = 157 pages
//3) [12, 34, 67] and [90] Max number of pages is allocated to student ‘1’ with 12 + 34 + 67 = 113 pages
//
//Of the 3 cases, Option 3 has the minimum pages = 113.

public class BookAllocation {

    public int allocatePages(int[] books, int students) {

        int sum = 0;
        int max = 0;

        for (int a : books) {
            sum += a;
            max = Math.max(max, a);
        }

        // Low can not be less than the maximum element of the Array
        // Can be set to zero
        int low = max;
        // If one day then the max range would be summation of all the elements
        int high = sum;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(books, mid, students)) {
                // update result to current distribution
                // as it's the best we have found till now.
                ans = mid;
                high = mid - 1; // as we need to minimize , we will go left , high need to play the role
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
                // Now sum is greater than mid , that means student wont be assigned this page
                // We need a new student,
                // Add this weight to sum
                requiredStudent++;
                sum = books[i]; // update curr_sum . books[i] belongs to new student now
            }
        }
        return requiredStudent == students;
    }

    // using (high < low Template)
    public int allocatePages_v2(int[] books, int students) {

        int sum = 0;
        int max = books[0];

        for(int book : books){
            sum += book;
            max = Math.max(max, book);
        }

        int low = max;
        int high = sum;

        while(low < high) {
            int mid = low + (high - low) / 2;
            System.out.println("Mid "+ mid);
            if(isPossible(books, mid, students)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        BookAllocation bookAllocation = new BookAllocation();
        //Number of pages in books
        int[] books = {12, 34, 67, 90};

        int students = 2; //No. of students
        //System.out.println("Minimum number of pages = " +
           //     bookAllocation.allocatePages(books, students));

        //System.out.println("Minimum number of pages = " +
          //      bookAllocation.allocatePages_v2(books, students));

        books = new int[]{40, 30, 30};
        students = 3;
        System.out.println("Minimum number of pages = " +
                bookAllocation.allocatePages_v2(books, students));
    }
}
