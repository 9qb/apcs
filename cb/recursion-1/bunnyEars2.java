public class bunnyEars2{
  // We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears.
  // The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).

  public int bunnyEars2(int bunnies) {
    int ears = 0;
    if (bunnies == 0){
      ears += 0;
    }
    else if (bunnies == 1){
      ears += 2;
    }
    else{
      if (bunnies % 2 == 1){
        ears += 2 + bunnyEars2(bunnies - 1);
      }
      else{
        ears += 3 + bunnyEars2(bunnies - 1);
      }
    }
    return ears;
  }
}
