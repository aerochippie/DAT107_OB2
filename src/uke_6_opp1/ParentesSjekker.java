package uke_6_opp1;

public class ParentesSjekker {
    private static final char[] START_PARENTESER = {'(', '{', '['};
    private static final char[] SLUTT_PARENTESER = {')', '}', ']'};

    public static boolean sjekkParenteser(String s) {
        StabelADT<Character> stabel = new LenketStabel<>();

        for (char c : s.toCharArray()) {
            if (erStartParentes(c)) {
                stabel.push(c);
            } else if (erSluttParentes(c)) {
                if (stabel.erTom() || !erParentesPar(stabel.pop(), c)) {
                    return false;
                }
            }
        }

        return stabel.erTom(); // Må være tom til slutt for å være korrekt
    }

    private static boolean erStartParentes(char c) {
        for (char p : START_PARENTESER) {
            if (c == p) return true;
        }
        return false;
    }

    private static boolean erSluttParentes(char c) {
        for (char p : SLUTT_PARENTESER) {
            if (c == p) return true;
        }
        return false;
    }

    private static boolean erParentesPar(char start, char slutt) {
        return (start == '(' && slutt == ')') ||
                (start == '{' && slutt == '}') ||
                (start == '[' && slutt == ']');
    }
}