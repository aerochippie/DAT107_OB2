package uke_7_opp1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import static uke_7_opp1.BedreInnsetning.innsetning;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 1132001;
        int antall = 20;
        int[][] x = new int[antall][n];
        for (int i = 0; i < antall; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = random.nextInt();
            }
        }

        Instant start = Instant.now();
        for (int i = 0; i < antall; i++) {
            innsetning(x[i]);
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);

        System.out.println("Gjennomsnitt: " + (duration.toMillis() / (double) antall) + " ms");
    }
}
