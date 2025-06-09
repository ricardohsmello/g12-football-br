package br.com.g12.validators;

import br.com.g12.exception.BetException;
import br.com.g12.exception.NotFoundException;
import br.com.g12.fake.BetFake;
import br.com.g12.fake.MatchFake;
import br.com.g12.model.Bet;
import br.com.g12.model.Score;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class BetValidatorTest {

    @Test
    public void should_throw_exception_when_bet_is_null() {
        BetValidator validator = new BetValidator();
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> validator.validate(null));
        assertEquals(notFoundException.getMessage(), "Bet not found!");
    }

    @Test
    public void should_throw_error_when_match_id_is_null() {
        Bet build = BetFake.builder()
                .id(null)
                .build();

        BetValidator validator = new BetValidator();
        BetException betException = assertThrows(BetException.class, () -> validator.validate(build));
        assertEquals(betException.getMessage(), "Match ID is required");
    }

    @Test
    public void should_throw_error_when_match_idUser_is_null_or_empty() {
        Bet build = BetFake.builder()
                .matchId("123")
                .username("")
                .build();

        BetValidator validator = new BetValidator();
        BetException betException = assertThrows(BetException.class, () -> validator.validate(build));
        assertEquals(betException.getMessage(), "User ID is required");
    }

    @Test
    public void should_throw_error_when_prediction_is_not_provided() {
        Bet build = BetFake.builder()
                .matchId("123")
                .username("1")
                .prediction(null)
                .build();

        BetValidator validator = new BetValidator();
        BetException betException = assertThrows(BetException.class, () -> validator.validate(build));
        assertEquals(betException.getMessage(), "Score prediction must be provided");
    }

    @Test
    public void should_throw_error_when_round_is_invalid() {
        Bet build = BetFake.builder()
                .matchId("123")
                .username("1")
                .prediction(new Score(2, 2))
                .round(-1)
                .build();

        BetValidator validator = new BetValidator();
        BetException betException = assertThrows(BetException.class, () -> validator.validate(build));
        assertEquals(betException.getMessage(), "Round must be between 1 and 38");
    }

    @Test
    public void should_validate_match() {
        var match = MatchFake.builder()
                .homeTeam("Corinthians")
                .awayTeam("Barcelona")
                .round(5)
                .matchDate(getDateWithOffset(5))
                .build();

        MatchValidator validator = new MatchValidator();
        assertDoesNotThrow(() -> validator.validate(match));
    }

    private Date getDateWithOffset(int days) {
        var calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }
}
