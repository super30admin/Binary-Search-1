class Main {
    public static void main(String[] args) {
        int[] secret={0,2,3,4,5,7,8,67,80};
        System.out.print(getIndex(secret, 66));
    }
    
    static public int getIndex(int[] reader, int target){
        int low=0;
        int high =1;
        while(reader[high] < target){
            low=high;
            high = 2*high;
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            if(reader[mid]==target) return mid;
            if(reader[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}