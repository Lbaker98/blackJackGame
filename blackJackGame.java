{\rtf1\ansi\ansicpg1252\cocoartf1671\cocoasubrtf600
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 import java.io.*;\
public class SimpleBlackjack\
\{\
    // Integer arrays to contain each of the players' drawn card values.\
    static Card[] computerCards = new Card[12];  \
    static Card[] userCards = new Card[12];\
    \
    static int computerCardsCount = 0;\
    static int userCardsCount = 0;\
    \
    // Create a new deck of cards.\
    static Deck deck = new Deck();\
\
    // Variables to keep the score of each player.\
    static int computerSum;\
    static int userSum;\
    \
    public static void main(String[] args)\
    \{\
        // Deal two cards to each player.\
        computerCards[0] = deck.drawCard();\
        computerCards[1] = deck.drawCard(); \
        computerCardsCount = 2;\
        userCards[0] = deck.drawCard();\
        userCards[1] = deck.drawCard();\
        userCardsCount = 2;\
        \
        // Variables to keep the score of each player.\
        computerSum = computerCards[0].value + computerCards[1].value;\
        userSum = userCards[0].value + userCards[1].value;\
\
        // Construction site...\
        //initialisation of key variables\
        InputStreamReader isr = new InputStreamReader(System.in);\
        BufferedReader br = new BufferedReader(isr);\
        boolean playerTurn = true;\
        String userRep = "";\
\
        //Users turn   \
        while((21 < userSum ) || (playerTurn == true))\
        \{\
            System.out.println("USER TURN");\
            displayCards(false);\
\
            System.out.println("Would you like to take another card (Y/N): ");\
            \
            try\
            \{\
               userRep = br.readLine();\
               userRep = userRep.toUpperCase();\
            \}\
            catch(IOException e)\
            \{\
                System.out.print("Only Y OR N");\
                continue;           \
            \}\
           \
            if(userRep.equals("Y"))\
            \{\
                userCardsCount++;\
                userCards[userCardsCount-1] = deck.drawCard();\
                userSum = userSum + userCards[userCardsCount-1].value;\
                \
                if(userSum >= 22)\
                \{  \
                   System.out.println();\
                   System.out.println("END");\
                   displayCards(true);\
                   System.out.println("User went over 21. COMPUTER WINS!");\
                   System.exit(0);\
                \}\
                System.out.println("You drew a/an: "+ userCards[userCardsCount-1].name);\
                displayCards(false);        \
            \}\
            if(userRep.equals("N"))\
            \{\
                playerTurn = false;\
                break;\
            \}\
                 \
        \}\
        \
        //Computers turn\
        playerTurn=false;  \
        System.out.println("COMPUTERS TURN");\
        displayCards(true);\
           \
        while((userSum>computerSum ) || (21>=computerSum ) || (playerTurn==false))\
        \{\
            if((computerSum >= 19)|| (userSum>computerSum ))\
            \{\
                playerTurn=false;\
                break;\
            \}\
            else\
            \{          \
            computerCardsCount++;\
            computerCards[computerCardsCount-1] = deck.drawCard();\
            computerSum = computerSum + computerCards[computerCardsCount-1].value;\
            \
                if (computerSum > 21)\
                \{\
                    System.out.println("The Computer has drawn a/an: "+computerCards[computerCardsCount-1].name );\
                    System.out.println("END");\
                    displayCards(true);\
                    System.out.println("Computer went over 21. USER WINS!");\
                    System.exit(0);\
                \}\
                \
                if((playerTurn == true))\
                \{\
                System.out.println("Computer has drawn a/an: "+computerCards[computerCardsCount-1].name );\
                displayCards(true);\
                \}\
            \}           \
        \}\
           \
            if((userSum <= computerSum) )\
            \{\
                System.out.println();\
                System.out.println("END");\
                displayCards(true);\
                System.out.println("COMPUTER WINS");\
                \
            \}\
            \
            else if(userSum > computerSum)\
            \{\
                System.out.println();\
                System.out.println("END");\
                displayCards(true);\
                System.out.println("USER WINS!");\
            \}\
    \}\
    \
    public static void displayCards(boolean showHidden)\{\
        if(showHidden) \{\
            System.out.print("Computer's cards: [" + computerCards[0].name + "]");\
        \} else \{\
            System.out.print("Computer's cards: [X]");\
        \}\
        for(int i = 1; i < computerCardsCount; i++) \{\
            System.out.print("[" + computerCards[i].name + "]");\
        \}\
        if(showHidden) \{\
            System.out.print(" (sum: " + computerSum + ")");\
        \}\
        \
        System.out.print("\\nUser's cards: ");\
        for(int i = 0; i < userCardsCount; i++) \{\
            System.out.print("[" + userCards[i].name + "]");\
        \}\
        System.out.print(" (sum: " + userSum + ")");\
\
        System.out.print("\\n");\
    \}\
\}\
\
\
}