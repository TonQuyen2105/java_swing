public class Library {

    String name;
    int year;
    Book[] books;
    
    Library(String name, int year, Book[] books) {
        this.name = name;
        this.year = year;
        this.books = books;
    }

    String displayInfo() {
        StringBuilder info = new StringBuilder("Library Name: " + name + ", Year: " + year + "\nBooks:\n");
        for (Book book : books) {
            info.append(book.displayInfo()).append("\n");
        }
        return info.toString();
    }
}
