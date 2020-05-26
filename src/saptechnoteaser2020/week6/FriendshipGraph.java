package saptechnoteaser2020.week6;

import java.util.ArrayList;
import java.util.List;
/* 
 * <h1>Friends and Strangers</h1>
 * SAPTechnoteaser 2020, Week6, Question1
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2020/#week6,question1">Description and explanation</a>
 * 
 */
public class FriendshipGraph {

	public static final int NUMBER_OF_PEOPLE = 6;
	
	List<List<Integer>> peopleFriends = new ArrayList<List<Integer>>(6); 
			
	public static void main(String[] args) {

		boolean graphWithout3FullFriendsOrStrangers = false;
		boolean graphWith1CommonFriendForEvery2People = false;
		boolean graphWith3StrangersAndEverybodyHas2Friends = false;
		boolean graphWithAtLeast1CommonFriendWithout4FullFriends = false;
		
		int numberOfPairs = NUMBER_OF_PEOPLE*(NUMBER_OF_PEOPLE-1)/2;
		int everybodyKnowsEverybodyGraph = (1 << numberOfPairs) - 1;

		for(int i=0; i<=everybodyKnowsEverybodyGraph; i++) {
			FriendshipGraph graph = new FriendshipGraph(NUMBER_OF_PEOPLE, i);
			
			boolean have3FullFriends = graph.haveGroupOf3FullFriends();
			boolean have3FullStrangers = graph.haveGroupOf3FullStrangers();
			if (!have3FullFriends && !have3FullStrangers) {
				graphWithout3FullFriendsOrStrangers = true;
				System.out.println("There is no group of 3 full friends or full strangers:");
				graph.print();
			}
			
			if (!graphWith3StrangersAndEverybodyHas2Friends && have3FullStrangers && graph.everybodyHas2Friends()) {
				graphWith3StrangersAndEverybodyHas2Friends = true;
				System.out.println("3 strangers and everybody has 2 friends:");
				graph.print();
			}
			if (!graphWithAtLeast1CommonFriendWithout4FullFriends && graph.every2PeopleHaveAtLeast1CommonFriend() && !graph.haveGroupOf4FullFriends()) {
				graphWithAtLeast1CommonFriendWithout4FullFriends = true;
				System.out.println("Every 2 people have at least 1 common friend but there is no group of 4 full friends:");
				graph.print();
			}
			
			if (graph.every2PeopleHave1CommonFriend()) {
				graphWith1CommonFriendForEvery2People = true;
				System.out.println("Every 2 people have exactly 1 common friend:");
				graph.print();
			}
			
		}
		
		if (!graphWithout3FullFriendsOrStrangers) {
			System.out.println("In every graph we can find 3 full friends or 3 full strangers.");
		}
		if (!graphWith1CommonFriendForEvery2People) {
			System.out.println("There is no graph where every 2 people have 1 common friend.");
		}
	}
	
	private FriendshipGraph() {}
	
	public FriendshipGraph (int numberOfPeople, int friendshipRelationsEncodedInInt) {
		for (int i = 1; i <= numberOfPeople; i++) {
			peopleFriends.add(new ArrayList<>(numberOfPeople - 1));
		}
		for(int p1 = 0; p1 < 5; p1++) {
			for(int p2 = p1+1; p2 < 6; p2++) {
				boolean p1KnowsP2 = (friendshipRelationsEncodedInInt & 1) == 1;
				if (p1KnowsP2) {
					peopleFriends.get(p1).add(p2);
					peopleFriends.get(p2).add(p1);
				}
				friendshipRelationsEncodedInInt = friendshipRelationsEncodedInInt >> 1;
			}
		}
	}
	
	public boolean every2PeopleHave1CommonFriend() {
		for (int p1 = 0; p1 < 5; p1++)
			for(int p2 = p1+1; p2 < 6; p2++) {
				//if i and j do not have exactly 1 common friend - fail
				List<Integer> p1Friends = peopleFriends.get(p1);
				List<Integer> p2Friends = peopleFriends.get(p2);
				List<Integer> commonFriends = new ArrayList<Integer>(p1Friends);
				commonFriends.retainAll(p2Friends);
				if (commonFriends.size() != 1) {
					return false;
				}
			}
		return true;
	}
	public boolean every2PeopleHaveAtLeast1CommonFriend() {
		for (int p1 = 0; p1 < 5; p1++)
			for(int p2 = p1+1; p2 < 6; p2++) {
				//if i and j do not have exactly 1 common friend - fail
				List<Integer> p1Friends = peopleFriends.get(p1);
				List<Integer> p2Friends = peopleFriends.get(p2);
				List<Integer> commonFriends = new ArrayList<Integer>(p1Friends);
				commonFriends.retainAll(p2Friends);
				if (commonFriends.size() == 0) {
					return false;
				}
			}
		return true;
	}
	
	public boolean haveGroupOf3FullFriends() {
		List<List<Integer>> peopleOfInterest = new ArrayList<>(peopleFriends);
		peopleOfInterest.removeIf(friends -> friends.size() < 2);
		if (peopleOfInterest.size() < 3) {
			return false;
		}
		int numberOfPeopleOfInterest = peopleOfInterest.size();
		for(int p1 = 0; p1 < numberOfPeopleOfInterest - 1; p1++)
			for (int p2 = p1+1; p2 < numberOfPeopleOfInterest; p2++) {
				//check if person i and j have a common friend, forming a group of full friends
				List<Integer> p1Friends = peopleFriends.get(p1);
				if (!p1Friends.contains(p2)) {
					//i and j are not friends
					continue;
				}
				List<Integer> p2Friends = peopleFriends.get(p2);
				List<Integer> commonFriends = new ArrayList<Integer>(p1Friends);
				commonFriends.retainAll(p2Friends);
			    if (commonFriends.size() > 0) {
			    	return true;
			    }
		}
		return false;
	}
	public boolean haveGroupOf4FullFriends() {
		List<List<Integer>> peopleOfInterest = new ArrayList<>(peopleFriends);
		peopleOfInterest.removeIf(friends -> friends.size() < 3);
		if (peopleOfInterest.size() < 4) {
			return false;
		}
		int numberOfPeopleOfInterest = peopleOfInterest.size();
		for(int p1 = 0; p1 < numberOfPeopleOfInterest - 2; p1++)
			for (int p2 = p1 + 1; p2 < numberOfPeopleOfInterest-1; p2++) {
				//check if person i and j have a common friend, forming a group of full friends
				List<Integer> p1Friends = peopleFriends.get(p1);
				if (!p1Friends.contains(p2)) {
					//i and j are not friends
					continue;
				}
				List<Integer> p2Friends = peopleFriends.get(p2);
				List<Integer> commonFriends = new ArrayList<Integer>(p1Friends);
				commonFriends.retainAll(p2Friends);
				for (int p3 = p2 + 1; p3 < numberOfPeopleOfInterest; p3++) {
					List<Integer> p3Friends = peopleFriends.get(p3);
					if (!commonFriends.contains(p3)) {
						continue;
					}
					commonFriends.retainAll(p3Friends);
				    if (commonFriends.size() > 0) {
				    	return true;
				    }
				}
		}
		return false;
	}
	
	private FriendshipGraph getReversedGraph() {
		FriendshipGraph reversedGraph = new FriendshipGraph();
		int numberOfPeople = this.peopleFriends.size();
		List<Integer> fullListOfFriends = new ArrayList<>(numberOfPeople);
		for (int i=0; i<numberOfPeople; i++) {
			fullListOfFriends.add(i);
		}
		for (int i=0; i<numberOfPeople; i++) {
			List<Integer> originalFriends = peopleFriends.get(i);
			List<Integer> reversedFriends = new ArrayList<>(fullListOfFriends);
			//remove object (not index) i - this is the self reference
			reversedFriends.remove(i);
			reversedFriends.removeAll(originalFriends);
			reversedGraph.peopleFriends.add(reversedFriends);
		}
		return reversedGraph;
	}
	
	public boolean haveGroupOf3FullStrangers() {
		return getReversedGraph().haveGroupOf3FullFriends();
	}
	
	public boolean everybodyHas2Friends() {
		for(List<Integer> friends:peopleFriends) {
			if (friends.size() != 2) {
				return false;
			}
		}
		return true;
	}
	

	public void print() {
		for(int i=0; i<peopleFriends.size(); i++) {
			System.out.println(i + ":" + peopleFriends.get(i));
		}
		System.out.println();
	}
}
