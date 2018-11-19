package lab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Snake game
 * <p>
 * Initially a gold coin is randomly placed in the matrix and the snakes head is placed at the center of it.
 * The snake aims to collect coins which disappear after collection. Whenever the snake collects a coin the snake grows by one tile
 * and a new coin is spawned at a random position in the matrix. The game ends if
 * the snake head collides with the snakes body, if the snake head collides with a wall or
 * if the snake grows to be as large as the entire game board.
 */
	
public class SnakeModel extends GameModel{
	public enum Directions {
		EAST(1, 0),
		WEST(-1, 0),
		NORTH(0, -1),
		SOUTH(0, 1),
	    NONE(0, 0);
		
		private final int xDelta;
		private final int yDelta;

		Directions(final int xDelta, final int yDelta) {
			this.xDelta = xDelta;
			this.yDelta = yDelta;
		}

		public int getXDelta() {
			return this.xDelta;
		}

		public int getYDelta() {
			return this.yDelta;
		}
	}
	
	/** Graphical representation of a coin. */
	private static final GameTile COIN_TILE = new RoundTile(new Color(255, 215,
			0),
			new Color(255, 255, 0), 2.0);

	/** Graphical representation of the snake head */
	private static final GameTile HEAD_TILE = new HeadTile(Color.BLACK,
			Color.GREEN, 2.0);
	
	/** Graphical representation of the snakes body */
	private static final GameTile BODY_TILE = new RoundTile(Color.BLACK,Color.GREEN,2.0);

	/** Graphical representation of a blank tile. */
	private static final GameTile BLANK_TILE = new GameTile();
	
	/** A list containing the positions of all parts of the snake. */
	private ArrayDeque<Position> snakePos = new ArrayDeque<Position>();
	
	/** Position of the coin. */
	private Position coinPos;
	
	/** The direction of the snake. */
	private Directions direction = Directions.NORTH;
	
	/** The number of coins eaten */
	private int score;
	
	/**
	 * Create a new model for the snake game.
	 */
	public SnakeModel() {
		Dimension size = getGameboardSize();

		// Blank out the whole gameboard
		for (int i = 0; i < size.width; i++) {
			for (int j = 0; j < size.height; j++) {
				setGameboardState(i, j, BLANK_TILE);
			}
		}

		// Insert the snake in the middle of the gameboard.
		Position snakeStart = new Position(size.width/2,size.height/2);
		this.snakePos.add(snakeStart);
		setGameboardState(this.snakePos.getFirst(), HEAD_TILE);

		// Insert coin into the gameboard.
		addCoin();
	}
	
	/**
	 * Insert another coin into the gameboard.
	 */
	private void addCoin() {
		Position newCoinPos;
		Dimension size = getGameboardSize();
		// Loop until a blank position is found and ...
		do {
			newCoinPos = new Position((int) (Math.random() * size.width),
										(int) (Math.random() * size.height));
		} while (!isPositionEmpty(newCoinPos) && this.snakePos.size() != 100);

		// ... add a new coin to the empty tile.
		setGameboardState(newCoinPos, COIN_TILE);
		this.coinPos = newCoinPos;
	}
	
	/**
	 * Return whether the specified position is empty.
	 * 
	 * @param pos
	 *            The position to test.
	 * @return true if position is empty.
	 */
	private boolean isPositionEmpty(final Position pos) {
		return (getGameboardState(pos) == BLANK_TILE);
	}
	
	/**
	 * Update the direction of the snake
	 * according to the user's keypress.
	 */
	private void updateDirection(final int key) {
		switch (key) {
			case KeyEvent.VK_LEFT:
				if(this.direction == Directions.EAST && snakePos.size() > 1) {
					break; //The snake cannot go backwards.
				}
				this.direction = Directions.WEST;
				break;
			case KeyEvent.VK_UP:
				if(this.direction == Directions.SOUTH && snakePos.size() > 1) {
					break;
				}
				this.direction = Directions.NORTH;
				break;
			case KeyEvent.VK_RIGHT:
				if(this.direction == Directions.WEST && snakePos.size() > 1) {
					break;
				}
				this.direction = Directions.EAST;
				break;
			case KeyEvent.VK_DOWN:
				if(this.direction == Directions.NORTH && snakePos.size() > 1) {
					break;
				}
				this.direction = Directions.SOUTH;
				break;
			default:
				// Don't change direction if another key is pressed
				break;
		}
	}
	
	/**
	 * Get next position of the snake.
	 */
	private Position getNextSnakePos() {
		Position nextSnakePos = new Position(this.snakePos.getFirst().getX() + this.direction.getXDelta(),
							this.snakePos.getFirst().getY() + this.direction.getYDelta());
		return nextSnakePos;
	}
	
	/**
	 * This method is called repeatedly so that the
	 * game can update its state.
	 * 
	 * @param lastKey
	 *            The most recent keystroke.
	 */
	@Override
	public void gameUpdate(final int lastKey) throws GameOverException {
		updateDirection(lastKey);	
		
		// End game if snake has crashed into himself
		if(this.snakePos.contains(getNextSnakePos())) {
			throw new GameOverException(this.score);
		}
		
		//Add the new position of the head to snakePos
		setGameboardState(this.snakePos.getFirst(), BODY_TILE);
		this.snakePos.addFirst(getNextSnakePos());

		
		//Game over if snake is out of bounds
		if (isOutOfBounds(this.snakePos.getFirst())) {
			throw new GameOverException(this.score);
		}
		
		/* Remove the coin at the new snake head position (if any) and add a new coin
		 * Else replace the last part of the snake with a blank tile and 
		 * remove the last part from snakePos.
		 */
		if (this.coinPos.equals(this.snakePos.getFirst())) {
			this.score++;
			addCoin();
		}else{
			setGameboardState(this.snakePos.getLast(), BLANK_TILE);	
			this.snakePos.removeLast();
		}
		
		//Add a head tile to the snake heads new position.
		setGameboardState(this.snakePos.getFirst(), HEAD_TILE);
	

		// Check if snake is max size
		if (this.snakePos.size() == 100) {
			throw new GameOverException(this.score + 5);
		}
	}

	/**
	 * 
	 * @param pos The position to test.
	 * @return <code>false</code> if the position is outside the playing field, <code>true</code> otherwise.
	 */
	private boolean isOutOfBounds(Position pos) {
		return pos.getX() < 0 || pos.getX() >= getGameboardSize().width
				|| pos.getY() < 0 || pos.getY() >= getGameboardSize().height;
	}
}
