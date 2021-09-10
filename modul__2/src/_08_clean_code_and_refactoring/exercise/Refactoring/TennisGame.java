package _08_clean_code_and_refactoring.exercise.Refactoring;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int magicValue1, int magicValue2) {
        String score = "";
        int tempScore = 0;
        if (magicValue1 == magicValue2) {
            switch (magicValue1) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (magicValue1 >= 4 || magicValue2 >= 4) {
            int minusResult = magicValue1 - magicValue2;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = magicValue1;
                else {
                    score += "-";
                    tempScore = magicValue2;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }
}
