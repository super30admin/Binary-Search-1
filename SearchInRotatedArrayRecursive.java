// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
* taking length of the array and retrieving first and last position
* find the mid position and then see which side is sorted(either one will be sorted)
 go to that side and check whether our target lies in that range if yes modify low or high according to that
 or else the other way
* ex. if low---mid is sorted go to that side and search target if not in that range go to other part
*/

public class SearchInRotatedArrayRecursive {
    public int binarySearch(int[] arr, int target, int low, int high){
        if(low > high) return -1;

        int mid = low + (high - low)/2;
        if(target == arr[mid]) return mid;
        if(arr[mid] <= arr[high]){//righ sorted
                if(target > arr[mid] && target <= arr[high]){
                    return binarySearch(arr, target, mid + 1, high);
                }
                else{
                    return binarySearch(arr, target, low, mid - 1);
                }
            }
        if(arr[low] <= arr[mid]){//left sorted
                if(target < arr[mid] && target >= arr[low]){
                    return binarySearch(arr, target, low, mid - 1);
                }
                else{
                    return binarySearch(arr, target, mid + 1, high);
                }
            }
            return -1;
    }
    public int search(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        return binarySearch(arr, target, low, high);
    }
    
    
    public static void main(String args[]){
        SearchInRotatedArrayRecursive obj = new SearchInRotatedArrayRecursive();
        int target = 5;
        int position = obj.search(new int[]{5,6,0,1,2,3,4},target);
        System.out.println(target + " was found in position "+position);

    }
}