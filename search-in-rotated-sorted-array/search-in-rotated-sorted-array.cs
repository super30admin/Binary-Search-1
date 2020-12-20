public class Solution {
    int[] nums;
    int target;
    
public int findindex(int left,int right)
{
    if(nums[left] < nums[right])
    {
        return 0;
    }
    
    while(left<=right)
    {
        int pivot = (left+right)/2;
        if(nums[pivot] > nums[pivot+1])
        {
            return pivot+1;
        }
        else if(nums[pivot] < nums[left])
        {
            right = pivot-1;
        }
        else
        {
            left = pivot+1;
        }
    }
    
    return 0;
}
    
    public int search(int left,int right)
    {
        while(left<=right)
        {
            int piv = (left+right)/2;
            if(nums[piv]==target)
            {
                return piv;
            }
            else if (target < nums[piv])
            {
                right = piv-1;
            }
            else 
            {
                left = piv+1;
            }
        }
        return -1;
    }
    public int Search(int[] nums, int target) {
        if(nums==null || nums.Length ==0) return -1;
        this.nums = nums;
        this.target = target;
        
        int n = nums.Length;
        
        if(n==1)
        {
            return this.nums[0]==target ?0 :-1;
