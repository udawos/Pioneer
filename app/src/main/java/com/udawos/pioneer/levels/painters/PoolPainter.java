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
package com.udawos.pioneer.levels.painters;

import com.udawos.pioneer.actors.Actor;
import com.udawos.pioneer.actors.mobs.SeaMonster;
import com.udawos.pioneer.items.Generator;
import com.udawos.pioneer.items.Heap;
import com.udawos.pioneer.items.Item;
import com.udawos.pioneer.items.potions.PotionOfInvisibility;
import com.udawos.pioneer.levels.Level;
import com.udawos.pioneer.levels.Room;
import com.udawos.pioneer.levels.Terrain;
import com.udawos.utils.Random;

public class PoolPainter extends Painter {

	private static final int NPIRANHAS	= 3;
	
	public static void paint( Level level, Room room ) {
		
		fill( level, room, Terrain.WALL );
		fill( level, room, 1, Terrain.WATER );
		
		Room.Door door = room.entrance(); 
		door.set( Room.Door.Type.REGULAR );

		int x = -1;
		int y = -1;
		if (door.x == room.left) {
			
			x = room.right - 1;
			y = room.top + room.height() / 2;
			
		} else if (door.x == room.right) {
			
			x = room.left + 1;
			y = room.top + room.height() / 2;
			
		} else if (door.y == room.top) {
			
			x = room.left + room.width() / 2;
			y = room.bottom - 1;
			
		} else if (door.y == room.bottom) {
			
			x = room.left + room.width() / 2;
			y = room.top + 1;
			
		}
		
		int pos = x + y * Level.WIDTH;
		level.drop( prize( level ), pos ).type = 
			Random.Int( 3 ) == 0 ? Heap.Type.CHEST : Heap.Type.HEAP;
		set( level, pos, Terrain.PEDESTAL );
		
		level.addItemToSpawn( new PotionOfInvisibility() );
		
		for (int i=0; i < NPIRANHAS; i++) {
			SeaMonster SeaMonster = new SeaMonster();
			do {
				SeaMonster.pos = room.random();
			} while (level.map[SeaMonster.pos] != Terrain.WATER|| Actor.findChar( SeaMonster.pos ) != null);
			level.mobs.add( SeaMonster );
			Actor.occupyCell( SeaMonster );
		}
	}
	
	private static Item prize( Level level ) {
		
		Item prize = level.itemToSpanAsPrize();
		if (prize != null) {
			return prize;
		}
		
		prize = Generator.random( Random.oneOf(  
			Generator.Category.WEAPON, 
			Generator.Category.ARMOR 
		) );

		for (int i=0; i < 4; i++) {
			Item another = Generator.random( Random.oneOf(  
				Generator.Category.WEAPON, 
				Generator.Category.ARMOR 
			) );
			if (another.level > prize.level) {
				prize = another;
			}
		}
		
		return prize;
	}
}