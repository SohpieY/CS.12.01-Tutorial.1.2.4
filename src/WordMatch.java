public class WordMatch {
    String secret;
    public WordMatch(String x){
        secret = x;
    }
    public int scoreGuess(String guess){
        if(guess.length() == 0){
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }

        if(guess.length() > secret.length()){
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }

        int count = 0;
        for(int i = 0; i <= secret.length() - guess.length(); i++){
            String check = secret.substring(i, i+guess.length());
            if(check.equals(guess)){
                count++;
            }

        }
        int score = count * (guess.length() * guess.length());
        return score;
    }

    public String findBetterGuess(String guess1, String guess2){
        int a = scoreGuess(guess1);
        int b = scoreGuess(guess2);

        if(a > b){
            return guess1;
        }else if(b > a){
            return guess2;
        } else{ //scores are equal
            if(guess1.compareTo(guess2) > 0){
                return guess1;
            } return guess2;
        }
    }

}
