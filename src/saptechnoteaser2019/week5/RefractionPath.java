package saptechnoteaser2019.week5;

public class RefractionPath {

	private static final double ASSEN_TO_SHORE_DISTANCE = 3;
	private static final double GRANDPA_TO_SHORE_DISTANCE = 5;
	private static final double ASSEN_TO_GRANDPA_SHORELINE_DISTANCE = 6;
	private static final double WALK_TO_SWIM_SPEED_RATIO = 2;
	
	
	public static void main(String[] args) {
		double x= findXforTheLeastTimePath(0, 6, 1);
		x = findXforTheLeastTimePath(x-1, x+1, 0.1);
		x = findXforTheLeastTimePath(x-0.1, x+0.1, 0.01);
		x = findXforTheLeastTimePath(x-0.01, x+0.01, 0.001);
		x = findXforTheLeastTimePath(x-0.001, x+0.001, 0.0001);
		x = findXforTheLeastTimePath(x-0.0001, x+0.0001, 0.00001);
	}	
	
	private static double findXforTheLeastTimePath(double fromX, double toX, double step) {
		double leastTime = Double.MAX_VALUE;
		double distanceOfTheLeastTimePath = 0;
		double xForTheLeastTimePath = 0;
		for (double x = fromX; x <= toX; x += step) {
			double d1 = Math.sqrt(x*x + ASSEN_TO_SHORE_DISTANCE*ASSEN_TO_SHORE_DISTANCE); 
			double d2 = Math.sqrt(
					(ASSEN_TO_GRANDPA_SHORELINE_DISTANCE - x)*(ASSEN_TO_GRANDPA_SHORELINE_DISTANCE - x) + 
					GRANDPA_TO_SHORE_DISTANCE*GRANDPA_TO_SHORE_DISTANCE
					);
			double timeForCurrentPath = d1 + WALK_TO_SWIM_SPEED_RATIO*d2;
			if (leastTime > timeForCurrentPath) {
				leastTime = timeForCurrentPath;
				distanceOfTheLeastTimePath = d1 + d2;
				xForTheLeastTimePath = x;
			}
		}
		System.out.println("For x from " + fromX + " to " + toX + " with step " + step + ":");
		System.out.println("\t Least time=" + leastTime + " for x=" +  xForTheLeastTimePath + " with overall distance=" + distanceOfTheLeastTimePath + " km");
		return xForTheLeastTimePath;
	}
}
