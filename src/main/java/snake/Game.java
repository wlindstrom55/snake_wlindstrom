package snake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * All of the responsibility for actually executing the game
 * will be pushed into our Game class. This is where we’ll get input
 * from the player, display the board, keep track of point totals,
 * and manage everything else that our program does.
 * As our program gets longer and more complex, we’ll start breaking
 * parts of Game’s functionality off into new classes. Maybe we’ll have
 * a Renderer that will be responsible for displaying the game state.
 * We might also want a Player class that takes charge of asking the 
 * player (or maybe an AI) for their next move. We might even want a
 * Board class, dedicated to managing the positions of our Snakes and Apples.
 */
public class Game {
	int width;
	int height;
	List<List<String>> matrix;
	

	Game(int height, int width) {
		this.width = width;
		this.height = height;
	}
	
	public List<List<String>> boardMatrix(int width, int height) {
		//TODO does this need to be a string? Could it just be a character?
        List<List<String>> listOfLists = new ArrayList<List<String>>(width);
        for(int i = 0; i < width; i++)  {
            listOfLists.add(new ArrayList<String>());
            for (int e = 0; e < height; e++) {
            	listOfLists.get(i).add("-"); //changed from null to this for now TODO
            }
        }// end for loops
        return listOfLists;
	}

	public String createNorthAndSouthBorders(int width) {
		String northAndSouthBorders = "+";
		for (int i = 0; i < width; i++) {
			northAndSouthBorders += "-";
		}
		northAndSouthBorders += "+";
		return northAndSouthBorders;
	}

	public void render() {
		System.out.println("Width is: " + width);
		System.out.println("Height is: " + height);
		String topAndBottom = createNorthAndSouthBorders(width);
		matrix = this.boardMatrix(width, height); //moved matrix into an instance object
		//TODO print matrix in a for loop
		//TODO think: why is this now printing correctly after I changed the right border to println?
		System.out.println(topAndBottom); //top border
		for(int i = 0; i < width; i++) {
			System.out.print("|"); //left side border
			for(int e = 0; e < height; e++) {
				System.out.print(matrix.get(i).get(e));
			}
			System.out.println("|"); //right side border
		}
		System.out.println(topAndBottom); //bottom border
	}
	
public static void main (String[] args) {
	Game game = new Game(10, 10);
	game.render();
}


	
} //end game class
