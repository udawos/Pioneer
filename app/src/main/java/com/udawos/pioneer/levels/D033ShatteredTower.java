/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.udawos.pioneer.levels;

import com.udawos.pioneer.Assets;
import com.udawos.pioneer.actors.Actor;
import com.udawos.pioneer.actors.mobs.npcs.WildSheep;
import com.udawos.pioneer.levels.painters.Painter;
import com.udawos.utils.Bundle;
import com.udawos.utils.Random;

public class D033ShatteredTower extends Level {
    //Currently not a shattered tower, just hills

    {
        color1 = 0x4b6636;
        color2 = 0xf2f2f2;
        viewDistance = 16;
    }


    private static final int NW_CORNER_X	= 17;
    private static final int NW_CORNER_Y	= 0;
    private static final int SQUARE_WIDTH	= 13;
    private static final int SQUARE_HEIGHT	= 9;
    private static final int NE_CORNER_X	= NW_CORNER_X + SQUARE_WIDTH;

   private static final int NW_CORNER_X2	= 30;
    private static final int NW_CORNER_Y2	= 9;
    private static final int SQUARE_WIDTH2	= 11;
    private static final int SQUARE_HEIGHT2	= 9;
    private static final int NE_CORNER_X2	= NW_CORNER_X2 + SQUARE_WIDTH2;

    private static final int NW_CORNER_X3	= 41;
    private static final int NW_CORNER_Y3	= 18;
    private static final int SQUARE_WIDTH3	= 8;
    private static final int SQUARE_HEIGHT3	= 14;
    private static final int NE_CORNER_X3	= NW_CORNER_X3 + SQUARE_WIDTH3;

    private static final int NW_CORNER_X4	= 19;
    private static final int NW_CORNER_Y4	= 0;
    private static final int SQUARE_WIDTH4	= 11;
    private static final int SQUARE_HEIGHT4	= 7;
    private static final int NE_CORNER_X4	= NW_CORNER_X4 + SQUARE_WIDTH4;

    private static final int NW_CORNER_X5	= 32;
    private static final int NW_CORNER_Y5	= 7;
    private static final int SQUARE_WIDTH5	= 9;
    private static final int SQUARE_HEIGHT5	= 9;
    private static final int NE_CORNER_X5	= NW_CORNER_X5 + SQUARE_WIDTH5;

    private static final int NW_CORNER_X6	= 43;
    private static final int NW_CORNER_Y6	= 16;
    private static final int SQUARE_WIDTH6	= 6;
    private static final int SQUARE_HEIGHT6	= 13;
    private static final int NE_CORNER_X6	= NW_CORNER_X6 + SQUARE_WIDTH6;

    private static final int NW_CORNER_X7	= 21;
    private static final int NW_CORNER_Y7	= 0;
    private static final int SQUARE_WIDTH7	= 9;
    private static final int SQUARE_HEIGHT7	= 5;
    private static final int NE_CORNER_X7	= NW_CORNER_X7 + SQUARE_WIDTH7;

    private static final int NW_CORNER_X8	= 34;
    private static final int NW_CORNER_Y8	= 5;
    private static final int SQUARE_WIDTH8	= 7;
    private static final int SQUARE_HEIGHT8	= 9;
    private static final int NE_CORNER_X8	= NW_CORNER_X8 + SQUARE_WIDTH8;

    private static final int NW_CORNER_X9	= 45;
    private static final int NW_CORNER_Y9	= 14;
    private static final int SQUARE_WIDTH9	= 4;
    private static final int SQUARE_HEIGHT9	= 13;
    private static final int NE_CORNER_X9	= NW_CORNER_X9 + SQUARE_WIDTH9;

    private static final int NW_CORNER_X10	= 23;
    private static final int NW_CORNER_Y10	= 0;
    private static final int SQUARE_WIDTH10	= 7;
    private static final int SQUARE_HEIGHT10	= 3;
    private static final int NE_CORNER_X10	= NW_CORNER_X10 + SQUARE_WIDTH10;

    private static final int NW_CORNER_X11	= 36;
    private static final int NW_CORNER_Y11	= 3;
    private static final int SQUARE_WIDTH11	= 5;
    private static final int SQUARE_HEIGHT11	= 9;
    private static final int NE_CORNER_X11	= NW_CORNER_X11 + SQUARE_WIDTH11;

    private static final int NW_CORNER_X12	= 47;
    private static final int NW_CORNER_Y12	= 12;
    private static final int SQUARE_WIDTH12	   = 2;
    private static final int SQUARE_HEIGHT12   = 13;
    private static final int NE_CORNER_X12	= NW_CORNER_X12 + SQUARE_WIDTH12;

    @Override
    public String tilesTex() { return Assets.TILES_GRASS;
    }

    @Override
    public String waterTex() {
        return Assets.WATER_CITY;
    }

    protected boolean[] water() {
        return Patch.generate( feeling == Feeling.CHASM ? 0.60f : 0.45f, 6 );
    }


    @Override
    public void storeInBundle( Bundle bundle ) {
        super.storeInBundle(bundle);
    }

    @Override
    public void restoreFromBundle( Bundle bundle ) {
        super.restoreFromBundle(bundle);
    }

    @Override
    protected boolean build() {

        Painter.fill(this, NW_CORNER_X, NW_CORNER_Y, SQUARE_WIDTH + 1, 1, Terrain.MOUNTAIN_N);
        Painter.fill(this, NW_CORNER_X, NW_CORNER_Y , 1, 1, Terrain.MOUNTAIN_CORNER_NW);
        Painter.fill(this, NW_CORNER_X, NW_CORNER_Y+1 , 1, SQUARE_HEIGHT, Terrain.MOUNTAIN_W);
        Painter.fill(this, NW_CORNER_X , NW_CORNER_Y+SQUARE_HEIGHT , SQUARE_WIDTH+1, 1, Terrain.MOUNTAIN_S);
        Painter.fill(this, NW_CORNER_X, NW_CORNER_Y+SQUARE_HEIGHT , 1, 1, Terrain.MOUNTAIN_CORNER_SW);
       //Painter.fill(this, NE_CORNER_X , NW_CORNER_Y+SQUARE_HEIGHT , 1, 1, Terrain.MOUNTAIN_CORNER_SE);
       // Painter.fill(this, NE_CORNER_X, NW_CORNER_Y , 1, SQUARE_HEIGHT, Terrain.MOUNTAIN_E);
        //Painter.fill(this, NE_CORNER_X, NW_CORNER_Y, 1, 1, Terrain.MOUNTAIN_CORNER_NE);


        //
        //Painter.fill(this, NW_CORNER_X2, NW_CORNER_Y2 , SQUARE_WIDTH2+1, 1, Terrain.MOUNTAIN_N);
        //Painter.fill(this, NW_CORNER_X2, NW_CORNER_Y2 , 1, 1, Terrain.MOUNTAIN_CORNER_NW);
        Painter.fill(this, NW_CORNER_X2, NW_CORNER_Y2+1 , 1, SQUARE_HEIGHT2, Terrain.MOUNTAIN_W);
        Painter.fill(this, NW_CORNER_X2 , NW_CORNER_Y2+SQUARE_HEIGHT2 , SQUARE_WIDTH2+1, 1, Terrain.MOUNTAIN_S);
        Painter.fill(this, NW_CORNER_X2, NW_CORNER_Y2+SQUARE_HEIGHT2 , 1, 1, Terrain.MOUNTAIN_CORNER_SW);
        //Painter.fill(this, NE_CORNER_X2 , NW_CORNER_Y2+SQUARE_HEIGHT2 , 1, 1, Terrain.MOUNTAIN_CORNER_SE);
        //Painter.fill(this, NE_CORNER_X2, NW_CORNER_Y2 , 1, SQUARE_HEIGHT2, Terrain.MOUNTAIN_E);
        //Painter.fill(this, NE_CORNER_X2, NW_CORNER_Y2, 1, 1, Terrain.MOUNTAIN_CORNER_NE);

        //
        //Painter.fill(this, NW_CORNER_X3, NW_CORNER_Y3 , SQUARE_WIDTH3+1, 1, Terrain.MOUNTAIN_N);
        //Painter.fill(this, NW_CORNER_X3, NW_CORNER_Y3 , 1, 1, Terrain.MOUNTAIN_CORNER_NW);
        Painter.fill(this, NW_CORNER_X3, NW_CORNER_Y3+1 , 1, SQUARE_HEIGHT3, Terrain.MOUNTAIN_W);
        Painter.fill(this, NW_CORNER_X3 , NW_CORNER_Y3+SQUARE_HEIGHT3 , SQUARE_WIDTH3+1, 1, Terrain.MOUNTAIN_S);
        Painter.fill(this, NW_CORNER_X3, NW_CORNER_Y3+SQUARE_HEIGHT3 , 1, 1, Terrain.MOUNTAIN_CORNER_SW);
        //Painter.fill(this, NE_CORNER_X3 , NW_CORNER_Y3+SQUARE_HEIGHT3 , 1, 1, Terrain.MOUNTAIN_CORNER_SE);
        //Painter.fill(this, NE_CORNER_X3 , NW_CORNER_Y3 , 1, SQUARE_HEIGHT3, Terrain.MOUNTAIN_E);
       // Painter.fill(this, NE_CORNER_X3, NW_CORNER_Y3, 1, 1, Terrain.MOUNTAIN_CORNER_NE);


        //
        //Painter.fill(this, NW_CORNER_X4, NW_CORNER_Y4 , SQUARE_WIDTH4+1, 1, Terrain.MOUNTAIN_N);
        //Painter.fill(this, NW_CORNER_X4, NW_CORNER_Y4 , 1, 1, Terrain.MOUNTAIN_CORNER_NW);
        Painter.fill(this, NW_CORNER_X4, NW_CORNER_Y4 , 1, SQUARE_HEIGHT4, Terrain.MOUNTAIN_W);
        Painter.fill(this, NW_CORNER_X4 , NW_CORNER_Y4+SQUARE_HEIGHT4 , SQUARE_WIDTH4+3, 1, Terrain.MOUNTAIN_S);
        Painter.fill(this, NW_CORNER_X4, NW_CORNER_Y4+SQUARE_HEIGHT4 , 1, 1, Terrain.MOUNTAIN_CORNER_SW);
        //Painter.fill(this, NE_CORNER_X4 , NW_CORNER_Y4+SQUARE_HEIGHT4 , 1, 1, Terrain.MOUNTAIN_CORNER_SE);
        //Painter.fill(this, NE_CORNER_X4 , NW_CORNER_Y4 , 1, SQUARE_HEIGHT4, Terrain.MOUNTAIN_E);
        //Painter.fill(this, NE_CORNER_X4, NW_CORNER_Y4, 1, 1, Terrain.MOUNTAIN_CORNER_NE);



        //
        //Painter.fill(this, NW_CORNER_X5, NW_CORNER_Y5 , SQUARE_WIDTH5, 1, Terrain.MOUNTAIN_N);
        // Painter.fill(this, NW_CORNER_X5 , NW_CORNER_Y5 , 1, 1, Terrain.MOUNTAIN_CORNER_NW);
        Painter.fill(this, NW_CORNER_X5 , NW_CORNER_Y5+1 , 1, SQUARE_HEIGHT5, Terrain.MOUNTAIN_W);
        Painter.fill(this, NW_CORNER_X5 , NW_CORNER_Y5+SQUARE_HEIGHT5 , SQUARE_WIDTH5+3, 1, Terrain.MOUNTAIN_S);
        Painter.fill(this, NW_CORNER_X5  , NW_CORNER_Y5+SQUARE_HEIGHT5 , 1, 1, Terrain.MOUNTAIN_CORNER_SW);
        //Painter.fill(this, NE_CORNER_X5 , NW_CORNER_Y5+SQUARE_HEIGHT5 , 1, 1, Terrain.MOUNTAIN_CORNER_SE);
        //Painter.fill(this, NE_CORNER_X5 , NW_CORNER_Y5 , 1, SQUARE_HEIGHT5, Terrain.MOUNTAIN_E);
        // Painter.fill(this, NE_CORNER_X5, NW_CORNER_Y5, 1, 1, Terrain.MOUNTAIN_CORNER_NE);

        //
        //Painter.fill(this, NW_CORNER_X6, NW_CORNER_Y6 , SQUARE_WIDTH6, 1, Terrain.MOUNTAIN_N);
        //Painter.fill(this, NW_CORNER_X6 , NW_CORNER_Y6 , 1, 1, Terrain.MOUNTAIN_CORNER_NW);
        Painter.fill(this, NW_CORNER_X6 , NW_CORNER_Y6+1 , 1, SQUARE_HEIGHT6, Terrain.MOUNTAIN_W);
        Painter.fill(this, NW_CORNER_X6, NW_CORNER_Y6+SQUARE_HEIGHT6 , SQUARE_WIDTH6, 1, Terrain.MOUNTAIN_S);
        Painter.fill(this, NW_CORNER_X6  , NW_CORNER_Y6+SQUARE_HEIGHT6 , 1, 1, Terrain.MOUNTAIN_CORNER_SW);
        Painter.fill(this, NE_CORNER_X6 , NW_CORNER_Y6+SQUARE_HEIGHT6 , 1, 1, Terrain.MOUNTAIN_CORNER_SE);
        //Painter.fill(this, NE_CORNER_X6 , NW_CORNER_Y6 , 1, SQUARE_HEIGHT6, Terrain.MOUNTAIN_E);
        //Painter.fill(this, NE_CORNER_X6, NW_CORNER_Y6, 1, 1, Terrain.MOUNTAIN_CORNER_NE);

        //
        //Painter.fill(this, NW_CORNER_X7, NW_CORNER_Y7 , SQUARE_WIDTH7, 1, Terrain.MOUNTAIN_N);
        //Painter.fill(this, NW_CORNER_X7 , NW_CORNER_Y7 , 1, 1, Terrain.MOUNTAIN_CORNER_NW);
        Painter.fill(this, NW_CORNER_X7 , NW_CORNER_Y7 , 1, SQUARE_HEIGHT7, Terrain.MOUNTAIN_W);
        Painter.fill(this, NW_CORNER_X7 , NW_CORNER_Y7+SQUARE_HEIGHT7 , SQUARE_WIDTH7+5, 1, Terrain.MOUNTAIN_S);
        Painter.fill(this, NW_CORNER_X7  , NW_CORNER_Y7+SQUARE_HEIGHT7 , 1, 1, Terrain.MOUNTAIN_CORNER_SW);
        //Painter.fill(this, NE_CORNER_X7 , NW_CORNER_Y7+SQUARE_HEIGHT7 , 1, 1, Terrain.MOUNTAIN_CORNER_SE);
        //Painter.fill(this, NE_CORNER_X7, NW_CORNER_Y7 , 1, SQUARE_HEIGHT7, Terrain.MOUNTAIN_E);
        //Painter.fill(this, NE_CORNER_X7, NW_CORNER_Y7, 1, 1, Terrain.MOUNTAIN_CORNER_NE);


        //Painter.fill(this, NW_CORNER_X8, NW_CORNER_Y8 , SQUARE_WIDTH8, 1, Terrain.MOUNTAIN_N);
        //Painter.fill(this, NW_CORNER_X8 , NW_CORNER_Y8 , 1, 1, Terrain.MOUNTAIN_CORNER_NW);
        Painter.fill(this, NW_CORNER_X8 , NW_CORNER_Y8+1 , 1, SQUARE_HEIGHT8, Terrain.MOUNTAIN_W);
        Painter.fill(this, NW_CORNER_X8 , NW_CORNER_Y8+SQUARE_HEIGHT8 , SQUARE_WIDTH8+5, 1, Terrain.MOUNTAIN_S);
        Painter.fill(this, NW_CORNER_X8  , NW_CORNER_Y8+SQUARE_HEIGHT8 , 1, 1, Terrain.MOUNTAIN_CORNER_SW);
        //Painter.fill(this, NE_CORNER_X8 , NW_CORNER_Y8+SQUARE_HEIGHT8 , 1, 1, Terrain.MOUNTAIN_CORNER_SE);
       // Painter.fill(this, NE_CORNER_X8, NW_CORNER_Y8 , 1, SQUARE_HEIGHT8, Terrain.MOUNTAIN_E);
        //Painter.fill(this, NE_CORNER_X8, NW_CORNER_Y8, 1, 1, Terrain.MOUNTAIN_CORNER_NE);

        // Painter.fill(this, NW_CORNER_X9, NW_CORNER_Y9 , SQUARE_WIDTH9, 1, Terrain.MOUNTAIN_N);
        // Painter.fill(this, NW_CORNER_X9 , NW_CORNER_Y9 , 1, 1, Terrain.MOUNTAIN_CORNER_NW);
        Painter.fill(this, NW_CORNER_X9 , NW_CORNER_Y9+1 , 1, SQUARE_HEIGHT9, Terrain.MOUNTAIN_W);
        Painter.fill(this, NW_CORNER_X9, NW_CORNER_Y9+SQUARE_HEIGHT9, SQUARE_WIDTH9, 1, Terrain.MOUNTAIN_S);
        Painter.fill(this, NW_CORNER_X9  , NW_CORNER_Y9+SQUARE_HEIGHT9 , 1, 1, Terrain.MOUNTAIN_CORNER_SW);
        Painter.fill(this, NE_CORNER_X9 , NW_CORNER_Y9+SQUARE_HEIGHT9 , 1, 1, Terrain.MOUNTAIN_CORNER_SE);
        //Painter.fill(this, NE_CORNER_X9 , NW_CORNER_Y9 , 1, SQUARE_HEIGHT9, Terrain.MOUNTAIN_E);
        //Painter.fill(this, NE_CORNER_X9 , NW_CORNER_Y9, 1, 1, Terrain.MOUNTAIN_CORNER_NE);

        //Painter.fill(this, NW_CORNER_X10, NW_CORNER_Y10 , SQUARE_WIDTH10, 1, Terrain.MOUNTAIN_N);
        //Painter.fill(this, NW_CORNER_X10 , NW_CORNER_Y10 , 1, 1, Terrain.MOUNTAIN_CORNER_NW);
        Painter.fill(this, NW_CORNER_X10 , NW_CORNER_Y10 , 1, SQUARE_HEIGHT10, Terrain.MOUNTAIN_W);
        Painter.fill(this, NW_CORNER_X10 , NW_CORNER_Y10+SQUARE_HEIGHT10 , SQUARE_WIDTH10+7, 1, Terrain.MOUNTAIN_S);
        Painter.fill(this, NW_CORNER_X10  , NW_CORNER_Y10+SQUARE_HEIGHT10 , 1, 1, Terrain.MOUNTAIN_CORNER_SW);
        //Painter.fill(this, NE_CORNER_X10 , NW_CORNER_Y10+SQUARE_HEIGHT10 , 1, 1, Terrain.MOUNTAIN_CORNER_SE);
        //Painter.fill(this, NE_CORNER_X10 , NW_CORNER_Y10 , 1, SQUARE_HEIGHT10, Terrain.MOUNTAIN_E);
        // Painter.fill(this, NE_CORNER_X10 , NW_CORNER_Y10, 1, 1, Terrain.MOUNTAIN_CORNER_NE);

        //Painter.fill(this, NW_CORNER_X11, NW_CORNER_Y11 , SQUARE_WIDTH11, 1, Terrain.MOUNTAIN_N);
        //Painter.fill(this, NW_CORNER_X11 , NW_CORNER_Y11 , 1, 1, Terrain.MOUNTAIN_CORNER_NW);
        Painter.fill(this, NW_CORNER_X11 , NW_CORNER_Y11+1 , 1, SQUARE_HEIGHT11, Terrain.MOUNTAIN_W);
        Painter.fill(this, NW_CORNER_X11, NW_CORNER_Y11+SQUARE_HEIGHT11 , SQUARE_WIDTH11+7, 1, Terrain.MOUNTAIN_S);
        Painter.fill(this, NW_CORNER_X11  , NW_CORNER_Y11+SQUARE_HEIGHT11 , 1, 1, Terrain.MOUNTAIN_CORNER_SW);
        //Painter.fill(this, NE_CORNER_X11 , NW_CORNER_Y11+SQUARE_HEIGHT11 , 1, 1, Terrain.MOUNTAIN_CORNER_SE);
        //Painter.fill(this, NE_CORNER_X11 , NW_CORNER_Y11+2 , 1, SQUARE_HEIGHT11-2, Terrain.MOUNTAIN_E);
        //Painter.fill(this, NE_CORNER_X11 , NW_CORNER_Y11+1, 1, 1, Terrain.MOUNTAIN_CORNER_NE);

        // Painter.fill(this, NW_CORNER_X12, NW_CORNER_Y12 , SQUARE_WIDTH12, 1, Terrain.MOUNTAIN_N);
        //Painter.fill(this, NW_CORNER_X12 , NW_CORNER_Y12 , 1, 1, Terrain.MOUNTAIN_CORNER_NW);
        Painter.fill(this, NW_CORNER_X12 , NW_CORNER_Y12+1 , 1, SQUARE_HEIGHT12, Terrain.MOUNTAIN_W);
        Painter.fill(this, NW_CORNER_X12, NW_CORNER_Y12+SQUARE_HEIGHT12 , SQUARE_WIDTH12, 1, Terrain.MOUNTAIN_S);
        Painter.fill(this, NW_CORNER_X12  , NW_CORNER_Y12+SQUARE_HEIGHT12 , 1, 1, Terrain.MOUNTAIN_CORNER_SW);
        Painter.fill(this, NE_CORNER_X12 , NW_CORNER_Y12+SQUARE_HEIGHT12 , 1, 1, Terrain.MOUNTAIN_CORNER_SE);
        //Painter.fill(this, NE_CORNER_X12 , NW_CORNER_Y12 , 1, SQUARE_HEIGHT12, Terrain.MOUNTAIN_E);
        // Painter.fill(this, NE_CORNER_X12 , NW_CORNER_Y12, 1, 1, Terrain.MOUNTAIN_CORNER_NE);

        west = 1151;
        map[west] = Terrain.WEST;

        east = 1098;
        map[east] = Terrain.EAST;

        north = 75;
        map[north] = Terrain.NORTH;

        south =  2425;
        map[south] = Terrain.SOUTH;
        return true;
    }

    @Override
    protected void decorate() {
        for (int i=WIDTH + 1; i < LENGTH - WIDTH; i++) {
            if (map[i] == Terrain.MOUNTAIN_S && map[i+1] == Terrain.EMPTY && map[i+50] == Terrain.MOUNTAIN_W) {
                map[i] = Terrain.MOUNTAIN_ELBOW_NE;
            }
        }

        for (int i=WIDTH + 1; i < LENGTH - WIDTH; i++) {
            if (map[i] == Terrain.EMPTY) {
                int n = 0;
                if (map[i + 1] == Terrain.EMPTY) {
                    n++;
                }
                if (map[i - 1] == Terrain.EMPTY) {
                    n++;
                }
                if (map[i + WIDTH] == Terrain.EMPTY) {
                    n++;
                }
                if (map[i - WIDTH] == Terrain.EMPTY) {
                    n++;
                }
                if (Random.Int( 35 ) <= n) {
                    map[i] = Terrain.PEDESTAL;
                }
            }
        }
    }

    @Override
    public int nMobs() {
        return 1;
    }

    @Override
    protected void createMobs() {
        WildSheep.spawn(this);
    }

    public Actor respawner() {
        return null;
    }

    @Override
        protected void createItems() {

        }


    @Override
    public String tileName( int tile ) {
        switch (tile) {
            case Terrain.WATER:
                return "Suspiciously colored water";
            case Terrain.HIGH_GRASS:
                return "High blooming flowers";
            default:
                return super.tileName( tile );
        }
    }

    @Override
    public String tileDesc(int tile) {
        switch (tile) {
            case Terrain.ENTRANCE:
                return "A ramp leads up to the upper depth.";
            case Terrain.EXIT:
                return "A ramp leads down to the lower depth.";
            case Terrain.EMPTY_SP:
                return "Thick carpet covers the floor.";
            case Terrain.STATUE:
            case Terrain.STATUE_SP:
                return "The statue depicts some dwarf standing in a heroic stance.";
            case Terrain.BOOKSHELF:
                return "The rows of books on different disciplines fill the bookshelf.";
            default:
                return super.tileDesc( tile );
        }
    }

}
