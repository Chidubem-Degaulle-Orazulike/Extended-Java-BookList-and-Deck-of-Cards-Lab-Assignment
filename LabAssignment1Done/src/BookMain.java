import java.util.Arrays;

public class BookMain {
    public static void main(String[] args) {
        BookCollection bCollection = new BookCollection("BookList.csv");
        //System.out.println(bCollection.mostPopular());
        //need to use an array.toString to view the file
        System.out.println(Arrays.toString(bCollection.mostPopular()));

    }
}
