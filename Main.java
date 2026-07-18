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

class WordDocument extends Document {
    void edit() {
        System.out.println("Editing Word Document");
    }
}

public class Main {

    public static void main(String[] args) {

        // Polymorphic Array
        Document[] docs = {
                new PDFDocument(),
                new WordDocument()
        };

        for (Document d : docs) {

            d.open();

            if (d instanceof PDFDocument) {
                PDFDocument pdf = (PDFDocument) d;
                pdf.compress();
            }

            if (d instanceof WordDocument) {
                WordDocument word = (WordDocument) d;
                word.edit();
            }
        }
    }
}
// Parent class that contains common methods for all document types.

// Common method inherited by all child classes.

// Child class that extends the Document class.

// Method specific to PDFDocument.

// Another child class that extends the Document class.

// Method specific to WordDocument.

// Main method where program execution starts.

// Creating a polymorphic array using the parent class reference.
// The array stores different child class objects.

// Loop through each object in the polymorphic array.

// Calling the common method inherited from the parent class.

// Check if the current object is a PDFDocument using instanceof.

// Downcasting the parent reference to PDFDocument.

// Calling the PDF-specific method.

// Check if the current object is a WordDocument using instanceof.

// Downcasting the parent reference to WordDocument.

// Calling the WordDocument-specific method.