// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// HW47 -- Guess Again
// 2021-12-14
// time spent: 0.5 hours

/***
 * class GuessNumber -- fun fun fun!
 *
 * SKELETON
 *
 * eg, sample interaction with end user:
 *
 * Guess a # fr 1-100: 50
 * Too high
 * Guess a # fr 1-49: 25
 * Too low
 * Guess a # fr 26-49: 38
 * Correct! It took 3 guesses
 ***/

/***
    DISCO:
    - You can simply make a while loop run forever by putting (true) in the condition statement.

    QCC:
    - Is there a better way of choosing a random integer within a range of values?

 ***/
import java.util.Scanner;

public class GuessNumber
{

  //instance vars
  private int _lo, _hi, _guessCtr, _target;
  Scanner sc = new Scanner( System.in );


  /*==================================================
    constructor -- initializes a guess-a-number game
    pre:
    post: _lo is lower bound, _hi is upper bound,
    _guessCtr is 1, _target is random int on range [_lo,_hi]
    ==================================================*/
  public GuessNumber( int a, int b )
  {
    _lo = Math.min(a,b);
    _hi = Math.max(a,b);
    _guessCtr = 1;

    //pick random number in range [a,b]
    int diff = _hi - _lo;
    _target = (int)(Math.random()*(diff + 1) + _lo);
  }


  /*==================================================
    void playRec() -- Prompts a user to guess until guess is correct.
    Uses recursion.
    ==================================================*/

  public void playRec()
  {
    System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
    int guess = sc.nextInt();

    //3 cases: we either found it, too hi, too lo

    if (_target == guess){
      System.out.println("Correct! It took " + _guessCtr + " guesses.");
      return;
    }
    else if (_target < guess){
      System.out.println("Too high");
      if (!(guess > _hi)){
        _hi = guess - 1;
      }
      else{
        System.out.println("Your guess is outside of the range.");
      }
    }
    else{
      System.out.println("Too low");
      if (!(guess < _lo)){
        _lo = guess + 1;
      }
      else{
        System.out.println("Your guess is outside of the range.");
      }
    }

    _guessCtr++;
    playRec();
  }


  /*==================================================
    void playIter() -- Prompts a user to guess until guess is correct.
    Uses iteration.
    ==================================================*/
  public void playIter()
  {

    int guess;

    while( true ) {
      System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
      guess = sc.nextInt();

      //3 cases: we either found it, too hi, too lo

      if (_target == guess){
        System.out.println("Correct! It took " + _guessCtr + " guesses.");
        return;
      }
      else if (_target < guess){
        System.out.println("Too high");
        if (!(guess > _hi)){
          _hi = guess - 1;
        }
        else{
          System.out.println("Your guess is outside of the range.");
        }
      }
      else{
        System.out.println("Too low");
        if (!(guess < _lo)){
          _lo = guess + 1;
        }
        else{
          System.out.println("Your guess is outside of the range.");
        }
      }

      _guessCtr++;
    }
  }


  //wrapper for playRec/playIter to simplify calling
  public void play()
  {
    //use one or the other below:
    // playRec();
    playIter();
  }


  //main method to run it all
  public static void main( String[] args )
  {
    //instantiate a new game
    GuessNumber g = new GuessNumber(1,100);

    //start the game
    g.play();
    /*-----------------------------
    -----------------------------*/
  }

}//end class GuessNumber
