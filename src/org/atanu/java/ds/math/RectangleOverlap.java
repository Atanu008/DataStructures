package org.atanu.java.ds.math;

public class RectangleOverlap {

    //To Overlap
    // X Co Ordinate (Top Left Corner of One Rectangle) < X Co Ordinate (Bottom Right Corner of One Rectangle)
    // Y Co Ordinate (Top Left Corner of One Rectangle) > Y Co Ordinate (Bottom Right Corner of One Rectangle)
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int a1 = rec2[0];
        int b1 = rec2[1];
        int a2 = rec2[2];
        int b2 = rec2[3];

        //If one rectangle is on left side of other 
        if (x1 >= a2 || a1 >= x2) {
            System.out.println("Hello");
            return false;
        }
        //If one rectangle is above other
        if (y1 <= b2 || b1 <= y2) {
            System.out.println("World");
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {

        int[] rec1 = {0, 0, 2, 2};
        int[] rec2 = {1, 1, 3, 3};

        if (isRectangleOverlap(rec1, rec2)) {
            System.out.println("Rectangles Overlap");
        } else {
            System.out.println("Rectangles Don't Overlap");
        }

    }
}