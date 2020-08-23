
    /*  Explanation
    Time Complexity for operators : log(n) 
    Extra Space Complexity for operators : o(1) .. No extra space
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
    Initillay it will try to find the max value by just doubling the element and traversing till end.
    Then, the implemntation consists dividing array and find the element. if not found then compare if it is greater of lesser
    and  the traverse accordingly.
    */

public class searchinInfiniteSortedArray{

   
    public static int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
       
        while(reader.get(high)!=Integer.MAX_VALUE)
            high = high*2;
       
        return binarySearch(reader,low,high,target);
    }
   
    private static int binarySearch(ArrayReader reader, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
           
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid)>target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

}
