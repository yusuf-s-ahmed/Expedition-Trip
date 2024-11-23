public class ResearchExpedition {
    private ExpeditionMember expeditionLeader;
    private ExpeditionMember archivist;
    private ExpeditionMember fieldResearcher;

    // Constructor

    public ResearchExpedition(ExpeditionMember expeditionLeader, ExpeditionMember archivist, ExpeditionMember fieldResearcher) {
        // If no member is available for a role, use placeholders
        this.expeditionLeader = expeditionLeader != null ? expeditionLeader : new ExpeditionMember("Unassigned", -1);
        this.archivist = archivist != null ? archivist : new ExpeditionMember("Unassigned", -1);
        this.fieldResearcher = fieldResearcher != null ? fieldResearcher : new ExpeditionMember("Unassigned", -1);
    }

    public ExpeditionMember getExpeditionLeader() {
        return expeditionLeader;
    }

    public ExpeditionMember getArchivist() {
        return archivist;
    }

    public ExpeditionMember getFieldResearcher() {
        return fieldResearcher;
    }

    public void printRoles() {
        System.out.println("Expedition Leader: " + expeditionLeader.getMemberName());
        System.out.println("Archivist: " + archivist.getMemberName());
        System.out.println("Field Researcher: " + fieldResearcher.getMemberName());
    }
}
