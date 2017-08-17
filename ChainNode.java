package estructuras2017gr4;

/**
 * Created by ivanc on 15/08/2017.
 */
class ChainNode <T>{
    T element;
    ChainNode<T> next;

    ChainNode()
    {
        this(null, null);
    }

    ChainNode(T element)
    {
        this(element, null);
    }

    ChainNode(T element, ChainNode<T> next)
    {
        this.element = element;
        this.next = next;
    }
}
