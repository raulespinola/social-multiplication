package microservices.raul.multiplication.services;

import microservices.raul.multiplication.domain.Multiplication;
import microservices.raul.multiplication.domain.MultiplicationResultAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class  MultiplicationServiceImpl implements MultiplicationService {


    private RandomGeneratorService randomGeneratorService;

    @Autowired
    public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA= randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA,factorB);
    }

    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt
                                        attempt) {
        // Checks if it's correct
        boolean correct = attempt.getResultAttempt() ==
                        attempt.getMultiplication().
                getFactorA() *
                        attempt.getMultiplication().
                getFactorB();

        // Avoids 'hack' attempts
        Assert.isTrue(!attempt.isCorrect(), "You can't send an attempt marked as correct!!");
            // Creates a copy, now setting the 'correct' fieldaccordingly
        MultiplicationResultAttempt checkedAttempt =
                new MultiplicationResultAttempt(attempt.getUser(),
                        attempt.getMultiplication(),
                        attempt.getResultAttempt(),
                        correct);
        // Returns the result
        return correct;
    }
}
