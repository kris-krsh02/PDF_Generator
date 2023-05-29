import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDF_Gen {
	
	public PDF_Gen(String name) throws IOException {
	PDDocument document = new PDDocument();
	PDPage page = new PDPage(PDRectangle.A4);
	document.addPage(page);
	
	PDPageContentStream contentStream = new PDPageContentStream(document, page);
	contentStream.beginText();
    PDType0Font font = PDType0Font.load(document, new File("C:\\Windows\\WinSxS\\amd64_microsoft-windows-font-truetype-arial_31bf3856ad364e35_10.0.22621.1_none_d4193be3a119442b\\arial.ttf"));
	//contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
	contentStream.setFont(font, 12);
	contentStream.newLineAtOffset(100, 700);
	//name = "Име";
	contentStream.showText(name);
	contentStream.endText();
	contentStream.close();
	document.save("C:\\Users\\krisk\\Desktop\\version1.pdf");
	document.close();
	
	Desktop.getDesktop().open(new File("C:\\Users\\krisk\\Desktop\\version1.pdf"));
	}

	
	
	
}
