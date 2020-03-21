package microservices.raul.multiplication.domain;

import lombok.*;

/**
 * This represents a Multiplication (a * b).
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode

public final class Multiplication {
    // Both factors
    private final int factorA;
    private final int factorB;
    // Empty constructor for JSON (de)serialization
    Multiplication() {
        this(0, 0);
    }
}

