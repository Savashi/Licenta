package ro.cristin.dto;

import java.util.List;

public class GraphDTO {
    private List<NodeDTO> nodeDTOList;
    private List<EdgeDTO> edgeDTOList;

    public GraphDTO(List<NodeDTO> nodeDTOList, List<EdgeDTO> edgeDTOList) {
        this.nodeDTOList = nodeDTOList;
        this.edgeDTOList = edgeDTOList;
    }

    public List<NodeDTO> getNodeDTOList() {
        return nodeDTOList;
    }

    public void setNodeDTOList(List<NodeDTO> nodeDTOList) {
        this.nodeDTOList = nodeDTOList;
    }

    public List<EdgeDTO> getEdgeDTOList() {
        return edgeDTOList;
    }

    public void setEdgeDTOList(List<EdgeDTO> edgeDTOList) {
        this.edgeDTOList = edgeDTOList;
    }
}
