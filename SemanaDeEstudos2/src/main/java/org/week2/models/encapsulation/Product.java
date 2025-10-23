package org.week2.models.encapsulation;

import java.util.ArrayList;

public class Product {
    private String name;
    private double productValue;

    /*
        Agora que já temos a definição dos comportamentos, atributos e visibilidades,
        podemos pensar na criação de um novo produto (na instanciação de produto)...
        Da forma como ProductPartial está, podemos instanciar um novo produto com
        "ProductPartial p = new ProductPartial();" que significa utilizar o construtor padrão.
        Como futuramente utilizaremos Spring, vamos deixar um construtor padrão explicito:
     */

    // dica: no IntelliJ você pode usar CRTL + INSERT e selecionar constructor com NONE arguments.
    public Product() {
    }

    // como na pratica um produto sem informações não faz sentido, vamos criar outro construtor:
    public  Product(String name, Double value) {
        /*
            agora, ao criar um novo produto, podemos já receber informações de nome e valor,
            isso nos possibilita aplicar regras diretamente nos atributos.
        */
        boolean isValidName = validateName(name);
        boolean isValidPrice = validatePrice(value);

        if (!isValidName || !isValidPrice) {
            /*
                se o nome ou preço invalido, ocorre uma exceção;
                utilizei uma exceção genérica para exemplificar (pesquise sobre exceções);
                essa lógica de construção de produto provavelmente possa ser simplificada, fica o desafio.
             */
            throw new RuntimeException("O produto é inválido!");
        }

        // se tudo valido, as informações recebidas são atribuído à instância que foi gerada.
        this.name = name;
        this.productValue = value;
    }

    public boolean validateProduct() {
        boolean isValidName, isValidPrice;
        isValidName = validateName(this.name);
        isValidPrice = validatePrice(this.productValue);
        return isValidName && isValidPrice;
    }

    private boolean validateName(String name) {
        return !name.isEmpty();
    }

    private boolean validatePrice(double price) {
        return price > 0;
    }

    private boolean validatePricesList(ArrayList<Double> prices) {
        return !prices.isEmpty();
    }
}
