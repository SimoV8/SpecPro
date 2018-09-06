package it.sagelab.reasoners;

import it.sagelab.reasoners.ModelChecker;
import it.sagelab.reasoners.NuSMV;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NuSMVTests {

    @ParameterizedTest
    @ValueSource(strings = {"test1.nusmv", "test2.nusmv", "test3.nusmv", "test4.nusmv", "test5.nusmv", "test6.nusmv"})
    public void testRunSat(String fileName) throws IOException {
        NuSMV mc = new NuSMV(60);

        String filePath = new File(getClass().getResource("/" + fileName).getFile()).getAbsolutePath();

        assertEquals(ModelChecker.Result.SAT, mc.run(filePath), mc.getMessage());
    }

}
