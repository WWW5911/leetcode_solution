class Solution {
    class rev implements Comparable<rev>{
        int num, key;
        rev(int n, int k){
            num = n;
            key = k;
        }
        public void addOne(){++num;}
        @Override
        public int compareTo(rev n) {
            if(n.num > num) return 1;
            if(n.num < num) return -1;
            return 0;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, rev> hm = new HashMap<Integer, rev>();
        for(int i = 0; i < nums.length; ++i)
            if(!hm.containsKey(nums[i])) hm.put(nums[i], new rev(1, nums[i]));
            else hm.get(nums[i]).addOne();
        PriorityQueue<rev> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, rev> E : hm.entrySet())
            pq.add(E.getValue());
        int [] ans = new int[k];
        for(int i = 0; i < k; ++i)
            ans[i] = pq.poll().key;
        return ans;
    }
}