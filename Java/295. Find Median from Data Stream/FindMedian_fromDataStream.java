class MedianFinder {
    int [] arr;
    ArrayList<Integer> under, up;
    int size;
    /** initialize your data structure here. */
    public MedianFinder() {
        arr = new int[101];
        under = new ArrayList<Integer>();
        up = new ArrayList<Integer>();
        size = 0;
    }
    
    public void addNum(int num) {
        if(num >= 0 && num <= 100)
            ++arr[num];
        else if(num < 0) add(num, under);
        else add(num, up);
        ++size;
    }
    public double findMedian() {
        int mid = size / 2;
        if(size % 2 == 1){
            if(mid < under.size()) return (double)under.get(mid);
            if(size - up.size() <= mid) return (double)up.get(mid - size + up.size());
            mid -= under.size()-1;
            for(int i = 0; i < 101 ; ++i)
                if(mid > arr[i]) mid -= arr[i];
                else return (double)i;
        }else{
            double m1 = 0, m2 = 0;
            int midt = mid;
            if(mid <= under.size()) m1 = under.get(mid-1);
            else if(size - up.size() < mid) m1 = up.get((mid-1) - size + up.size());
            else {
                mid -= under.size();
                for(int i = 0; i < 101 && m1 == 0 ; ++i)
                    if(mid > arr[i]) mid -= arr[i];
                    else m1 = i;
            }
            if(midt < under.size()) m2 = under.get(midt);
            if(size - up.size() <= midt) m2 = up.get(midt - size + up.size());
            midt -= under.size()-1;
            for(int i = 0; i < 101 && m2 == 0 ; ++i)
                if(midt > arr[i]) midt -= arr[i];
                else m2 = i;
            return (double)((m2+m1)/2);
        }
        return 0;
    }
    void add(int num, ArrayList<Integer> al){
        int i = al.size();
        while(i-1 >= 0 && al.get(i-1) > num) {--i;}
        al.add(i, num);
    }
}
