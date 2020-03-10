package CelebrityLab;

import java.util.ArrayList;

/**
 * The framework for the Celebrity Game project
 * 
 * @author cody.henrichsen
 * @version 2.3 25/09/2018 refactored the prepareGame and play methods
 */
public class CelebrityGame
{
	/**
	 * A reference to a Celebrity or subclass instance.
	 */
	private Celebrity gameCelebrity;

	/**
	 * The GUI frame for the Celebrity game.
	 */
	private CelebrityFrame gameWindow;

	/**
	 * The ArrayList of Celebrity values that make up the game
	 */
	private ArrayList<Celebrity> celebGameList;

	/**
	 * Builds the game and starts the GUI
	 */
	public CelebrityGame()
	{
		gameWindow = new CelebrityFrame(this);
	}

	/**
	 * Prepares the game to start by re-initializing the celebGameList and having the gameFrame open the start screen.
	 */
	public void prepareGame()
	{
		celebGameList = new ArrayList<Celebrity>();
		gameWindow.replaceScreen("START");
	}

	/**
	 * Determines if the supplied guess is correct.
	 * 
	 * @param guess
	 *            The supplied String
	 * @return Whether it matches regardless of case or extraneous external
	 *         spaces.
	 */
	public boolean processGuess(String guess)
	{
		guess = guess.trim();
		
		if (this.gameCelebrity.getName().equalsIgnoreCase(guess)){
			celebGameList.remove(this.gameCelebrity);
			if (getCelebrityGameSize() > 0) {
				this.gameCelebrity = celebGameList.get(0);
			}
			else {
				this.gameCelebrity = new Celebrity("", "");
			}
			return true;
		}
		
		return false;
	}

	/**
	 * Asserts that the list is initialized and contains at least one Celebrity.
	 * Sets the current celebrity as the first item in the list. Opens the game
	 * play screen.
	 */
	public void play()
	{
		if (celebGameList != null && celebGameList.size() > 0) {
			this.gameCelebrity = celebGameList.get(0);
			gameWindow.replaceScreen("Game");
		}
		
	}

	/**
	 * Adds a Celebrity of specified type to the game list
	 * 
	 * @param name
	 *            The name of the celebrity
	 * @param clues
	 *            The clue(s) for the celebrity
	 * @param type
	 *            What type of celebrity
	 */
	public void addCelebrity(String name, String clues, String type)
	{
		if (type.equals("Sport")) {
			celebGameList.add(new SportCelebrity(name, clues));
		}
		else if (type.equals("Literature")) {
			celebGameList.add(new LiteratureCelebrity(name, clues));
		}
		else {
			celebGameList.add(new Celebrity(name, clues));
		}
	}

	/**
	 * Validates the name of the celebrity. It must have at least 4 characters.
	 * @param name The name of the Celebrity
	 * @return If the supplied Celebrity is valid
	 */
	public boolean validateCelebrity(String name)
	{
		name = name.trim();
		return name.length() >= 4;
	}

	/**
	 * Checks that the supplied clue has at least 10 characters or is a series of clues
	 * This method would be expanded based on your subclass of Celebrity.
	 * @param clue The text of the clue(s)
	 * @param type Supports a subclass of Celebrity 
	 * @return If the clue is valid.
	 */
	public boolean validateClue(String clue, String type)
	{
		clue = clue.trim();
		boolean validClue = false;
		
		if (clue.length()>=10) {
			
			validClue = true;
			
			if (type.equalsIgnoreCase("sport")) {
				String clues [] = clue.split(",");
				if (clues.length > 1)
					validClue = true;
				else
					validClue = false;
			}
			
			if (type.equalsIgnoreCase("sport")) {
				String clues [] = clue.split(",");
				if (clues.length > 1)
					validClue = true;
				else
					validClue = false;
			}
			
		}
		return validClue;
	}

	/**
	 * Accessor method for the current size of the list of celebrities
	 * 
	 * @return Remaining number of celebrities
	 */
	public int getCelebrityGameSize()
	{
		return celebGameList.size();
	}

	/**
	 * Accessor method for the games clue to maintain low coupling between
	 * classes
	 * 
	 * @return The String clue from the current celebrity.
	 */
	public String sendClue()
	{
		return gameCelebrity.getClue();
	}

	/**
	 * Accessor method for the games answer to maintain low coupling between
	 * classes
	 * 
	 * @return The String answer from the current celebrity.
	 */
	public String sendAnswer()
	{
		return null;
	}
}
