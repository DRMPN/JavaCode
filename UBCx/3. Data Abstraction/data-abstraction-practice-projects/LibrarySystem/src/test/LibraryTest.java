package test;

import model.book.Book;
import model.library.Librarian;
import model.library.Library;
import org.junit.Before;
import org.junit.Test;

import static model.book.BookType.*;
import static org.junit.Assert.*;

public class LibraryTest {

    private Book refBook;
    private Book ficBook;
    private Book nonficBook;
    private Book textBook;
    private Book cookBook;
    private Library testLib;
    private Librarian testLibrarian;

    @Before
    public void setUp() {
        testLibrarian = new Librarian("Alan Kay", 11, testLib, ficBook);
        testLib = new Library("Vancouver Public model.library.Library", testLibrarian);

        refBook = new Book("Encyclopedia Britannica", "John Williams", REFERENCE, 1850, 1);
        refBook.setHomeLibrary(testLib);
        ficBook = new Book("Harry Potter and the Deathy Hallows", "J.K. Rowling", FICTION, 2007, 1);
        ficBook.setHomeLibrary(testLib);
        nonficBook = new Book("The Immmortal Life of Henrietta Lacks", "Rebecca Skloot", NONFICTION, 2008, 1);
        nonficBook.setHomeLibrary(testLib);
        textBook = new Book("Introduction to Algorithms", "Thomas H. Cormen", TEXTBOOK, 1992, 1);
        textBook.setHomeLibrary(testLib);
        cookBook = new Book("Mastering the Art of French Cooking", "Julia Child", COOKING, 1960, 1);
        cookBook.setHomeLibrary(testLib);
    }

    @Test
    public void testGetName() {
        assertEquals(testLib.getName(), "Vancouver Public model.library.Library");
    }

    @Test
    public void testGetManager() {assertEquals(testLib.getManager().getName(), "Alan Kay");}

    @Test
    public void testinCatalogue() {
        testLib.storeBook(refBook);
        testLib.storeBook(cookBook);
        testLib.storeBook(ficBook);
        testLib.storeBook(textBook);
        assertTrue(testLib.inCatalogue(refBook));
        assertTrue(testLib.inCatalogue(cookBook));
        assertTrue(testLib.inCatalogue(ficBook));
        assertTrue(testLib.inCatalogue(textBook));
        testLib.printCatalogue();
    }

    @Test
    public void testcanLoan() {
        assertTrue(testLib.canLoan(refBook));
        testLib.checkOutBook(refBook);
        assertFalse(testLib.canLoan(refBook));

        assertTrue(testLib.canLoan(cookBook));
        testLib.checkOutBook(cookBook);
        assertFalse(testLib.canLoan(cookBook));
    }

    @Test
    public void testreturnBook() {
        assertTrue(testLib.canLoan(textBook));
        assertTrue(testLib.checkOutBook(textBook));
        assertFalse(testLib.canLoan(textBook));
        assertTrue(testLib.returnBook(textBook));
        assertTrue(testLib.canLoan(textBook));
    }

    @Test
    public void testDifferentBranches() {
        Library branchLibrary = new Library("Vancouver Public model.library.Library", null);
        Book branchFicBook = new Book("Idiot", "Fyodor Dostoevsky", FICTION, 1874, 3);
        branchFicBook.setHomeLibrary(branchLibrary);
        Librarian branchLibrarian = new Librarian("Ilya", 18, branchLibrary, branchFicBook);

        branchLibrary.hireLibrarian(branchLibrarian);
        branchLibrary.storeBook(branchFicBook);
        testLib.addLibraryBranch(branchLibrary);

        assertTrue(testLib.isInDiffBranch(branchFicBook));
    }
}