
//Time Complexity : O(n)
// Couldn't solve the problem in O(log n)
class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        
        int i=0;
        int j =nums.length-1;
        
        while(i<=j)
        {
            if(nums[i]==target)
            {
                return i;
            }
            else if(nums[j]==target)
            {
                return j;
            }
            else
            {
                i++;
                j--;
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = {4,5,6,7,8,0,1,2};
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.out.println("Index " + s.search(arr, 8));
    }
}