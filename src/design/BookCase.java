package design;

import javafx.util.Pair;

import java.util.ArrayList;

public class BookCase
{
    /***
     *  https://leetcode.com/discuss/interview-question/object-oriented-design/836160/Design-a-multi-shelf-book-case
     *  Not clear from the requirements:
     *  1) only one book can be on row/col or many books can be on the same row/col
     *  2) what is  Nth book - they have not only 2-dimentional coordinates(row/col), but also 1-dimentional??
     */

    int numberOfRows;
    int numberOfCols;
    ArrayList<Book> books; // TODO: delete it, it is excessive
    Book[][] shelf;

    private class Book{
        String title;
        int row;
        int col;

        public Book(String title){
            this.title = title;
        }

        public Book (String title, int row, int col)
        {
            this.title = title;
            this.row = row;
            this.col = col;
        }

        public String getTitle(){
            return this.title;
        }

        public int getRow ()
        {
            return row;
        }

        public void setRow (int row)
        {
            this.row = row;
        }

        public int getCol ()
        {
            return col;
        }

        public void setCol (int col)
        {
            this.col = col;
        }
    }


    public BookCase(int rows, int cols){
        this.numberOfCols = cols;
        this.numberOfRows = rows;
        this.books = new ArrayList<>();
        this.shelf = new Book[rows][cols];
    }

    public void addBook(Book book, int row, int col){
        if (row> this.numberOfRows || col> this.numberOfCols){
            return;
        }
        book.setCol(col);
        book.setRow(row);
        this.books.add(book);
        shelf[row][col] = book;
    }

    /***
     * Should be able to locate the Nth book (N given as input)
     */
    public Book getBookByNumber(int bookNumber){
        if (this.books.size()< bookNumber)
            return null;
        return this.books.get(bookNumber-1);
    }

    /***
     * Should be able to return the row, column of the book in the shelf given book title
     */
    public int[] getBookByTitle(String title){
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        for (Book book: this.books){
            if (book.getTitle() == title){
                res[0] = book.getRow();
                res[1] = book.getCol();
            }
        }
        return res;
    }

    /***
     * Should be able to return the given book position, the book in front of the input book and the one after the input book
     * given book position is saved in Book object itself
     */

    public Book[] getFrontBackBooks(Book book){
        if(book.getCol()> this.numberOfCols || book.getRow() > numberOfRows){
            return null;
        }
        //0-front, 1-back
        Book[] res = new Book[2];
        Book frontBook = null;
        Book backBook = null;
        res[0] = frontBook;
        res[1] = backBook;
        //what if a given book is at the edge?????
        for (int i = 0; i< this.shelf.length; i++){
            for (int j = 0; j< this.shelf[0].length; j++){
                if(!shelf[i][j].equals(book)) {
                    frontBook = shelf[i][j];
                }else {
                    if(i+1 <this.shelf.length) {
                        backBook = shelf[i + 1][j];
                    }
                }
            }
        }

        return res;
    }

}
