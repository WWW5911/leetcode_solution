class Solution { //general for N bucket solution
    public int totalFruit(int[] tree) {
        int count = 0, ans = 0, bucket = 2;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i + count < tree.length; ++i){
            if(i > 0){
                hm.replace(tree[i-1], hm.get(tree[i-1])-1);
                if(hm.get(tree[i-1]) == 0) hm.remove(tree[i-1]);
            }
            while((i + count) < tree.length && (hm.size() < bucket || hm.containsKey(tree[i + count]) )){
                if(!hm.containsKey(tree[i + count])) hm.put(tree[i + count] , 1);
                else hm.replace(tree[i + count], hm.get(tree[i + count])+1);
                ans = ans > count ? ans : count;
                count++;
            }
            count--;
        }
        return ans+1;
    }
}