// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes




 class Solution {
    public int search(ArrayReader reader, int target) {
        int startValue = reader.get(0);
        if(target <0){
            if(startValue > 0){
                return -1;
            }else{
                int predictedIndex = target - startValue;      
                return binarySearch(reader, target, 0, predictedIndex);
            }
        }else{
                int predictedIndex = target - startValue;   
                return binarySearch(reader, target, 0, predictedIndex);
        }
    }

    public int binarySearch(ArrayReader reader, int target, int start, int end){
        while(start <= end){
            int mid = start+(end-start)/2;
            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
}