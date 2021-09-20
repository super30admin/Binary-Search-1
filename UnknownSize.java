public class UnknownSize {

    interface ArrayReader {
        int get(int index);
    }

    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target) return 0;

        int left = 0, right = 2, middle, mid_element;

        while(reader.get(right) < target){
            left = right;
            right *= 2;
        }

        while(left <= right){
            middle = left + (right - left) / 2;
            mid_element = reader.get(middle);
            if(mid_element == target)   return middle;
            else if(mid_element < target) left = middle + 1;
            else if(mid_element > target) right = middle - 1;
        }
        return -1;
    }

}
