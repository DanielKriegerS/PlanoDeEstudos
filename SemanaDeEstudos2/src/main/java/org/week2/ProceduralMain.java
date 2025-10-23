package org.week2;

import java.util.ArrayList;
import java.util.Scanner;

public class ProceduralMain {
    /*
        Mantive essa versão procedural, para demonstrar as validações,
        se houver alguma que você acrescentou, que não está aqui, fique a vontade para complementar.
        Use essa Classe como base para a abstração das informações das Classes
        a continuidade dessa tarefa se dará na package .models
        criamos essa package para separar classes que representam objetos (futuramente entidades)
        de outras classes com outras funcionalidades.
     */

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        ArrayList<Double> prices = initializePrices();

        int selection;

        // o valor da seleção já está sendo validado através do nosso comportamento default
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

    public static void readInfos(ArrayList<Double> actualPrices) {
        Scanner sc = new Scanner(System.in);
        double priceToAdd = sc.nextDouble();

        // função para validar o preço (vamos fazê-la retornar verdadeiro ou falso)
        boolean isvalidPrice = validatePrice(priceToAdd);

        if (isvalidPrice) {
            actualPrices.add(priceToAdd);
            // se é válido, adicionamos e encerramos a função
            return;
        }
        // se não é válido, chega aqui
        System.out.println("O preço informado é inválido.");

        // pense sobre essa solução, porque precisamos retornar boolean, ao invés de encerrar na validação?
    }

    public static void calculateAverage(ArrayList<Double> prices) {
        // chamando validação de lista
        boolean isValidList = validatePricesList(prices);

        // aqui usaremos o conceito de "Fail First", evitando processamento, sugiro pesquisar (5 minutos de pesquisa resolve)
        if (!isValidList) {
            System.out.println("Sem itens para calcular a média.");
            return;
        }

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
        boolean isValidList = validatePricesList(prices);

        if (!isValidList) {
            System.out.println("Sem itens para exibir infos.");
            return;
        }

        double bigPrice = getBiggestPrice(prices);
        double minPrice = getMinimalPrice(prices);
        System.out.println("O maior valor é: " + bigPrice);
        System.out.println("O menor valor é: " + minPrice);
    }

    public static boolean validatePrice(double price) {
        // como é boolean, você pode retornar uma equação e o resultado será o retorno
        return price > 0;
        // preço é maior que 0? então true (válido)
    }

    public static boolean validatePricesList(ArrayList<Double> prices) {
        // se preços não está vazio... true
        return !prices.isEmpty();
    }
}