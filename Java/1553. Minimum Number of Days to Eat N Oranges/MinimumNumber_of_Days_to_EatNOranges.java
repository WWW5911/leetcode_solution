import java.lang.Math;
class Solution {
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public int minDays(int n) {
        if(hm.get(n) != null) return hm.get(n);
        int tmp = 1;
        if(n == 1) return 1;
        if(n % 3 == 0 && n % 2 == 0)
            tmp += Math.min( minDays(n/3), minDays(n/2));
        else if(n % 3 == 0)
            tmp += Math.min( minDays(n-1), minDays(n/3));
        else if(n % 2 == 0)
            tmp += Math.min( minDays(n-1), minDays(n/2));
        else tmp += minDays(n-1);
        hm.put(n,tmp);
        return tmp;
    }
}
/*
90%抄 沒啥想
主要就是跑BFS 全跑就對了
跑的過程中記錄當時的結果來節省速度
*/