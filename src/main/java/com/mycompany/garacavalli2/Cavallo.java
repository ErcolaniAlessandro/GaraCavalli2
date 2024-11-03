package com.mycompany.garacavalli2;

import java.util.Random;

class Cavallo extends Thread {
    private final String nome;
    private final int lunghezzaGara;
    private final int velocita; // metri al secondo
    private int distanzaPercorsa = 0;
    private boolean infortunato = false; // stato di infortunio
    private static final Random random = new Random();
    
    public Cavallo(String nome, int lunghezzaGara, int velocita) {
        this.nome = nome;
        this.lunghezzaGara = lunghezzaGara;
        this.velocita = velocita;
    }

    public int getDistanzaPercorsa() {
        return distanzaPercorsa;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void run() {
        while (distanzaPercorsa < lunghezzaGara && !infortunato) {
            distanzaPercorsa += velocita;
            System.out.println(nome + " ha percorso " + distanzaPercorsa + " metri");

            // Simulazione dell'infortunio con una probabilità del 5%
            if (random.nextInt(100) < 5) {
                infortunato = true;
                System.out.println(nome + " si è infortunato ed è fuori gara!");
                break;
            }

            try {
                Thread.sleep(1000); // Simula un secondo per ogni iterazione
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!infortunato) {
            System.out.println(nome + " ha terminato la gara!");
        }
    }
}
