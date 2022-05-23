package me.Felipe.PadroesDeProjetoJava.Strategy;

public class ComportamentoDefensivo implements Comportamento{
    @Override
    public void mover() {
        System.out.println("Robo se move Defensivamente");
    }
}
