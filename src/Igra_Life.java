/**
 * Created by Оля on 12.10.2014.
 */
public class Igra_Life {
    public static void main(String[] args) {
        Display d = new Display();
        boolean[][]mask = new boolean [100][100];
        mask[30][60] = true;
        mask[30][61] = true;
        mask[30][62] = true;
        d.setMask(mask);
        while (true){
            boolean[][] mask1 = new boolean[100][100];
            for (int y=0; y<100; y++){
                for (int x=0; x<100; x++){
                    mask1[y][x] = mask[y][x];
                }
            }
            for (int y=1; y<99; y++){
                for (int x=1; x<99; x++){
                    int count = 0;
                    for (int dy=-1; dy<=1; dy++){
                        for (int dx=-1; dx<=1; dx++){
                            if (dx == 0 && dy == 0){
                                continue;
                            }
                            int y1 = y+dy;
                            int x1 = x+dx;
                            if (mask[y1][x1] == true){
                                count++;
                            }
                        }
                        if ((count < 2 || count > 3)&&(mask[y][x] == false)){
                        mask1[y][x] = false;
                        }
                        if ((count == 3)&&(mask[y][x] == false)){
                        mask[y][x] = true;
                        }
                    }
                d.setMask(mask1);
                mask = mask1;
                }
            }
        }

    }
}
