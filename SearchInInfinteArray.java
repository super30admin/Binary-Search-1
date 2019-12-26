// Time Complexity : O(log n) for moving the high pointers  + O(logn) for binary search --> Asymptotically, makes it O(log n)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : -

// Any problem you faced while coding this :
// Note that its not mid but nums[mid] .. ALso check for high going out of bounds

// Your code here along with comments explaining your approach
class SearchInfiniteArray{
    public static int searchInArray(int[] nums,int target){
        int low = 0;
        int high = 1;
        while(high <nums.length  && target > nums[high]  ){
            low = high;
            high = high * 2;
        }
        System.out.println("low is"+low);
        System.out.println("high is"+high);
        int index = binarySearch(nums,low,high,target);
        return index;
    }
    private static int binarySearch(int[] nums,int low,int high,int target){
        int mid;
        while(low <= high){

            mid = low + (high- low)/2;
           // System.out.println("Mid "+mid);
            if(target == nums[mid]){
                return mid;
            }
            if(target < nums[mid]){
                high = mid -1;
            }
            else{
                low = mid+1;
            }

        }
        return -1;

    }
}
class Main{
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,8,9,10};
       System.out.println(SearchInfiniteArray.searchInArray(nums,5));
       // System.out.println(SearchInfiniteArray.binarySearch(nums,0,nums.length,10));
    }
}