package me.Felipe.PadroesDeProjetoJava.Singleton;

public class SingletonEager {
    private static SingletonEager instancia = new SingletonEager();

    private SingletonEager(){
        super();
    }
    public static SingletonEager getInstancia(){
        return instancia;
    }



}
