package org.detectiveGame;

import java.util.HashSet;
import java.util.Set;

public class EvidenceData {
    private final Set<String> evidences = new HashSet<>();

    public Set<String> getEvidences() {
        return evidences;
    }


    public void addEvidence(String evidence){
        evidences.add(evidence);

    }

    public boolean deleteEvidence(String evidence){
        if (!evidences.contains(evidence)){

            return false;
        } else {
            evidences.remove(evidence);
            return true;
        }

    }

    public boolean checkForEvidence(String evidence){
        return evidences.contains(evidence);
    }

    public String showAllEvidenceFound(){
        StringBuilder sb = new StringBuilder();
        for(String evidence:evidences){
            sb.append("\n - ").append(evidence);
        }
        return sb.toString();
    }

}
