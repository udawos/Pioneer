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
package com.udawos.pioneer.levels.features;

import com.udawos.pioneer.Dungeon;
import com.udawos.pioneer.actors.hero.Hero;
import com.udawos.pioneer.levels.Level;
import com.udawos.pioneer.levels.Terrain;
import com.udawos.pioneer.scenes.GameScene;
import com.udawos.pioneer.windows.WndClimb;

public class Cliff {


    public static void enter( int cell ) {
            int pos = cell;
            if (Level.solid[pos]) {
                Level.set( pos, Terrain.EMPTY );
                GameScene.updateMap(pos);
                Dungeon.observe();
            }

    }

    public static boolean climbConfirmed = false;

    public static void heroClimb( final Hero hero ) {
        GameScene.show(
                new WndClimb() {
                }
        );
    }


    public static void leave( int pos ) {
        if (Dungeon.level.heaps.get( pos ) == null) {
            Level.set( pos, Terrain.BOOKSHELF );
            GameScene.updateMap( pos );
            Dungeon.observe();
        }
    }
}