package sample;

public class Cipher {

    public String encrypt(char input[], int k)   //char input[] is the input string and k is the caeser shift

    {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        String cipherText = "";
        for (int i = 0; i < input.length; i++) {
            if (Character.isAlphabetic(input[i])) {
                if (Character.isUpperCase(input[i])) {
                    input[i]=Character.toLowerCase(input[i]);
                    int charPosition = ALPHABET.indexOf(input[i]);
                    int keyVal = (k + charPosition) % 26;
                    char replaceVal = ALPHABET.charAt(keyVal);
                    input[i] = replaceVal;
                    cipherText += input[i];
                } else
                if (Character.isLowerCase(input[i])){
                    int charPosition = ALPHABET.indexOf(input[i]);
                    int keyVal = (k + charPosition) % 26;
                    char replaceVal = ALPHABET.charAt(keyVal);
                    input[i] = replaceVal;
                    cipherText += input[i];
                }
            } else if (Character.isDigit(input[i])) {
                int value = (int) ((input[i]) % 48) + 1;
                if (value == 10) {
                    value = 0;
                }
                String val = Integer.toString(value);
                cipherText += val;
            } else if (input[i] == '@') {
                input[i] = '.';
                cipherText += input[i];
            } else if (input[i] == '.') {
                input[i] = '@';
                cipherText += input[i];
            } else if (input[i] == '&') {
                input[i] = '*';
                cipherText += input[i];
            } else {
                cipherText+=input[i];
            }
        }
        return cipherText;
    }

    public String decrypt(char input[], int k)   //char input[] is the input string and k is the caeser shift

    {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        String decipherText = "";
        for (int i = 0; i < input.length; i++) {
            if (Character.isAlphabetic(input[i])) {
                if (Character.isUpperCase(input[i])) {
                    input[i]=Character.toLowerCase(input[i]);
                    int charPosition = ALPHABET.indexOf(input[i]);
                    int keyVal = (charPosition - k+26) % 26;
                    char replaceVal = ALPHABET.charAt(keyVal);
                    input[i] = replaceVal;
                    decipherText += input[i];
                } else
                if (Character.isLowerCase(input[i])){
                    int charPosition = ALPHABET.indexOf(input[i]);
                    int keyVal = (charPosition -k+26) % 26;
                    char replaceVal = ALPHABET.charAt(keyVal);
                    input[i] = replaceVal;
                    decipherText += input[i];
                }
            } else if (Character.isDigit(input[i])) {
                int value = (int) (input[i] % 48) - 1;
                if (value == -1) {
                    value = 9;
                }
                String val = Integer.toString(value);
                decipherText += val;
            } else if (input[i] == '.') {
                input[i] = '@';
                decipherText += input[i];
            } else if (input[i] == '@') {
                input[i] = '.';
                decipherText += input[i];
            } else if (input[i] == '*') {
                input[i] = '&';
                decipherText += input[i];
            } else {
                decipherText+=input[i];
            }
        }
        return decipherText;
    }
}
