/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.lowagie.text.DocWriter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.pdf.PdfWriter;
import dataclasses.UploadHelperDto;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import views.QuotationScreen;

/**
 *
 * @author sreenath
 */
public class FileHandler {

    public static String getCopiedFilePath(File selectedFile) {
        try {
            String name = selectedFile.getName();
            String destination = Constants.BASE_DIRECTORY + name;

            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };

            Path path = Files.copy(selectedFile.toPath(), new File(destination).toPath(), options);
            return destination;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static File showFileChooser(String description, List<String> extensions) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile = null;
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(description, extensions.get(0), extensions.get(1)));
        chooser.setAcceptAllFileFilterUsed(false);

        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
        }
        return selectedFile;
    }

    public static List<UploadHelperDto> getExcelData(File file) {
        List<UploadHelperDto> uploadHelperDtos = new ArrayList<>();
        try {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                UploadHelperDto helperDto = new UploadHelperDto();
                for (Cell cell : row) {  
                    if (cell.getCellType() == CellType.NUMERIC) {
                        helperDto.getColumnValues().add("" + cell.getNumericCellValue());
                    } else if (cell.getCellType() == CellType.STRING) {
                        helperDto.getColumnValues().add("" + cell.getRichStringCellValue());
                    } else if (cell.getCellType() == CellType.BLANK) {
                        helperDto.getColumnValues().add("");
                    } else {
                        helperDto.getColumnValues().add("" + cell.getDateCellValue());
                    }
                }
                uploadHelperDtos.add(helperDto);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncryptedDocumentException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uploadHelperDtos;
    }

    /**
     * To export data to excel file.
     *
     * @param table
     * @param file
     * @throws IOException
     */
    public static boolean exportTableToExcel(JTable table, String name) throws IOException {
        boolean isExcelExported = false;
        FileWriter out = null;
        File file = new File(Constants.EXCEL_EXPORT_PATH);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            TableModel model = table.getModel();
            out = new FileWriter(Constants.EXCEL_EXPORT_PATH + name);
            for (int i = 0; i < model.getColumnCount(); i++) {
                out.write(model.getColumnName(i) + "\t");
            }
            out.write("\n");
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    out.write(model.getValueAt(i, j).toString() + "\t");
                }
                out.write("\n");
            }
            isExcelExported = true;
        } catch (Exception e) {
            isExcelExported = false;
        } finally {
            out.close();
        }
        return isExcelExported;
    }

    private static String getColumnNames(Workbook workbook) {
        Sheet sheet = workbook.getSheetAt(0);
        String column = "";
        for (Row row : sheet) {
            for (Cell cell : row) {
                column += (column.length() > 0 ? "," + cell.getStringCellValue() : cell.getStringCellValue());
            }
            break;
        }
        return column;
    }

    private static String getColValue(String colType, Cell cell) {
        switch (colType) {
            case "NUMERIC":
                return cell.getStringCellValue();
            case "STRING":
                return "'" + cell.getStringCellValue() + "'";
            default:
                return "";
        }
    }

    public static boolean WriteToPdfFile(String file, String content) {
        try {
            File directory = new File(file.substring(0, file.lastIndexOf(File.separator)));
            if (! directory.exists()){
                directory.mkdir();
            }
            
            final Document document = new Document();
            DocWriter docWriter = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            HTMLWorker worker = new HTMLWorker(document);

            worker.parse(new StringReader(content));

            document.close();
            docWriter.close();

            return true;
        } catch (Exception ex) {
            Logger.getLogger(QuotationScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
