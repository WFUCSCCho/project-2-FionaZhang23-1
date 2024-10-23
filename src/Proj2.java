/***********************************************************
 * @file: Proj2.java
 * @Description: This file contains the main method of this project, which calls all the crucial methods and also compute the insertion time and also the search time of different AVL and BST Trees.
 * @Author: Fiona Zhang
 * @Date: October 23, 2024
 ***********************************************************/
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.lang.Comparable;

public class Proj2 {
    public static void main(String[] args) throws IOException {
        // Use command line arguments to specify the input file
        if (args.length != 2) {
            System.err.println("Usage: java TestAvl <input file> <number of lines>");
            System.exit(1);
        }

        String inputFileName = args[0];
        int numLines = Integer.parseInt(args[1]);

        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();

        ArrayList<Song> dataList = new ArrayList<>();

        int count = 0;
        // Read data from the file
        for (int i = 0; i < numLines && inputFileNameScanner.hasNextLine(); i++) {
            String line = inputFileNameScanner.nextLine();
            String[] parts = line.split(",");

            // Trim whitespace from each part
            for (int j = 0; j < parts.length; j++) {
                parts[j] = parts[j].trim();
            }

            try {
                String trackName = parts[0];
                String artistName = parts[1];
                int releaseYear = Integer.parseInt(parts[2]);
                long streams = Long.parseLong(parts[3]);
                int bpm = Integer.parseInt(parts[4]);
                int danceability = Integer.parseInt(parts[5]);
                dataList.add(new Song(trackName, artistName, releaseYear, streams, bpm, danceability));
            } catch (NumberFormatException e) {
            }
        }

        inputFileNameScanner.close();


        // Sort and shuffle data
        ArrayList<Song> sortedList = new ArrayList<>(dataList);
        ArrayList<Song> randomizedList = new ArrayList<>(dataList);
        Collections.sort(sortedList);
        Collections.shuffle(randomizedList);

        // Create BST and AVL Trees
        BST<Song> bstSorted = new BST<>();
        BST<Song> bstRandomized = new BST<>();
        AvlTree<Song> avlSorted = new AvlTree<>();
        AvlTree<Song> avlRandomized = new AvlTree<>();

        // Calculate the nanoseconds running time for the trees when insertion and also search
        long startTime = System.nanoTime();
        for (Song value : sortedList) {
            bstSorted.insert(value);
        }
        long endTime = System.nanoTime();
        double sortedBSTInsertTime = (endTime - startTime)/ 1.0e9;

        long startTimes = System.nanoTime();
        for (Song value : sortedList) {
            avlSorted.insert(value);
        }
        long endTimes = System.nanoTime();
        double sortedAVLInsertTime = (endTimes - startTimes) / 1.0e9;

        long startTimet = System.nanoTime();
        for (Song value : randomizedList) {
            bstRandomized.insert(value);
        }
        long endTimet = System.nanoTime();
        double randomBSTInsertTime = (endTimet - startTimet) / 1.0e9;

        long startTimef = System.nanoTime();
        for (Song value : randomizedList) {
            avlRandomized.insert(value);
        }
        long endTimef = System.nanoTime();
        double randomAVLInsertTime = (endTimef - startTimef) / 1.0e9;

        long startTimeoo = System.nanoTime();
        for (Song value : dataList) {
            bstSorted.search(value);
        }
        long endTimeoo = System.nanoTime();
        double sortedBSTsearchTime = (endTimeoo - startTimeoo) / 1.0e9;

        long startTimess = System.nanoTime();
        for (Song value : dataList) {
            avlSorted.contains(value);
        }
        long endTimess = System.nanoTime();
        double sortedAVLsearchTime = (endTimess - startTimess) / 1.0e9;

        long startTimett = System.nanoTime();
        for (Song value : dataList) {
            bstRandomized.search(value);
        }
        long endTimett = System.nanoTime();
        double randomBSTsearchTime = (endTimett - startTimett) / 1.0e9;

        long startTimeff = System.nanoTime();
        for (Song value : dataList) {
            avlRandomized.contains(value);
        }
        long endTimeff = System.nanoTime();
        double randomAVLsearchTime = (endTimeff - startTimeff) / 1.0e9;

        // write into an output file of the running times
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt", true))) {
            writer.printf("Number of lines: %d\n", numLines);
            writer.printf("BST Sorted Insert Time: %.6f s\n", sortedBSTInsertTime);
            writer.printf("BST Randomized Insert Time: %.6f s\n", randomBSTInsertTime);
            writer.printf("AVL Sorted Insert Time: %.6f s\n", sortedAVLInsertTime);
            writer.printf("AVL Randomized Insert Time: %.6f s\n", randomAVLInsertTime);
            writer.printf("BST Sorted Search Time: %.6f s\n", sortedBSTsearchTime);
            writer.printf("BST Randomized Search Time: %.6f s\n", randomBSTsearchTime);
            writer.printf("AVL Sorted Search Time: %.6f s\n", sortedAVLsearchTime);
            writer.printf("AVL Randomized Search Time: %.6f s\n", randomAVLsearchTime);
        }
    }
}



