/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.view.document;

import us.greatapps4you.greatsales.desktop.common.FileUtil;
import com.lowagie.text.DocumentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringBufferInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

public class PdfCreator {
    public PdfCreator() {
    }

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, FileNotFoundException, DocumentException {
        String html = "<html><h1>Ola grandao</h1><br/><h4>Ola menor</h4></html>";
        PdfCreator pdfCreator = new PdfCreator();
        pdfCreator.savePdf(html, html);
    }

    public String createFromHtml(String html, String pdfFileName) throws ParserConfigurationException, SAXException, FileNotFoundException, DocumentException, IOException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new StringBufferInputStream(html));
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(doc, (String)null);
        String pdfPath = FileUtil.getHome() + "pdf/";
        File pdfDir = new File(pdfPath);
        if (!pdfDir.exists()) {
            pdfDir.mkdirs();
        }

        String outputFile = pdfPath + pdfFileName + ".pdf";
        OutputStream os = new FileOutputStream(outputFile);
        Throwable var10 = null;

        try {
            renderer.layout();
            renderer.createPDF(os);
        } catch (Throwable var19) {
            var10 = var19;
            throw var19;
        } finally {
            if (os != null) {
                if (var10 != null) {
                    try {
                        os.close();
                    } catch (Throwable var18) {
                        var10.addSuppressed(var18);
                    }
                } else {
                    os.close();
                }
            }

        }

        return outputFile;
    }

    public String savePdf(String html, String pdfFileName) throws ParserConfigurationException, SAXException, FileNotFoundException, DocumentException, IOException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new StringBufferInputStream(html));
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(doc, (String)null);
        String pdfPath = FileUtil.getHome() + "pdf/";
        File pdfDir = new File(pdfPath);
        if (!pdfDir.exists()) {
            pdfDir.mkdirs();
        }

        String outputFile = pdfFileName + ".pdf";
        OutputStream os = new FileOutputStream(outputFile);
        Throwable var10 = null;

        try {
            renderer.layout();
            renderer.createPDF(os);
        } catch (Throwable var19) {
            var10 = var19;
            throw var19;
        } finally {
            if (os != null) {
                if (var10 != null) {
                    try {
                        os.close();
                    } catch (Throwable var18) {
                        var10.addSuppressed(var18);
                    }
                } else {
                    os.close();
                }
            }

        }

        return outputFile;
    }
}
