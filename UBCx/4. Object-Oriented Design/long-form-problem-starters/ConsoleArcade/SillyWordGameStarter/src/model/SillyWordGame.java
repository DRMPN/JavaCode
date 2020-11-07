package model;

import java.util.Iterator;
import java.util.List;

public class SillyWordGame implements Iterable<Phrase> {

    private List<Phrase> phrases;

    public SillyWordGame(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    //EFFECTS: returns all phrases in this game
    public List<Phrase> getAllPhrases() {
        return phrases;
    }

    @Override
    public Iterator<Phrase> iterator() {
        return new SillyWordGameIterator();
    }

    private class SillyWordGameIterator implements Iterator<Phrase> {

        private int numWordsNeeded;
        private Iterator<Phrase> phraseIterator;

        private SillyWordGameIterator() {
            phraseIterator = phrases.iterator();
            calculateNumWordsNeeded();
        }

        @Override
        public boolean hasNext() {
            return (numWordsNeeded>0);
        }

        //EFFECTS: returns the next phrase needing a word
        public Phrase next() {
            Phrase p = phraseIterator.next();
            while (!p.needsWord()) { p = phraseIterator.next(); }
            numWordsNeeded--;
            return p;
        }

        //MODIFIES: this
        //EFFECTS: sets numWordsNeeded to the number of phrases that still need words
        private void calculateNumWordsNeeded() {
            Iterator<Phrase> it = phrases.iterator();
            while(it.hasNext()) {
                if (it.next().needsWord())
                    numWordsNeeded++;
            }
        }
    }
}
