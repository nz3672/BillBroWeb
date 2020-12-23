package ku.ac.th.billbroweb.model;

import java.util.List;

public class CrewmateWrapper {
    private List<CrewmateAdd> crewmateAdds;

    public CrewmateWrapper(List<CrewmateAdd> crewmateAdds) {
        this.crewmateAdds = crewmateAdds;
    }

    public void addCrewmateWrapper(CrewmateAdd crewmateAdd) {
        this.crewmateAdds.add(crewmateAdd);
    }

    public List<CrewmateAdd> getCrewmateAdds() {
        return crewmateAdds;
    }

    public void setCrewmateAdds(List<CrewmateAdd> crewmateAdds) {
        this.crewmateAdds = crewmateAdds;
    }
}
