package saptechnoteaser2022.week3;

import java.util.HashMap;
import java.util.Map;

/* 
 * <h1>Room for everybody</h1>
 * SAPTechnoteaser 2022, Week3, Question1
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2022/#week3,question1">Description and explanation</a>
 * 
 */
public class RoomDistribution {

	private static enum Room {
		  ASIA,
		  BIBI,
		  VILI,
		  DIDI,
		  EMPTY
	}
	
	public static Room getNeighbor(Room p) {
		switch (p) {
			case ASIA: return Room.BIBI;
			case BIBI: return Room.ASIA;
			case VILI: return Room.DIDI;
			case DIDI: return Room.VILI;
			default: return null;
		}
		
	}
	
	public static Room getUnwantedNeighbor(Room p) {
		switch (p) {
			case ASIA: return Room.VILI;
			case VILI: return Room.ASIA;
			default: return null;
		}
	}
	
	public static void main(String[] args) {
		Map<Room, Integer> rooms = new HashMap<>();
		rooms.put(Room.ASIA, 1);
		rooms.put(Room.BIBI, 1);
		rooms.put(Room.VILI, 1);
		rooms.put(Room.DIDI, 1);
		rooms.put(Room.EMPTY, 6);
		
		int possibleRoomConfigurations = findPossibleConfigurations(rooms, null);
		System.out.println(possibleRoomConfigurations);
	}
	
	public static int findPossibleConfigurations (Map<Room, Integer> availableRooms, Room unwantedNeighbor) {
	
		if (availableRooms.size() == 0) {
			//Recursion base case
			return 1;
		}
		
		int currentResult = 0;
		Room[] rooms = availableRooms.keySet().toArray(new Room[availableRooms.size()]);
		
		for (Room currentRoomType : rooms) {
			
			if (!currentRoomType.equals(unwantedNeighbor)) {
				int availableRoomsOfCurrentType = availableRooms.get(currentRoomType);
				if (availableRoomsOfCurrentType == 1) {
					availableRooms.remove(currentRoomType);
				} else {
					availableRooms.put(currentRoomType, availableRoomsOfCurrentType - 1);
				}
				//add also the neighbor in the next room
				Room requiredNeighbor = getNeighbor(currentRoomType);
				if (requiredNeighbor != null) {
					availableRooms.remove(requiredNeighbor);
				}
				
				currentResult += findPossibleConfigurations (availableRooms, getUnwantedNeighbor(currentRoomType));
				
				//revert changes
				if (requiredNeighbor != null) {
					availableRooms.put(requiredNeighbor, 1);
				}
				availableRooms.put(currentRoomType, availableRoomsOfCurrentType);
			}
		}
		
		return currentResult;
	}

}
