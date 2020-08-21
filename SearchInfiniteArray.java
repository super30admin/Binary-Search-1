// Time Complexity : O(logT) T - index of target element
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int search(ArrayReader reader, int target) {
        int l=0, h=1;
        while(reader.get(h)<target){
            l=h;
            h=h*2;
            
        }
        return binarySearch(reader,target,l,h);
    }
        
    private int binarySearch(ArrayReader reader, int target, int l, int h){
            
            while(l<=h){
                int mid= l+(h-l)/2;
                
                if(reader.get(mid)==target) return mid;
                
                if (target<reader.get(mid)){
                    h=mid-1;
                }else{
                    l=mid+1;
                }
            }
            
            return -1;   
        }

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(0);
        list.add(3);
        list.add(5);
        list.add(9);
        list.add(12);
        //System.out.println(list.indexOf(12));

        System.out.println(search(list,12));

    }
}