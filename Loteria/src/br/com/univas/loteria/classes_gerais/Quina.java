
package br.com.univas.loteria.classes_gerais;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
public class Quina implements Loterias {
    
    // Atributos
    
    public ArrayList<Integer> dezenas = new ArrayList();
    
    
     //Metodos
    //Os métodos a seguir foi explicado o seu funcionamento na classe interface.
    
    @Override
      public ArrayList<Integer> getDezenas() {
        return dezenas;
    }

    public void setDezenas(ArrayList<Integer> dezenas) {
        this.dezenas = dezenas;
    }
     
  
    @Override
    public boolean validacao(int valida) {
        if (valida < 1 || valida > 80){
            return false;
        }
        return true;
    }

    @Override
    public void setDezenas(int dezenas) {
        this.dezenas.add(dezenas);
    }

    @Override
    public int confere(ArrayList<Integer> aposta, ArrayList<Integer> jogo) {
        int cont = 0;
        for(int i = 0; i < aposta.size(); i++){
            for(int j = 0; j < jogo.size(); j++ ){
                if (aposta.get(i) == jogo.get(j)){
                    cont++;
                    //continue;
                }
            }
        }
        return cont;       
    }

    @Override
    public void randomicos() {
        
         int find = 0;
        int c, i = 0;
        ArrayList num = new ArrayList();
        Random rdm = new Random();

//construindo o array sem repetição
        for (i = 0; i < 5; i++) {
            find = rdm.nextInt(80) + 1;
            if (i == 0) {
                num.add(find);
            } else {
                c = 0;
                while (c < i) {
                    if (num.get(c).equals(find)) {
                        find = rdm.nextInt(5) + 1;
                        c = 0;
                    } else {
                        c++;
                    }
                }
                num.add(find);
            }
            //Ordenando a lista
            Collections.sort(num);
        }
        //imprimindo a lista
        System.out.println("SEU JOGO ALEATORIO QUINA");
        System.out.print(num);
        System.out.println("");
        System.out.println("");
        
    }

    @Override
    public void cincoMais(ArrayList<Integer> vet) {
        
        System.out.println("CINCO NUMEROS QUE MAIS SAIRAM: ");

         vet.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
         .sorted(Map.Entry.<Integer, Long>comparingByValue()
         .reversed())
         .limit(5)
         .forEachOrdered(e -> System.out.println("Nº " + e.getKey() + " apareceu " + e.getValue() + " vezes"));
         System.out.println("");
        
    }

    @Override
    public void cincoMenos(ArrayList<Integer> vet) {
       
        System.out.println("CINCO NUMEROS QUE MENOS SAIRAM: ");
        vet.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
        .sorted(Map.Entry.<Integer, Long>comparingByValue())
        .limit(5)
        .forEachOrdered(e -> System.out.println("Nº " + e.getKey() + " apareceu " + e.getValue() + " vezes"));
        System.out.println("");
        
    }
}
