// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// L02 -- OrderedArrayList
// 2021-12-10
// time spent: 0.8 hours

/*
DISCO
- Have to import java.util.ArrayList and limit the ArrayList object to only use integers. 
- ArrayList has its own toString(), get(), remove(), and compareTo() method. 
QCC
- How could you modify this program to work with Objects other than Integer?
- How would compareTo work with Strings? Other objects?
*/

import java.util.ArrayList;

public class OrderedArrayList{
  public ArrayList<Integer> _data;

  public OrderedArrayList(){
    _data = new ArrayList<Integer>(10);
  }

  public OrderedArrayList(ArrayList<Integer> array){
    _data = new ArrayList<Integer>(array.size());
    for (int val : array){
      add(val);
    }
  }

  // overrides toString() with ArrayList's toString()
  public String toString(){
    return _data.toString();
  }

  // using ArrayList's get(), returns the int at a certain index
  public int get(int index){
    return _data.get(index);
  }

  // using ArrayList's size(), returns the size of the ArrayList.
  public int size(){
    return _data.size();
  }

  // swap method to be used with sort()
  private void swap(int a, int b){
    int temp = _data.get(a);
    _data.set(a, _data.get(b));
    _data.set(b, temp);
  }

  // iterates through _data, size() times.
  // every time the value at an index, n, is greater than the value at index n+1, the values swap places.
  // the outer for loop ensures the appropriate number of swaps are done.
  // (a value at index 0 can swap all the way to the last index, etc.)
  // the nested for loop allows for swapping at a lower scope.
  // (a value at index 0 can swap to index 1.)
  private void sort(){
    for (int i = 0; i < size(); i++){
      for (int nestedI = 0; nestedI + 1 < size(); nestedI++){
        if (_data.get(nestedI).compareTo(get(size() - 1)) > 0){
          swap(0, size() - 1);
        }
        if (_data.get(nestedI).compareTo(get(nestedI + 1)) > 0){
          swap(nestedI, nestedI + 1);
        }
      }
    }
  }

  // employs ArrayList's set(), and then sorts the list in case
  // the replaced value breaks ascending order.
  public int set(int index, int newVal){
    int oldVal = _data.set(index, newVal);
    sort();
    return oldVal;
  }

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

  // using ArrayList's remove(), removes the element at a certain index and
  // shifts proceeding values one index less.
  public int remove(int index){
    return _data.remove(index);
  }

  
}
