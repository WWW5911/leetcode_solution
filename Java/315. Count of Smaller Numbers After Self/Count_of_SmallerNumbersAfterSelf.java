
class fenwick{
    int [] array;
    int [] ori;
    
    public fenwick(int node){
        array = new int[node+1];
        ori = new int[node+1];
    }
    int lowbit(int posi){
        return posi&(-posi);
    }
    void update(int posi, int value){
        int dif = ori[posi] - value;
        ori[posi] = value;
        while(posi <= array.length){
            array[posi] -= dif;
            posi += lowbit(posi);
        }
    }
    int sum(int posi){
        int sum = 0;
        while(posi > 0){
            sum += array[posi];
            posi -= lowbit(posi);
        }
        return sum;
    }
}


class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int [] arr = new int[20001];
        List<Integer> al = new ArrayList<Integer>();
        fenwick ft = new fenwick(20001);
        for(int i = nums.length-1; i >= 0; --i){
            ++arr[nums[i]+10000];
            al.add(ft.sum(nums[i]+10000-1));
            ft.update(nums[i]+10000, arr[nums[i]+10000]);
        }
        Collections.reverse(al);
        return al;
    }
}