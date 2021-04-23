// Time Complexity : O(log(m)+log(range))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach



/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

interface ArrayReader {
        public default int get(int index) {
            return index;}
    }

class InfiniteArray {
    public int search(ArrayReader reader, int target) {
        int low=0; int high=1;
        while(reader.get(high) !=Integer.MAX_VALUE && 
             target > reader.get(high)){
            low=high;
            high=high*2;
        }
        return traditionalBinary(reader, low, high,target);
        
    }
    
    
    private int traditionalBinary(ArrayReader reader, int low, int high, int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target)
                return mid;
            else{
                if(reader.get(mid)< target)
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
    }


    public static void main(String args[]) 
    {
        InfiniteArray obj = new InfiniteArray();
        int array_input[]={ 1,2,3,4,5  };
        if(obj.search(array_input, 10))
            System.out.println("Element is present ");
        else
            System.out.println("Element is not present");

        
    
    }
}