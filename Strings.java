package sample;

import java.util.Random;

    public class Strings {

        private static String charlist = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        private static int maxlength;


        public String generateRandomString(){

            StringBuffer randStr = new StringBuffer();
            for(int i=0; i<maxlength; i++){
                int number = getRandomNumber();
                char ch = charlist.charAt(number);
                randStr.append(ch);
            }
            return randStr.toString();
        }
        public void setMaxlength(int max){
            this.maxlength = max;
        }
        public void setCharlist(String list){
            this.charlist = list;
        }
        private int getRandomNumber() {
            int randomInt = 0;
            Random randomGenerator = new Random();
            randomInt = randomGenerator.nextInt(charlist.length());
            if (randomInt - 1 == -1) {
                return randomInt;
            } else {
                return randomInt - 1;
            }
        }
}
