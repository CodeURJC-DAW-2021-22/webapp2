package es.codeurjc.Flyventas.Tecnology;


import com.lowagie.text.pdf.PdfPTable;
import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.model.Transaction;
import es.codeurjc.Flyventas.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@Component("/resumen/5/12345")
public class PdfCreator extends AbstractPdfView {



    @Override
    protected void buildPdfDocument(Map<String, Object> model, com.lowagie.text.Document document,
                                    com.lowagie.text.pdf.PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        PdfPTable tableproducto = new PdfPTable(4);


        Optional<Product> Product = (Optional<es.codeurjc.Flyventas.model.Product>) model.get("Product");
        //Optional<Transaction> Transaction = (Optional<es.codeurjc.Flyventas.model.Transaction>) model.get("Transaction");


            tableproducto.addCell(Product.get().getTitle());
            tableproducto.addCell(Product.get().getDescription());
            tableproducto.addCell(String.valueOf(Product.get().getPrice()));
            //tableproducto.addCell(Transaction.get().getDate());

        document.add(tableproducto);
    }

}