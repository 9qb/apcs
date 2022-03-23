//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW80 - Generically Speaking
//2022-03-23r
//time spent: 0.6 hrs + class time

/*
DISCO
- You cannot use a primitive to parameterize an object.
- Include <name> in the header of a class to parameterize it.
- A class that is parameterized can still be instantiated when the
  variable type is not parameterized.

QCC
- Why can we not use primitives to parameterize an object?
*/

/***
 * interface List
 * subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 *
 * If placed in current working dir, will be consulted instead of
 *  built-in Java library interface.
 *
 * new in version 2.0:
 * REMOVE-AT-INDEX
 * ADD-AT-INDEX
 **/

public interface List<T>
{
  //add node to list, containing input Tas its data
  public boolean add( T x );

  //insert at specified index
  public void add( int index, T newVal );

  //remove node from list, return its data
  public T remove( int index );

  //return data in element at position i
  public T get( int i );

  //overwrite data in element at position i
  public T set( int i, T x );

  //return length of list
  public int size();

}//end interface
