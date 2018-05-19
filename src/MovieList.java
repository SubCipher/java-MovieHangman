import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MovieList {

    private String moviesFromText;
    private String[] movieArray;
    private int movieCount;

    public String movieList() {
        this.movieArray = new String[500];
        this.movieCount = 0;
        moviePick("movies.txt");

        return moviesFromText;
    }

    private void moviePick(String movieFileName){

       movieFileOpen(movieFileName);
       moviesFromText = movieArray[randomNum()];
    }

   private void movieFileOpen(String movieList){

        Scanner scanner;

        try{
            scanner = new Scanner(new File(movieList));

            while (scanner.hasNextLine()){
                movieArray[movieCount] = scanner.nextLine();
                movieCount++;
            }
        }

        catch(FileNotFoundException exception) {
            System.out.println("unable to parse file");
        }
    }

    private int randomNum(){

        double movieNumber = Math.random();

        movieNumber = movieNumber * 6;
        movieNumber = movieNumber + 1;

        return(int) movieNumber;
    }
}
