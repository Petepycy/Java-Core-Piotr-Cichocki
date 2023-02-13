package flashcards;

public class Flashcard {

    private final String term;
    private final String definition;
    private int mistake;

    public Flashcard(String term, String definition, int mistake) {
        this.term = term;
        this.definition = definition;
        this.mistake = Math.max(0, mistake);
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }

    public int getMistake() {
        return mistake;
    }

    public void setMistake(int mistake) {
        this.mistake = mistake;
    }

    public boolean checkAnswer(String str) {
        boolean isCorrect = str != null && str.equalsIgnoreCase(definition);
        if (!isCorrect) {
            mistake++;
        }
        return isCorrect;
    }

    @Override
    public int hashCode() {
        return term.hashCode();
    }
}