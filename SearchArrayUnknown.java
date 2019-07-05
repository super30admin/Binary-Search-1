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
        try{
        while(nums[high]<=value){
            low = high;
            high =2*high;
        }}
        catch (Exception e){
            try{
                while(true){
                    if(nums[low]==value)
                        return low;
                    low++;
                }
            }
            catch(Exception ee){
                return -1;
            }
        }
        return search(nums,low,high,value);
    }
    public static void main(String[] args) {
        SearchArrayUnknown obj = new SearchArrayUnknown();
        int[] nums = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int x  = obj.find(nums,90);
        System.out.println(x);
    }
}
