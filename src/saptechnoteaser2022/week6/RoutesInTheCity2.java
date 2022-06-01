package saptechnoteaser2022.week6;

/* 
 * <h1>Routes in the city</h1>
 * SAPTechnoteaser 2022, Week6, Question2
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2022/#week6,question2">Description and explanation</a>
 * @author Добромир Кралчев
 */ 
public class RoutesInTheCity2 extends Object {

	// Board
	private static final int ROWS_NUM = 6;
	private static final int COLS_NUM = 6;
	private static final int FIELD_NUM = ROWS_NUM * COLS_NUM;

	// Input data
	private static final int FIRST_CELL_ROW = 0;
	private static final int FIRST_CELL_COL = 0;
	private static final int LAST_CELL_ROW = ROWS_NUM - 1;
	private static final int LAST_CELL_COL = COLS_NUM - 2;
	private static final int TURNS_NUM = 17;

	// Moves
	private static final int NOWHERE = 0;
	private static final int NORTH = 1;
	private static final int EAST = 2;
	private static final int SOUTH = 3;
	private static final int WEST = 4;

	// Local variables of search

	private static int routesCount;

	private static int directions[][];
	private static int unvisited;

	private static void init() {
		int row, col;
		routesCount = 0;
		directions = new int[ROWS_NUM][COLS_NUM];
		for (row = 0; row < ROWS_NUM; ++row)
			for (col = 0; col < COLS_NUM; ++col)
				directions[row][col] = NOWHERE;
		unvisited = FIELD_NUM;
	}

	private static void reportRoute() {
		final int CANVAS_HEIGHT = 2 * ROWS_NUM - 1;
		final int CANVAS_WIDTH = 3 * COLS_NUM - 2;
		boolean travelling = true;
		int row, col;
		char[][] canvas = new char[CANVAS_HEIGHT][CANVAS_WIDTH];
		for (row = 0; row < CANVAS_HEIGHT; ++row)
			for (col = 0; col < CANVAS_WIDTH; ++col)
				canvas[row][col] = ' ';
		row = FIRST_CELL_ROW;
		col = FIRST_CELL_COL;
		while (travelling) {
			canvas[2 * row][3 * col] = 'o';
			switch (directions[row][col]) {
			case NOWHERE:
				travelling = false;
				break;
			case NORTH:
				canvas[2 * row - 1][3 * col] = '|';
				--row;
				break;
			case SOUTH:
				canvas[2 * row + 1][3 * col] = '|';
				++row;
				break;
			case EAST:
				canvas[2 * row][3 * col + 1] = '-';
				canvas[2 * row][3 * col + 2] = '-';
				++col;
				break;
			case WEST:
				canvas[2 * row][3 * col - 1] = '-';
				canvas[2 * row][3 * col - 2] = '-';
				--col;
				break;
			}
		}
		++routesCount;
		System.out.print("Route number ");
		System.out.print(routesCount);
		System.out.println(":");
		System.out.println();
		for (row = 0; row < CANVAS_HEIGHT; ++row) {
			for (col = 0; col < CANVAS_WIDTH; ++col)
				System.out.print(canvas[row][col]);
			System.out.println();
		}
		System.out.println();
		System.out.println();
		canvas = null;
	}

	private static int isTurn(int newMove, int oldMove) {
		if (oldMove == newMove) // direction not changed
			return 0;
		if (oldMove == NOWHERE) // no old move
			return 0;
		return 1;
	}

	private static void findRoutesRec(int row, int col, int turnsAvail, int lastMove) {
		if (row < 0 || row >= ROWS_NUM)
			return; // out of the board
		if (col < 0 || col >= COLS_NUM)
			return; // out of the board
		if (turnsAvail < 0)
			return; // too many turns
		if (directions[row][col] != NOWHERE)
			return; // field already visited
		--unvisited;
		if (unvisited == 0 && turnsAvail == 0 && row == LAST_CELL_ROW && col == LAST_CELL_COL)
			reportRoute();
		else if (unvisited > 0 && (row != LAST_CELL_ROW || col != LAST_CELL_COL)) {
			directions[row][col] = NORTH;
			findRoutesRec(row - 1, col, turnsAvail - isTurn(NORTH, lastMove), NORTH);
			directions[row][col] = SOUTH;
			findRoutesRec(row + 1, col, turnsAvail - isTurn(SOUTH, lastMove), SOUTH);
			directions[row][col] = EAST;
			findRoutesRec(row, col + 1, turnsAvail - isTurn(EAST, lastMove), EAST);
			directions[row][col] = WEST;
			findRoutesRec(row, col - 1, turnsAvail - isTurn(WEST, lastMove), WEST);
			directions[row][col] = NOWHERE;
		}
		++unvisited;
	}

	private static void findRoutes() {
		init();
		findRoutesRec(FIRST_CELL_ROW, FIRST_CELL_COL, TURNS_NUM, NOWHERE);
	}

	public static void main(String args[]) {
		System.out.println("Routes:");
		System.out.println();
		System.out.println();
		findRoutes();
		System.out.println("===============================================");
		System.out.print("Total count of routes: ");
		System.out.print(routesCount);
		System.out.println(".");
	}
}
