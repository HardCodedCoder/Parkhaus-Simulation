import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lecture.SimulationService;
import org.lecture.interfaces.IOHandler;
import org.lecture.interfaces.Service;
import org.lecture.view.ConsoleIOHandler;

import java.io.*;

public class SimulationServiceTest {

    /**
     * Test if the SimulationService works as it should
     */
    @Test
    public void testSimulationService() {
        InputStream sysIn = System.in;
        OutputStream sysOut = System.out;
        String input = "3\n3,20,ja\n1\n4";
        ByteArrayInputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo, true));

        IOHandler ioHandler = new ConsoleIOHandler();
        SimulationService.setIOHandler(ioHandler);
        Service applicationService = new SimulationService(ioHandler);
        applicationService.run();

        String output = bo.toString();
        output = output.replace("Bitte wählen Sie eine Option: ", "");
        String[] lines = output.split("\n");
        int actual = 0;
        for(String line : lines){
            if(line.startsWith("[")){
                actual++;
            }
        }

        int expected = 9;
        System.setIn(sysIn);
        System.setOut((PrintStream) sysOut);

        Assertions.assertEquals(expected, actual);
    }
}