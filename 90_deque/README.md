# Team (P)BNJ's Deque
## Members: Brian Li, Nakib Abedin, Jefford Shau

## Methods
### Add Methods
`public boolean add(E e)` - adds e to the end of the Deque and returns true <br>
`public void addFirst(E e)` - adds e to the front of the Deque <br>
`public void addLast(E e)` - adds e to the end of the Deque <br>

These methods are necessary to add elements in both directions of the Deque.

### Remove Methods
`public E remove()` - removes the element at the front of the Deque <br>
`public boolean remove(Object o)` - removes first instance of o in the Deque <br>
`public E removeFirst()` - removes the element at the front of the Deque <br>
`public E removeLast()` - removes the element at the end of the Deque <br>

These methods are necessary to remove elements in both directions of the Deque.

### Peek Methods
`public E peek()` - returns element at front of the Deque <br>
`public E peekFirst()` - returns element at front of the Deque <br>
`public E peekLast()` - returns element at end of the Deque <br>

These methods allow us to view elements at both ends of the Deque.

### Other Methods
`public boolean isEmpty()` - returns true if Deque is empty, false otherwise <br>
`public int size()` - returns number of elements in the Deque <br>
`public void clear()` - clears the Deque <br>
`public boolean contains(Object o)` - returns true if o is found within the Deque, false otherwise <br>

These are methods that provide additional information about the Deque, and aid in manipulating the Deque.

### Plan of Attack
- Determine what library will be used (LL or AL?)
- Work on isEmpty() and size() first, then work on Add, then Remove, then Peek methods. 
- Check what methods can be easily optimized via passthru before implementation.
