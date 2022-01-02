import grapheelement.Graphe;
import graphegenerator.GrapheGenerator;
import graphegenerator.RandomLinearGrapheGenerator;
import graphesolver.GrapheSolver;
import graphesolver.GrapheSolverAlgo1;
import graphesolver.GrapheSolverAlgo2;
import graphesolver.GrapheSolverCombine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Main
 */
public class Main {

    public static void createStats(GrapheSolver gs) {
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
    public static void writeExcel(GrapheSolver gs){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("result.txt"));
            for (float i = 0f; i < 1.1f; i+=0.1f) {
                for (float j = 0f; j < 1.1f; j+=0.1f) {
                    double moyAct = 0;
                    GrapheGenerator gg = new RandomLinearGrapheGenerator(j, i);
                    for (int j2 = 0; j2 < 100; j2++) {
                        Graphe g = gg.generateGraphe();
                        moyAct += gs.solve(g);
                    }
                    moyAct = moyAct / 100;
                   out.write(moyAct+"\n");
                }
                out.write("\n\n");
            }
            out.close();

        } catch (IOException e) {
        }
    }
    public static double fixedStats(GrapheSolver gs){
        double moyAct1 = 0;
        double moyAct2 = 0;
        double moyAct3 = 0;
        GrapheGenerator gg1 = new RandomLinearGrapheGenerator(0.3f, 0.5f);
        GrapheGenerator gg2 = new RandomLinearGrapheGenerator(0.5f, 0.5f);
        GrapheGenerator gg3 = new RandomLinearGrapheGenerator(0.7f, 0.5f);
        for (int j2 = 0; j2 < 100; j2++) {
            Graphe g1 = gg1.generateGraphe();
            Graphe g2 = gg2.generateGraphe();
            Graphe g3 = gg3.generateGraphe();
            moyAct1 += gs.solve(g1);
            moyAct2 += gs.solve(g2);
            moyAct3 += gs.solve(g3);
        }
        moyAct1 = moyAct1 / 100;
        moyAct2 = moyAct2 / 100;
        moyAct3 = moyAct3 / 100;
        return (moyAct1+moyAct2+moyAct3)/3;
    }

    public static void test(GrapheSolverCombine gs){
        double max = 0;
        int[] tab = new int[3];
        gs.weight[0]=0;
        for (int i = 3; i < 20; i++) {
            for (int j = 3; j < 20; j++) {
                for (int k = 3; k <7 ; k++) {
                    gs.weight[0]=i;
                    gs.weight[2]=j;
                    gs.weight[1]=k;
                    if(fixedStats(gs)>max){
                        max = fixedStats(gs);
                        tab[0]=i;
                        tab[1]=j;
                        tab[2]=k;
                    }
                }

            }



        }
        System.out.println(Arrays.toString(tab));
    }

    public static void main(String[] args) {
        Main m = new Main();
        GrapheGenerator generator = new RandomLinearGrapheGenerator(0.5f, 0.5f);
        Graphe graphe = generator.generateGraphe();
        System.out.println(graphe);
        System.out.println("          ");

        GrapheSolverCombine gsb = new GrapheSolverCombine();
        GrapheSolverAlgo1 gsa = new GrapheSolverAlgo1();
        GrapheSolverAlgo2 gsa2 = new GrapheSolverAlgo2();

//        createStats(gsa);
        fixedStats(gsa2);
    }

}
