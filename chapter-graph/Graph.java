public class Graph{

  private final int V;
  private int E;
  private Bag<Integer>[] adj;

  /**
   * 顶点数量
   * @param V [description]
   */
  public Graph(int V){
      this.V = V; E = 0;
      adj = (Bag<Integer>[])new Bag[V];
      for(int v = 0;v < V;v++){
        adj[v] = new Bag<Integer>();
      }
  }

  /**
   * 从标准输入流in读入一幅图
   * @param in [description]
   */
  public Graph(In in){

    this(readInt(in));
    E = readInt(in);

    for(int i = 0;i < E;i++){
      addEdge(readInt(in),readInt(in));
    }

  }

  /**
   * 返回顶点数量
   * @return [description]
   */
  int V(){
    return V;
  }

  /**
   * 返回边数
   * @return [description]
   */
  int E(){
    return E;
  }

  /**
   * 添加一条边
   * @param v [description]
   * @param w [description]
   */
  void addEdge(int v, int w){
    adj[v].add(w);
    adj[w].add(v);
    E++;
  }

  /**
   * 和v相邻的所有顶点
   * @param  v [description]
   * @return   [description]
   */
  Iterable<Integer> adj(int v){
    return adj[v];
  }

  /**
   * 对象的字符串表示
   * @return [description]
   */
  String toString(){

  }
}
