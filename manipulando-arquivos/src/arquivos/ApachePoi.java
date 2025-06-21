package arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApachePoi {
    public static void main(String[] args) throws IOException {
        File file = new File(
                "C:\\praticando-arquivos\\praticando-arquivos\\manipulando-arquivos\\src\\arquivos\\arquivo_excel.xls");

        if(!file.exists()){
            file.createNewFile();
        }

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

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();/*Usado para escrever a planilha*/

        HSSFSheet linhaPessoas = hssfWorkbook.createSheet("Planilha de passoa, Dev-Renan");/*Criar a planilha*/

        int numeroLinhas = 0;
        for(Pessoa p : pessoas){//para cada pessoa eu vou criar uma linha e colocar suas celulas
            Row linha = linhaPessoas.createRow(numeroLinhas++);/*Criando a linha na planilha*/

            int celula = 0;
            Cell celNome = linha.createCell(celula++);//celula 01
            celNome.setCellValue(p.getNome());

            Cell celEmail= linha.createCell(celula++);//celula 02
            celNome.setCellValue(p.getEmail());

            Cell celIdade = linha.createCell(celula++);//celula 03
            celIdade.setCellValue(p.getIdade());
        }/*Terminou de montar a planilha*/

        FileOutputStream saida = new FileOutputStream(file);

        hssfWorkbook.write(saida);//escreve a planilha em arquivo

        saida.flush();
        saida.close();

        System.out.println("Planilha criada com sucesso!");

    }
}