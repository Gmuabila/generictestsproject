package genericclasses.hashcodeAndEqualsMethodsDemo;

/*If you are using objects of your own classes, and you have not provided a hashCode method,
the inherited hashCode method from the Object class is called.  This does not behave in the way we would wish.
It generates the hashCode number from the memory address of the object,
so two “equal” objects could have different hashCode values.
Program below demonstrates this.*/
public class Book {

    public String isbn;
    public String author;
    public String title;

    public Book() {
    }

    public Book(String isbn, String author, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int hashCode(){
        return isbn.hashCode();
    }

    public boolean equals(Object obj){
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }

    public String toString(){
        return "[\"Book ISBN\"" + ":" + "\"" + isbn + "\",  " + "\"Author\":" + "\"" + author + "\",  " + "\"Book Title\":\"" + title + "\"]";
    }
}
