package ro.cristin.service;

import ro.cristin.dto.GraphDTO;
import ro.cristin.dto.ResultDTO;
import ro.cristin.model.UserDO;

import java.util.List;

public interface GraphService {
    GraphDTO getGraph();
    List<ResultDTO> getResults(UserDO currentUser, int threshold);

}
