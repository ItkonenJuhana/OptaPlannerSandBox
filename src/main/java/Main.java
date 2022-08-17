import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Item;
import models.Solution;
import models.Tank;
import org.optaplanner.benchmark.api.PlannerBenchmark;
import org.optaplanner.benchmark.api.PlannerBenchmarkFactory;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import java.io.FileWriter;

import java.io.File;;

public class Main {

    public static void main(String[] args) {
        SolverFactory<Solution> solverFactory = SolverFactory
                .createFromXmlResource("SolverConfig.xml");

        // Load the problem
        Solution problem = Solution.generateDemoData();

        Integer totalItemsQty = problem.getItems().stream().map(Item::getQty).reduce(0, Integer::sum);
        Integer totalTanksCapacity = problem.getTanks().stream().map(Tank::getCapacity).reduce(0, Integer::sum);

        System.out.println("Total qty");
        System.out.println(totalItemsQty);
        System.out.println("Total capacity");
        System.out.println(totalTanksCapacity);
        // Generate benchmark
        try {
            FileWriter myWriter = new FileWriter("local/data/data.txt");
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(problem);
            myWriter.write(json);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        PlannerBenchmarkFactory benchmarkFactory = PlannerBenchmarkFactory
                .createFromXmlFile (new File("src/main/resources/SolverBenchmark.xml"));
        PlannerBenchmark benchmark = benchmarkFactory.buildPlannerBenchmark();
        benchmark.benchmarkAndShowReportInBrowser();

        // Solve problem
        Solver<Solution> solver = solverFactory.buildSolver();
        Solution solution = solver.solve(problem);

        System.out.println(solution.getScore());
    }
}