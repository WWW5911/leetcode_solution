class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] arr = new int[numCourses];
        ArrayList<Integer> [] adj = new ArrayList[numCourses]; 
        for(int i = 0; i < prerequisites.length; ++i){
            if(adj[prerequisites[i][1]] == null) adj[prerequisites[i][1]] = new ArrayList<Integer>();
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            ++arr[prerequisites[i][0]];
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < numCourses; ++i)
            if(arr[i] == 0) stack.push(i);
        while(!stack.empty()){
            int temp = stack.pop();
            --numCourses;
            if(adj[temp] == null) continue;
            for(int i = 0; i < adj[temp].size(); ++i){
                --arr[adj[temp].get(i)];
                if(arr[adj[temp].get(i)] == 0) stack.push(adj[temp].get(i));
            }
        }
        return numCourses == 0 ? true : false;
    }
}