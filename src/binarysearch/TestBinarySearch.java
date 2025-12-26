package binarysearch;

public class TestBinarySearch {
    public static void main(String[] args) {
        //Test for search in RotatedSortedArray
        RotatedSortedArray sortedArray = new RotatedSortedArray();
        int [] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(sortedArray.search(nums, 0)); //expected 4
        System.out.println(sortedArray.search(nums, 9)); //expected -1

        //Test for search an element in unknownSortedArray
        UnknownSizeSortedArray sol = new UnknownSizeSortedArray();

        ArrayReader reader = new MockArrayReader(new int[]{-1, 0, 3, 5, 9, 12});

        System.out.println(sol.search(reader, 9)); // expected 4
        System.out.println(sol.search(reader, 2)); // expected -1
        System.out.println(sol.search(reader, -1)); // expected 0
        System.out.println(sol.search(reader, 12)); // expected 5
        // Test for search in 2D matrix
        Search2DMatrix matrix = new Search2DMatrix();
        int[][] values = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(matrix.searchMatrix(values, 3));// true
        System.out.println(matrix.searchMatrix(values, 61)); //false
    }
}

