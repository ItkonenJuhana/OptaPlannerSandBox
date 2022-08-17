package misc;

import java.io.File;

public interface SolutionFileIO<Solution_> {
    Solution_ read(File inputSolutionFile);
    void write(Solution_ solution, File outputSolutionFile);
}

