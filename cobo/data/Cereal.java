// Team (P)BNJ :: Brian Li, Nakib Abedin, Jefford Shau
// APCS pd07
// LAB08 -- America's Next Top Data Scientist
// 2022-04-05
// time spent: 0.7 hrs + class time

public class Cereal {
    private String name;
    private double calories;
    private double protein;
    private double fat;
    private double sodium;
    private double fiber;
    private double carbs;
    private double sugar;
    private double potassium;
    private double vitamins;
    private double shelf;
    private double weight;
    private double cups;
    private double ratings;

    public Cereal(
      String name,
      double calories,
      double protein,
      double fat,
      double sodium,
      double fiber,
      double carbs,
      double sugar,
      double potassium,
      double vitamins,
      double shelf,
      double weight,
      double cups,
      double ratings)
      {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = protein;
        this.sodium = sodium;
        this.fiber = fiber;
        this.carbs = carbs;
        this.sugar = sugar;
        this.potassium = potassium;
        this.vitamins = vitamins;
        this.shelf = shelf;
        this.weight = weight;
        this.cups = cups;
        this.ratings = ratings;
    }

    public String getName(){return name;}
    public double getCalories(){return calories;}
    public double getProtein(){return protein;}
    public double getFat(){return fat;}
    public double getSodium(){return sodium;}
    public double getFiber(){return fiber;}
    public double getCarbs(){ return carbs;}
    public double getSugar(){ return sugar;}
    public double getPotassium(){ return potassium;}
    public double getVitamins(){ return vitamins;}
    public double getShelf(){ return shelf;}
    public double getWeight(){ return weight;}
    public double getCups() { return cups;}
    public double getRatings() { return ratings;}

    public static void main(String[] args) {
      Cereal cheerios = new Cereal("Cheerios",100.0,20.0,20.0,22.0,30.0,20.0,30.3,40.2,12.4,30.4,12.0,13.0, 60.0);

      System.out.println(cheerios.getName());
      System.out.println(cheerios.getCalories());
      System.out.println(cheerios.getProtein());
      System.out.println(cheerios.getFat());
      System.out.println(cheerios.getSodium());
      System.out.println(cheerios.getFiber());
      System.out.println(cheerios.getCarbs());
      System.out.println(cheerios.getSugar());
      System.out.println(cheerios.getPotassium());
      System.out.println(cheerios.getVitamins());
      System.out.println(cheerios.getShelf());
      System.out.println(cheerios.getWeight());
      System.out.println(cheerios.getCups());
      System.out.println(cheerios.getRatings());
    }


}
