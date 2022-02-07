// Time complexity O(n)
// Space complexity O(1)
class Solution {
    
    public int search(int[] arr, int target) {
       int start = 0;
       int end = arr.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            
            if(arr[mid] == target) return mid;
            
            if(arr[mid] >= arr[start]) {
                if(target <= arr[mid] && arr[start] <= target)                  {
                    end = mid - 1;
                 } else {
                    start = mid + 1;
                }

            }
            
            if(arr[mid] <= arr[end]) {
                if(target >= arr[mid] && arr[end] >= target)                  {
                    start = mid + 1;
                 } else {
                    end = mid - 1;
                }

            }
        }
        return -1;
    }
}
