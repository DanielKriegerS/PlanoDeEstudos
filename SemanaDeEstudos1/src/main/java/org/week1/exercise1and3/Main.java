package org.week1.exercise1and3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> prices = new ArrayList<>();
        /*
            utilizando arraylist para ser mais realista,
            pesquise sobre como funciona essa estrutura (e note que é uma classe)
            começando já com arraylist para deixar as entradas dinâmicas
        */

        double sum = 0.0; // utilizado pro calculo de média;
        double average = 0.0;

        Scanner sc = new Scanner(System.in);
        // aqui geramos um Scanner (leitor), para entradas do sistema (Sys.in)

        for (int i = 0; i < 3; i++) { // como no exemplo são 3 valores
            double priceToAdd = sc.nextDouble(); // capturando próximo double escrito
            prices.add(priceToAdd); // adicionando valor informado à array
            /*
                poderíamos fazer o comando prices.add(sc.nextDouble()) direto
                porém, por questões de leitura e facilidade de entendimento,
                o recomendado é abstrair esse valor em uma variável e utilizá-la
             */
        }

        for (double price : prices) {
            /*
                loop "for-each / para-cada", assim iteramos dinamicamente
                (sem precisar saber quantia), em cada uma das iterações ("rodadas" do loop)
                o valor presente nessa rodada da array (como se fosse o "i" no for-i
                é associado ao valor informado, em nosso caso "price"
            */
            sum += price; // você está dizendo que "para cada" price, soma recebe soma + preço.
        }

        average = sum / prices.size();
        // pra ver a média, basta dividir a somatória pela quantia de valores (tamanho da lista)

        double biggestPrice = prices.getFirst();
        double minimalPrice = prices.getFirst();
        // aqui usamos métodos da arraylist para pegar o primeiro item da lista como max e min

        for (double price : prices) {
            if (price > biggestPrice) {
                biggestPrice = price;
            }

            if (price < minimalPrice) {
                minimalPrice = price;
            }
        }

        System.out.println("O preço médio é: " + average);
        System.out.println("O maior valor é: " + biggestPrice);
        System.out.println("O menor valor é: " + minimalPrice);
    }
}