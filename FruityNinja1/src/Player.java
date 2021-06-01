
public class Player {
	private int score;
	private int lives;
	
	public Player() {
		score = 0;
		lives = 3;
	}
	
	public int getScore() {
		return score;
	}
	public void addScore(int pscore) {
		score += pscore;
	}
	public void removeLife() {
		lives--;
	}
	public int getLives() {
		return lives;
	}
	
}
