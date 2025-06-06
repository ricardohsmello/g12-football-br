package br.com.g12.http;

import br.com.g12.request.MatchRequest;
import br.com.g12.request.ScoreRequest;
import br.com.g12.response.MatchResponse;
import br.com.g12.usecase.match.CreateMatchUseCase;
import br.com.g12.usecase.match.FindMatchesByRoundUseCase;
import br.com.g12.usecase.match.UpdateMatchScoreUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final CreateMatchUseCase createMatchUseCase;
    private final UpdateMatchScoreUseCase updateMatchScoreUseCase;
    private final FindMatchesByRoundUseCase findMatchesByRoundUseCase;

    MatchController(
            CreateMatchUseCase createMatchUseCase,
            UpdateMatchScoreUseCase updateMatchScoreUseCase,
            FindMatchesByRoundUseCase findMatchesByRoundUseCase) {
        this.createMatchUseCase = createMatchUseCase;
        this.updateMatchScoreUseCase = updateMatchScoreUseCase;
        this.findMatchesByRoundUseCase = findMatchesByRoundUseCase;
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

    @GetMapping("/round/{round}")
    public ResponseEntity<List<MatchResponse>> findByRound(@PathVariable int round) {
        List<MatchResponse> matches = findMatchesByRoundUseCase.execute(round);
        return ResponseEntity.ok(matches);
    }
}
