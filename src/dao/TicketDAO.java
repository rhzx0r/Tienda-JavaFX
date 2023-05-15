package dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import classes.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TicketDAO implements Serializable {

  public void saveTicket(int clientID, String clientName, List<Product> products, BigDecimal clientMoney, BigDecimal fullImport, BigDecimal change) {

    DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
    Date date = new Date();
    Document document = new Document();

    try {
      
      //* Crea el archivo del ticket */
      File directory = new File("Tickets");

      if (!directory.exists()) {
          directory.mkdir(); //* crea la carpeta si no existe */ 
      }

      File file = new File(directory, "Ticket - " + clientID + " Hora " + dateFormat.format(date) + ".pdf");
      FileOutputStream pdfFile = new FileOutputStream(file);

      PdfWriter.getInstance(document, pdfFile);
      document.open();

      //* Escribe los datos del ticket */
      Paragraph tStoreName = new Paragraph("\n            Abarrotes Tizimin",
          FontFactory.getFont("arial", 12, BaseColor.BLACK));
      document.add(tStoreName);

      Paragraph tDate = new Paragraph( "\nFecha: " + dateGenerator(),
          FontFactory.getFont("arial", 12, BaseColor.BLACK));
      document.add(tDate);
      
      Paragraph tclient = new Paragraph("\nCliente: " + clientName, FontFactory.getFont("arial", 11, BaseColor.BLACK));
      document.add(tclient);

      for (Product p : products) { //* Agrega la lista de productos */
        Paragraph tProduct = new Paragraph("\nProducto: " + p.getProductName() + " ....... $" + p.getPublicPrice() + "  Cant: " + p.getAmount(), FontFactory.getFont("arial", 9, BaseColor.BLACK));
        document.add(tProduct);
      }

      Paragraph tFullImport = new Paragraph("\nTotal: $" + fullImport, FontFactory.getFont("arial", 11, BaseColor.BLACK));
      document.add(tFullImport);

      Paragraph tImport = new Paragraph("\nImporte: $" + clientMoney, FontFactory.getFont("arial", 11, BaseColor.BLACK));
      document.add(tImport);

      Paragraph tChange = new Paragraph("\nCambio: $" + change, FontFactory.getFont("arial", 11, BaseColor.BLACK));
      document.add(tChange);

      Paragraph tFinalMessage = new Paragraph("\n        Gracias por su compra!!!", FontFactory.getFont("arial", 11, BaseColor.BLACK));
      document.add(tFinalMessage);

      //* Cierra el documento */
      document.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private static String dateGenerator() { //* Genera una feccha valida */
    String format = "yyyy-MM-dd HH:mm:ss";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    LocalDateTime now = LocalDateTime.now();
    return formatter.format(now);
  }
}