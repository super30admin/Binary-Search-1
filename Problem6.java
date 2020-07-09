//Time Complexity for this operation : O(logn) + O(logn) ~ O(logn) 

class Solution {
    public int search(ArrayReader reader, int target) {
        //Declare two int varibles: fast & slow pointers
        int slow = 0;
        int fast = 1;
        
        //Process to find range where target value lies in.  //Time Complexity for this operation : O(logn)
        while(target>reader.get(fast)){
            slow = fast;
            fast = 2*fast;
        }
        
        //Binary Search Logic to find element within an range. //Time Complexity for this operation : O(logn)
        while(slow<=fast){
            int mid = slow + (fast-slow)/2;
            if(reader.get(mid) == target){
                return mid;
            } else if(reader.get(mid)>target){
                fast = mid -1;
            } else if(reader.get(mid)<target){
                slow = mid +1;
            }
        }
        return -1;
    }
}

class Main{
    public static void main(String[] args){
        Solution obj = new Solution();
        int arr = [-1,0,3,5,9,12]; 
        int target = 2;
        int result = obj.search(arr,target);
        System.out.println("Result : " + result);
    }
}