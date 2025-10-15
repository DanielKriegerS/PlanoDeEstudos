package org.week1.exercise2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> prices = readInfos();
            // substituindo criação e leitura da array por métdo

        double average = calculateAverage(prices);
            // substiuindo o calculo de média por métdo

        double biggestPrice = getBiggestPrice(prices);
            // substiuindo o calculo do maior preço por métdo

        double minPrice = getMinimalPrice(prices);
            // substiuindo o calculo do menor preço por métdo


    displayInfos(average, biggestPrice, minPrice);


    }

    /*
        Sobre a estrutura de um métdo:
            *   inicia com a visibilidade (deixaremos public por enquanto);
            *   se o métdo for imutável, tem static (entenda o que é o "static");
            *   tipo de retorno (ou void se não tiver retorno);
            *   nome;
            *   (parâmetros), informações que serão recebidas e processadas.
     */

//  visib  static retorno           nome     (parametros)
    public static ArrayList<Double> readInfos() { // deixei a leitura com nome genérico para reaproveitar
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> prices = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            double priceToAdd = sc.nextDouble();
            prices.add(priceToAdd);
        }

        return prices;
    }

    public static double calculateAverage(ArrayList<Double> prices) {
        //recebe arraylist de doubles, devolve double

        double sum = 0.0;
        double average; // removi a inicialização não utilizada... Tente entender porque não era utilizada.

        for (double price : prices) {
            sum += price;
        }
        average = sum / prices.size();

        return average;
    }

    public static double getBiggestPrice(ArrayList<Double> prices) {
        double bigPrice = prices.getFirst();
        for (double price : prices) {
            if (price > bigPrice) {
                bigPrice = price;
            }
        }

        return bigPrice;
    }

    public static double getMinimalPrice(ArrayList<Double> prices) {
        double minPrice = prices.getFirst();

        for (double price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
        }

        return minPrice;
    }

    public static void displayInfos(double average, double biggestPrice, double minPrice) {
        System.out.println("O preço médio é: " + average);
        System.out.println("O maior valor é: " + biggestPrice);
        System.out.println("O menor valor é: " + minPrice);
    }

}