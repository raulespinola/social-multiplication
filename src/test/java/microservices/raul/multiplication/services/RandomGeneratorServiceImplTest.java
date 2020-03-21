package microservices.raul.multiplication.services;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class RandomGeneratorServiceImplTest {

    private RandomGeneratorServiceImpl randomGeneratorServiceImpl;



    @Test
    public void generateRandomFactorIsBetweenExpectedLimits() throws Exception{
        randomGeneratorServiceImpl= new RandomGeneratorServiceImpl();
        //when a good sample of randomly
        List<Integer> randomFactors = IntStream.range(0,1000)
                .map(i -> randomGeneratorServiceImpl.generateRandomFactor())
                .boxed().collect(Collectors.toList());

        // then all of them should be between 11 and 100
        // because we want a middle-complexity calculation
        assertThat(randomFactors).containsOnlyElementsOf
                (IntStream.range(11, 100)
                        .boxed().collect(Collectors.toList()));
    }
}