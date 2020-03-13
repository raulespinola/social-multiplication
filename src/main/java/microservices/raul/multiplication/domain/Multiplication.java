package microservices.raul.multiplication.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Multiplication {
    private int factorA;
    private int factorB;
    private int result;

    @Builder
    public Multiplication(int factorA, int factorB){
        this.factorA= factorA;
        this.factorB= factorB;
        this.result= factorA*factorB;
    }
}

