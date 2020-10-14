import java.util.HashSet;

public class Ciclo {

    private boolean[] marked;
    private boolean hasCycle;
    private HashSet<String> edges;

    public Ciclo(Graph G) {
        marked = new boolean[G.V()];
        hasCycle = false;
        edges = new HashSet<>();
        for (int v = 0; v < G.V(); v++)
            if (!marked[v] && !hasCycle)
                dfs(G, v); // chamada recursiva
        // for (boolean b : marked) {
        // System.out.println(b);
        // }
    }

    private void dfs(Graph g, int s) {
        marked[s] = true;
        for (int v : g.adj(s)) {
            String e = null;
            if (s < v)
                e = s + "-" + v;
            else
                e = v + "-" + s;
            if (!marked[v]) {
                System.out.println(e);
                edges.add(e); // adiciona a aresta no conjunto
                dfs(g, v);
            } else {
                // Já visitei, tem ciclo?
                // Se o conj. não contém a aresta, é um ciclo!
                if (!edges.contains(e))
                    hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        // g.addEdge(3, 0);
        g.addEdge(2, 5);
        g.addEdge(5, 4);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(6, 8);

        Ciclo detector = new Ciclo(g);
        if (detector.hasCycle())
            System.out.println("Tem ciclo!");
    }
}