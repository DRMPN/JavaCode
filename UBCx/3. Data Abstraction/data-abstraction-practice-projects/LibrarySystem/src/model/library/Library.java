package model.library;

import model.book.Book;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Library {

    private Librarian manager;
    private final String name;
    private final List<Library> branches = new ArrayList<>();
    private final List<Book> referenceBooks = new ArrayList<>();
    private final List<Book> fictionBooks = new ArrayList<>();
    private final List<Book> nonfictionBooks = new ArrayList<>();
    private final List<Book> textBooks = new ArrayList<>();
    private final List<Book> cookBooks = new ArrayList<>();

    public Library(String nm, Librarian manager) {
        this.name = nm;
        this.manager = manager;
    }

    // getters
    public String getName() {
        return name;
    }

    public Librarian getManager() {
        return manager;
    }

    // REQUIRES: bk != null
    // MODIFIES: this
    // EFFECTS: stores the given Book bk into the appropriate container within this class
    public void storeBook(Book bk) {
     switch (bk.getType()){
         case REFERENCE: referenceBooks.add(bk); break;
         case FICTION: fictionBooks.add(bk); break;
         case NONFICTION: nonfictionBooks.add(bk); break;
         case TEXTBOOK: textBooks.add(bk); break;
         case COOKING: cookBooks.add(bk); break;
        }
    }

    // REQUIRES: bk != null
    // EFFECTS: return true if the given book is in the catalogue,
    //          regardless of its loan status, else return false
    public boolean inCatalogue(Book bk) {
    switch (bk.getType()){
        case REFERENCE: return referenceBooks.contains(bk);
        case FICTION: return fictionBooks.contains(bk);
        case NONFICTION: return nonfictionBooks.contains(bk);
        case TEXTBOOK: return textBooks.contains(bk);
        case COOKING: return cookBooks.contains(bk);
        default: return false;}
//        return bk.getHomeLibrary().getName() == name;
    }

    // REQUIRES: bk != null
    // EFFECTS: return true if the given book is available to loan
    //          Note: What requirements should a book meet to be available?
    public boolean canLoan(Book bk) {
        return !bk.onLoan();
    }

    // REQUIRES: bk != null
    // EFFECTS: return true if the given book is available in the catalogue of this library's
    //          other branches; else, return false
    // TODO: check correctness
    public boolean isInDiffBranch(Book bk) {
        for (Library lib : branches){
            if (lib.inCatalogue(bk)) {return true;}
        }
        return false;
    }

    // EFFECTS: adds new branch to this library
    public void addLibraryBranch(Library lib) {
        if (!branches.contains(lib)) {
            branches.add(lib);
        }
    }

    // REQUIRES: bk != null
    // MODIFIES: this
    // EFFECTS: set bk as being checked out from this library if possible
    //          return true if successful, else false
    public boolean checkOutBook(Book bk) {
        if (canLoan(bk)) {
            bk.nowOnLoan();
            return true;
        }
        else {
            return false;
        }
    }

    // REQUIRES: bk != null
    // MODIFIES: this
    // EFFECTS: set bk as being back in the library if it has been borrowed previously
    //          return true if successful, otherwise false
    public boolean returnBook(Book bk) {
        if (bk.onLoan()) {
            bk.notOnLoan();
            return true;
        }
        else {
            return false;
        }
    }

    // REQUIRES: manager != null
    // MODIFIES: this
    // EFFECTS: sets this library's librarian to manager; return true if successful, else false
    // TODO: check correctness
    public boolean hireLibrarian(Librarian manager) {
        if (manager != null) {
            this.manager = manager;
            return true;}
        else {return false;}
    }


    // Utility method, do not touch its implementation
    public void printCatalogue() {
        List<Book> totalCatalogue = new LinkedList<>();
        totalCatalogue.addAll(this.cookBooks);
        totalCatalogue.addAll(this.fictionBooks);
        totalCatalogue.addAll(this.nonfictionBooks);
        totalCatalogue.addAll(this.textBooks);
        totalCatalogue.addAll(this.referenceBooks);

        for (Book b : totalCatalogue) {
            System.out.println(b.getTitle() + " by " + b.getAuthor());
        }
    }


}
