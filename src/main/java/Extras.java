public class Extras {
    public String normalizeWhiteSpace(String s) {
        String stripped = s.trim().replaceAll("\\t", " ");
        stripped = stripped.replaceAll("\\n", " ");
        stripped = stripped.replaceAll(" +", " ");
        return stripped;
    }
}
