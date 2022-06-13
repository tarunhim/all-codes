

class Maxheap{
        int size;
        int[] heap;
        int capasity;

        Maxheap(int capasity) {
            this.capasity = capasity;
            heap = new int[capasity];
            size = 0;
        }
        int returnParent(int index) {
            return (index-1)/2;
        }
        int returnChild(int index, boolean left) {
            return index*2+(left? 1 : 2);
        }
        void add(int val) {
            heap[size] = val;
            heapifyUp(size);
            size++;
        }
        void heapifyUp(int index) {
            int parent = returnParent(index);
            int value = heap[index];

            while(index > 0 && value > heap[parent]) {
                heap[index] = heap[parent];
                index = parent;
                parent = returnParent(parent);
            }
            heap[index] = value;
        }
        void print() {
            int n = size;
            for(int i = 0; i < n; ++i) {
                System.out.print(heap[i]+" ");
            }
        }
        void delete(int value) {
            int index = -1;
            for(int i = 0; i < size; ++i) {
                if(heap[i] == value) {
                    index = i;
                    break;
                }
            }

            if(index != -1) {
                heap[index] = heap[size-1];
                size--;
            } else {
                return;
            }
            if(heap[index] > heap[returnParent(index)]) {
                heapifyUp(index);
            } else {
                heapifyDown(index, size-1);
            }
        }
        void heapifyDown(int index, int lastIndex) {
            int value = heap[index];
            int left = returnChild(index, true);
            int right = returnChild(index, false);
            int leftV = left < lastIndex ? heap[left] : 0;
            int rightV = right < lastIndex ? heap[right] : 0;
            while(index < lastIndex && value < Math.max(leftV,rightV)) {
                if(leftV > rightV) {
                    heap[index] = leftV;
                    index = left;
                } else {
                    heap[index] = rightV;
                    index = right;
                }
                left = returnChild(index, true);
                right = returnChild(index, false);
                leftV = left < lastIndex ? heap[left] : 0;
                rightV = right < lastIndex ? heap[right] : 0;
                
            }
            heap[index] = value;
        }
        
}
class Mock{
    public static void main(String[] args) {
        Maxheap heap = new Maxheap(10);
        heap.add(3);
        heap.add(2);
        heap.add(1);
        heap.add(5);
        heap.add(9);
        heap.print();
        heap.delete(9);
        System.out.println();
        heap.print();
    }
}