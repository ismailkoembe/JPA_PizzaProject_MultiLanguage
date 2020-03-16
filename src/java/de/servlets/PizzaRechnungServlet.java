/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.servlets;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import de.pizza.control.OrderController;
import de.pizza.model.Pizza;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hasan
 */
@WebServlet(name = "rechnung", urlPatterns = "/generate/myrechnung.pdf")
public class PizzaRechnungServlet extends HttpServlet{
    @Inject
    OrderController orderController;
    
    
      @Override
      public void doGet(HttpServletRequest req, HttpServletResponse resp) {
          
          
          
        Document document = new Document();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfPTable table;
        PdfPTable table1;
       
        
        
        
        try {
            resp.setContentType("application/pdf");
            //benötigter Zugriff auf die im Sessionscope
            //abgelegte Bean
            HttpSession sess = req.getSession();
            if (orderController.getOrders().getSelection().size()>0) {
                           
                
                PdfWriter.getInstance(document, bos);
                
                document.open();
                
                
                 document.addTitle("Ihre Rechnung");
                 document.add(new Paragraph("Ihre Rechnung"));
                 table=new PdfPTable(2);
                  table.addCell("Vorname:");
                    table.addCell(orderController.getOrders().getCustomer().getFirstname());
                    table.addCell("Nachname:");
                    table.addCell(orderController.getOrders().getCustomer().getLastname());
                    table.addCell("Stadt:");
                    table.addCell(orderController.getOrders().getCustomer().getCity());
                    table.addCell("Straße:");
                    table.addCell(orderController.getOrders().getCustomer().getStreet());

                    document.add(table);
                 
                 
                    table = new PdfPTable(3);
                    table.addCell("Pizza Name");
                    table.addCell("Nummer");
                    table.addCell("Einzel Preis");
                                     
                    
                    
                    for (Pizza p : orderController.getOrders().getSelection()) {
                        
                        table.addCell(p.getpType());
                        table.addCell(String.valueOf(p.getNumber()));
                        table.addCell(String.valueOf(p.getPrice()));
                        }
                    document.add(table);
                   double x= orderController.getOrders().totalPrice(orderController.getOrders());
                    document.add(new Paragraph("Gesammt Preis:"+String.valueOf(x)));
                    
                    
                    
                    
                    }
           else{
                 PdfWriter.getInstance(document, bos);
                 document.open();
                document.add(new Paragraph("Session ist abgelaufen  " ));
            }
            document.close();
            try (OutputStream os = resp.getOutputStream()) {
                bos.writeTo(os);
                os.flush();
                //for ( PrintService s : PrintServiceLookup.lookupPrintServices( null, null ) )System.out.println( s.getName() );
            }
          

        } catch (DocumentException | IOException ex) {
            Logger.getLogger(PizzaRechnungServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
}
