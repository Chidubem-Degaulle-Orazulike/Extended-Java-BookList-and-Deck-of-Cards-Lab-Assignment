public class Book {
    private String title;
    private String author;
    private long isbn;
    private int pages;
    private int copiesInCollection;
    private int copiesOnLoan;

    //1, complete this class with a constructor that has arguments for all the properties
    //and, getters and setters for each of them

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getIsbn() {
        return this.isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCopiesInCollection() {
        return this.copiesInCollection;
    }

    public void setCopiesInCollection(int copiesInCollection) {
        this.copiesInCollection = copiesInCollection;
    }

    public int getCopiesOnLoan() {
        return this.copiesOnLoan;
    }

    public void setCopiesOnLoan(int copiesOnLoan) {
        this.copiesOnLoan = copiesOnLoan;
    }

    public Book(String Title, String Author, Long ISBN, int Pages, int CopiesInCollection, int CopiesOnLoan) {
        this.title = Title;
        this.author = Author;
        this.isbn = ISBN;
        this.pages = Pages;
        this.copiesInCollection = CopiesInCollection;
        this.copiesOnLoan = CopiesOnLoan;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn=" + isbn +
                ", pages=" + pages +
                ", copiesInCollection=" + copiesInCollection +
                ", copiesOnLoan=" + copiesOnLoan +
                '}';
    }
}
