import java.util.*;

public class GameLogic {

    public static int score;
    public static int roundNumber = 1;
    public static int prRound = roundNumber - 1;

    public int stakeCard;
    public int humanCard;
    public int aiCard;

    public static int[][] gameLength = new int[13][3];

    public List<String> stakes = new ArrayList<>();
    public List<Integer> stakesPlayed = new ArrayList<>();
    public List<Integer> plCardsPlayed = new ArrayList<>();
    public static List<Integer> aiCardsPlayed = new ArrayList<>();



    public GameLogic() {

        stakes.add("Ace");
        stakes.add("Two");
        stakes.add("Three");
        stakes.add("Four");
        stakes.add("Five");
        stakes.add("Six");
        stakes.add("Seven");
        stakes.add("Eight");
        stakes.add("Nine");
        stakes.add("Ten");
        stakes.add("Jack");
        stakes.add("Queen");
        stakes.add("King");

    }

    public static int chooseCardP2(int[][] gameHistory, int stakeCard)
    {
        int myChoice = 0;
        int random = 0;
        int lastHope = 0;
        int random2 = 0;



            if (stakeCard == 13) {
                if (!aiCardsPlayed.contains(13)) {
                    myChoice = 13;
                } else if (!aiCardsPlayed.contains(12)) {
                    myChoice = 12;
                } else if (!aiCardsPlayed.contains(11)) {
                    myChoice = 11;
                } else if (!aiCardsPlayed.contains(10)) {
                    myChoice = 10;
                } else if (!aiCardsPlayed.contains(9)) {
                    myChoice = 9;
                } else {
                    random = (int) (Math.random() * 13);
                    lastHope = 1 + random;
                    while (aiCardsPlayed.contains(lastHope)) {
                        random = (int) (Math.random() * 13);
                        lastHope = 1 + random;
                    }

                    if (lastHope > 13)
                        lastHope--;
                    myChoice = lastHope;
                }
            }
            else if (stakeCard == 12) {

                random2 = (int) (Math.random() * 13);
                if (!aiCardsPlayed.contains(13) && random2 > 7) {
                    myChoice = 13;
                } else if (!aiCardsPlayed.contains(12)) {
                    myChoice = 12;
                } else {

                    random = (int) (Math.random() * 6);
                    lastHope = 8 + random;
                    if (lastHope > 13)
                        lastHope--;
                    if (aiCardsPlayed.contains(lastHope)) {
                        if (!aiCardsPlayed.contains(8) && !aiCardsPlayed.contains(9) && !aiCardsPlayed.contains(10)
                                && !aiCardsPlayed.contains(11) && !aiCardsPlayed.contains(12) && !aiCardsPlayed.contains(13)) {
                            while (aiCardsPlayed.contains(lastHope)) {
                                random = (int) (Math.random() * 6);
                                lastHope = 8 + random;
                            }
                        } else {
                            while (aiCardsPlayed.contains(lastHope)) {
                                random = (int) (Math.random() * 13);
                                lastHope = 1 + random;
                            }
                        }
                    }

                    if (lastHope > 13)
                        lastHope--;
                    myChoice = lastHope;
                }
            }
            else if (stakeCard == 11) {
                random2 = (int) (Math.random() * 13);

                if (!aiCardsPlayed.contains(13) && random2 > 7) {
                    myChoice = 13;
                }
                else if (!aiCardsPlayed.contains(12) && random2 > 4) {
                    myChoice = 12;
                } else {
                    random = (int) (Math.random() * 6);
                    lastHope = 8 + random;
                    if (lastHope > 13)
                        lastHope--;
                    if (aiCardsPlayed.contains(lastHope)) {
                        if (!aiCardsPlayed.contains(8) && !aiCardsPlayed.contains(9) && !aiCardsPlayed.contains(10)
                                && !aiCardsPlayed.contains(11) && !aiCardsPlayed.contains(12) && !aiCardsPlayed.contains(13)) {
                            while (aiCardsPlayed.contains(lastHope)) {
                                random = (int) (Math.random() * 6);
                                lastHope = 8 + random;
                            }
                        } else {
                            while (aiCardsPlayed.contains(lastHope)) {
                                random = (int) (Math.random() * 13);
                                lastHope = 1 + random;
                            }
                        }
                    }

                    if (lastHope > 13)
                        lastHope--;
                    myChoice = lastHope;
                }

            } else if (stakeCard == 10) {
                random = (int) (Math.random() * 7);
                lastHope = 7 + random;
                if (lastHope > 13)
                    lastHope--;
                if (aiCardsPlayed.contains(lastHope)) {
                    if(!aiCardsPlayed.contains(7) && !aiCardsPlayed.contains(8) && !aiCardsPlayed.contains(9) && !aiCardsPlayed.contains(10)
                            && !aiCardsPlayed.contains(11) && !aiCardsPlayed.contains(12) && !aiCardsPlayed.contains(13)) {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 7);
                            lastHope = 7 + random;
                        }
                    } else {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 13);
                            lastHope = 1 + random;
                        }
                    }
                }

                if (lastHope > 13)
                    lastHope--;
                myChoice = lastHope;
            } else if (stakeCard == 9) {
                random = (int) (Math.random() * 8);
                lastHope = 6 + random;
                if (lastHope > 13)
                    lastHope--;
                if (aiCardsPlayed.contains(lastHope)) {
                    if(!aiCardsPlayed.contains(7) && !aiCardsPlayed.contains(8) && !aiCardsPlayed.contains(9) && !aiCardsPlayed.contains(10)
                            && !aiCardsPlayed.contains(11) && !aiCardsPlayed.contains(12) && !aiCardsPlayed.contains(13) && !aiCardsPlayed.contains(6)) {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 8);
                            lastHope = 6 + random;
                        }
                    } else {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 13);
                            lastHope = 1 + random;
                        }
                    }
                }

                if (lastHope > 13)
                    lastHope--;
                myChoice = lastHope;
            } else if (stakeCard == 8) {
                random = (int) (Math.random() * 9);
                lastHope = 5 + random;
                if (lastHope > 13)
                    lastHope--;
                if (aiCardsPlayed.contains(lastHope)) {
                    if(!aiCardsPlayed.contains(5) && !aiCardsPlayed.contains(7) && !aiCardsPlayed.contains(8) && !aiCardsPlayed.contains(9) && !aiCardsPlayed.contains(10)
                            && !aiCardsPlayed.contains(11) && !aiCardsPlayed.contains(12) && !aiCardsPlayed.contains(13) && !aiCardsPlayed.contains(6)) {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 9);
                            lastHope = 5 + random;
                        }
                    } else {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 13);
                            lastHope = 1 + random;
                        }
                    }
                }

                if (lastHope > 13)
                    lastHope--;
                myChoice = lastHope;
            } else if (stakeCard == 7) {
                random = (int) (Math.random() * 6);
                lastHope = 4 + random;
                if (lastHope > 13)
                    lastHope--;
                if (aiCardsPlayed.contains(lastHope)) {
                    if (!aiCardsPlayed.contains(4)  && !aiCardsPlayed.contains(8) && !aiCardsPlayed.contains(9) &&
                            !aiCardsPlayed.contains(5) && !aiCardsPlayed.contains(6) && !aiCardsPlayed.contains(7) & !aiCardsPlayed.contains(10)) {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 6);
                            lastHope = 4 + random;
                        }
                    } else {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 13);
                            lastHope = 1 + random;
                        }
                    }
                }

                if (lastHope > 13)
                    lastHope--;
                myChoice = lastHope;
            }  else if (stakeCard == 6) {
                random = (int) (Math.random() * 5);
                lastHope = 3 + random;
                if (lastHope > 13)
                    lastHope--;
                if (aiCardsPlayed.contains(lastHope)) {
                    if (!aiCardsPlayed.contains(3) && !aiCardsPlayed.contains(4)  && !aiCardsPlayed.contains(8) &&
                            !aiCardsPlayed.contains(5) && !aiCardsPlayed.contains(6) && !aiCardsPlayed.contains(7)) {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 5);
                            lastHope = 3 + random;
                        }
                    } else {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 13);
                            lastHope = 1 + random;
                        }
                    }
                }

                if (lastHope > 13)
                    lastHope--;
                myChoice = lastHope;
            } else if (stakeCard == 5) {
                random = (int) (Math.random() * 5);
                lastHope = 2 + random;
                if (lastHope > 13)
                    lastHope--;
                if (aiCardsPlayed.contains(lastHope)) {
                    if (!aiCardsPlayed.contains(4)  && !aiCardsPlayed.contains(2) &&
                            !aiCardsPlayed.contains(5) && !aiCardsPlayed.contains(6) && !aiCardsPlayed.contains(7)) {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 5);
                            lastHope = 2 + random;
                        }
                    } else {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 13);
                            lastHope = 1 + random;
                        }
                    }
                }

                if (lastHope > 13)
                    lastHope--;
                myChoice = lastHope;
            } else if (stakeCard == 4) {
                random = (int) (Math.random() * 5);
                lastHope = 2 + random;
                if (lastHope > 13)
                    lastHope--;
                if (aiCardsPlayed.contains(lastHope)) {
                    if (!aiCardsPlayed.contains(3) && !aiCardsPlayed.contains(4)  && !aiCardsPlayed.contains(2) &&
                            !aiCardsPlayed.contains(5) && !aiCardsPlayed.contains(6) && !aiCardsPlayed.contains(7)) {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 5);
                            lastHope = 2 + random;
                        }
                    } else {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 13);
                            lastHope = 1 + random;
                        }
                    }
                }

                if (lastHope > 13)
                    lastHope--;
                myChoice = lastHope;
            } else if (stakeCard == 3) {
                random = (int) (Math.random() * 5);
                lastHope = 1 + random;
                if (lastHope > 13)
                    lastHope--;
                if (aiCardsPlayed.contains(lastHope)) {
                    if (!aiCardsPlayed.contains(1) && !aiCardsPlayed.contains(3) && !aiCardsPlayed.contains(4)  &&
                            !aiCardsPlayed.contains(2) && !aiCardsPlayed.contains(5) && !aiCardsPlayed.contains(6)) {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 5);
                            lastHope = 1 + random;
                        }
                    } else {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 13);
                            lastHope = 1 + random;
                        }
                    }
                }

                if (lastHope > 13)
                    lastHope--;
                myChoice = lastHope;
            } else if (stakeCard == 2) {
                random = (int) (Math.random() * 4);
                lastHope = 1 + random;
                if (lastHope > 13)
                    lastHope--;
                if (aiCardsPlayed.contains(lastHope)) {
                    if (!aiCardsPlayed.contains(1) && !aiCardsPlayed.contains(3) && !aiCardsPlayed.contains(4)  &&
                            !aiCardsPlayed.contains(2) && !aiCardsPlayed.contains(5)) {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 4);
                            lastHope = 1 + random;
                        }
                    } else {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 13);
                            lastHope = 1 + random;
                        }
                    }
                }

                if (lastHope > 13)
                    lastHope--;
                myChoice = lastHope;
            }
            else if (stakeCard == 1) {
                random = (int) (Math.random() * 3);
                lastHope = 1 + random;
                if (lastHope > 13)
                    lastHope--;
                if (aiCardsPlayed.contains(lastHope)) {
                    if (!aiCardsPlayed.contains(1) && !aiCardsPlayed.contains(3) && !aiCardsPlayed.contains(4)  &&
                            !aiCardsPlayed.contains(2)) {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 3);
                            lastHope = 1 + random;
                        }
                    } else {
                        while (aiCardsPlayed.contains(lastHope)) {
                            random = (int) (Math.random() * 13);
                            lastHope = 1 + random;
                        }
                    }
                }

                if (lastHope > 13)
                    lastHope--;
                myChoice = lastHope;
            }
            else {
                random = (int) (Math.random() * 13);
                lastHope = 1 + random;
                if (aiCardsPlayed.contains(lastHope)) {
                    while (aiCardsPlayed.contains(lastHope)) {
                        random = (int) (Math.random() * 13);
                        lastHope = 1 + random;
                    }
                }
                myChoice = lastHope;
            }

        return myChoice;
        }

    public static int calcPlayer1Score(int[][] gameHistory) {

        if(gameHistory[prRound][1] > gameHistory[prRound][2] )
            score += gameHistory[prRound][0];

        return score;
    }

}
