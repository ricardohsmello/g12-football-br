package br.com.g12.http;

import br.com.g12.request.MatchRequest;
import br.com.g12.request.ScoreRequest;
import br.com.g12.response.MatchResponse;
import br.com.g12.usecase.match.CreateMatchUseCase;
import br.com.g12.usecase.match.UpdateMatchScoreUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final CreateMatchUseCase createMatchUseCase;
    private final UpdateMatchScoreUseCase updateMatchScoreUseCase;

    MatchController(CreateMatchUseCase createMatchUseCase, UpdateMatchScoreUseCase updateMatchScoreUseCase) {
        this.createMatchUseCase = createMatchUseCase;
        this.updateMatchScoreUseCase = updateMatchScoreUseCase;
    }

    @PostMapping
    public ResponseEntity<MatchResponse> addMatch(@RequestBody MatchRequest matchRequest) {
        MatchResponse matchResponse = createMatchUseCase.execute(matchRequest);
        return ResponseEntity.ok(matchResponse);
    }

    @PutMapping("/{id}/score")
    public ResponseEntity<Void> updateScore(@PathVariable String id, @RequestBody ScoreRequest scoreRequest) {
        updateMatchScoreUseCase.execute(id, scoreRequest);
        return ResponseEntity.noContent().build();
    }
}
