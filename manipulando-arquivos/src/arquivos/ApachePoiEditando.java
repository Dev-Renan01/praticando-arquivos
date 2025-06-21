package arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.Iterator;

public class ApachePoiEditando {
    public static void main(String[] args) throws IOException {
        File file = new File(
                "C:\\praticando-arquivos\\praticando-arquivos\\manipulando-arquivos\\src\\arquivos\\arquivo_excel.xls");

        FileInputStream entrada = new FileInputStream(file);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);//Prepara a entrada do arquivo xls do excel

        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);//Pegando a planilha

        Iterator<Row> linhaIterator = planilha.iterator();

        while(linhaIterator.hasNext()){// enquanto tiver dados...
            Row linha = linhaIterator.next();//Dados da pessoa na linha

            int numeroCelulas = linha.getFirstCellNum();// Quantidade de celulas

            Cell cell = linha.createCell(numeroCelulas);//cria nova celula na linha

            cell.setCellValue("5.487,20");
        }
        entrada.close();

        FileOutputStream saida = new FileOutputStream(file);

        hssfWorkbook.write(saida);
        saida.flush();
        saida.close();

        System.out.println("Plannilha atualizada com sucesso!");
    }
}