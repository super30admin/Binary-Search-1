// ## Problem3
// Search in Infinite sorted array: 

// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
//time complexity:O(log n)
//leetcode solution accepted
//we need to define the search space first,//once that is done just perfomr normal binary search
class Solution {
    public int search(ArrayReader reader, int target) {
        //defining start and end for the search
        int left= 0;
        int right = 1;
        while(reader.get(right)<target){
            right = right*2;
        }
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(reader.get(mid)==target){
                return mid;
            }else if (target>reader.get(mid)){
                left = mid+1;
            }else if (target<reader.get(mid)){
                right = mid-1;
            }
        }
        return -1;

        
    }
}