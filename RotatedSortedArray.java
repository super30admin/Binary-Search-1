public class RotatedSortedArray {
    public int search(int [] arr, int target) {
        
        if (arr == null || arr.length == 0) return -1;
        
        int low = 0; int high = arr.length - 1;
        
        while (low <= high) {
            
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == target) return mid;
            else if (arr[mid] >= arr[low]) {
                
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                
            } else {
                
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
                
            } 
            
        }
        
        return -1;
        
    }
}
