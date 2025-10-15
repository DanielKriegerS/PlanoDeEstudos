package org.week1.exercise4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // nosso main agora tem apenas a função de "porta de entrada" do sistema
        menu();
    }

    public static void menu() {
        // ao iniciar o menu, vamos inicializar nossos preços ("produtos")
        ArrayList<Double> prices = initializePrices();

        // criamos uma variável que representa o item do menu selecionado
        int selection;

        // loop de seleção do usuário
        while (true) {
            // fique a vontade para fazer seu próprio menu.
            displayMenu();

            Scanner menuSelection = new Scanner(System.in);
            selection = menuSelection.nextInt();

            // aqui vamos usar a estrutura SWITCH-CASE para alternar entre opções, pesquise ela :)
            switch (selection) {
                case 1:
                    System.out.println("Opção 1 selecionada...");
                    insertProduct(prices); // por enquanto, "inserir produto" é apenas inserir um preço novo.
                    return;
                case 2:
                    System.out.println("Opção 2 selecionada...");
                    calculateAverage(prices);
                    return;
                case 3:
                    System.out.println("Opção 3 selecionada...");
                    displayInfos(prices); // apenas listar o maior e o menor valor.
                /*
                    vamos "inverter" essa funcionalidade, ao inves de receber os dados para exibir
                    vamos receber a lista e calcular internamente os dados (usando nossos métodos de calculo)
                 */
                case 0:
                    // saiu do loop, você pode incrementar.
                    System.out.println("Você está saindo do sistema, muito obrigado e volte sempre.");
                default:
                    System.out.println("Opção selecionada é inválida.");
            }
        }

    }

    public static ArrayList<Double> initializePrices() {
        /*
            isso é uma forma de se inicializar a variável... Poderia ser feito no menu(),
            porém, ao ler o nome do métdo, já subentende; "new ArrayList<>()" pode não
            ser tão intuitivo, por mais que a variável tenha um nome explicativo.
            Pense sempre em um sistema mais complexo e com informações mais abstratas...
            poderia ser mais dificil de identificar.
         */
        return new ArrayList<>();
    }

    public static void displayMenu() {
        System.out.println("Bem-vindo!");
        System.out.println("Informe uma opção:");
        System.out.println("1 - Cadastrar produto"); // irei deixar esta opção
                                                    // para que você crie (ou no package "result")
        System.out.println("2 - Calcular preço médio");
        System.out.println("3 - Listar produtos"); // na verdade iremos demonstrar mais caro e barato
        System.out.println("0 - Sair.");
    }

    public static void insertProduct(ArrayList<Double> actualPrices) {
        // aqui você pode querer utilizar readInfos(), e adicionar alguns prints para o usuário
        // e fazer alguns ajustes no métdo de leitura
    }

    public static ArrayList<Double> readInfos() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> prices = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            double priceToAdd = sc.nextDouble();
            prices.add(priceToAdd);
        }

        return prices;
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