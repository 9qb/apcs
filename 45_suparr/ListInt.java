// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// HW45 -- interfaces
// 2021-12-09
// time spent: 0.5 hours

/*
DISCO
- Interfaces basically work as "checklists", making sure a class has certain methods or instance variables before being allowed to compile and run.
- Abstract objects cannot be instantiated.
QCC
- What is the point of interfaces? Can't you use inheritance as a way to make sure certain methods/variables exist?
*/

public interface ListInt{
  public void add(int newVal);
  public void add(int index, int newVal);
  public void remove(int index);
  public int get(int index);
  public int set(int index, int newVal);
  public int size();
}
