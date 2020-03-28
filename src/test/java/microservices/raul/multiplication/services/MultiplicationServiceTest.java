package microservices.raul.multiplication.services;

import microservices.raul.multiplication.domain.Multiplication;
import microservices.raul.multiplication.event.EventDispatcher;
import microservices.raul.multiplication.repositories.MultiplicationResultAttemptRepository;
import microservices.raul.multiplication.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


public class MultiplicationServiceTest {

    private MultiplicationServiceImpl multiplicationServiceImpl;

    @Mock
    private UserRepository userRepository;

    @Mock
    private MultiplicationResultAttemptRepository attemptRepository;

    @Mock
    private RandomGeneratorService randomGeneratorService;

    @Mock
    private EventDispatcher eventDispatcher;

    @Before
    public void setUp(){
        // With this call to initMocks we tell Mockito to
        //process the annotations
        MockitoAnnotations.initMocks(this);
        multiplicationServiceImpl = new MultiplicationServiceImpl(
                randomGeneratorService,
                attemptRepository,
                userRepository,
                eventDispatcher);
    }

    @Test
    public void createRandomMultiplicationTest() {
        // given (our mocked Random Generator service will
        //return first 50, then 30)
        given(randomGeneratorService
                .generateRandomFactor()).willReturn(50,30);

        //when
        Multiplication multiplication = multiplicationServiceImpl
                .createRandomMultiplication();

        //then
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);


    }
}