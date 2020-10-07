public class TesteGrafo {
    public static void main(String args[]) {
        /*
         * Graph g = new Graph(5); g.addEdge(1,2); g.addEdge(0,1); g.addEdge(2,4);
         * g.addEdge(4,3); g.addEdge(1,4);
         */

        /*
         * Graph g = new Graph(4); g.addEdge(0, 1); g.addEdge(1, 2); g.addEdge(0, 3);
         * g.addEdge(0, 2);
         */

        In in = new In("../tinyG.txt");
        Graph g = new Graph(in);

        System.out.println("Adjacentes ao 1:");
        for (int v : g.adj(1)) {
            System.out.println("==> " + v);
        }

        System.out.println(g.toDot());

        /*
         * CaminhamentoProfundidade dfs = new CaminhamentoProfundidade(g, 0);
         * dfs.exibe(); System.out.println(); for (int v = 0; v < g.V(); v++) { if
         * (dfs.hasPath(v)) System.out.println(v + ":" + dfs.pathTo(v)); }
         */
        CaminhamentoLargura bfs = new CaminhamentoLargura(g, 0);
        bfs.exibe();
    }
}
