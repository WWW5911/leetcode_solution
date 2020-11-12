class KthLargest {
    int target;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        target = k;
        pq = new PriorityQueue<Integer>();
        int i = 0;
        for(; i < nums.length; ++i){
            pq.add(nums[i]);
            if(i >= k ) pq.poll();
        }
        if(i < k) pq.add((int)-1e9);
    }
    
    public int add(int val) {
        pq.add(val);
        pq.poll();
        return pq.peek();
    }
}