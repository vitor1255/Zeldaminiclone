package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	
	//tamanho da janela 
	public static int WIDTH = 640, HEIGHT = 480;
	public static int SCALE = 3;
	public Player player;
	public World world;
	public List<Inimigo> inimigo = new ArrayList <Inimigo>();
	
	public Game() {
		this.addKeyListener(this);
		//dimensão da janela
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		new Spritesheet ();
		player = new Player(64,64);
		world = new World ();
		inimigo.add(new Inimigo(32,32));
	}
	//movimentações do player
	public void tick() {
		player.tick();
		
		for (int i = 0; i< inimigo.size();i++) {
			inimigo.get(i).tick();
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		//otimizar o grafico
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//cor de fundo
		g.setColor(new Color(0,135,13));
		//TAMANHO DA COR OU IMAGEM
		g.fillRect(0, 0, WIDTH*SCALE,HEIGHT*SCALE);
		
		player.render(g);
		for (int i = 0; i< inimigo.size();i++) {
			inimigo.get(i).render(g);
		}
		world.render(g);
		
		bs.show();
		
		
	}
	public static void main(String[] args) {
		Game game = new Game();
		//janela do jogo
		JFrame frame = new JFrame();
		//manter todos nessa sequencia
		frame.add(game);
		//nome do jogo 
		frame.setTitle("Mini Zelda");
		//transformar tudo as conf em um pack
		frame.pack();
		//janela centralizada na tela
		frame.setLocationRelativeTo(null);
		//fechar a operação quando fechar a janela do jogo
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//tela do jogo ficar visivel 
		frame.setVisible(true);
		
		new Thread(game).start();
	}
	public void run() {	
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if( e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		if( e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
		}
		if( e.getKeyCode() == KeyEvent.VK_SPACE) {
			player.shoot = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if( e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		if( e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;
		}
	}
	
}
