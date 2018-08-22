
private void listAll(int depth){
  printName(depth);
  if(isDirectory())
    for each file c in the directory(for each child)
      c.listAll(depth + 1)
}

public void listAll()
{
  listAll(0)
}
