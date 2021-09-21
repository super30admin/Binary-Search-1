// Time Complexity :0(n) for inserting in hashmap,searching key
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : one of the testcase got runtime error saying stackoverflow but modified to get out of it.


// Your code here along with comments explaining your approach: initially these are inserted in hashmap with array indexices as keys, next this array is sorted and used binary search for element,with this element I found key in hashmap.

import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public int search(int[] nums, int target) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int k=0;k<nums.length;k++){
            map.put(k,nums[k]);
        }
        Arrays.sort(nums);
        int l=0;
        if(nums.length==1){
            int h=0;
            map.put(0,nums[0]);
        }
         int h=nums.length-1;
        
        int t= bisearch(nums,l,h,target);
        for(int j=0;j<nums.length;j++){
            if(map.get(j)==t){
                return j;
            }
        }
            
        
    
    return -1;}

    
    static int bisearch(int[] a,int l1,int h1,int x){
        int middle =  (l1+(h1-l1)/2);
        
        while(l1<=h1){
        if(x==a[middle]){
            return a[middle];}
        else if(x<a[middle]){
            h1=middle-1;
            return bisearch(a,l1,h1,x);
        }
        else if(x>a[middle]){
            l1=middle+1;
            return bisearch(a,l1,h1,x);
        }
        }
        
    return -1;
    
     }
}
