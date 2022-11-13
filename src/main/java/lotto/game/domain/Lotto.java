package lotto.game.domain;

import static lotto.game.ExceptionHandler.*;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throwException(NOT_SIX_NUMBER_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long noDuplicateCount = numbers.stream()
                .distinct()
                .count();
        if (noDuplicateCount != 6) {
            throwException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto)) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
