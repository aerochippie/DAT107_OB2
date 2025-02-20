package uke_6_opp1;

public interface StabelADT<T> {
    void push(T element);
    T pop();

    boolean erTom();
    int antall();
}