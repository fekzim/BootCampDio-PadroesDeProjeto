package me.Felipe.PadroesDeProjetoJava;

import me.Felipe.PadroesDeProjetoJava.Facade.Facade;
import me.Felipe.PadroesDeProjetoJava.Strategy.*;

public class Test {
    public static void main(String[] args) {

        //Strategy
        Comportamento normal = new ComportamentoNormal();
        Comportamento agressivo = new ComportamentoAgressivo();
        Comportamento defensivo = new ComportamentoDefensivo();

        Robo robo = new Robo();
        robo.setComportamento(agressivo);

        robo.mover();
        robo.mover();

        //Facade

        Facade facade = new Facade();
        facade.migrarCliente("Tester","18076000");
    }
}
