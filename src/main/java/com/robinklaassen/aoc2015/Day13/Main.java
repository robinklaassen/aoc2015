package com.robinklaassen.aoc2015.Day13;

import com.robinklaassen.aoc2015.Utils;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.tour.RandomTourTSP;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static Map<Set<String>, Integer> parseRelationships(List<String> input) {
        HashMap<Set<String>, Integer> map = new HashMap<>();
        Pattern p = Pattern.compile("(\\w+) would (\\w+) (\\d+) happiness units by sitting next to (\\w+).");

        for (String line : input) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                assert m.groupCount() == 4;
                Set<String> couple = new HashSet<>();
                couple.add(m.group(1));
                couple.add(m.group(4));
                int value = Integer.parseInt(m.group(3)) * ((m.group(2).equals("gain")) ? 1 : -1);
                map.put(couple, map.getOrDefault(couple, 0) + value);
            }
        }

        return map;
    }

    public static Graph<String, DefaultWeightedEdge> constructGraphFromMap(Map<Set<String>, Integer> map) {
        SimpleWeightedGraph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        for (Map.Entry<Set<String>, Integer> entry : map.entrySet()) {
            String[] couple = entry.getKey().toArray(new String[2]);
            Graphs.addEdgeWithVertices(graph, couple[0], couple[1], entry.getValue());
        }

        return graph;
    }

    private static int determineHighestHappiness(Graph<String, DefaultWeightedEdge> graph) {
        RandomTourTSP<String, DefaultWeightedEdge> randomTour = new RandomTourTSP<>();
        int i = 0;
        int highestHappiness = 0;
        while (i < 100000) {
            GraphPath<String, DefaultWeightedEdge> path = randomTour.getTour(graph);
            int happiness = path.getEdgeList().stream().mapToInt(edge -> (int) graph.getEdgeWeight(edge)).sum();
            if (happiness > highestHappiness) {
                System.out.printf("Found higher happiness %d after %d iterations.%n", happiness, i);
                highestHappiness = happiness;
                i = 0;
            }

            i++;
        }
        return highestHappiness;
    }

    public static void main(String[] args) {
        List<String> puzzleInput = Utils.getPuzzleInput(13);
        Map<Set<String>, Integer> relationships = parseRelationships(puzzleInput);
        Graph<String, DefaultWeightedEdge> graph = constructGraphFromMap(relationships);

        // Part one
        int highestHappiness = determineHighestHappiness(graph);
        System.out.println("Highest happiness found: " + highestHappiness);

        // Part two
        String[] vertices = graph.vertexSet().toArray(new String[0]);
        for (String v : vertices) {
            Graphs.addEdgeWithVertices(graph, "me", v, 0);
        }

        int highestHappiness2 = determineHighestHappiness(graph);
        System.out.println("Highest happiness including myself: " + highestHappiness2);

    }
}
