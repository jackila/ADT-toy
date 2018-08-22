public class MyLinkedList<AnyType> implements Iterable<AnyType>
{


  private static class Node<AnyType>
  {
    public Node(AnyType d,Node<AnyType> p,Node<AnyType> n){
      data = d;prev = p; next = n;
    }

    public AnyType data;
    public Node<AnyType> prev;
    public Node<AnyType> next;

  }

  public MyLinkedList()
  {
    clear();
  }


  public void clear()
  {
    beginMarker = new Node<AnyType>(null,null,null);
    endMarker = new Node<AnyType>(null,beginMarker,null);
    beginMarker.next = endMarker;

    theSize = 0;
    modCount++;
  }

  public int size()
  {
    return theSize;
  }

  public boolean isEmpty()
  {
    return size() == 0;
  }

  public boolean add(AnyType x)
  {
    Node<AnyType> insert = new Node<NodeType>(x,endMarker,null);
    add(size(),insert);
    return true;
  }

  public void add(int idx,AnyType x)
  {
    addBefore(getNode(idx),x);
  }

  public AnyType get(int idx)
  {
    return getNode(idx).data;
  }

  public AnyType set(int idx,AnyType newVal)
  {
    Node oldNode = getNode(idx);
    AnyType oldval = oldNode.data;
    oldNode.data = newVal;
    return oldval;
  }

  public AnyType remove(int idx)
  {
    return remove(getNode(idx));
  }

  private void addBefore(Node<AnyType> p, AnyType x)
  {

    Node<AnyType> newNode = new Node<AnyType>(x,p.prev,p);
    newNode.prev.next = newNode;
    p.prev = newNode;
    theSize ++;
    modCount ++;
  }

  private AnyType remove(Node<AnyType> p)
  {
      p.prev.next = p.next;
      p.next.prev = p.prev;

      theSize -- ;
      modCount ++;
      return p.data;
  }

  private Node<AnyType> getNode(int idx)
  {

    Node<AnyType> p;

    if(idx < 0 || idx > theSize)
    {
      throw new IndexOutOfBoundsException();
    }

    if(idx < theSize/2){

      p = beginMarker;
      for(int i =0 ;i < idx;i++){
        p = p.next;
      }

    }else{
      p = endMarker;
      for(int i = size();i > idx;i--){
        p = p.prev;
      }
    }

    return p;
  }

  public Iterator<AnyType> iterator()
  {
    return new LinkedListIterator<AnyType>();
  }
  private class LinkedListIterator implements Iterator<AnyType>
  {

      private Node<AnyType> current = beginMarker.next;
      private int expectedModCount = modCount;
      private boolean okToRemove = false;

      public boolean hasNext()
      {
          return current != endMarker;
      }
      public AnyType next()
      {
        if(modCount != expectedModCount){
          throw new java.util.ConcurrentModificationException();
        }
        if(!hasNext()){
          throw new java.util.NoSuchElementException();
        }

        AnyType nextItem = current.data;
        current = current.next;
        okToRemove = true;
        return nextItem;
      }

      public void remove()
      {
        if(modCount != expectedModCount){
          throw new ConcurrentModificationException();
        }

        if(!okToRemove){
          throw new IllegalStateException();
        }

        MyLinkedList.this.remove(current.prev);
        okToRemove = false;
        expectedModCount ++ ;
      }
  }

  private int theSize;
  private int modCount = 0;
  private Node<AnyType> beginMarker;
  private Node<AnyType> endMarker;
}
