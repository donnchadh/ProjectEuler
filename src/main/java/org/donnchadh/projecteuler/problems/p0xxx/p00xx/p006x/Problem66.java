package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p006x;

import java.math.BigInteger;

public class Problem66 {
    public static void main(String[] args) {
        BigInteger max = BigInteger.ZERO;
        long DforMax = 0;
        for (long D = 2; D <= 1000; D++) {
            double sqrtD = Math.sqrt(D);
            int iSqrtD = (int) Math.round(sqrtD);
            if (iSqrtD * iSqrtD != D) {
                long a0 = (int) Math.floor(sqrtD);
                long p0 = a0;
                long P0 = 0;
                long Q0 = 1;

                BigInteger pnm2 = BigInteger.ONE;
                BigInteger pnm1 = BigInteger.valueOf(p0);
                long Pnm1 = P0;
                long anm1 = a0;
                long Qnm1 = Q0;
                BigInteger qnm2 = BigInteger.ZERO;
                BigInteger qnm1 = BigInteger.ONE;
                for (int n = 1;; n++) {
                    long Pn = anm1 * Qnm1 - Pnm1;
                    long Qn = (D-Pn*Pn)/Qnm1;
                    long an = (a0 + Pn)/Qn;
                    BigInteger bigA = BigInteger.valueOf(an);
                    BigInteger pn = bigA.multiply(pnm1).add(pnm2);
                    BigInteger qn = bigA.multiply(qnm1).add(qnm2);
                    
                    if (pn.pow(2).subtract(BigInteger.valueOf(D).multiply(qn.pow(2))).equals(BigInteger.ONE)) {
                        System.out.println(D + " - " + pn + "^2 - " + D + "*" + qn + "^2=1");
                        if (pn.compareTo(max) > 0) {
                            max = pn;
                            DforMax = D;
                        }
                        break;
                    }
                    pnm2 = pnm1;
                    pnm1 = pn;
                    Pnm1 = Pn;
                    anm1 = an;
                    Qnm1 = Qn;
                    qnm2 = qnm1;
                    qnm1 = qn;
                }
            }
        }
        System.out.println(max);
        System.out.println(DforMax);
    }

    public static void main1(String[] args) {
        long minXs[] = new long[1001];
        for (int D = 2; D <= 1000; D++) {
            int sqrtD = (int) Math.round(Math.sqrt(D));
            if (sqrtD * sqrtD != D) {
                for (long y = 1;; y++) {
                    long xSquared = D * y * y + 1;
                    long x = Math.round(Math.sqrt(xSquared));
                    if (x * x == xSquared) {
                        if (x * x - D * y * y != 1) {
                            System.out.println("!" + (x * x - D * y * y));
                        }
                        minXs[D] = x;
                        break;
                    }
                }
            }
        }
        long max = 0;
        int DforMax = 0;
        for (int D = 2; D <= 1000; D++) {
            int sqrtD = (int) Math.round(Math.sqrt(D));
            if (sqrtD * sqrtD != D) {
                for (long x = 2;; x++) {
                    if ((x * x - 1) % D == 0) {
                        long ySquared = (x * x - 1) / D;
                        long y = Math.round(Math.sqrt(ySquared));
                        if (y * y == ySquared) {
                            if (x * x - D * y * y != 1) {
                                System.out.println("!" + (x * x - D * y * y));
                            }
                            if (x > minXs[D]) {
                                x = minXs[D];
                            }
                            if (x > max) {
                                System.out.println(D + " - " + x + "^2 - " + D + "*" + y + "^2=1");
                                max = x;
                                DforMax = D;
                            }
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(max);
        System.out.println(DforMax);
    }

    public static void main2(String[] args) {
        long max = 0;
        int DforMax = 0;
        for (int D = 2; D <= 1000; D++) {
            int sqrtD = (int) Math.round(Math.sqrt(D));
            if (sqrtD * sqrtD != D) {
                for (long x = 2;; x++) {
                    if ((x * x - 1) % D == 0) {
                        long ySquared = (x * x - 1) / D;
                        long y = Math.round(Math.sqrt(ySquared));
                        if (y * y == ySquared) {
                            if (x * x - D * y * y != 1) {
                                System.out.println("!" + (x * x - D * y * y));
                            }
                            if (x > max) {
                                System.out.println(D + " - " + x + "^2 - " + D + "*" + y + "^2=1");
                                max = x;
                                DforMax = D;
                            }
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(max);
        System.out.println(DforMax);
    }

    public static void main3(String[] args) {
        long max = 0;
        int DforMax = 0;
        long minXs[] = new long[1001];
        for (int D = 2; D <= 1000; D++) {
            if (D % 20 == 0) {
                System.out.println(D);
            }
            int sqrtD = (int) Math.round(Math.sqrt(D));
            if (sqrtD * sqrtD != D) {
                for (long y = 1;; y++) {
                    long xSquared = D * y * y + 1;
                    long x = Math.round(Math.sqrt(xSquared));
                    if (x * x == xSquared) {
                        if (x * x - D * y * y != 1) {
                            System.out.println("!" + (x * x - D * y * y));
                        }
                        minXs[D] = x;
                        if (x > max) {
                            System.out.println(D + " - " + x + "^2 - " + D + "*" + y + "^2=1");
                            max = x;
                            DforMax = D;
                        } else {
                            System.out.print(".");
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(max);
        System.out.println(DforMax);
    }

}
