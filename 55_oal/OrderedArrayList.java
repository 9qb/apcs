// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// HW55 -- Execution time categorization
// 2022-01-11
// time spent: 1.2 hours

/*
DISCO:
- get(), size(), toString() and constructor methods don't have best/worst cases, as their functions do not differ in any way given any number of elements in a list.
- Because we want out list to be ordered, methods like add and set require us to iterate through the list an extra time time to ensure ascending order.
QCC:
- How can we optimize set() so its runtime complexity is O(1) (that is, removing the add and remove methods)? Are they necessary for setting a value at an index?
*/

import java.util.ArrayList;

public class OrderedArrayList{
  private ArrayList<Integer> _data;

  /*
  No best or worse case exists.
  Runtime Complexity: O(1)
  Why?
  Creating a new, empty ArrayList is not affected by any data.
  */
  public OrderedArrayList(){
    _data = new ArrayList<Integer>(10);
  }

  /*
  No best or worse case exists.
  Runtime Complexity: O(n)
  Why?
  The runtime is dependent solely on the length of the dataset in the input.
  */
  public OrderedArrayList(ArrayList<Integer> array){
    _data = new ArrayList<Integer>(array.size());
    for (int val : array){
      add(val);
    }
  }

  /*
  No best or worse case exists.
  Runtime Complexity: O(n)
  Why?
  The runtime is dependent on iterating through all elements in _data to create the String.
  */
  // overrides toString() with ArrayList's toString()
  public String toString(){
    return _data.toString();
  }

  /*
  No best or worse case exists.
  Runtime Complexity: O(1)
  Why?
  Returning the value at a certain index is not affected by any data.
  */
  // using ArrayList's get(), returns the int at a certain index
  public Integer get(int index){
    return _data.get(index);
  }

  /*
  No best or worse case exists.
  Runtime Complexity: O(1)
  Why?
  Returning an ArrayList's size is not affected by any data.
  */
  // using ArrayList's size(), returns the size of the ArrayList.
  public int size(){
    return _data.size();
  }

	/*
	Best case: Changing last element to value that still greater than all other values.
  Runtime Complexity: O(n)
  Why?
  By changing the last element in this manner, we are only iterating through the dataset
  once. First removing the last element does not require a shift in indices, and then adding
  a new value that still maintains sortedness only results in one iteration, as no shifting
  in indices is made.

  Worst case: Changing first element to a value that is still less than all other values.
  Runtime Complexity: O(n)
  Why?
  By changing the first element in this manner, we are iterating through the dataset 3 times.
  Removing the first element results in a shift in indices of all other elements one down, and
  then another iteration is made to find the position to add the new value in. The third iteration
  is made in shifting all proceeding elements one index up.
  */
  // removes the value at the index intended to be changed,
  // and adds the new value to the dataset.
  public Integer set(int index, int newVal){
    int oldVal = remove(index);
    add(newVal);
    return oldVal;
  }

	/*
 	Best case: There is enough empty indices within the array for all the data. The value
  					 being added is larger than all the other elements in the dataset.
 	Runtime Complexity: O(n)
 	Why?
 	Since order matters, the list is iterated through before adding newVal in the proper index.
  The value being larger than all other elements does not result in a shift of index for other
  elements in the dataset.

 	Worst case: Array has to be expanded in order to accomodate newly added value. The value
              being added is less than all the other elements in the dataset.
 	Runtime Complexity: O(n)
 	Why?
 	List is iterated through the first time with order in mind. If we need to expand the array,
  we iterate through the ordered array again. On top of that, if the value being added is less
  than all the other elements in the dataset, it results in a shift of one index up for all other
  elements in the dataset.
	*/
  // employs ArrayList's add(). index of insertion is based on the appropriate
  // index that maintains ascending order. proceeding values are shifted one index greater.
  public void add(int newVal){
    for (int index = 0; index < size(); index++){
      // when an existing int in _data is greater than newVal, newVal is inserted in that index.
      // the succeeding values are shifted one index greater.
      if (_data.get(index).compareTo(newVal) > 0){
        _data.add(index, newVal);
        return; // ends once the first addition is made
      }
    }
    // this happens if size == 0
    _data.add(newVal);
  }

	/*
  Best Case: Last element is removed.
  Runtime complexity: O(1)
  Why?
  Because it's the last element, you don't have to shift the elements down an index. Only one action: removing last element.
  Worst Case: First element is removed.
  Runtime complexity: O(n)
  Why?
  Because it's the first element, we have to go through all the elements in the array and shift them all down one index.
  */
  // using ArrayList's remove(), removes the element at a certain index and
  // shifts proceeding values one index less.
  public Integer remove(int index){
    return _data.remove(index);
  }
}
