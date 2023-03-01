class SearchInArrayOfUnknownSize {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = (start + end)/2;
            if (nums[mid] == target) return mid;
            if(nums[mid] > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInArrayOfUnknownSize obj = new SearchInArrayOfUnknownSize();
        int[] nums = new int[]{1,2,2,3,4,5,6,7,9,11,15,56,77,89,89,89,99,768,889};
        int target = 89;
        int res = obj.search(nums, target);
        System.out.println("result = " + res);

    }
}