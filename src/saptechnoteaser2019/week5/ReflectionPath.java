package saptechnoteaser2019.week5;

public class ReflectionPath {

	private static final double ASSYA_TO_SHORE_DISTANCE = 3;
	private static final double GRANNY_TO_SHORE_DISTANCE = 5;
	private static final double ASSYA_TO_GRANNY_SHORELINE_DISTANCE = 10;

	public static void main(String[] args) {
		double x= getXforTheLeastTimePath(0, 10, 1);
		x = getXforTheLeastTimePath(x-1, x+1, 0.1);
		x = getXforTheLeastTimePath(x-0.1, x+0.1, 0.01);
		x = getXforTheLeastTimePath(x-0.01, x+0.01, 0.001);
	}

	private static double getXforTheLeastTimePath(double fromX, double toX, double step) {
		double minPath = Double.MAX_VALUE;
		double xForTheMinPath = 0;
		for(double x = fromX; x <= toX; x += step) {
			double currentPath = Math.sqrt(x*x + ASSYA_TO_SHORE_DISTANCE*ASSYA_TO_SHORE_DISTANCE) + 
					Math.sqrt(
							(ASSYA_TO_GRANNY_SHORELINE_DISTANCE - x)*(ASSYA_TO_GRANNY_SHORELINE_DISTANCE - x) + 
							GRANNY_TO_SHORE_DISTANCE*GRANNY_TO_SHORE_DISTANCE
							);
			if (minPath > currentPath) {
				minPath = currentPath;
				xForTheMinPath = x;
			}
		}
		System.out.println("For X from " + fromX + " to " + toX + " with step " + step + ":");
		System.out.println("\t Min distance=" + minPath + " km for X=" +  xForTheMinPath);
		return xForTheMinPath;
	}
}
