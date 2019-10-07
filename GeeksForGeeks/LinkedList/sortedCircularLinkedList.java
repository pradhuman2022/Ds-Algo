class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}*/
class GfG
{
	public static void insert(Node head,int value,int n)
         {
            //add code here.
             if(head == null){
                 head = new Node(value);
                 head.next = head;
                 System.out.println(value);
                 return ;
             }else{
                 Node tail = head;
                 while(tail.next != head){
                     tail = tail.next;
                 }
                 
                 tail.next = null ;
                 Node curr = head; 
                 Node prev = null;
                 while(curr != null){
                     
                      if(value <= curr.data){
                          
                          if(prev == null){
                              Node nk = new Node(value);
                              nk.next = head ;
                              head = nk ;
                              
                          }else{
                              Node tmp = prev.next ;
                              prev.next = new Node(value);
                              prev.next.next = curr;
                             
                          }
                          tail.next = head ;
                          break ;
                      }
                      prev = curr;
                      curr = curr.next ;
                     
                 }
                 if(curr == null){
                     tail.next = new Node(value);
                     tail.next.next = head ;
                 }
                 Node h = head ;
                 while(h.next != head){
                     System.out.print(h.data+" ");
                     h = h.next ;
                 }
                 System.out.print(h.data);
             }
         }
}
