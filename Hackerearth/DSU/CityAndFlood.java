import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    static int parent[];
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++)
            parent[i] = i;
        for(int i = 0; i < K; i++)
            union(sc.nextInt(), sc.nextInt());

        int finalDistinctEmpires = 0; 
        for(int i = 1; i <= N; i++)
            if(parent[i] == i)
                finalDistinctEmpires++;
        System.out.println(finalDistinctEmpires);
    }

    static int find(int iThEmpire) {
        if(parent[iThEmpire] != iThEmpire)
            parent[iThEmpire] = find(parent[iThEmpire]);
        return parent[iThEmpire];
    }

    static void union(int iThEmpire, int jThEmpire) {
        int iThRootEmpire = find(iThEmpire);
        int jThRootEmpire = find(jThEmpire);
        parent[jThEmpire] = iThEmpire;
    }
}
