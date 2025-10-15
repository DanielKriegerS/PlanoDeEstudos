package org.week1.result;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
        Como um bonus, tente executar 2 e 3 antes de 1. Consegue imaginar porque isso acontece?
        Nosso processamento, nesse ponto em que estamos em result\Main, está completo,
        entretanto, não temos um sistema de validações.
        Em que lugar poderíamos adicionar as validações? o que podemos validar?
        Tente fazer essas abstrações antes de prosseguir.
        Em geral, temos o objetivo de manter apenas 1 funcionalidade por métdo...
        Olhe para nosso menu(), ele segue esta regra?
     */

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        ArrayList<Double> prices = initializePrices();

        int selection;

        while (true) {
            displayMenu();

            Scanner menuSelection = new Scanner(System.in);
            selection = menuSelection.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Opção 1 selecionada...");
                    insertProduct(prices);
                    break;
                case 2:
                    System.out.println("Opção 2 selecionada...");
                    calculateAverage(prices);
                    break;
                case 3:
                    System.out.println("Opção 3 selecionada...");
                    displayInfos(prices);
                    break;
                case 0:
                    System.out.println("Você está saindo do sistema, muito obrigado e volte sempre.");
                    return;
                default:
                    System.out.println("Opção selecionada é inválida.");
            }
        }

    }

    public static ArrayList<Double> initializePrices() {
        return new ArrayList<>();
    }

    public static void displayMenu() {
        System.out.println("Bem-vindo!");
        System.out.println("Informe uma opção:");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Calcular preço médio");

        System.out.println("3 - Listar produtos");
        System.out.println("0 - Sair.");
    }

    public static void insertProduct(ArrayList<Double> actualPrices) {
        System.out.println("Informe o valor a ser adicionado:"); // iremos atualizar para produto depois
        readInfos(actualPrices);
    }

//    public static ArrayList<Double> readInfos() {
    public static void readInfos(ArrayList<Double> actualPrices) {
        // agora, ao invés de gerar a lista toda vez, estamos atualizando a lista existente.
        Scanner sc = new Scanner(System.in);
        /*
            ArrayList<Double> prices = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                double priceToAdd = sc.nextDouble();
                prices.add(priceToAdd);
            }
            alem disso, o loop para ler três preços não é mais necessário, vamos
            executar de acordo com a interação do usuário
         */

        double priceToAdd = sc.nextDouble();
        actualPrices.add(priceToAdd);
    }

    public static void calculateAverage(ArrayList<Double> prices) {
        double sum = 0.0;
        double average;

        for (double price : prices) {
            sum += price;
        }
        average = sum / prices.size();

        System.out.println("A média atual é: " + average);
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

    public static void displayInfos(ArrayList<Double> prices) {
        double bigPrice = getBiggestPrice(prices);
        double minPrice = getMinimalPrice(prices);
        System.out.println("O maior valor é: " + bigPrice);
        System.out.println("O menor valor é: " + minPrice);
    }
}