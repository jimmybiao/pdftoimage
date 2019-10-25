package com.jimmy;

import java.awt.image.BufferedImage;
import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

public class PdfToJpgDemo {

	public static void main(String[] args) throws Exception{
		File file=new File(".pdf");
		PDDocument doc=PDDocument.load(file);
		PDFRenderer renderer=new PDFRenderer(doc);
		for(int i=0;i<doc.getNumberOfPages();i++) {
			BufferedImage image=renderer.renderImage(i);
			//BufferedImage image=renderer.renderImageWithDPI(i, 300, ImageType.GRAY);
			String fileName="nid-"+i+".jpg";
			ImageIOUtil.writeImage(image, fileName, 300);
		}
		doc.close();
	}
	
	
}
