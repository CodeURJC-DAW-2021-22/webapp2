package es.codeurjc.Flyventas.tecnologypdf;


import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import es.codeurjc.Flyventas.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Map;

@Component("resumen")
public class PdfCreator extends AbstractPdfView {



    @Override
    protected void buildPdfDocument(Map<String, Object> model, com.lowagie.text.Document document,
                                    com.lowagie.text.pdf.PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        PdfPTable tableproduct = new PdfPTable(4);

        PdfPTable title = new PdfPTable(1);
        PdfPCell cell = null;
        cell = new PdfPCell(new Phrase("Recibo:"));
        cell.setBorder(0);
        cell.setBackgroundColor(new Color(0, 204, 204));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(20);

        tableproduct.addCell(cell);
        title.setSpacingAfter(30);





        document.setPageSize(PageSize.LETTER.rotate());
        document.open();

        Product Product = (Product)model.get("Product");
        //Optional<Transaction> Transaction = (Optional<es.codeurjc.Flyventas.model.Transaction>) model.get("Transaction");


            tableproduct.addCell(Product.getTitle());
            tableproduct.addCell(Product.getDescription());
            tableproduct.addCell(String.valueOf(Product.getPrice()));
            //tableproduct.addCell(Transaction.get().getDate());

        document.add(title);
        document.add(tableproduct);
    }

}