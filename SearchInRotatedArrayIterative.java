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

public class SearchInRotatedArrayIterative {
    public int search(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(target == arr[mid]) return mid;
            else if(arr[mid] <= arr[high]){//righ sorted
                if(target > arr[mid] && target <= arr[high]){
                    low = mid + 1;
                }
                else{
                    high = mid -1;
                }
            }
            else if(arr[low] <= arr[mid]){//left sorted
                if(target < arr[mid] && target >= arr[low]){
                    high = mid - 1;
                }
                else{
                    low = mid +1;
                }
            }
        }
        return -1;

    }

    public static void main(String args[]){
        SearchInRotatedArrayIterative obj = new SearchInRotatedArrayIterative();
        int target = 4;
        int position = obj.search(new int[]{5,6,0,1,2,3,4},target);
        System.out.println(target + " was found in position "+position);

    }

}