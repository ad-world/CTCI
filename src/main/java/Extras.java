import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Extras {
    public String normalizeWhiteSpace(String s) {
        String stripped = s.trim().replaceAll("\\t", " ");
        stripped = stripped.replaceAll("\\n", " ");
        stripped = stripped.replaceAll(" +", " ");
        return stripped;
    }

    class WordBreak {
        public List<String> splitSentence(String sentence, int line_length) {
            String normalized = Extras.this.normalizeWhiteSpace(sentence);
            String hyphenJoined = this.joinHyphenWords(normalized);

            String[] hyphenSplit = hyphenJoined.split(" ");

            List<String> lines = new ArrayList<>();
            StringBuilder currentLine = new StringBuilder();

            for(String word: hyphenSplit) {
                if(word.length() + currentLine.length() + 1 <= line_length) {
                    currentLine.append(word).append(" ");
                } else {
                    if(word.contains("-")) {
                        String[] splitWord = word.split("-");
                        if(splitWord[0].length() + currentLine.length() + 1 <= line_length) {
                            currentLine.append(splitWord[0]).append('-');
                            lines.add(currentLine.toString());
                            currentLine = new StringBuilder(splitWord[1]);
                        } else {
                            lines.add(currentLine.toString());
                            currentLine = new StringBuilder(splitWord[0]).append('-');
                            if(currentLine.length() + splitWord[1].length() + 1 <= line_length) {
                                currentLine.append(splitWord[1]).append(' ');
                            } else {
                                lines.add(currentLine.toString());
                                currentLine = new StringBuilder(splitWord[1]).append(' ');
                            }
                        }
                    } else {
                        lines.add(currentLine.toString());
                        currentLine = new StringBuilder(word).append(' ');
                    }
                }
            }
            lines.add(hyphenSplit[hyphenSplit.length - 1]);

            return lines;
        }

        private String joinHyphenWords(String sentence) {
            String[] split = sentence.split(" ");

            StringBuilder builder = new StringBuilder();

            boolean isLastCharHyphen = false;
            for(String word: split) {
                if(isLastCharHyphen) {
                    builder.append(word).append(' ');
                    isLastCharHyphen = false;
                } else {
                    if(Objects.equals(word, "-")) {
                        builder.deleteCharAt(builder.length() - 1);
                        isLastCharHyphen = true;
                        builder.append(word);
                    } else {
                        builder.append(word).append(' ');
                    }
                }
            }

            return builder.toString();
        }
    }
}

