import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;


public class BookCollection {
    private  ArrayList<Book> books= new ArrayList<Book>();

    //2, complete constructor that takes a string path (the BookList file name) load the books from BookList into the books arrayList
    //When complete books should have 100 items. Make sure you don't include the header row!
    BookCollection(String path) {
        try{
            File readFile = new File(path);
            Scanner in = new Scanner(readFile);
            in.nextLine();
            int counter = 0;
            while(in.hasNext()){
                String[] splitStore = in.nextLine().split(",");
                books.add(new Book(splitStore[counter],splitStore[counter+1],Long.parseLong(splitStore[counter+2]),Integer.parseInt(splitStore[counter+3]),Integer.parseInt(splitStore[counter+4]),Integer.parseInt(splitStore[counter+5])));
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }

    }

    //3, Return a HashSet of all the authors in the book list
    public HashSet<String> getAuthors(){
        HashSet<String> authors = new HashSet<>();
        for(Book i: books){
            authors.add(i.getAuthor());
        }
        return authors;
    }

    //4, return an arrayList of books with more than 750 pages
    public ArrayList<Book> getLongBooks(){
        ArrayList<Book> mostPages = new ArrayList<Book>();
        for(Book i : books){
            if(i.getPages() > 750){
                mostPages.add(i);
            }
        }
        return mostPages;
    }

    //5, return the book if the given title is in the list.
    public Book getBookByTitle(String title){
        for(Book i : books){
            if (i.getTitle().equals(title)){
                return i;
            }
        }
        return null;
    }

    //6, return an array of the 10 most popular books (That is those that currently have most copies on loan)
    public Book[] mostPopular(){
        Book chosen[] = new Book[100];
        Book[] secondChosen = new Book[10];
        int secondCounter = 0;
        for(Book chosenCounter : books){
            chosen[secondCounter] = (chosenCounter);
            secondCounter++;
        }
        for(int i = 0;i<chosen.length;i++){
            for(int j = 0; j < chosen.length-1;j++){
                if(chosen[j].getCopiesOnLoan() > chosen[j+1].getCopiesOnLoan()){
                    Book tempPlacement = chosen[j];
                    chosen[j] = chosen[j+1];
                    chosen[j+1] = tempPlacement;
                }
            }
        }
        int thirdCounter = 0;
        for(var k = chosen.length-1;k>88;k--){
            Book temp2 = chosen[k];
            secondChosen[thirdCounter] = temp2;
            thirdCounter++;
            if(k==90){
                break;
            }
        }
        return secondChosen;
    }

}
