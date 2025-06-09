package br.com.g12.http;

import br.com.g12.request.MatchRequest;
import br.com.g12.request.ScoreRequest;
import br.com.g12.response.MatchResponse;
import br.com.g12.usecase.match.CreateMatchUseCase;
import br.com.g12.usecase.match.FindMatchesWithUserBetsUseCase;
import br.com.g12.usecase.match.UpdateMatchScoreUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
@CrossOrigin
public class MatchController {

    private final CreateMatchUseCase createMatchUseCase;
    private final UpdateMatchScoreUseCase updateMatchScoreUseCase;
    private final FindMatchesWithUserBetsUseCase findMatchesWithUserBetsUseCase;

    MatchController(
            CreateMatchUseCase createMatchUseCase,
            UpdateMatchScoreUseCase updateMatchScoreUseCase,
            FindMatchesWithUserBetsUseCase findMatchesWithUserBetsUseCase) {
        this.createMatchUseCase = createMatchUseCase;
        this.updateMatchScoreUseCase = updateMatchScoreUseCase;
        this.findMatchesWithUserBetsUseCase = findMatchesWithUserBetsUseCase;
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

//    @GetMapping("/round/{round}")
//    public ResponseEntity<List<MatchResponse>> findByRound(@PathVariable int round) {
//        List<MatchResponse> matches = findMatchesByRoundUseCase.execute(round);
//        return ResponseEntity.ok(matches);
//    }

    @GetMapping("/username/{username}/round/{round}")
    public ResponseEntity<List<MatchResponse>> findByRound(@PathVariable String username, @PathVariable int round) {
        List<MatchResponse> matches = findMatchesWithUserBetsUseCase.execute(username, round);
        return ResponseEntity.ok(matches);
    }

//    @GetMapping("/round/{round}/username/{username}")
//    public  ResponseEntity<List<MatchResponse>> findMatchesWithUserBets(@PathVariable int round,@PathVariable String username) {
//        List<MatchResponse> matches = findMatchesWithUserBets.execute(round, username);
//        return ResponseEntity.ok(matches);
//    }
}
