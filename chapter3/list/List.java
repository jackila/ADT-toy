public interface List<AnyType> List{
  AnyType get(int index);
  AnyType set(int index, AnyType anytype);

  void add(int idx,AnyType anytype);
  void remove(int idx);

  ListIterator<AnyType> listIterator(int idx);
}
