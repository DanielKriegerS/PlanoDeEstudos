package org.week2.models.abstraction;

import java.util.ArrayList;

// representação de objetos do tipo "Produto"
public class Product {
    // fique a vontade para representar seus produtos da forma como quiser, apenas lembre de aplicar os conceitos

    /* opcional
        int id;
     */
    public String name;
    public double productValue;

    /*
        há outro exemplo de validação no documento de apoio, porém aqui, para manter a consistência
        iremos replicar as validações criadas no código anterior (com consistência de valores).
        a principal diferença é que teremos a validação do nome e um métdo "acionador",
        responsável pela validação do produto inteiro (esse é quem substitui aquele métdo do exemplo)
     */

    boolean validateProduct() {
        boolean isValidName, isValidPrice;
        isValidName = validateName(this.name);
        isValidPrice = validatePrice(this.productValue);
        /*
            vale muito a pena entender o que this. quer dizer, mas resumindo:
            estamos nos referindo à INSTÂNCIA de produto que chamou o métdo.
            digamos que você fez ProductPartial p = new ProductPartial,
            p é "um bolo feito na forma ProductPartial", considere que a forma representa o "molde"
            no qual foi feito o bolo, enquanto que quem tem as informações é o bolo
                Classe = molde / forma
                Objeto = bolo / representação gerada a partir da classe

            Uma INSTÂNCIA, nada mais é, do que o objeto gerado, no nosso casso o 'p'.
            ao escrever "p.", você está acessando o que há dentro de p (considere a visibilidade).

            para usar validateProduct(), faríamos algo como p.validateProduct(), nesse caso,
            quando chegasse na linha isValidName = validateName(this.name);
            "this.name" está apontando para o name associado à p.
         */

        return isValidName && isValidPrice;
    }

    boolean validateName(String name) {
        return !name.isEmpty();
    }

    public boolean validatePrice(double price) {
        return price > 0;
    }

    public  boolean validatePricesList(ArrayList<Double> prices) {
        return !prices.isEmpty();
    }
}
