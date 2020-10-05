import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CaminhamentoProfundidade {

    private boolean[] marked;
    private int[] edgeTo;
    private int start; // vértice inicial do caminhamento

    public CaminhamentoProfundidade(Graph G, int start) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.start = start;

        edgeTo[start] = -1;
        dfs(G, start); // chamada recursiva
    }

    private void dfs(Graph g, int s) {
        marked[s] = true;
        for (int v : g.adj(s)) {
            if (!marked[v]) {
                edgeTo[v] = s;
                dfs(g, v);
            }
        }
    }

    // Retorna true se há caminho de start até v
    public boolean hasPath(int v) {
        return marked[v]; // se há caminho, o vértice foi marcado!
    }

    // Retorna um objeto com o caminho de start até v
    // (pode ser uma lista, uma pilha, etc)
    public Iterable<Integer> pathTo(int v) {
        List<Integer> path = new LinkedList<>();
        while (v != start) {
            path.add(0, v); // insere no início para inverter a ordem
            v = edgeTo[v];
        }
        path.add(0, start); // idem
        return path;
    }

    public void exibe() {
        for (int v = 0; v < marked.length; v++) {
            System.out.println(v + ": " + marked[v] + " - " + edgeTo[v]);
        }
    }
}
