package model;

import model.media.AbstractMedia;

import java.util.*;

public class iPod implements Iterable<AbstractMedia> {

    private String name;
    // hashmap< ???, List<AbstractMedia> >
    private List<AbstractMedia> allMedia = new ArrayList<>();

    public iPod(String name) {
        this.name = name;
    }

    // getters
    public String getName() { return name; }

    public void addMedia(AbstractMedia m) {
        allMedia.add(m);
    }

    @Override
    public Iterator<AbstractMedia> iterator() {
        return new iPodMediaIterator();
    }

    private class iPodMediaIterator implements Iterator<AbstractMedia> {

        private Iterator allMediaIterator = allMedia.iterator();

        @Override
        public boolean hasNext() {
            return allMediaIterator.hasNext();
        }

        @Override
        public AbstractMedia next() {
            AbstractMedia m = null;

            if (allMediaIterator.hasNext()) {
                m = (AbstractMedia) allMediaIterator.next();
            }

            return m;
        }
    }
}