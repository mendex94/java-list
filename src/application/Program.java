package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Anna");
        list.add(2, "Marco");

        System.out.println(list.size());

        for (String x : list) {
            System.out.println(x);
        }

        System.out.println("---------------------");

        list.remove("Anna");
        list.remove(1);

        for (String x : list) {
            System.out.println(x);
        }

        System.out.println("---------------------");

        // Função lambda do tipo predicado que retorna true ou false para cada elemento da lista e remove os elementos que retornam true;
        list.removeIf(x -> x.charAt(0) == 'M');

        for (String x : list) {
            System.out.println(x);
        }

        System.out.println("---------------------");

        System.out.println("Index of Bob: " + list.indexOf("Bob"));

        System.out.println("---------------------");

        // Nesse caso devemos converter list para o tipo stream que aceita expressões lambda e depois coletar os elementos que retornam true;
        // O método collect(Collectors.toList()) coleta os elementos que retornam true e os armazena em uma nova lista;
        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());

        for (String x : result) {
            System.out.println(x);
        }

        System.out.println("---------------------");

        // O método findFirst() retorna o primeiro elemento que atende a condição do predicado ou null caso não encontre nenhum;
        String name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);

        System.out.println(name);
    }
}
