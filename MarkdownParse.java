//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            if (openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1) {
                break;
            }
            // To differentiate between a link and image
            if(openBracket != 0) {
                char character = markdown.charAt(openBracket - 1);
                if(character == '!') {
                    currentIndex = closeParen +1;
                    continue;
                }
            }
            // Bracket and Parenthesis should be consecutive
            if (closeBracket + 1 != openParen) {
                currentIndex += 1;
                continue;
            }
            String substring = markdown.substring(openParen + 1, closeParen);
            //Link should contain "."
            if(substring.contains(".")) {
                toReturn.add(substring);
            }
            currentIndex = closeParen + 1;

        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
        System.out.println("Tests End");
    }
}
