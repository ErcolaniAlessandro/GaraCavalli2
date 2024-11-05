package com.mycompany.garacavalli2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GaraCavalli2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Inserisci la lunghezza del percorso di gara (in metri): ");
        int lunghezzaGara = scanner.nextInt();
        scanner.nextLine();

        
        System.out.print("Inserisci i nomi dei cavalli separati da virgola: ");
        String[] nomiCavalli = scanner.nextLine().split(",");

        List<Cavallo> cavalli = new ArrayList<>();

        
        for (String nome : nomiCavalli) {
            System.out.print("Inserisci la velocità di " + nome.trim() + " (metri al secondo): ");
            int velocita = scanner.nextInt();
            scanner.nextLine();

            
            Cavallo cavallo = new Cavallo(nome.trim(), lunghezzaGara, velocita);
            cavalli.add(cavallo);
        }

        
        for (Cavallo cavallo : cavalli) {
            cavallo.start();
        }

        
        for (Cavallo cavallo : cavalli) {
            try {
                cavallo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        
        List<Cavallo> classifica = new ArrayList<>(cavalli);
        Collections.sort(classifica, Comparator.comparingInt(Cavallo::getDistanzaPercorsa).reversed());

        System.out.println("\nClassifica finale:");
        for (int i = 0; i < Math.min(3, classifica.size()); i++) {
            System.out.println((i + 1) + "° posto: " + classifica.get(i).getNome() +
                               " con " + classifica.get(i).getDistanzaPercorsa() + " metri");
        }

        System.out.println("La gara è terminata!");
        scanner.close();
    }
}
