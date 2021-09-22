class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
//         if(nums.length == 1){ 
//             if(target==nums[0]) 
//                 return 0;
//             else
//                 return -1;
//         }
        
         //{4,5,6,7,0,1,2}   
           //  s=0 e=6 m = 3 so nums[m]=7  continue s=3+1=4  e=6 m =(4+6)/2 =5 continue...
        while(start<end) //to get the start as the lowest element
        {
            int mid = (start +end)/2;
            if(nums[mid]>nums[end]){
                start = mid+1;
            }
            else
            {
                end=mid;
            }
        }
        
        int left = start;
        start=0;
        end=nums.length-1;
        
        i
            f(target>=nums[left] && target<=nums[end]){ 
            start = left;
        }else
        {
            end =  left;
        }
        
        while(start<=end)
        {
            int mid= (start+end)/2;
            if(target==nums[mid])
                return mid;
            else if(nums[mid]<target)
                start = mid+1;
            else
                end = mid-1;
        }
        
        return -1;
    }
}

//time complexity : O(log n)
//space complexity : O(1)
//ran successfully on leetcode
////I thought this edge case was necessary but didnt understand how it got covered using the same below code itself. If any one can explain me. Thank you.
//faced diffuclty in finding the start index which is minimun index.
