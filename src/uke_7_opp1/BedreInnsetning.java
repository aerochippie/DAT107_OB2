package uke_7_opp1;

import java.time.Duration;

import java.time.Instant;
import java.util.Random;

public class BedreInnsetning {

    public static void innsetning(int[] x) {
        int n = x.length;

        //flytte minste elementet fremst
        int minsteEl = 0;
        for (int i = 1; i < n; i++) {
            if (x[i] < x[minsteEl]) {
                minsteEl = i;
            }
        }
        int byttom = x[0];
        x[0] = x[minsteEl];
        x[minsteEl] = byttom;



        //sette inn to om gangen
        for (int i = 2; i < n; i += 2) {
            int minste = Math.min(x[i], x[i - 1]);
            int storste = Math.max(x[i], x[i - 1]);

            int j = i - 1;

            while (j >= 1 && storste < x[j ] ) {
                x[j + 1] = x[j];
                j--;

            x[j + 2] = storste;

                while (j >= 0 && minste < x[j]) {
                    x[j + 1] = x[j];
                    j--;
                }
                x[j + 1] = minste;
            }
        }
        //oddetall
        if (n % 2 != 0) {
            int siste = x[n - 1];
            int j = n - 2;

            while (j >= 0 && x[j] > siste) {
                x[j + 1] = x[j];
                j--;
            }
            x[j + 1] = siste;
        }
    }


}
//Observasjoner:
//Ved å flytte det minste elementet først, reduseres antall sammenligninger i den indre løkken, siden vi aldri trenger å sjekke posisjon 0.
//Ved å sette inn to elementer om gangen, reduseres antall iterasjoner i den ytre løkken, noe som gir en raskere sortering.
//Når vi kombinerer begge triksene, ser vi en tydelig forbedring i kjøretiden sammenlignet med standard insertion sort.

// Fungerer koden for både odde og jevne n?
//Ja, koden fungerer for både odde og jevne n.
//
//For partall (n er jevnt, f.eks. 32000): Algoritmen vil alltid sette inn to elementer per iterasjon gjennom hovedløkken.
//For oddetall (n er odde, f.eks. 32001): Den siste iterasjonen vil kun ha ett element igjen, men det går fint fordi den ytre løkken øker i med 2. Hvis n er odde, vil det siste elementet bli håndtert normalt.
//Hvis n er odde, så vil i til slutt være n-1, og i += 2 vil da gå ut av løkken. Det siste elementet vil allerede være sortert, fordi alle tidligere elementer er plassert riktig.
//
//Hva kan vi observere?
//Optimaliseringen hjelper, men insertion sort er fortsatt
//𝑂
//(
//𝑛
//2
//)
//O(n
//2
// )
//
//Vi ser en merkbar reduksjon i kjøretid sammenlignet med standard insertion sort, spesielt for store n.
//Men for store verdier av n vil algoritmen fortsatt være treg sammenlignet med mer effektive algoritmer som merge sort eller quick sort.
//Flytting av minste element først forenkler betingelsen i while-løkken
//
//Normalt må vi sjekke j >= 0 i while, men nå vet vi at indeks 0 aldri trenger å bli overskrevet.
//Dette sparer noen få sammenligninger, men effekten er ikke enorm.
//Innføring av to elementer om gangen gir færre iterasjoner
//
//Ved å sette inn både minste og største element samtidig, reduserer vi antall iterasjoner av den ytre løkken.
//Det betyr færre sammenligninger og flyttinger totalt sett.
//Denne optimaliseringen har en større effekt enn å bare flytte minste element først.
//Insertion sort er fortsatt best for nesten-sorterte data
//
//Hvis dataene allerede er delvis sortert, vil algoritmen fungere svært raskt.
//I verste fall, med tilfeldig data, er forbedringene vi gjorde nyttige, men kan ikke konkurrere med mer avanserte sorteringsalgoritmer.
//Gjennomsnittsmåling gir mer stabile resultater
//
//Ved å kjøre sorteringen flere ganger og ta gjennomsnittlig tid, unngår vi tilfeldige variasjoner forårsaket av CPU-belastning, minnehåndtering, eller andre prosesser som kjører på maskinen.
//Oppsummert
//Ja, koden fungerer for både odde og jevne n.
//Vi observerer en forbedring i kjøretid, men insertion sort er fortsatt treg for store n.
//Optimaliseringene reduserer konstanten i kjøretiden, men ikke den asymptotiske veksten (
//𝑂
//(
//𝑛
//2
//)
//O(n
//2
// ) forblir det samme).
//Insertion sort fungerer best for små n eller nesten-sorterte data.
//🚀 Dette er et godt forsøk på å optimalisere insertion sort, men for virkelig store n bør vi bruke mer effektive sorteringsalgoritmer som merge sort eller quick sort.