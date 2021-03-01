class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int [][] adjm = new int[n+1][n+1];
        int [] arrived = new int[n+1], dis = new int[n+1];
        for(int i = 0; i <= n; ++i)
            dis[i] = (int)1e9;
        for(int i = 0; i < times.length; ++i)
            adjm[times[i][0]][times[i][1]] = times[i][2]+1;
        int next = k, nowl = 0;
        dis[k] = 0;
        for(int mm = 1; mm <= n; ++mm){
            int now = next, min = (int)1e9;
            arrived[now] = 1;
            for(int i = 1; i <= n; ++i){
                if(adjm[now][i] != 0){
                    if(adjm[now][i] + nowl-1 < dis[i]){
                        dis[i] = adjm[now][i] + nowl-1;
                    }
                }
            }
            for(int i = 1; i <= n; ++i)
                if(arrived[i] != 1 && min > dis[i]){
                    min = dis[i];
                    next = i;
                }
            nowl = min;
        }
        Arrays.sort(dis);
        return dis[dis.length-2] < 1e9 ? dis[dis.length-2] : -1;
    }
}