package jamesbond;

public class JamesBond {
    
    public boolean bondRegex(String input) {
        String pattern = ".*\\(.*007.*\\).*";
        return input.matches(pattern);
    }
}
