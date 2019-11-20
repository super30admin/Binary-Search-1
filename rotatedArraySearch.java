   Time Complexity-O(log n)
   Space Complexity-O(1)
   public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0,h=n-1;
        while(l<h){
            int m=(l+h)/2;
            if(nums[m]>nums[h]) l=m+1;
            else h=m;
        }
      
        int rot=l;
        l=0;h=n-1;
        while(l<=h){
            int m=(l+h)/2;
            int adjustedMid=(m+rot)%n;
            if(nums[adjustedMid]==target)return adjustedMid;
            if(nums[adjustedMid]<target)l=m+1;
            else h=m-1;
        }
        return -1;
    }
