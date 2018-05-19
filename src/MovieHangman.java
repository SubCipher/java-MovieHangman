import java.util.Scanner;

public class MovieHangman {

    private static final int maxGuess = 5;

    private String hangThis;

    private int incorrectGuessCount = 0;
    private int correctGuess = 0;
    private int wordLength;

    private boolean didMatch;

    private char[] guessedLettersArray;

    public void gameOn(){

        MovieList myMovies = new MovieList();
        hangThis = myMovies.movieList();

        wordLength = hangThis.toCharArray().length;
        guessedLettersArray = new char[wordLength];

        for (int i = 0; i < guessedLettersArray.length;i++){
            guessedLettersArray[i] = '_';

        }
        while (incorrectGuessCount < (maxGuess) ) {
            System.out.print("guessed letters ");
            System.out.println(guessedLettersArray);
            System.out.println("incorrect guesses: " + incorrectGuessCount);

            Scanner letterScanner = new Scanner(System.in);
            System.out.println(" enter a letter: ");
            char thisLetter = letterScanner.next().charAt(0);

            if (gusessLetterDidMatch(thisLetter)){
                correctGuess++;
                if ((correctGuess + 1) == wordLength) {
                    System.out.println("You Win");
                    System.out.println("puzzle answer = " + hangThis);
                    break;
                }
            }

            else {
                incorrectGuessCount++;
                if (incorrectGuessCount >= maxGuess){
                    System.out.println("Game Over: You Lose");
                    System.out.println("puzzle ans = " + hangThis);
                }
                else {
                    System.out.println("try again" );

                }
            }
        }
    }

    private boolean gusessLetterDidMatch(char gussedLetter){
        int count = 0;

        for (int i = 0; i < wordLength; i++) {

            if (hangThis.toCharArray()[i] == gussedLetter) {

                guessedLettersArray[i] = gussedLetter;
                didMatch = true;
                count++;
            }
        }
        if (count == 0){
            didMatch = false;
        }
       return didMatch;
    }
}