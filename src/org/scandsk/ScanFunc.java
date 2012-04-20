package org.scandsk;

/**
 * Created by IntelliJ IDEA.
 * User: пользователь1
 * Date: 21.03.12
 * Time: 19:58
 * To change this template use File | Settings | File Templates.
 */
public class ScanFunc  {
    private int fat;
    private int rdir;
    public void scanFunc(Fat aa,Rdir bb){
        fat=aa.getFat();
        rdir=bb.getRdir();
        String[] dop_Name = new String[fat];
        Integer[] dop_FC = new Integer[fat];

        int q = 0;
        int x = 0;
        int y = 0;
        R:
        for (int i = 0; i <= fat; i++) {
            if (aa.Claster[i] > -1) {
                L:
                for (int j = 0; j <= rdir; j++) {
                    if (bb.FC_[j] != i) {
                        x++;
                        if (x == rdir + 1) {
                            x = 0;
                            T:
                            for (int n = 0; n <= fat; n++) {
                                if (aa.Claster[n] != i) {
                                    y++;
                                    if (y == fat + 1) {
                                        y = 0;

                                        dop_Name[q] = ("File " + (rdir + q + 1));
                                        dop_FC[q] = i;
                                        q++;

                                    } else continue T;

                                } else {
                                    y = 0;
                                    continue R;
                                }
                            }
                        } else continue L;

                    } else {
                        x = 0;
                        continue R;
                    }
                }
            } else continue R;
        }


        rdir += q;
        String[] Name = new String[rdir + 1];
        Integer[] FC = new Integer[rdir + 1];
        for (int i = 0; i <= rdir - q; i++) {
            FC[i] = bb.FC_[i];
            Name[i] = bb.Name_[i];
        }
        for (int i = rdir - q + 1; i <= rdir; i++) {
            FC[i] = dop_FC[i - rdir + q - 1];
            Name[i] = dop_Name[i - rdir + q - 1];
        }


        //Исправление ссылок на путые или испоченные кластеры


        E:
        for (int i = 0; i <= rdir; i++) {
            int e = aa.Claster[FC[i]];
            int w = FC[i];
            int v = 0;
            System.out.println("Для файла '" + Name[i] + "' с начальным кластером " + FC[i]);

            if (e == -2) {
                System.out.println("    Недопустимая ссылка (на пустую ячейку), удаление файла " + Name[i]);
                Name[i] = "Delited"; /*FC[i]=null;*/
                continue E;
            }
            if (e == -3) {
                System.out.println("    Недопустимая ссылка (на 'плохую' ячейку), удаление файла " + Name[i]);
                Name[i] = "Delited"; /*FC[i]=null;*/
                continue E;
            }

            if (e >= 0) {
                do {
                    System.out.println("    Совершен переход в кластер " + e);
                    e = aa.Claster[e];
                    v++;

                } while (e >= 0);
                if (v > 1) {
                    for (int j = 2; j <= v; j++) {
                        w = aa.Claster[w];
                    }
                }
                /*
                if (FC[i] < 0) {
                    System.out.println("Недопустимая ссылка, удаление файла " + Name[i]);
                    Name[i] = "Delited";
                    FC[i] = null;
                    continue E;
                } */


            } else
                System.out.println("    Кластер №" + w + ":");


            if (e == -1) {
                System.out.println("        Конец файла '" + Name[i] + "'");
                continue E;
            }
            if (e == -2) {
                System.out.println("        Пуст. Перенесение конца файла в кластер " + w);
                aa.Claster[w] = -1;

                continue E;
            }
            if (e == -3) {
                System.out.println("        Испорчен. Перенесение конца файла в кластер " + w);
                aa.Claster[w] = -1;

                continue E;
            }

        }


        //Исправление ошибки пересечения файлов
        int d = 0;
        Integer[] Nemp = new Integer[fat];
        for (int n = 0; n <= fat; n++) {
            if (aa.Claster[n] == -2) {
                Nemp[d] = n;
                d++;
            }
        }
        int a = 0;
        Y:
        for (int i = 1; i <= rdir; i++) {
            for (int j = 0; j < i; j++) {
                int r = FC[i];
                int z = FC[j];

                if (r == z) {
                    FC[i] = Nemp[a];
                    aa.Claster[Nemp[a]] = aa.Claster[r];
                    a++;
                    continue Y;
                }

                for (int k = 1; k <= fat; k++) {
                    for (int m = 0; m != k; m++) {
                        int rr = aa.Claster[k];
                        int zz = aa.Claster[m];

                        if (r == zz) {
                            if (zz >= 0) {

                                FC[i] = Nemp[a];
                                aa.Claster[Nemp[a]] = aa.Claster[r];
                                a++;
                                continue Y;
                            }
                        }


                        if (rr == zz) {
                            if (rr >= 0) {
                                aa.Claster[k] = Nemp[a];
                                do {
                                    aa.Claster[Nemp[a]] = aa.Claster[rr];
                                    a++;
                                    rr = aa.Claster[rr];
                                    zz = aa.Claster[zz];

                                    zz = Nemp[a];

                                }
                                while (rr == zz);
                                continue Y;
                            }
                        }

                    }
                }
            }
        }
        System.out.println("Окончательный Fat:");
        for (int i = 0; i <= fat; i++) {
            System.out.println(aa.Claster[i]);
        }

        int bad = 0, emp = 0;
        for (int j = 0; j <= fat; j++) {
            if (aa.Claster[j] == -2) emp++;
            if (aa.Claster[j] == -3) bad++;
        }
        /*System.out.println("Массив пустых ячеек:");
        for (int i = 0; i <= d - 1; i++) {
            System.out.println(" Nemp[" + i + "] = " + Nemp[i]);
        } */
        System.out.println("bad = " + bad + "; emp = " + emp);

        System.out.println("Массив новых файлов:");
        for (int i = 0; i <= q - 1; i++) {
            System.out.println(dop_Name[i] + " " + dop_FC[i]);
        }
        System.out.println("Окончательный rDir:");
        for (int i = 0; i <= rdir; i++) {
            System.out.println(Name[i] + "\t " + FC[i]);
        }   
    }
}
