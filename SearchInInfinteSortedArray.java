/*
Time complexity : O(log n) using binary search
Space complexity : O(1)
 */
public class SearchInInfinteSortedArray {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170 , 190, 320, 325, 568, 679, 700};

        int target = 145;
        int ans = findPos(arr, target);
        System.out.println(ans);
    }

    /*
    * This method finds an element in array of infinite size.
    * we start with 2 element array and search for target
    * if target is more than end element - we just double the search window eliminating the already searched array
    */
    private static int findPos(int[] arr, int target) {
        //Initialize start and end for the search range
        int start  = 0, end = 1;

        while(target > arr[end]){
            // store current end as new start
            int temp = end + 1;

            //double the size of an array and update the end index
            end = end + (end - start + 1) * 2;

            // update start to old end + 1 -- stored in temp above
            start = temp;
        }

        //perform usual binary search
        return binarySearch(arr, target, start, end);
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while(end >= start){

            // calculate mid
            int mid = start + (end - start ) / 2;

            // check if target equals to this element
            if(arr[mid] == target){
                return mid;
            } else if (target > arr[mid]){ //if target is greater than mid
                start = mid + 1;
            } else { //if target is smaller than mid
                end = mid - 1;
            }
        }

        //if emement is missing just return -1
        return -1;
    }
}
