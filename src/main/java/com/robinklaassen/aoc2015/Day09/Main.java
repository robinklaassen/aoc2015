package com.robinklaassen.aoc2015.Day09;

import com.robinklaassen.aoc2015.Utils;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.tour.RandomTourTSP;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static Graph<String, DefaultWeightedEdge> constructGraph(List<String> puzzleInput) {
        Graph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        for (String line : puzzleInput) {
            Pattern p = Pattern.compile("(\\w+) to (\\w+) = (\\d+)");
            Matcher m = p.matcher(line);
            if (m.find()) {
                assert m.groupCount() == 3;
                String loc1 = m.group(1);
                String loc2 = m.group(2);
                int dist = Integer.parseInt(m.group(3));
                Graphs.addEdgeWithVertices(graph, loc1, loc2, dist);
            } else {
                throw new AssertionError();
            }
        }
        return graph;
    }

    private static double getHighestWeight(Graph<String, DefaultWeightedEdge> graph) {
        RandomTourTSP<String, DefaultWeightedEdge> tourGenerator = new RandomTourTSP<>();

        int i = 0;
        double optimalWeight = 0;
        while (true) {
            GraphPath<String, DefaultWeightedEdge> path = tourGenerator.getTour(graph);
            List<DefaultWeightedEdge> edgeList = path.getEdgeList();
            double weightWithoutFirst = path.getWeight() - graph.getEdgeWeight(edgeList.get(0));
            double weightWithoutLast = path.getWeight() - graph.getEdgeWeight(edgeList.get(edgeList.size() - 1));
            double heighestWeight = Math.max(weightWithoutFirst, weightWithoutLast);
            if (heighestWeight > optimalWeight) {
                System.out.printf("Found higher weight %d after %d iterations%n", (int) heighestWeight, i);
                optimalWeight = heighestWeight;
                i = 0;
            }

            if (i == 100000) {
                break;
            }

            i++;
        }
        return optimalWeight;
    }

    private static double getLowestWeight(Graph<String, DefaultWeightedEdge> graph) {
        RandomTourTSP<String, DefaultWeightedEdge> tourGenerator = new RandomTourTSP<>();

        int i = 0;
        double optimalWeight = 1e6;
        while (true) {
            GraphPath<String, DefaultWeightedEdge> path = tourGenerator.getTour(graph);
            List<DefaultWeightedEdge> edgeList = path.getEdgeList();
            double weightWithoutFirst = path.getWeight() - graph.getEdgeWeight(edgeList.get(0));
            double weightWithoutLast = path.getWeight() - graph.getEdgeWeight(edgeList.get(edgeList.size() - 1));
            double lowestWeight = Math.min(weightWithoutFirst, weightWithoutLast);
            if (lowestWeight < optimalWeight) {
                System.out.printf("Found lower weight %d after %d iterations%n", (int) lowestWeight, i);
                optimalWeight = lowestWeight;
                i = 0;
            }

            if (i == 100000) {
                break;
            }

            i++;
        }
        return optimalWeight;
    }

    public static void main(String[] args) {
        List<String> puzzleInput = Utils.getPuzzleInput(9);

        Graph<String, DefaultWeightedEdge> graph = constructGraph(puzzleInput);

        System.out.println(graph);

        // Part one
        double lowestWeight = getLowestWeight(graph);
        System.out.printf("Lowest path length found: %d%n", (int) lowestWeight);

        // Part two
        double heighestWeight = getHighestWeight(graph);
        System.out.printf("Highest path length found: %d%n", (int) heighestWeight);

    }
}
