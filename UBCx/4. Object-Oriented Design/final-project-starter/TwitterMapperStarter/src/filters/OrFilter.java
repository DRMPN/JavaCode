package filters;

import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

public class OrFilter implements Filter {

    private final Filter leftChild;
    private final Filter rightChild;

    public OrFilter(Filter leftChild, Filter rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public boolean matches(Status s) {
        return leftChild.matches(s) || rightChild.matches(s);
    }

    @Override
    public List<String> terms() {
        //fixme
        List<String> newTerms = new ArrayList<>();
        newTerms.addAll(leftChild.terms());
        newTerms.addAll(rightChild.terms());
        return newTerms;
    }

    @Override
    public String toString() {
        return "(" + leftChild.toString() + " or " + rightChild.toString() + ")";
    }
}
