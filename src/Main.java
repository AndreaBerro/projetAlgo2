import grapheelement.Graphe;
import graphegenerator.GrapheGenerator;
import graphegenerator.RandomLinearGrapheGenerator;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        GrapheGenerator generator = new RandomLinearGrapheGenerator(0.5f, 0.5f);
        Graphe graphe = generator.generateGraphe();
        System.out.println(graphe);
    }
    
}