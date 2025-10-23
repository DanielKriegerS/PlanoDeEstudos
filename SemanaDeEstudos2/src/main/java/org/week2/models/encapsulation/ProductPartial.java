package org.week2.models.encapsulation;

import java.util.ArrayList;

public class ProductPartial {
    // tornando os atributos privados.
    private String name;
    private double productValue;

    /*
        Com relação aos métodos, há algo a se pensar... Aquilo que a classe FAZ deve ser
        acessível em outras classes, para que elas utilizem essas funções.
        Entretanto, alguns métodos não são exatamente o que ela FAZ e sim COMO ela faz,
        por exemplo abaixo, ao chamar validateProduct o que classe está FAZENDO é validar o produto
        agora, como essa validação é feita, não precisa ser vísivel em outras classes.
     */

    // a validação FEITA pelo produto ficará vísivel
    public boolean validateProduct() {
        boolean isValidName, isValidPrice;
        isValidName = validateName(this.name);
        isValidPrice = validatePrice(this.productValue);
        return isValidName && isValidPrice;
    }

    // o COMO validar nome, pode ser de responsabilidade e visibilidade apenas da classe
    private boolean validateName(String name) {
        return !name.isEmpty();
    }

    // o mesmo do nome se aplica ao preço
    private boolean validatePrice(double price) {
        return price > 0;
    }

    // o mesmo do nome também se aplica à lista de preços
    private boolean validatePricesList(ArrayList<Double> prices) {
        return !prices.isEmpty();
    }
}
