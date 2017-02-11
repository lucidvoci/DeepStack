package deepstack;

/**
 * Deep stack provides operations peek, pop and push of regular
 * stack and of the stack that can access certain depth.
 * Deep stack also provides option of pushing array of
 * objects on the stack, eather on top or in certain depth.
 * 
 * @author lucie dvorakova
 */

public class DeepStack<T> {
    Node top = null;
    private int size = 0;
    public class Node {
        private Node previous = null;
        private Node next = null;
        private T data = null;

        public Node(T data){
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
    
  /**
   * Regular push operation to top of the stack. 
   * @param elm The object that is pushed on the stack
   */
    public Node push(T elm) {
        if (top == null) {
            top = new Node(elm);
        }
        else {
            Node oldElm = top;
            top = new Node(elm);
            top.next = oldElm;
            oldElm.previous = top;
        }
        size++;
        return top;
    }
    
   /**
    * Push operation to certain depth. 
    * @param elm The object that is pushed on the stack
    * @param lvl The depth where the object is pushed
    * (top of stack depth is 0)
    */
    public Node push(T elm, int lvl) {
        if(lvl == 0){
            Node newElm = push(elm);
            return newElm;
        }
        if(lvl > size) {
            throw new IndexOutOfBoundsException();
        }
        Node cur = top;
        for(int i = 0; i < (lvl - 1); i++){
            cur = cur.next;
        }
        Node next = cur.next;
        Node newElm = new Node(elm);
        
        cur.next = newElm;
        newElm.next = next;
        next.previous = newElm;
        newElm.previous = cur;
        
        size++;
        
        return newElm;
    }
    
    /**
    * Pushes value UNDER existing node exNode. 
    * @param elm The object that is pushed on the stack
    * @param exNode Node that already exists in the stack
    * (top of stack depth is 0)
    */
    public Node push(T elm, Node exNode) {
        Node newElm = new Node(elm);
        
        if(exNode.next == null){
            exNode.next = newElm;
            newElm.previous = exNode;
            return newElm;
        }
        
        exNode.next.previous = newElm;
        newElm.next = exNode.next;
        exNode.next = newElm;
        newElm.previous = exNode;
        
        size++;
        
        return newElm;
    }
    
    /**
    * Regular push operation of array of objects. 
    * @param elms The array of objects that is pushed on the stack
    */
    public void push(T[] elms) {
        int lenght = elms.length;
        if (lenght == 0) {
            return;
        }
        if (lenght == 1) {
            push(elms[1]);
            return;
        }
        
        for(int i = 0; i < lenght; i++){
            Node newElm = new Node(elms[i]);
            newElm.next = top;
            top.previous = newElm;
            top = newElm;
            size++;
        } 
    }
    
    /**
    * Push operation of array of objects to certain depth. 
    * @param elms The array objects that is pushed on the stack
    * @param lvl The depth where the objects are pushed
    * (top of stack depth is 0)
    */
    public void push(T[] elms, int lvl) {
        int lenght = elms.length;
        if (lenght == 0) {
            return;
        }
        if (lenght == 1) {
            push(elms[1], lvl);
            return;
        }
        if(lvl == 0){
            push(elms);
            return;
        }
        
        Node cur = top;
        for(int i = 0; i < (lvl - 1); i++){
            cur = cur.next;
        }
        
        for(int i = lenght - 1; i >= 0; i--){
            Node newElm = new Node(elms[i]);
            newElm.next = cur.next;
            cur.next.previous = newElm;
            cur.next = newElm;
            newElm.previous = cur;
            cur = newElm;
            size++;
        } 
    }
    
  /**
   * Regular pop operation of top of the stack. After the 
   * pop operation the top object is removed from the stack
   * @return T Returns the top object on the stack
   */
    public T pop(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        Node oldElm = top;
        top = oldElm.next;
        top.previous = null;
        size--;
        return oldElm.data;
    }
  /**
   * Pop operation of object in ceratin depth. After the 
   * pop operation the object is removed from the stack
   * @param lvl The depth of the poped objects
   * @return T Returns the object on the stack in the given depth
   * (top of stack depth is 0)
   */
    public T pop(int lvl){
        if (isEmpty() || lvl > size){
            throw new IndexOutOfBoundsException();
        }
        Node cur = top;
        for(int i = 0; i < (lvl - 1); i++) {
            cur = cur.next;
        }
        Node del = cur.next;
        cur.next.next.previous = cur;
        cur.next = cur.next.next;
        size--;
        return del.data;
    }
    
   /**
   * Pop a already existing node in stack. After the 
   * pop operation the object is removed from the stack
   * @param exNode Node that already exists in the stack
   * @return T Returns the object on the stack
   * (top of stack depth is 0)
   */
    public T pop(Node exNode){
        if(exNode == top){
            top = top.next;
            top.previous = null;
        }
        else {
            exNode.next.previous = exNode.previous;
            exNode.previous.next = exNode.next;
        }
        size--;
        return exNode.data;
    }
    
  /**
   * Regular peek operation of top of the stack. The top
   * object remains on the stack
   * @return T Returns the top object on the stack in the given depth
   */
    public T peek() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return top.data;
    }
    
  /**
   * Peek operation of object in ceratin depth. The object 
   * remains on the stack
   * @param lvl The depth of the peeked objects
   * @return T Returns the object on the stack
   * (top of stack depth is 0)
   */
    public T peek(int lvl) {
        if (isEmpty() || lvl > size){
            throw new IndexOutOfBoundsException();
        }
        Node cur = top;
        for(int i = 0; i < lvl; i++) {
            cur = cur.next;
        }
        return cur.data;
    }
    
  /**
   * Operation returns true if stack is empty.
   * @return boolean Returns true if stack is empty
   */
    public boolean isEmpty() {
        return (top == null);
    }
    
  /**
   * Operation converts Deep Stack to string. The top of the stack
   * is printed first and bottom of the stack is printed last.
   * @return String Returns printable version of the Deep Stack
   */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = top;
        for(int i = 0; i < size ; i++) {
            sb.append(cur.data);
            sb.append("\n");
            cur = cur.next;
        }
        return sb.toString();
    }
    
    public int size() {
        return size;
    }
}
