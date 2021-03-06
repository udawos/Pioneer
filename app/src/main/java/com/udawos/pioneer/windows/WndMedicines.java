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
package com.udawos.pioneer.windows;

import com.udawos.noosa.BitmapText;
import com.udawos.noosa.ui.Component;
import com.udawos.pioneer.Pioneer;
import com.udawos.pioneer.items.Item;
import com.udawos.pioneer.items.medicines.Medicines;
import com.udawos.pioneer.items.scrolls.Scroll;
import com.udawos.pioneer.scenes.GameScene;
import com.udawos.pioneer.scenes.PixelScene;
import com.udawos.pioneer.sprites.ItemSprite;
import com.udawos.pioneer.ui.ScrollPane;
import com.udawos.pioneer.ui.Window;
import com.udawos.pioneer.utils.Utils;

import java.util.ArrayList;

public class WndMedicines extends WndTabbed {

    private static final int WIDTH_P	= 112;
    private static final int HEIGHT_P	= 160;

    private static final int WIDTH_L	= 128;
    private static final int HEIGHT_L	= 128;

    private static final int ITEM_HEIGHT	= 18;

    private static final int TAB_WIDTH		= 50;

    private static final String TXT_MEDICINES	= "Medicines";
    private static final String TXT_SCROLLS 	= "Scrolls";
    private static final String TXT_TITLE	    = "Medicines";

    private BitmapText txtTitle;
    private ScrollPane list;

    private ArrayList<ListItem> items = new ArrayList<WndMedicines.ListItem>();

    private static boolean showMedicines = true;

    public WndMedicines() {

        super();

        if (Pioneer.landscape()) {
            resize( WIDTH_L, HEIGHT_L );
        } else {
            resize( WIDTH_P, HEIGHT_P );
        }

        txtTitle = PixelScene.createText( TXT_TITLE, 9 );
        txtTitle.hardlight( Window.TITLE_COLOR );
        txtTitle.measure();
        add( txtTitle );

        list = new ScrollPane( new Component() ) {
            @Override
            public void onClick( float x, float y ) {
                int size = items.size();
                for (int i=0; i < size; i++) {
                    if (items.get( i ).onClick( x, y )) {
                        break;
                    }
                }
            }
        };
        add( list );
        list.setRect( 0, txtTitle.height(), width, height - txtTitle.height() );

        boolean showPotions = WndMedicines.showMedicines;
        Tab[] tabs = {
                new LabeledTab( TXT_MEDICINES ) {
                    protected void select( boolean value ) {
                        super.select( value );
                        WndMedicines.showMedicines = value;
                        updateList();
                    };
                },
                new LabeledTab( TXT_SCROLLS ) {
                    protected void select( boolean value ) {
                        super.select( value );
                        WndMedicines.showMedicines = !value;
                        updateList();
                    };
                }
        };
        for (Tab tab : tabs) {
            tab.setSize( TAB_WIDTH, tabHeight() );
            add( tab );
        }

        select( showMedicines ? 0 : 1 );
    }

    private void updateList() {

        txtTitle.text( Utils.format( TXT_TITLE, showMedicines ? TXT_MEDICINES : TXT_SCROLLS ) );
        txtTitle.measure();
        txtTitle.x = PixelScene.align( PixelScene.uiCamera, (width - txtTitle.width()) / 2 );

        items.clear();

        Component content = list.content();
        content.clear();
        list.scrollTo( 0, 0 );

        float pos = 0;
        for (Class<? extends Item> itemClass : showMedicines ? Medicines.getKnown() : Scroll.getKnown()) {
            ListItem item = new ListItem( itemClass );
            item.setRect( 0, pos, width, ITEM_HEIGHT );
            content.add( item );
            items.add( item );

            pos += item.height();
        }

        for (Class<? extends Item> itemClass : showMedicines ? Medicines.getUnknown() : Scroll.getUnknown()) {
            ListItem item = new ListItem( itemClass );
            item.setRect( 0, pos, width, ITEM_HEIGHT );
            content.add( item );
            items.add( item );

            pos += item.height();
        }

        content.setSize( width, pos );
    }

    private static class ListItem extends Component {

        private Item item;
        private boolean identified;

        private ItemSprite sprite;
        private BitmapText label;

        public ListItem( Class<? extends Item> cl ) {
            super();

            try {
                item = cl.newInstance();
                if (identified = item.isIdentified()) {
                    sprite.view( item.image(), null );
                    label.text( item.name() );
                } else {
                    sprite.view( 127, null );
                    label.text( item.trueName() );
                    label.hardlight( 0xCCCCCC );
                }
            } catch (Exception e) {
                // Do nothing
            }
        }

        @Override
        protected void createChildren() {
            sprite = new ItemSprite();
            add( sprite );

            label = PixelScene.createText( 8 );
            add( label );
        }

        @Override
        protected void layout() {
            sprite.y = PixelScene.align( y + (height - sprite.height) / 2 );

            label.x = sprite.x + sprite.width;
            label.y = PixelScene.align( y + (height - label.baseLine()) / 2 );
        }

        public boolean onClick( float x, float y ) {
            if (identified && inside( x, y )) {
                GameScene.show( new WndInfoItem( item ) );
                return true;
            } else {
                return false;
            }
        }
    }
}
