// Time Complexity: log(n). 
// Space: Complexity: O(1)
// Search in a Rotated Sorted Array
class Solution {
    public int search(int[] arr, int target) {
        if(arr == null || arr.length == 0) return - 1;
        int low = 0; int high = arr.length - 1;
        while(low < high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target) return mid;
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target&&target<arr[mid]){
                    high=mid;
                }else{
                    low=mid+1;
                }
            }else{
                if(arr[mid]<target&&target<=arr[high]){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
        }
        if(arr[low]==target)return low;
        return -1;
    }
}