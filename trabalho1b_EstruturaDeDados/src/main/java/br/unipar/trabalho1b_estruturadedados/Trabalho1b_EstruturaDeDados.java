
package br.unipar.trabalho1b_estruturadedados;

import javax.swing.JOptionPane;

/**
 *
 * @author Beatr
 */
public class Trabalho1b_EstruturaDeDados {

    public static void main(String[] args) {
         
        int n;
        String input = JOptionPane.showInputDialog("Informe o tamanho do vetor:");
        n = Integer.parseInt(input);
        
        int []vetor = new int[n];
        for(int i=0; i < vetor.length; i++){
            String inputVetor = JOptionPane.showInputDialog("Informe um número inteiro:");
            vetor[i] = Integer.parseInt(inputVetor);
        }
        
        System.out.println("Ordenção Original:");
        for(int i=0; i < vetor.length; i++){ 
            System.out.println("vetor[" + i + "] = " + vetor[i]);
        }

        String ordenacao;
        String inputOrdenacao = JOptionPane.showInputDialog("Informe a ordenação que deseja usar(inserção, seleção ou bolha:");
        ordenacao = inputOrdenacao;
        
     
        switch (ordenacao) {
            case "inserção":
                
                long inicio = System.currentTimeMillis();
                
                int chave, j;
                for(int i=1; i < vetor.length; i++){
                    chave = vetor[i];
                    for(j=i-1; (j>=0 && vetor[j]>chave); j--){
                        vetor[j+1] = vetor[j];
                    }
                    vetor[j+1] = chave;
                }   
                
                long fim = System.currentTimeMillis();
                long tempo = fim - inicio;
                
                System.out.println("Ordenação Inserção:"  );
                for(int i=0; i < vetor.length; i++){ 
                    System.out.println("vetor[" + i + "] = " + vetor[i]);  
                }  
                System.out.println("Tempo de execução: " + tempo);
                
                break;
            case "seleção":
                
                long inicio2 = System.currentTimeMillis();
                
                for(int i=0; i < vetor.length - 1; i++){
                    int menor = i;
                    for(int f=i+1; f < vetor.length; f++){
                        if(vetor[f] < vetor[menor]){
                            menor = f;
                        }
                    }
                    if(menor != i){
                        int aux = vetor[i];
                        vetor[i] = vetor[menor];
                        vetor[menor] = aux;
                    }
                }   
                
                long fim2 = System.currentTimeMillis();
                long tempo2 = inicio2 - fim2;
                
                System.out.println("Ordenação Seleção:");
                for(int i=0; i < vetor.length; i++){ 
                    System.out.println("vetor[" + i + "] = " + vetor[i]); 
                }  
                
                System.out.println("Tempo de execução: " + tempo2);
                
                break;
            case "bolha":
                
                long inicio3 = System.currentTimeMillis();
                
                boolean troca = true;
                while(troca){
                    troca = false;
                    for(int i=0; i < vetor.length - 1; i++){
                        if(vetor[i] > vetor[i+1]){
                            int aux = vetor[i];
                            vetor[i] = vetor[i+1];        
                            vetor[i+1] = aux;
                            troca = true;
                        }
                    }
                }   
                
                long fim3 = System.currentTimeMillis();
                long tempo3 = inicio3 - fim3;
                
                System.out.println("Ordenação Bolha:");
                for(int i=0; i < vetor.length; i++){ 
                    System.out.println("vetor[" + i + "] = " + vetor[i]);
                }  
                
                System.out.println("Tempo de execução: " + tempo3);
                
                break;    
            default:
                System.out.println("opção inválida");
                break;
        }
        
        System.out.println("\n\nComparação dos 3 métodos:");
        
        System.out.print("\nOrdenação Inserção:\tOrdenação Seleção\t:Ordenação Bolha:\n");
        
        
        for(int i=0; i < vetor.length; i++){ 
            int insercao = vetor[i];
            int selecao = vetor[i];
            int bolha = vetor[i];
            System.out.printf("%-19d\t%-19d\t%-19d\n", insercao, selecao, bolha);
        } 
     
                     
        
    }
}
