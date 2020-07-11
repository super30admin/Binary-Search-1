// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

/* Approach:
approach : 1. find out the element where the array has been rotated. 2. if the target lies between the pivot element and end element, we apply binary search in that part of array else we apply binary search on the other part.
*/



public class RotatedSortedArrayRecursive {
    public int binarySearch(int[] arr, int target, int low, int high){
        if(low > high) return -1;

        int mid = low + (high - low)/2;
        if(target == arr[mid]) return mid;
        if(arr[mid] <= arr[high]){
                if(target > arr[mid] && target <= arr[high]){
                    return binarySearch(arr, target, mid + 1, high);
                }
                else{
                    return binarySearch(arr, target, low, mid - 1);
                }
            }
        if(arr[low] <= arr[mid]){
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
        RotatedSortedArrayRecursive obj = new RotatedSortedArrayRecursive();
        int target = 10;
        int pos = obj.search(new int[]{7,8,9,10,0,1,2,3,4,5,6},target);
        System.out.println("target found in: "+pos);

    }
}