//Problem - Search in sorted array of unknown size
//Time Complexity - O(log n) n - is the index of the target element in array
//Space Complexity - O(1) we are using constant amount of extra space 
//Code run successfully on Leetcode - Yes

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int low = 0;
        int high = 1;

        while(reader.get(high) < target){
            low = high;
            high *= 2;
        }

        while(low <= high){
            int mid = low +(high - low)/2;
            int ValueOfMid = reader.get(mid);

            if(ValueOfMid == target){
                return mid;
            }else if(ValueOfMid < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}