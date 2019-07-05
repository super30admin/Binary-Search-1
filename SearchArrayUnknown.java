public class SearchArrayUnknown {
    public int search(int[] nums,int start,int end,int target){
        if(start>end)
            return -1;
        int mid = (start+end)/2;
        if(nums[mid]== target)
            return mid;
        if(target<nums[mid])
            return search(nums,start,mid-1,target);
        else
            return search(nums,mid+1,end,target);

    }

    public int find(int[] nums,int value){
        int low = 0;
        int high = 1;
        int end = nums[high];
        while(end<value){
            low = high;
            if(2*high<nums.length)
                high = 2*high;
            else
                high = nums.length-1;
            end = nums[high];

        }
        return search(nums,low,high,value);
    }
    public static void main(String[] args) {
        SearchRSA obj = new SearchRSA();
        int[] nums = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int x  = obj.find(nums,10);
        System.out.println(x);
    }
}
