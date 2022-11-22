class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> 
queries) {     List<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        List<List<Integer>> list = new ArrayList<>();
        for(int i : queries) {
            List<Integer> temp = new ArrayList<>();
            temp.add(lt(arr,i));
            temp.add(gt(arr,i));
            list.add(temp);
        }
        return list;

    }
    int lt(List<Integer> arr, int num) {
        int l = 0;
        int r = arr.size()-1;
        while(l <= r) {
            int mid = (l+r)/2;
            if(arr.get(mid) == num) return arr.get(mid);
            if(arr.get(mid) < num) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return r < 0 ? -1 : arr.get(r);
    }
    int gt(List<Integer> arr, int num) {
        int l = 0;
        int r = arr.size()-1;
        while(l <= r) {
            int mid = (l+r)/2;
            if(arr.get(mid) == num) return arr.get(mid);
            if(arr.get(mid) > num) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return l >= arr.size() ? -1 : arr.get(l);
    }

    void inOrder(TreeNode root, List<Integer> arr) {
        if(root == null) return;

        inOrder(root.left,arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }
}
