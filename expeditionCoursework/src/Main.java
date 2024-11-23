import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // Initialising Arrays
        String[] allNames = {"Yusuf", "Alice", "Eshan", "Ashar", "Che", "Kennedy"};
        int[] allStudentIDs = {1001, 1002, 1003, 1004, 1005, 1006};

        // Randomly generate a number between (4-6)
        Random random = new Random();
        int numberOfMembers = random.nextInt(3) + 4; // Generates a random number from (0-2), then +4 to it

        // Debugging print statement:
        // System.out.println(numberOfMembers);

        // Setting Up The Length of the member pool from a random integer between (4-6)
        ExpeditionMember[] members = new ExpeditionMember[numberOfMembers];

        // Shuffling the indicies of the arrays: allNames & allStudentIDs - for random selection
        int[] indicies = {0, 1, 2, 3, 4, 5};
        for (int i = 0; i < indicies.length; i++) {
            int randomIndex = random.nextInt(indicies.length); // Generates a random number between (1-6)
            int temp = indicies[i]; // Store current indicies position as 'temp' variable
            indicies[i] = indicies[randomIndex]; // Puts random index into current indicies position.
            indicies[randomIndex] = temp; // Puts 'temp' variable into randomIndex positio, completing the swap
        }

        // Debugging print statement:
        // System.out.println(Arrays.toString(indicies));

        // Assign new members from shuffled array 'indicies'

        for (int i = 0; i < numberOfMembers; i++) {
            int index = indicies[i]; // storing the randomly generated numbers from indicies as 'index'
            members[i] = new ExpeditionMember(allNames[index], allStudentIDs[index]); // Adding the random index from name and ID array to the members array
        }

        // Debugging print statement:
        // System.out.println("Assigned members:");

        // for (ExpeditionMember member : members) {
        //    System.out.println("[ Name: " + member.getMemberName() + ", Member ID: " + member.getMemberID() + " ]");
        //  }


        ResearchExpedition pyramidExpedition = new ResearchExpedition(members[0], members[1], members[2]);

        ResearchExpedition nileExpedition;
        if (members.length == 4) {
            nileExpedition = new ResearchExpedition(members[3], null, null); // Only Expedition Leader assigned
        } else if (members.length == 5) {
            nileExpedition = new ResearchExpedition(members[3], members[4], null); // Expedition Leader and Archivist assigned
        } else {
            nileExpedition = new ResearchExpedition(members[3], members[4], members[5]); // All roles assigned
        }


        System.out.println("\nPyramid Expedition Roles:");
        pyramidExpedition.printRoles();

        System.out.println("\nNile Expedition Roles:");
        nileExpedition.printRoles();

        // Verify if all members are properly accounted for in expeditions
        int totalAssignedMembers = getTotalAssignedMembers(pyramidExpedition, nileExpedition);

        // Validate the count
        if (totalAssignedMembers == members.length) {
            System.out.println("\nSUCCESS");
        } else {
            System.out.println("\nERROR");
        }



    }

    private static int getTotalAssignedMembers(ResearchExpedition pyramidExpedition, ResearchExpedition nileExpedition) {
        int totalAssignedMembers = 0;

        // Count non-null members in Pyramid Expedition
        if (pyramidExpedition.getExpeditionLeader() != null) totalAssignedMembers++;
        if (pyramidExpedition.getArchivist() != null) totalAssignedMembers++;
        if (pyramidExpedition.getFieldResearcher() != null) totalAssignedMembers++;

        // Count non-null members in Nile Expedition
        if (nileExpedition.getExpeditionLeader() != null) totalAssignedMembers++;
        if (nileExpedition.getArchivist() != null) totalAssignedMembers++;
        if (nileExpedition.getFieldResearcher() != null) totalAssignedMembers++;
        return totalAssignedMembers;
    }
}
