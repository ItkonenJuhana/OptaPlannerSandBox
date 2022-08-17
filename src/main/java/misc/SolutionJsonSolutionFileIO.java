package misc;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Solution;
import org.optaplanner.persistence.jackson.impl.domain.solution.JacksonSolutionFileIO;

public class SolutionJsonSolutionFileIO extends JacksonSolutionFileIO<Solution> {
    public SolutionJsonSolutionFileIO() {
        super(Solution.class, new ObjectMapper()
        );
    }
}