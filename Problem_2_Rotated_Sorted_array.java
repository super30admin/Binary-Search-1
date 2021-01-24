class Solution {
  /*
  1) initializa low and high
  2) start binary search
        2.a) check if left is sorted
        2.b) check if right is sorted
        
        
      */
    public int search(int[] a, int target) {
      // 1
        int low = 0;
      int high = a.length -1;
      
      //2
      while(low <= high){
        
        int mid = low + (high - low)/2;
        
        //2.a
        if(a[low] == target) 
          return low;
        if(a[high] == target) 
          return high;
        if(a[mid] == target) 
          return mid;
        
        if(a[low] <= a[mid]){
          // left is sorted,
          if(a[low] < target && a[mid] > target){ // a[low] < target < a[mid] (does taeget fall in the sorted range?) if yes, do BS in left(sorted) range, if not, in right range
            high = mid -1;
          }else{
            low = mid + 1;
          }
        }else{
          //right is sorted
          if(a[high] > target && a[mid] < target ){ // a[mid] > target > a[high] (does taeget fall in the sorted range?) if yes, do BS in right(sorted) range, if not, in left range
            low = mid +1;
          }else{
            high = mid -1;
          }
        }
        
      }

        return -1;
      
        
    }
}
