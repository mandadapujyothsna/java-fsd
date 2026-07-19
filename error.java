class Document {
    void open() {
        System.out.println("Opening document");
    }
}

class PDFDocument extends Document {
    void compress() {
        System.out.println("Compressing PDF");
    }
}

public class error {
    public static void main(String[] args) {

        PDFDocument doc = new PDFDocument();

        doc.open();
        doc.compress();
    }
}