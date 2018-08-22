 public class MyArrayList<AnyType> implement Interface<AnyType>{

   private static final int DEFAULT_CAPACITY =10;

   private int theSize;
   private AnyType[] theItems;

   public MyArrayList(){
      clear();
   }

   public void clear(){
      int theSize = 0;
      ensureCapacity(DEFAULT_CAPACITY);//有点问题，因为没有将之前的数据清空。不用清空，这是一个新的对象
   }

   public int size(){
      return theSize;
   }
   public boolean isEmpty(){
      return size() == 0;
   }
   public void trimToSize(){
      ensureCapacity(size());
   }

   public Anytype get(int idx){

     if(idx < 0 || idx >= size()){
       throw new ArrayIndexOutOfBoundsException();
     }
      return theItems[idx];
   }

   public AnyType set(int idx,AnyType newVal){

     if(idx < 0 || idx >= size()){
       throw new ArrayIndexOutOfBoundsException();
     }
     AnyType oldItem = theItems[idx-1];
     theItems[idx-1] = newVal;
     return oldItem;

   }

   public void ensureCapacity(int newCapacity){
      if(newCapacity < theSize){
        return;
      }
      AnyType[] oldItems = theItems;
      theItems = (AnyType[])new Object[newCapacity];

      for(int i =0;i<newCapacity-1;i++){
        theItems[i] = oldItems[i];
      }
   }

   public boolean add(AnyType x){
     add(size(),x);
     return true;
   }

   public void add(int idx,Anytype x){

     if(theItems.length == size()){
       ensureCapacity(size() * 2 +1);
     }
     for(int i =theSize ;i> idx;i--){
        theItems[i] = theItems[i-1];
     }
     theItems[idx] = x; //在某个位置之后增加一个新的元素
     return true;

   }

   public AnyType remove(int idx){
      AnyType removedItem = theItems[idx];
      for(int i = idx;i<size()-1;i++){
        theItems[i] = theItems[i+1]
      }
      theSize -- ;
      return removedItem;
   }

   public Iterator<AnyType> iterator(){
     return new ArrayListIterator();
   }

   /**
    * 1.为什么使用内部类 数据域不同
    * 2.为什么不使用嵌套类 嵌套类无法判断出哪一个theItems被引用
    * 3. 内部类有一个 隐式引用   Outer.this
    * 为了简洁，我们使用size() 代替 Outer.this.size()
    *
    * 使用theItems 代替 Outer.this.theItems
    * 因为内部类与外部类都存在remove，为了区分使用了 outer.this.remove()
    */
   private class ArrayListIterator implement Iterator<AnyType>{

     private int current =0;

     public boolean hasNext(){
        return current < size();
     }

     public AnyType next(){

      if(!hasNext()){
        throw new NoSuchElementException();
      }
      return theItems[current++];
     }

     public void remove(){
      MyArrayList.this.remove(--current);//这段代码不理解
     }
   }
 }
