package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivosTXT {
    public static void main(String[] args) throws IOException {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Thiago Renan");
        pessoa1.setEmail("thiago@gmail.com");
        pessoa1.setIdade(18);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Suany Souza");
        pessoa2.setEmail("Suany@gmail.com");
        pessoa2.setIdade(20);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Regis ark");
        pessoa3.setEmail("Regis@gmail.com");
        pessoa3.setIdade(45);

        /*Pode vir do banco de dados ou qualqueer fonte*/
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        File arquivo = new File("C:\\praticando-arquivos\\teste-arquivo\\teste.txt");

        if (!arquivo.exists()) {
            arquivo.createNewFile(); // Criar novo arquivo
        }

        FileWriter escreverNoArquivo = new FileWriter(arquivo); //Escrevendo no arquivo

        for(Pessoa p : pessoas){

            escreverNoArquivo.write( p.getNome()
                    + ";"+ p.getEmail() + ";"+ p.getIdade() + "\n");
        }

        escreverNoArquivo.flush();
        escreverNoArquivo.close(); // fechar





    }
}
