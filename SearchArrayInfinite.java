class Solution {
    public int search(ArrayReader reader, int target) {
        int count=1;
        for (int i=0; i< count; i++){
            if(target== reader.get(i)) return i;
            else if(target> reader.get(i)) count++;
            else return -1;
        }
        return -1;
    }
}
