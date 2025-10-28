public class _27th_aggregation {
    public static void main(String[] args) {
        Book book = new Book("1984", "George Orwell", 328);
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 281);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 180);

        Book[] books = {book, book1, book2};

        for (Book b : books) {
            System.out.println(b.displayInfo());
        }

        Library library = new Library("City Library", 1995, books);
        System.out.println(library.displayInfo());

    }
}
