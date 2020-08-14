package Logiikka.Generointi;

import java.util.Random;

public class Huonegeneraattori {

    /**
     * Luo alueeseen satunnaisen huoneen. Metodit ovat public testejä varten.
     *
     * @param alue Alue johon huone halutaan luoda.
     */
    public void luoHuone(Alue alue) {
        if (alue.getPituusx() == 0 | alue.getPituusy() == 0) {
            yksinainen(alue, alue.getHuone());
        } else {
            Random r = new Random();
            int a = r.nextInt(8);
            int[][] huone = alue.getHuone();
            switch (a) {
                case 0:
                    temppeli(alue, huone);
                    break;
                case 1:
                    isoinMahdollinen(alue, huone);
                    break;
                case 2:
                    pilareita(alue, huone);
                    break;
                case 3:
                    nelio(alue, huone);
                    break;
                case 4:
                    yksinainen(alue, huone);
                    break;
                case 5:
                    ristikko(alue, huone);
                    break;
                case 6:
                    ympyra(alue, huone);
                    break;
                default:
                    taysinRandom(r, alue, huone);
                    break;
            }
        }
    }

    public void taysinRandom(Random r, Alue alue, int[][] huone) {
        int rx = r.nextInt(alue.getPituusx());
        int ry = r.nextInt(alue.getPituusy());
        for (int y = 0; y < alue.getPituusy(); y++) {
            for (int x = 0; x < alue.getPituusx(); x++) {
                if (x >= rx & y >= ry) {
                    huone[x][y] = 1;
                }
            }
        }
    }

    public void isoinMahdollinen(Alue alue, int[][] huone) {
        for (int y = 0; y < alue.getPituusy(); y++) {
            for (int x = 0; x < alue.getPituusx(); x++) {
                huone[x][y] = 1;
            }
        }
    }

    public void pilareita(Alue alue, int[][] huone) {
        int a = 1;
        for (int y = 0; y < alue.getPituusy(); y++) {
            for (int x = 0; x < alue.getPituusx(); x++) {
                if (a == 1) {
                    huone[x][y] = 1;
                } else {
                    if (x % 2 == 0) {
                        huone[x][y] = 1;
                    }
                }
            }
            if (a == 1) {
                a = 0;
            } else {
                a = 1;
            }
        }
    }

    public void nelio(Alue alue, int[][] huone) {
        int px = 0 + alue.getPituusx();
        int py = 0 + alue.getPituusy();
        if (px > py) {
            px = py;
        } else {
            py = px;
        }
        for (int y = 0; y < alue.getPituusy(); y++) {
            for (int x = 0; x < alue.getPituusx(); x++) {
                if (x <= px & y <= py) {
                    huone[x][y] = 1;
                }
            }
        }
    }

    public void yksinainen(Alue alue, int[][] huone) {
        if (alue.getPituusx() == 0 | alue.getPituusy() == 0) {
            huone[0][0] = 1;
        } else {
            huone[alue.getPituusx() / 2][alue.getPituusy() / 2] = 1;
        }
    }

    public void ristikko(Alue alue, int[][] huone) {
        for (int y = 0; y < alue.getPituusy(); y++) {
            for (int x = 0; x < alue.getPituusx(); x++) {
                if (y == alue.getPituusy() / 2 | x == alue.getPituusx() / 2) {
                    huone[x][y] = 1;
                }
            }
        }
    }

    public void ympyra(Alue alue, int[][] huone) {
        int palax = alue.getPituusx() / 4;
        int palay = alue.getPituusy() / 4;
        for (int y = 0; y < alue.getPituusy(); y++) {
            for (int x = 0; x < alue.getPituusx(); x++) {
                if (x <= palax | y <= palay | y >= (alue.getPituusy() - palay) | x >= (alue.getPituusx() - palay)) {
                    huone[x][y] = 1;
                }
            }
        }
    }

    public void temppeli(Alue alue, int[][] huone) {
        ympyra(alue, huone);
        ristikko(alue, huone);
    }

}
