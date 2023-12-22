// Didnt execute on leetcode still sorting premium
// Had to follow yt video and class to code as lack of prem will repeat once i get prem....The idea for this problem is simple we dont know the end point of this array so we keep moving pointers by a multiple till we get a range and to that range we apply binary search;
//Time complexity for this will be O(log n)

class Solution {
    public int search(ArrayReader nums, int target) {
        int h = 0;
        int l = 1;

        while(nums.get(h)<target){
            l = h;
            h = h*2;
        }
        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums.get(mid)==target){
                return mid;
            }
            else if(nums.get(mid)>target){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;
        
    }



}