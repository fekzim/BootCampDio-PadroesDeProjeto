package me.Felipe.PadroesDeProjetoJava.Strategy;

public class ComportamentoAgressivo implements Comportamento{
    @Override
    public void mover() {
        System.out.println("Robo se move agressivamente");
    }
}
