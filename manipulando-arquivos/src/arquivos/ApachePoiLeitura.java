package arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApachePoiLeitura {
    public static void main(String[] args) throws IOException {
        FileInputStream entrada = new FileInputStream(new File(
                "C:\\praticando-arquivos\\praticando-arquivos\\manipulando-arquivos\\src\\arquivos\\arquivo_excel.xls"));//Entrada

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);/*Prepara o arquivo excel pára ler*/
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);//Pega a primeira planilha do nosso arquivo excel

        Iterator<Row> linhaIterator = planilha.iterator();

        List<Pessoa> pessoas = new ArrayList<>();

        while (linhaIterator.hasNext()) {//enquanto tiver linha no arquivo

            Row linha = linhaIterator.next();//Dados da pessoa na linha

            Pessoa pessoa = new Pessoa();

            Iterator<Cell> celulas = linha.iterator();

            while (celulas.hasNext()) {// Percorrer as celulas
                Cell cell = celulas.next();
                switch (cell.getColumnIndex()) {
                    case 0:
                        pessoa.setNome(cell.getStringCellValue());
                        break;
                    case 1:
                        pessoa.setEmail(cell.getStringCellValue());
                        break;
                    case 2:
                        pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
                        break;
                }
            }//fim das celulas da linha.

            pessoas.add(pessoa);
        }
        entrada.close();// terminou de ler o arquivo excel

        for(Pessoa p : pessoas){
            System.out.println(p);
        }
    }
}