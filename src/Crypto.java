import java.util.Scanner;
public class Crypto {
    public static void main (String[] args){
//        Scanner input = new Scanner(System.in);
//        System.out.println("Type in your sentence: ");
//        String sentenceIn = input.next();
//        System.out.println("Enter the shifting number: ");
//        int shiftNo = input.nextInt();
//        System.out.println("Enter the grouping number: ");
//        int groupNo = input.nextInt();
        String sentenceIn = "I am super smart!!!";
        int shiftNo = 3;
        int groupNo = 5;
        System.out.println(encryptString(sentenceIn, shiftNo, groupNo));
    }

    public static String normalizeText (String textToNormalize){
        String normalizedText = "";
        for (int i = 0; i < textToNormalize.length(); i ++){
            char c = textToNormalize.charAt(i);
            if (Character.isLetterOrDigit(c)){
                normalizedText += c;
            }
        }
        return normalizedText.toUpperCase();
    }

    public static String caesarify (String toCaesarify, int shift){
        String caesarifiedText = "";
        for (int i = 0; i < toCaesarify.length(); i++){
            char c = toCaesarify.charAt(i);
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            int j = alphabet.indexOf(c);
            char cShifted = shiftAlphabet(shift).charAt(j);
            caesarifiedText += cShifted;
        }
        return caesarifiedText;
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String groupify (String toGroupify, int spaceInsert){
        String groupifiedText = "";
        for (int i = 0; i < toGroupify.length(); i++){
            char c = toGroupify.charAt(i);
            groupifiedText += c;
            if ((i+1) % spaceInsert == 0){
                groupifiedText += " ";
            }
        }
        groupifiedText += "x";
        return groupifiedText;
    }

    public static String encryptString (String toEncrypt, int shiftingNo, int groupingNo){
        String cyphertext = normalizeText(toEncrypt);
        cyphertext = caesarify(cyphertext, shiftingNo);
        cyphertext = groupify(cyphertext, groupingNo);
        return cyphertext;
    }
}
