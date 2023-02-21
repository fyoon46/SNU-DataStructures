package book.chap06.prob10;

@SuppressWarnings("UnnecessaryModifier")
public interface ListInterface<E> {
    public void add(int i, E x);

    public int index(E x);

    public E get(int i);

    public void remove(int i);

    public void clear();

    public int len();

    public boolean isEmpty();

    public void printReverse();
}
