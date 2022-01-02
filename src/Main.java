import grapheelement.Graphe;
import graphegenerator.GrapheGenerator;
import graphegenerator.RandomLinearGrapheGenerator;
import graphesolver.GrapheSolver;

/**
 * Main
 */
public class Main {

    public void createStats(GrapheSolver gs) {
        for (float i = 0f; i < 1.1f; i+=0.1f) {
            for (float j = 0f; j < 1.1f; j+=0.1f) {
                int moyAct = 0;
                GrapheGenerator gg = new RandomLinearGrapheGenerator(i, j);
                for (int j2 = 0; j2 < 100; j2++) {
                    Graphe g = gg.generateGraphe();
                    moyAct += gs.solve(g);
                }
                moyAct = moyAct / 100;
                System.out.println("'p':"+i+" 'q':"+j+" = "+moyAct);
            }
        }
    }

    public static void main(String[] args) {
        GrapheGenerator generator = new RandomLinearGrapheGenerator(0.5f, 0.5f);
        Graphe graphe = generator.generateGraphe();
        System.out.println(graphe);
    }

}
