import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.PrintWriter;
import java.io.FileWriter;

public class TrabalhoAvaliativo {
    public static void main(String[] args){
        try{
        //Lendo o arquivo
        BufferedReader buffer = new BufferedReader(new FileReader("numeros.txt"));
        String line = "";
        int contInfo = 0;
        while((line = buffer.readLine()) != null) {
            contInfo++;
        }
        buffer.close();
        //criano array com tamanho das linhas
        int[] array = new int[contInfo];
        contInfo = 0;
        //Lendo novamento o arquivo 
        buffer = new BufferedReader(new FileReader("numeros.txt"));
        line = "";
        while((line = buffer.readLine()) != null) {
            int numeros = Integer.parseInt(line);
            array[contInfo] = numeros;
            contInfo++;
        }
        buffer.close();
        //Executando o metódo insertion
        insertionSort(array);
        //Imprimindo ordenado
        for(int contNovo=0; contNovo<array.length;contNovo++){
            System.out.println(array[contNovo]);
        }
        //Executando a collection
        SortedSet<Integer> novo = new TreeSet<>();
        buffer = new BufferedReader(new FileReader("numeros.txt"));
        while((line = buffer.readLine()) != null) {
            int numeros = Integer.parseInt(line);
            novo.add(numeros);
        }
        //imprimindo collection
        System.out.println("+------------+");
        for(Integer value: novo){
            System.out.println(value);
        }
        //Gravando os numeros ordenados em um novo arquivo
        FileWriter arq = new FileWriter ("numerosOrdenados.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.printf("Numeros ordenados %n");
        gravarArq.printf(""+novo);
        //fechando arquivo 
        arq.close();
        //tratamento de exceçoes
        }catch(IOException e){
            System.out.println("Erro de Leitura"); // possiveis erros são tratatos aqui
        }
    }

    public static void insertionSort(int array[]) {
        //Executando insertion
        for (int contNum = 0; contNum < array.length; contNum++) {
            int vetorAtual = array[contNum];
            int vetorNovo = contNum;
            while ((vetorNovo > 0) && (array[vetorNovo - 1] > vetorAtual)) {
                array[vetorNovo] = array[vetorNovo - 1];
                vetorNovo -= 1;
            }
            array[vetorNovo] = vetorAtual;
        }
    }
}