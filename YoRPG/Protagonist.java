public class Protagonist{
  private String name;
  private int health = 100;
  private int nextAttackDmg;

  public Protagonist(String input){
    name = input;
  }

  public String getName(){
    return name;
  }

  public boolean isAlive(){
    return health > 0;
  }

  public void changeHealth(int damage){
    health -= damage;
  }

  public void specialize(){
  //   if (){
  //     nextAttackDmg = 30; //placeholder
  //   }
  //   else{
  //
  //   }
  }

  public void normalize(){
    if (Math.random() > 0.3){
      nextAttackDmg = 10;
    }
    else{
      nextAttackDmg = 0;
    }
  }

  public int attack(Monster enemy){
    enemy.changeHealth(nextAttackDmg);
    return nextAttackDmg;
  }
}
