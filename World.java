package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


public class World {
	
	public static List<Blocos> blocos = new ArrayList<Blocos>();
	
	public World() {
		for(int xx = 0; xx < 24; xx++) {
			blocos.add(new Blocos(xx*32,0));
	}
		for(int yy = 0; yy < 24; yy++) {
			blocos.add(new Blocos(0,yy*32));
	}
	for(int xx = 0; xx < 24; xx++) {
			blocos.add(new Blocos(xx*32,480-32));
	}
	for(int yy = 0; yy < 24; yy++) {
			blocos.add(new Blocos(640-32,yy*32));
	 	}
	}
	
	public static boolean isFree(int x, int y) {
		for(int i = 0; i< blocos.size(); i++) {
			Blocos blocoAtual = blocos.get(i);
			if(blocoAtual.intersects(new Rectangle(x,y,32,32))) {
				return false;
				}
			}	
		return true;
		}
	public void render(Graphics g) {
		for(int i = 0; i <blocos.size(); i++) {
			blocos.get(i).render(g);
			
		}}}

