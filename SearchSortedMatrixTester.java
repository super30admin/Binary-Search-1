public class SearchSortedMatrixTester {
    public static void main(String[] args) {
        SearchSortedMatrix obj = new SearchSortedMatrix();

        int[][] nums = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };

        System.out.println(obj.searchMatrix(nums, 31));
    }
}