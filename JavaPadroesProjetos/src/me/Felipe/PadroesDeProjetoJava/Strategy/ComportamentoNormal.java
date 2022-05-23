package me.Felipe.PadroesDeProjetoJava.Strategy;

public class ComportamentoNormal implements Comportamento{
    @Override
    public void mover() {
        System.out.println("Robo se move normalmente");
    }
}
