package service;

import java.util.Arrays;
import java.util.List;

public class DecypherText {

    /**
     * @param cypher is a phrase with a criptography of letter shifted
     *               Example: ibqqz cjuiievez (happy birthday)
     * @param word is a good word used to pivot the numjber o shifts
     *            Example: happy
     *
     * */

    public Integer solution(String cypher, String word) {
        var cypherLowerCase = cypher.toLowerCase();
        var wordLowerCase = word.toLowerCase();
        var shiftedTimes = 0;
        List<String> sameSizeWords = Arrays.stream(cypherLowerCase.split(" "))
                .filter(w -> w.length() == wordLowerCase.length())
                .toList();

        if(sameSizeWords
                .stream()
                .anyMatch(w -> w.equalsIgnoreCase(wordLowerCase))) {
            return 0;
        }

        var shiftedWords = sameSizeWords;

        while(shiftedTimes < 26) {
            shiftedWords = shiftedWords.stream()
                    .map(this::shiftOne)
                    .toList();
            shiftedTimes++;

            if(shiftedWords
                    .stream()
                    .anyMatch(w -> w.equalsIgnoreCase(wordLowerCase))) {
                return shiftedTimes;
            }

        }
        return shiftedTimes;
    }

    private String shiftOne(String word) {
        StringBuilder shifted = new StringBuilder();
        for(char c : word.toCharArray()){
            shifted.append((char) ('a' + (c - 'a' + 1) % 26));
        }
        return shifted.toString();
    }

}
