package lab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.*;

//import lab1.GoldModel.Directions;
	
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
	//private static final int COIN_START_AMOUNT = 1;
	
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
	 * Update the direction of the collector
	 * according to the user's keypress.
	 */
	private void updateDirection(final int key) {
		switch (key) {
			case KeyEvent.VK_LEFT:
				if(this.direction == Directions.EAST) {
					break;
				}
				this.direction = Directions.WEST;
				break;
			case KeyEvent.VK_UP:
				if(this.direction == Directions.SOUTH) {
					break;
				}
				this.direction = Directions.NORTH;
				break;
			case KeyEvent.VK_RIGHT:
				if(this.direction == Directions.WEST) {
					break;
				}
				this.direction = Directions.EAST;
				break;
			case KeyEvent.VK_DOWN:
				if(this.direction == Directions.NORTH) {
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

		// Erase the previous position.
		setGameboardState(this.snakePos.getLast(), BLANK_TILE);	
		
		if(this.snakePos.size() > 1) {
		setGameboardState(this.snakePos.getFirst(), BODY_TILE);
		}
		// Change snake position.
		Position tail = new Position(snakePos.getLast().getX(),snakePos.getLast().getY());
		
		// End game if snake has crashed into himself
		
		if(this.snakePos.contains(getNextSnakePos())) {
			throw new GameOverException(this.score);
			
		}
		
		this.snakePos.addFirst(getNextSnakePos());
		//Change if snake out of bounds
		
		if (isOutOfBounds(this.snakePos.getFirst())) {
			throw new GameOverException(this.score);
		}
		
		//Update snake
		
	
		this.snakePos.removeLast();
		/** Remove the coin at the new snake head position (if any)
		 * Add a body part to the snake and add a new coin at a random empty position.
		 * Draw another coin and the new body part of the snake.
		 */
		if (this.coinPos.equals(this.snakePos.getFirst())) {
			this.score++;
			snakePos.addLast(tail);
			setGameboardState(tail,BODY_TILE);
			setGameboardState(coinPos, BLANK_TILE);
			addCoin();
			setGameboardState(coinPos,COIN_TILE);
		}
		
		// Draw collector at new position.
		setGameboardState(this.snakePos.getFirst(), HEAD_TILE);
	

		// Check if all coins are found
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
