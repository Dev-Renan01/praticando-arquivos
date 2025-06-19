package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoCSV {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream lerArquivo = new FileInputStream(
                new File("C:\\praticando-arquivos\\teste-arquivo\\teste.csv"));

        Scanner sc = new Scanner(lerArquivo, "UTF-8");

        List<Pessoa> pessoas = new ArrayList<>();
        while(sc.hasNext()){// enquanto o meu arquivo tiver dados...

            String linha = sc.nextLine();

            if(linha != null && !linha.isEmpty()) {

                String[] dados = linha.split("\\;");
                Pessoa pessoa = new Pessoa();

                pessoa.setNome(dados[0]);
                pessoa.setEmail(dados[1]);
                pessoa.setIdade(Integer.parseInt(dados[2]));

                pessoas.add(pessoa);
            }
        }
        for(Pessoa p : pessoas){
            System.out.println(p);
        }
    }
}
