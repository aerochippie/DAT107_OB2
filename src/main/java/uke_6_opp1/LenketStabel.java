package uke_6_opp1;
import java.util.EmptyStackException;

public class LenketStabel<T> implements StabelADT<T> {
    private static class Node<T> {
        T data;
        Node<T> neste;

        Node(T data, Node<T> neste) {
            this.data = data;
            this.neste = neste;
        }
    }

    private Node<T> topp;
    private int antall;

    public LenketStabel() {
        topp = null;
        antall = 0;
    }

    @Override
    public void push(T element) {
        topp = new Node<>(element, topp);
        antall++;
    }

    @Override
    public T pop() {
        if (erTom()) {
            throw new EmptyStackException();
        }
        T resultat = topp.data;
        topp = topp.neste;
        antall--;
        return resultat;
    }


    @Override
    public boolean erTom() {
        return topp == null;
    }

    @Override
    public int antall() {
        return antall;
    }
}