package com.example.emad.splashscreen;

import java.util.ArrayList;

/**
 * Created by HP Pavilion 13 on 3/16/2017.
 */

public class FantasyScore {

    public static void calculatet20Points(ArrayList<Player> p) {

        int t = p.size();
        for (int i = 0; i < t; i++) {
            if (p.get(i).balls < 0) {
                p.get(i).runs = 0;

            }
            if (p.get(i).runs == 0) {
                if (p.get(i).balls > 0) {
                    p.get(i).points = p.get(i).points - 10;
                }
                if (p.get(i).balls == 0) {
                    p.get(i).points = p.get(i).points - 20;
                }
            }

            p.get(i).points = p.get(i).points + p.get(i).runs;

            if (p.get(i).runs >= 50 && p.get(i).runs < 100) {
                p.get(i).points = p.get(i).points + 25;
            }
            if (p.get(i).runs >= 100) {
                p.get(i).points = p.get(i).points + 50;
            }
            if (p.get(i).runs >= 50 && p.get(i).runs < 75) {
                p.get(i).points = p.get(i).points + 30;
            }
            if (p.get(i).runs >= 75 && p.get(i).runs < 100) {
                p.get(i).points = p.get(i).points + 40;
            }
            if (p.get(i).runs > 15) {
                if (p.get(i).SR >= 250) {
                    p.get(i).points = p.get(i).points + 50;
                }
                if (p.get(i).SR >= 200.0 && p.get(i).SR < 250) {
                    // p[i].points=p[i].points+40;
                }

                if (p.get(i).SR >= 175.0 && p.get(i).SR < 200.0) {
                    p.get(i).points = p.get(i).points + 30;
                }
                if (p.get(i).SR >= 150.0 && p.get(i).SR < 175.0) {
                    p.get(i).points = p.get(i).points + 20;
                }
                if (p.get(i).SR >= 125.0 && p.get(i).SR < 150.0) {
                    p.get(i).points = p.get(i).points + 10;
                }
                if (p.get(i).SR >= 75.0 && p.get(i).SR < 100.0) {
                    p.get(i).points = p.get(i).points - 10;
                }
                if (p.get(i).SR < 75.0) {
                    p.get(i).points = p.get(i).points - 20;
                }
            }
            if (p.get(i).runs < 0) {
                p.get(i).points = p.get(i).points + 0;
            }
            p.get(i).points = p.get(i).points + (p.get(i).wickets * 20);
            if (p.get(i).wickets == 3) {
                p.get(i).points = p.get(i).points + 30;
            }
            if (p.get(i).wickets == 4) {
                p.get(i).points = p.get(i).points + 40;
            }
            if (p.get(i).wickets > 4) {
                p.get(i).points = p.get(i).points + 50;
            }

            if (p.get(i).overs_ >= 2.00) {
                if (p.get(i).economy <= 5.00) {
                    p.get(i).points = p.get(i).points + 30;
                }
                if (p.get(i).economy <= 6.00 && p.get(i).economy > 5.00) {
                    p.get(i).points = p.get(i).points + 20;
                }
                if (p.get(i).economy <= 7.00 && p.get(i).economy > 6.00) {
                    p.get(i).points = p.get(i).points + 10;
                }
                if (p.get(i).economy <= 9.00 && p.get(i).economy > 8.00) {
                    p.get(i).points = p.get(i).points - 10;
                }
                if (p.get(i).economy <= 10.00 && p.get(i).economy > 9.00) {
                    p.get(i).points = p.get(i).points - 20;
                }
                if (p.get(i).economy > 10.00) {
                    p.get(i).points = p.get(i).points - 25;
                }
            }
            p.get(i).points = p.get(i).points + ((p.get(i).catches) * 10);
            p.get(i).points = p.get(i).points + ((p.get(i).stumping * 15));
            p.get(i).points = p.get(i).points + ((p.get(i).maidens_ * 10));
        }
        for (int j = 0; j < t; j++) {
            p.get(j).Display_Player();
        }
    }


    public static void calculatetestPoints(Player[] p) {

        int t = p.length;
        for (int i = 0; i < t; i++) {
            if (p[i].balls < 0) {
                p[i].runs = 0;

            }
            if (p[i].runs == 0) {
                if (p[i].balls > 0) {
                    p[i].points = p[i].points - 10;
                }
                if (p[i].balls == 0) {
                    p[i].points = p[i].points - 20;
                }
            }

            p[i].points = p[i].points + p[i].runs;

            if (p[i].runs >= 50 && p[i].runs < 100) {
                p[i].points = p[i].points + 35;
            }
            if (p[i].runs >= 100 && p[i].runs < 150) {
                p[i].points = p[i].points + 70;
            }
            if (p[i].runs >= 150 && p[i].runs < 200) {
                p[i].points = p[i].points + 125;
            }
            if (p[i].runs >= 200 && p[i].runs < 300) {
                p[i].points = p[i].points + 150;
            }
            if (p[i].runs >= 300) {
                p[i].points = p[i].points + 175;
            }
            if (p[i].runs < 0) {
                p[i].points = p[i].points + 0;
            }
            p[i].points = p[i].points + (p[i].wickets * 25);

            if (p[i].wickets == 4) {
                p[i].points = p[i].points + 35;
            }
            if (p[i].wickets == 5) {
                p[i].points = p[i].points + 70;
            }
            if (p[i].wickets > 6) {
                p[i].points = p[i].points + 125;
            }

            p[i].points = p[i].points + ((p[i].catches) * 10);
            p[i].points = p[i].points + ((p[i].stumping * 15));

        }
        for (int i = 0; i < t; i++) {
            p[i].Display_Player();
            // DB.insertDB(p[i]);
        }
    }

    public static void calculateOdiPoints(Player[] p) {

        int t = p.length;
        for (int i = 0; i < t; i++) {
            if (p[i].balls < 0) {
                p[i].runs = 0;

            }
            if (p[i].runs == 0) {
                if (p[i].balls > 0) {
                    p[i].points = p[i].points - 10;
                }
                if (p[i].balls == 0) {
                    p[i].points = p[i].points - 20;
                }
            }

            p[i].points = p[i].points + p[i].runs;

            if (p[i].runs >= 50 && p[i].runs < 100) {
                p[i].points = p[i].points + 25;
            }
            if (p[i].runs >= 100 && p[i].runs < 150) {
                p[i].points = p[i].points + 40;
            }
            if (p[i].runs >= 150 && p[i].runs < 200) {
                p[i].points = p[i].points + 55;
            }
            if (p[i].runs >= 200) {
                p[i].points = p[i].points + 70;
            }
            if (p[i].runs > 20) {
                if (p[i].SR >= 100) {
                    p[i].points = p[i].points + 10;
                }
                if (p[i].SR >= 80 && p[i].SR <= 99.9) {
                    p[i].points = p[i].points + 5;
                }
                if (p[i].SR < 75 && p[i].SR > 0) {
                    p[i].points = p[i].points - 10;
                }
            }
            if (p[i].runs < 0) {
                p[i].points = p[i].points + 0;
            }
            p[i].points = p[i].points + (p[i].wickets * 20);
            if (p[i].wickets == 4) {
                p[i].points = p[i].points + 30;
            }
            if (p[i].wickets > 4) {
                p[i].points = p[i].points + 50;
            }

            if (p[i].overs_ >= 4.00) {
                if (p[i].economy <= 3.50) {
                    p[i].points = p[i].points + 25;
                }
                if (p[i].economy <= 4.50 && p[i].economy > 3.50) {
                    p[i].points = p[i].points + 15;
                }
                if (p[i].economy <= 5.00 && p[i].economy > 4.50) {
                    p[i].points = p[i].points + 5;
                }
                if (p[i].economy <= 7.00 && p[i].economy > 6.00) {
                    p[i].points = p[i].points - 10;
                }
                if (p[i].economy <= 8.00 && p[i].economy > 7.00) {
                    p[i].points = p[i].points - 20;
                }
                if (p[i].economy > 8.00) {
                    p[i].points = p[i].points - 25;
                }
            }
            p[i].points = p[i].points + ((p[i].catches) * 10);
            p[i].points = p[i].points + ((p[i].stumping * 15));

        }
        for (int i = 0; i < t; i++) {
            p[i].Display_Player();
            // DB.insertDB(p[i]);
        }
    }


}
