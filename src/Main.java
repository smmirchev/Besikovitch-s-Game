import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Main  extends JFrame {


    public static int totalScore = 91;
    public static int myScore;
    public JLabel hScore;
    public GameLogic logic = new GameLogic();
    public NorthPanel panelNorth;
    public EastPanel panelEast;
    public SouthPanel panelSouth;
    public CentrePanel panelCentre;
    public TextField input = new TextField(15);
    public JButton okay;
    public JButton start;
    private JButton endTurn;
    public JLabel round;
    public JLabel betCard;
    public JLabel announce;
    public JLabel announce2;
    public JLabel announce3;
    public JLabel announce4;

    public String[] cardX = new String[] {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

    public JLabel[] myCards(){
        int cardValue = 1;
        JLabel[] cards=new JLabel[13];
        for (int i=0;i<13;i++){
            cards[i]=new JLabel(cardX[i] + " (" + cardValue + ")");
            cardValue++;
        }
        return cards;
    }

    public JLabel[] playCards = myCards();


    public Main() {

        super("Besikovitch’s Game");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelEast = new EastPanel();
        panelSouth = new SouthPanel();
        panelCentre = new CentrePanel();
        panelNorth = new NorthPanel();

        setLayout(new BorderLayout());
        add(panelEast, BorderLayout.EAST);
        add(panelSouth, BorderLayout.SOUTH);
        add(panelCentre, BorderLayout.CENTER);
        add(panelNorth, BorderLayout.NORTH);

        setVisible(true);
    }


    class EastPanel extends JPanel {


        private int count = 0;

        public EastPanel() {


            Border innerBorder = BorderFactory.createTitledBorder("Your Cards");
            Border outerBorder = BorderFactory.createEmptyBorder(0, 5, 0,5 );
            setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

            setLayout(new GridBagLayout());
            GridBagConstraints gc = new GridBagConstraints();

            for (int i = 0; i < playCards.length; i++){
                gc.gridx = 0;
                gc.gridy = count;
                gc.fill = GridBagConstraints.BOTH;
                gc.insets = new Insets(0,5,5,40);
                add(playCards[i], gc);
                count++;
            }

        }
    }

    class SouthPanel extends JPanel {

        private Main mainFrame;
        private JLabel msg = new JLabel("Choose the stake card!");
        private JLabel msg2 = new JLabel("Enter a number from 1 to 13!");
        private  JLabel errorMsg = new JLabel("");


        public SouthPanel() {

            okay = new JButton("GO!");
            okay.setEnabled(false);
            endTurn = new JButton("End Turn");
            endTurn.setEnabled(false);
            start = new JButton("Stake Card!");
            setLayout(new GridBagLayout());
            GridBagConstraints gc = new GridBagConstraints();

            gc.gridx = 0;
            gc.gridy = 0;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,15,13,0);
            add(errorMsg, gc);

            gc.gridx = 0;
            gc.gridy = 1;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,0,7,0);
            add(msg, gc);

            gc.gridx = 0;
            gc.gridy = 2;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,0,7,0);
            add(msg2, gc);

            gc.gridx = 0;
            gc.gridy = 3;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,0,20,0);
            add(input, gc);

            gc.gridx = 2;
            gc.gridy = 3;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,15,20,0);
            add(okay, gc);

            gc.gridx = 3;
            gc.gridy = 3;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,15,20,0);
            add(start, gc);

            gc.gridx = 1;
            gc.gridy = 3;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,15,20,0);
            add(endTurn, gc);


            okay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (input.getText().matches("^[1-9]\\d*$")) {
                        if(Integer.parseInt(input.getText()) > 13) {
                            errorMsg.setForeground(Color.red);
                            errorMsg.setText("Invalid Input");
                        }

                        else {
                            if (logic.plCardsPlayed.contains(Integer.parseInt(input.getText()))) {
                                errorMsg.setForeground(Color.red);
                                errorMsg.setText("You already played " + input.getText() + "!");
                            }
                            else {
                                errorMsg.setText("");

                                playCards[Integer.parseInt(input.getText()) - 1].setText("");
                                logic.humanCard = Integer.parseInt(input.getText());


                                logic.gameLength[logic.prRound][1] = logic.humanCard;
                                logic.plCardsPlayed.add(logic.humanCard);
                                endTurn.setEnabled(true);
                                okay.setEnabled(false);
                                input.setEnabled(false);
                                input.setText("");
                            }


                        }
                    }
                    else {
                        errorMsg.setForeground(Color.red);
                        errorMsg.setText("Invalid Input");
                    }

                }
            });

            endTurn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (totalScore - myScore < 46 || logic.roundNumber == 14) {
                        JOptionPane.showMessageDialog(null,"Well Done!");
                        okay.setEnabled(false);
                        start.setEnabled(false);
                        endTurn.setEnabled(false);
                    }

                    logic.aiCard = GameLogic.chooseCardP2(logic.gameLength, logic.stakeCard);
                    GameLogic.aiCardsPlayed.add(logic.aiCard);
                    logic.gameLength[logic.prRound][2] = logic.aiCard;

                    round.setText("Round " + String.valueOf(logic.roundNumber));
                    announce.setText("Stake Card - " + logic.stakes.get(logic.stakeCard - 1));
                    announce2.setText("Your Card - " + logic.stakes.get(logic.humanCard - 1));
                    announce3.setText("AI Card - " + logic.stakes.get(logic.aiCard - 1));
                    if (logic.humanCard > logic.aiCard)
                        announce4.setText("Winner - You");
                    else if (logic.humanCard < logic.aiCard)
                        announce4.setText("Winner - AI");
                    else
                        announce4.setText("Winner - Draw");

                    endTurn.setEnabled(false);
                    start.setEnabled(true);
                    input.setEnabled(true);

                    myScore = GameLogic.calcPlayer1Score(logic.gameLength);
                    hScore.setText("Score " + myScore);;

                    logic.roundNumber++;
                    logic.prRound++;
                }
            });

            start.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (totalScore - myScore < 46) {
                        JOptionPane.showMessageDialog(null,"Well Done! AI score - " + (totalScore - myScore) );
                        okay.setEnabled(false);
                        start.setEnabled(false);
                        endTurn.setEnabled(false);
                    }
                    else if (logic.roundNumber == 14) {
                        JOptionPane.showMessageDialog(null,"Game Over! AI score - " + (totalScore - myScore));
                        okay.setEnabled(false);
                        start.setEnabled(false);
                        endTurn.setEnabled(false);

                    }  else {
                        if (input.getText().matches("^[1-9]\\d*$")) {
                            if (Integer.parseInt(input.getText()) > 13) {
                                errorMsg.setForeground(Color.red);
                                errorMsg.setText("Invalid Input");
                            }
                            else {
                                if (logic.stakesPlayed.contains(Integer.parseInt(input.getText()))) {
                                    errorMsg.setForeground(Color.red);
                                    errorMsg.setText("Stake card already played!");
                                }
                                else {
                                    errorMsg.setText("");
                                    logic.stakeCard = Integer.parseInt(input.getText());
                                    msg.setText("Choose a card to play!");
                                    betCard.setText(logic.stakes.get(logic.stakeCard - 1));
                                    logic.stakesPlayed.add(logic.stakeCard);

                                    logic.gameLength[logic.prRound][0] = logic.stakeCard;
                                    okay.setEnabled(true);
                                    input.setEnabled(true);
                                    start.setEnabled(false);
                                }

                            }
                        } else {
                            errorMsg.setForeground(Color.red);
                            errorMsg.setText("Invalid Input");
                        }
                    }
                }
            });
        }
    }

    class CentrePanel extends JPanel {

        private JLabel msg = new JLabel("This turn stake card is:");
        private JLabel msg2 = new JLabel("Previous turn:");

        public CentrePanel() {

            betCard = new JLabel("");
            announce = new JLabel("");
            announce2 = new JLabel("");
            announce3 = new JLabel("");
            announce4 = new JLabel("");
            setLayout(new GridBagLayout());
            GridBagConstraints gc = new GridBagConstraints();

            gc.gridx = 0;
            gc.gridy = 0;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,0, 7,0);
            add(msg, gc);

            gc.gridx = 0;
            gc.gridy = 1;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,0, 7,0);
            add(betCard, gc);

            gc.gridx = 0;
            gc.gridy = 2;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,0, 7,0);
            add(msg2, gc);

            gc.gridx = 0;
            gc.gridy = 3;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,0, 7,0);
            add(announce, gc);

            gc.gridx = 0;
            gc.gridy = 4;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,0, 7,0);
            add(announce2, gc);

            gc.gridx = 0;
            gc.gridy = 5;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,0, 7,0);
            add(announce3, gc);

            gc.gridx = 0;
            gc.gridy = 6;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(0,0, 7,0);
            add(announce4, gc);
        }
    }

    class NorthPanel extends JPanel {



        public NorthPanel() {


            round = new JLabel("Round " + String.valueOf(logic.roundNumber));
            hScore = new JLabel("Score 0");

            setLayout(new GridBagLayout());
            GridBagConstraints gc = new GridBagConstraints();

            gc.gridx = 0;
            gc.gridy = 0;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(10,0,0,0);
            add(round, gc);

            gc.gridx = 0;
            gc.gridy = 1;
            gc.fill = GridBagConstraints.BOTH;
            gc.insets = new Insets(10,0,0,0);
            add(hScore, gc);
        }
    }


    public static void main(String[] args) {
        new Main();
    }
}