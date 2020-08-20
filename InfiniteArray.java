//Creating a class that abstracts away the infinite array.
//Assuming that this DS will have other methods that will double its size as and when required.
    public class InfiniteArray {
        private int index = 0;
        private int[] infArr;

        public InfiniteArray(int size) {
            infArr = new int[size];
        }

        public int get(int index) {
            try{
                int element = infArr[index];
                return element;
            } catch (ArrayIndexOutOfBoundsException e) {
                return -1;
            }
        }
        public int getCurrentLength() {
            return infArr.length;
        }

        public void add(int element) {
            infArr[index++] = element;
        }
    }