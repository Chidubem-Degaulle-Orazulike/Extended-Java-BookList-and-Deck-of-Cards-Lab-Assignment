import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand = new ArrayList<>();
    private final String[] ranks = {"Royal Flush", "Straight Flush", "4-of-a-kind", "Full House", "Flush", "Straight",
            "3-of-a-kind", "2 Pair", "1 Pair", "High Card"};

    public void addCard(Card c){
        if(hand.size() < 5){
            hand.add(c);
        }
    }

    public String getHandRank(){
        int Highest = hand.get(0).getNumericValue();
        boolean pair = false;
        boolean pair2 = false;
        int pairCounter  = 0;
        int pairCounter2 = 0;
        if(hand.size() != 5){
            return "Incorrect hand size";
        }
        //sort the hand
        hand.sort(new SortCards());

        //high card (None of the other hands match, the highest value of the card)
//        for(int i = 0; i < hand.size(); i++){
//         if(hand.get(i).getNumericValue() > hand.get(0).getNumericValue() && (hand.get(i).getNumericValue() > Highest) ){
//             Highest = hand.get(i).getNumericValue();
//         }
//        }
//
//        System.out.print(Highest);
        //return ranks[9];

        //one pair ( a pair of cards with the same value e.g. 7D, 7H, 4S, 6H, 8H)
        for(int k = 0; k < hand.size(); k++){
            for (int l =k+1; l < hand.size(); l++){
                if(hand.get(k).getNumericValue() == hand.get(l).getNumericValue()){
                    pairCounter += 1;
                }
            }
            //System.out.print(pairCounter);
        }
        if(pairCounter == 1){
            pair = true;
        }


        //two pair (2 pairs of matched values e.g. 7D, 7H, 4S, 4C, 2D)
        for(int m = 0; m < hand.size(); m++){
            for(int n = m+1; n < hand.size(); n++){
                if(hand.get(m).getNumericValue() == hand.get(n).getNumericValue()){
                    pairCounter2 += 1;
                }
            }
        }
        if(pairCounter2 == 2){
            pair2 = true;
        }

        //3 of a kind (3 cards with the same value and two others e.g. 7D, 7H, 7C, 2H, KS)
        boolean threeOfKind = false;
        for(int m = 0; m < hand.size()-2; m++){
            if (hand.get(m).getNumericValue() == hand.get(m + 1).getNumericValue() &&
                    hand.get(m).getNumericValue() == hand.get(m+2).getNumericValue()) {
                threeOfKind = true;
            }
        }



        //straight (A run of values in different suits e.g. 3H, 4D, 5H, 6C, 7S)
        boolean straight = false;
        int straightCounter3 = 0;
        for(int l = 0;l< hand.size()-1;l++){
            if (hand.get(l).getNumericValue()-hand.get(l+1).getNumericValue() ==-1){
                straightCounter3 +=1;
            }

        }
        if(straightCounter3 == 4){
            straight = true;
        }

        //flush (All cards are in the same suit e.g. 3H, 7H, 9H, JH, KH)
        boolean flush = false;
        int flushCounter = 0;

        for(int b = 1;b< hand.size();b++) {

            if(hand.get(0).getSuit() == hand.get(b).getSuit()){
                flushCounter+=1;
            }

        }
        if(flushCounter == 4){
            flush = true;
        }


        //full house (3 of a kind and a pair e.g. 7S, 7H, 7D, 4C, 4H)
        boolean fullHouse = false;
        if(pair == true && threeOfKind == true){
            fullHouse = true;
        }

        //4 of a kind (4 cards with the same value e.g. 9S, 9C, 9H, 9D, 7D)
        boolean fourOfKind = false;
        for(int i = 0;i< hand.size()-3;i++){
            if (hand.get(i).getNumericValue() == hand.get(i + 1).getNumericValue() &&
                    hand.get(i).getNumericValue() == hand.get(i+2).getNumericValue()&&
                    hand.get(i).getNumericValue() == hand.get(i+3).getNumericValue()) {
                fourOfKind = true;
            }
        }

        //straight flush (5 cards in a row all of the same suit e.g. 3S, 4S, 5S, 6S, 7S)
        boolean straightFlush = false;
        if(straight == true && flush == true){
            straightFlush = true;
        }

        //royal flush (J,Q,K,A,10 all of the same suit)
        boolean royalFlush = false;
        if(straight && flush && hand.get(0).getNumericValue()==10){
            royalFlush = true;
        }

        if(royalFlush == true){
            return ranks[0];
        }else if(straightFlush == true){
            return ranks[1];
        }else if(fourOfKind == true){
            return  ranks[2];
        }else if(fullHouse == true){
            return ranks[3];
        }else if(flush == true){
            return ranks[4];
        }
        else if(straight == true){
            return  ranks[5];
        }else if(threeOfKind == true){
            return ranks[6];
        }else if(pair2 == true){
            return  ranks[7];
        }else if(pair == true){
            return ranks[8];
        }

        return ranks[9];
    }

    public String toString(){
        String output = "";
        for(Card c: hand){
            if(c.getSuit().equals("Hearts") || c.getSuit().equals("Diamonds")) {
                output += "\u001B[31m[ " + c.getValue() + " , " + c.getSuit() + " ] \u001B[0m";
            }
            else{
                output += "[ " + c.getValue() + " , " + c.getSuit() + " ] ";
            }
        }

        return output;

    }
}
