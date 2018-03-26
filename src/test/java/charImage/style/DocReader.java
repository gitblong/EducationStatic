package charImage.style;

import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.File;
import java.io.FileInputStream;

public class DocReader {
    public void readDocFile() {
        File docFile = null;
        WordExtractor docExtractor = null;
        WordExtractor exprExtractor = null;
        try {
            docFile = new File("f:/4/1.docx");

            FileInputStream fis = new FileInputStream(docFile.getAbsolutePath());



            docExtractor = new WordExtractor(fis);
        } catch (Exception exep) {
            System.out.println(exep.getMessage());
        }


        String[] docArray = docExtractor.getParagraphText();

        for (int i = 0; i < docArray.length; i++) {
            if (docArray[i] != null)
                System.out.println("Line " + i + " : " + docArray[i]);
        }
    }

    public static void main(String[] args) {
        DocReader reader = new DocReader();
        reader.readDocFile();
    }
}