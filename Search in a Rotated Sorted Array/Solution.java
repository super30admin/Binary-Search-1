// O(log n) runtime complexity.
// space complexity = O(n)
class Solution {
    public int search(int[] nums, int target) {
        int minIndex=0;
        int x;
        for(int i=0;i<nums.length;i++){
            if(nums[minIndex]>nums[i]) minIndex=i;
        }

        if(nums[minIndex]==target) return minIndex;
        x = binarySearch(nums,0,minIndex-1,target);
        if(x!=-1) return x;
        x = binarySearch(nums,minIndex+1,nums.length-1,target);
        if(x!=-1) return x;
        return -1;
    }

    public int binarySearch(int nums[], int l, int h, int target){
        int x=-1;
        if(l>h) return -1;
        int m = (l+h)/2;
        System.out.println("mid: "+m);
        if(nums[m]==target) return m;
        else if(nums[m]<target) x= binarySearch(nums,m+1,h,target);
        else x= binarySearch(nums,l,m-1,target);
        return x;
    }
}