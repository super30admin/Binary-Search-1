//Problem - Search Infinite Sorted Array 
//Leetcode Problem link - https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

//Time complexity - O(log(n)) 
//Space complexity - O(1) - No additional data structure used
//Solution:

class SearchinInfinitesortedarray{
    public int search(ArrayReader reader, int target){
    
        //Time complexity - O(logN)
        
        int low = 0, high = 1;
        
        while(reader.get(high) < target){
            //This will add Time complexity - O(logN)
            low = high;
            high = high *2;    
        }

        while(low <= high){
            //Binary search will have Time complexity - O(logN)
            int mid = low + (high - low)/2;
            if(target == reader.get(mid)) return mid;
            else if(reader.get(mid) > target){
                high = mid -1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }
}