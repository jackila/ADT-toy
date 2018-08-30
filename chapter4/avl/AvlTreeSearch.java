public class AvlTreeSearch{

  private static class AvlNode<AnyType>{

    public AvlNode(AnyType theElement){
      AvlNode(theElment,null,null);
    }
    public AvlNode(AnyType theElement,AvlNode lt,AvlNode rt){
      element = theElement;
      left = lt;
      right = rt;
      height = 0;
    }

    AnyType element;
    AvlNode<AnyType> left;
    AvlNode<AnyType> right;
    int height;
  }

  private int height(AvlNode<AnyType> t){
    return t == null ? -1 : t.height;
  }

  private AvlNode<AnyType> insert(AnyType x,AvlNode t){

  }
}
