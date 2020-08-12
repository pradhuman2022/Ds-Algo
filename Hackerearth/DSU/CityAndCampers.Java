class TestClass {
    static int parent[];
    static int max = 0;
    static int min = 1;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String args[] ) throws Exception {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int queries = sc.nextInt();
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
            map.put(i, 1);
        }
            
        for(int i = 0; i < queries; i++) {
            union(sc.nextInt(), sc.nextInt());
            if(map.size() == 1) {
                System.out.println(0); 
                continue;
            }
            System.out.println(max - min);
        }
    }

    static int find(int person) {
        if(parent[person] != person)
            parent[person] = find(parent[person]);
        return parent[person];
    }
    /**
    *Missed edge case, but khud se find kia ki kya miss ho skta hai
    * So hmare pass wrong ans 0 aara tha kyuki 3 ke group ko consider hi nahi
    * karre the. So fir map ko init krana pda.
    * 1 2
    * 3 3
    *Baki union mai ek ye case ni handle kia tha ki agar dono same subset mai ho to 
    *fir ye bhi khud se dhunda tha.
    */
    static void union(int x, int y) {
        int xset = find(x);
        int yset = find(y);
        if(xset == yset)
            return;
        map.put(yset, map.get(xset) + map.get(yset));
        max = Math.max(max, map.get(yset));
        min = Math.min(min, map.get(yset));
        map.remove(xset);  
        parent[xset] = yset;
    }

}
