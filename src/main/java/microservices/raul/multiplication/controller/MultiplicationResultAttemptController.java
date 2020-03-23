package microservices.raul.multiplication.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import microservices.raul.multiplication.domain.MultiplicationResultAttempt;
import microservices.raul.multiplication.services.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/results")
final class MultiplicationResultAttemptController {

    private final MultiplicationService multiplicationService;
    @Autowired
    MultiplicationResultAttemptController(final
                                           MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    // Here we'll implement our POST later
    @RequiredArgsConstructor
    @NoArgsConstructor(force = true)
    @Getter
    static final class ResultResponse {
        private final boolean correct;
    }

    @PostMapping
    ResponseEntity<ResultResponse> postResult(@RequestBody
                                                      MultiplicationResultAttempt multiplicationResultAttempt) {
        return ResponseEntity.ok(
                new ResultResponse(multiplicationService
                        .checkAttempt(multiplicationResultAttempt)));
    }

}
