
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SearchInASortedArrayOfUnknownSize{
    public int search(ArrayReader reader, int target) {
        

        // So, we expand the search range until the right boundary is greater than or equal to the target.
        // Then apply binary search inside that range because the array is sorted in increasing order.
        // If the target is found, return its index; otherwise, return -1.

        if(reader.get(0) == target) return 0;

        int left =0, right = 1;

        while(reader.get(right) < target){
               left = right;
               right = right*2;
        }

        while(left <= right){

            int mid = left + (right-left)/2;

            if(reader.get(mid) == target )  return mid;

            if(reader.get(left) <= reader.get(mid)){
                if(reader.get(mid) > target &&  reader.get(left) <= target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(reader.get(mid) < target && reader.get(right) >=target){
                    left = mid+1;
                }else{
                    right = mid -1;
                }
            }
        }

        return -1;
    }
}
