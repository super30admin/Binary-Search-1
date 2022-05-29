class RoatatedArraySerach {
    public int search(int[] nums, int target) {

        //Arrays.sort(nums);
        if(nums == null || nums.length == 0) return -1;

        int r=nums.length-1;
        int l=0;

        if(nums[l]==target) return l;
        if(nums[r]==target) return r;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[l]<=nums[m]){

                if(nums[l]<=target && nums[m]>target){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }else{
                if(nums[m]<target && nums[r]>=target){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
        }
        return -1;
    }
}