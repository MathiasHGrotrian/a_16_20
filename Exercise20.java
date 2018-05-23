package Chapter16;

public class Exercise20
{
    /*
    Write a method called shift that rearranges the elements of a list of integers
    by moving to the end of the list all val- ues that are in odd-numbered positions
     and otherwise preserving list order. For example, suppose that a variable list
     stores the values[10, 31, 42, 23, 44, 75, 86]. The call of list.shift(); should
     rear range the list to store [10, 42, 44, 86, 31, 23, 75].Itdoesn’tmatterwhethertheva
     lueitselfisoddoreven;whatmattersis whether the value appears in an odd index (index 1,
      3, 5, etc.). Also notice that the original order of the list is other- wise preserved. Y
      ou may not construct any new nodes nor use any auxiliary data structures to solve this pro
      blem. You also may not change any data fields of the nodes; you must solve this problem by rearranging the links of the list.
     */

    public static ListNode front;

    public static void main(String[] args)
    {

        addNodeToList(0,10);
        addNodeToList(1,31);
        addNodeToList(2,42);
        addNodeToList(3,23);
        addNodeToList(4,44);
        addNodeToList(5,75);
        addNodeToList(6,86);

        //I have made a print list data method
        shift();
        printList();

    }

    private static void shift()
    {
        int copyA = 0;

        for (ListNode current = front; current != null; current = current.next)
        {
            if((current.data % 2) != 0)
            {
                copyA = current.data;

                for(ListNode secCurrent = current; secCurrent != null; secCurrent = secCurrent.next)
                {
                    if(secCurrent.next != null)
                    {
                        secCurrent.data = secCurrent.next.data;
                    }
                    if(secCurrent.next == null)
                    {
                        secCurrent.data = copyA;
                    }
                }
            }
        }
    }


    public static void addNodeToList(int index, int value)
    {
        if(index == 0)
        {
            front = new ListNode(value, front);
        }
        else
        {
            ListNode current = front;
            for (int i = 0; i < index-1 ; i++)
            {
                current = current.next;
            }
            current.next = new ListNode(value,current.next);
        }
    }

    public static void printList()
    {
        System.out.println("[ ");
        for (ListNode current = front; current != null; current = current.next)
        {
            System.out.print(current.data + ", ");
        }
        System.out.println("]");
    }
}
