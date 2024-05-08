package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScoreSystem {

    private Long totalScore = 0L;

    public static void main(String[] args) {
        SpringApplication.run(ScoreSystem.class, args);
    }

    @GetMapping("/score")
    public Long updateScore(@RequestParam(value = "point") Long point) {
        totalScore += point;
        return totalScore ;
    }

    @GetMapping("/getScore")
    public Long getScore() {
        return totalScore ;
    }
}
