public class SearchRSA {
   int find(int[] nums, int value){
       if(nums.length == 0)
           return -1;
       else{
           int start = 0;
           int end = nums.length-1;
           while(start<=end) {
               int mid = (start + end) / 2;
               if(nums[mid]==value)
                   return mid;
               if(nums[mid]<=nums[end]){
                   if(value>nums[mid] && value<=nums[end] ){
                       start = mid+1;
                   }
                   else{
                       end = mid-1;
                   }
               }
               else{
                    if(value>=nums[start] && value<nums[mid]){
                        end = mid-1;
                    }
                    else{
                        start = mid+1;
                    }
               }
           }
           return -1;
       }
   }


    public static void main(String[] args) {
        SearchRSA obj = new SearchRSA();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int x  = obj.find(nums,5);
        System.out.println(x);

    }
}
