// Time Complexity :O(log n/2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
         if(nums==null||nums.length==0)
                return -1;
        while(l<=r)
        {
           int mid=l+(r-l)/2;
           
             if(nums[mid]==target)
                return mid;
            else if(nums[l]<=nums[mid])//left part sorted
            {
                if(target>=nums[l]&&target<=nums[mid])
                {
                    r=mid-1;
                }
                else
                    l=mid+1;
            }
            else //right part sorted
            {
                if(target<=nums[r]&&target>=nums[mid])
                    l=mid+1;
                else
                    r=mid-1;
            }
        }
        
        return -1;
    }
}

---------------------------------------------------------------------------------

// Time Complexity :O(log n)
// Space Complexity :O(1)
// Your code here along with comments explaining your approach
import java.io.*;
import java.util.*;
public class InfSearch {
    int searcher(int[]nums,int target)
    {   int flag=0;
        int l=0;
        int h=1;
        while(flag==0)
        {
            if(target<nums[h])
                flag=1;
            else
            {
                l=h;
                h=h*2;
            }
        }
        while(l<=h)
        {

            int mid=l+(h-l)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(target<nums[mid])
            {
                h=mid-1;
            }
            else
                l=mid+1;

        }
        return -1;
    }
    public static void main(String args[]) {
        InfSearch inf= new InfSearch();
        int nums[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        System.out.println(inf.searcher(nums,9));
    }
}
