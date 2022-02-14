public class bunnyEars{
  // We have a number of bunnies and each bunny has two big floppy ears.
  // We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).

  public int bunnyEars(int bunnies) {
    int ears = 0;
    if (bunnies == 0){
      ears += 0;
    }
    else if (bunnies == 1){
      ears += 2;
    }
    else{
      ears += 2 + bunnyEars(bunnies - 1);
    }
    return ears;
  }
}
