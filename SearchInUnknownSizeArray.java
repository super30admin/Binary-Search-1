// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/*
*Taken two pointer slow and fast fast moving x2 times till it becomes more than target
*then both will stop and in the range(slow to fast) we will apply binary search till we find the element
if we don't it will return -1
*/

public class SearchInUnknownSizeArray{
    int[] arr = new int[]{2,4,5,6,7,8,8,9,12,17,19,20,21,23,24,25,26};// sorted array

    class ArrayReader{
        public int get(int index){
            return arr[index];
        }
    }
    public int search(ArrayReader reader, int target) throws Exception{
        int slow = 0;
        int fast = 1;
    
        while(reader.get(fast) < target){
            slow = fast;
            fast = fast * 2;
        }
        return binarySearch(reader, target, slow, fast);
    }
    private int binarySearch(ArrayReader reader, int target, int low, int high)
    {
        while(low <= high){
            int mid = low + (high-low)/2;
            if(target == reader.get(mid)) return mid;
            if(target < reader.get(mid))  high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        SearchInUnknownSizeArray obj = new SearchInUnknownSizeArray();
        ArrayReader reader = obj.new ArrayReader();
        int target = 8;
        try{
        int position = obj.search(reader, target);
        System.out.println(target+" was found in position "+ position);
        }
        catch(Exception e){
            System.out.println("Exception: "+e);
        }
    }

}