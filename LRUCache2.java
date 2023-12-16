import java.util.HashMap;

class Node{
  int key;
  int value;
  Node previous;
  Node next;
  public Node(int k,int v){
    key=k;
    value=v;
  }
}
class LRUCache2 {
    private int capacity;
    private HashMap<Integer, Node> hm;
    private Node head;
    private Node tail;
    private int count=0;
    public LRUCache2(int c){
      capacity =c;
    }

    public void put(int key,int value){
      
      count+=1;
      if (count==0){
        head = new Node(key,value);
        hm.put(key,head);
        tail=head;
      }
      else{
        if (count>capacity){
          tail.previous.next = null;
          tail=tail.previous;
        }
        Node newNode = Node(key,value);
        if(hm.containsKey(key)){
          delete(hm.get(key));
        }
        hm.put(key,newNode);
        newNode.next=head;
        head.previous = newNode;
        head = newNode;
      }
    }

    public int get(int key){
        if(hm.containsKey(key)){
          Node nodeToFirst = hm.get(key);

          delete(nodeToFirst);
          head.previous=nodeToFirst;
          nodeToFirst.next = head;
          head = nodeToFirst;
          return head.value;
        }else{
          return -1;
        }
    }
    private void delete(Node victim){
      victim.previous.next=victim.next;
      victim.next.previous=victim.previous;
    }
}