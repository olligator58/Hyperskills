import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.dynamic.input.DynamicTesting;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testing.TestedProgram;

import java.util.List;
import java.util.regex.Pattern;

import static org.hyperskill.hstest.testing.expect.Expectation.expect;

public class LogbackTasksTest extends StageTest<Object> {

    @DynamicTest
    DynamicTesting[] tests = {
            () -> checkLogMessage(3, 5),
            () -> checkLogMessage(1, 2),
            () -> checkLogMessage(12, 37),
            () -> checkLogMessage(0, 0),
            () -> checkLogMessage(-1001, -235),
    };

    private CheckResult checkLogMessage(int arg1, int arg2) {
        TestedProgram program = new TestedProgram();
        String output = program.start(String.valueOf(arg1), String.valueOf(arg2));

        List<String> lines = expect(output).toContain(2).lines();

        int sum = arg1 + arg2;
        if (!String.valueOf(sum).equals(lines.get(1))) {
            return CheckResult.wrong("It appears you messed up the method logic");
        }

        String regex =
                "(?i)\\d{2}:\\d{2}:\\d{2}\\.\\d{3} \\[main] DEBUG logbacktasks.Solution - arg1=%d, arg2=%d, sum=%d";
        Pattern pattern = Pattern.compile(String.format(regex, arg1, arg2, sum));

        if (!pattern.matcher(lines.get(0)).matches()) {
            return CheckResult.wrong("Your log message is incorrect, try again");
        }

        return CheckResult.correct();
    }
}
