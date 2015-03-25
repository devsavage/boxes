package tv.savageboy74.boxes.main;

/*
 * Game.java
 * Copyright (C) 2015 Savage - github.com/savageboy74
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import tv.savageboy74.boxes.game.ObjectId;
import tv.savageboy74.boxes.game.Player;
import tv.savageboy74.boxes.handlers.GameHandler;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable
{
    private static final long serialVersionUID = 6993996442171781734L;

    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;

    private boolean isRunning = false;

    private Thread thread;
    private GameHandler handler;

    public Game()
    {
        new Window(WIDTH, HEIGHT, "Boxes", this);
        handler = new GameHandler();
    }

    public static void main(String args[])
    {
        new Game();
    }

    @Override
    public void run()
    {
        long lastTime = System.nanoTime();
        double ticks = 60.0;
        double ns = 1000000000 / ticks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int fps = 0;

        while (isRunning)
        {
            long timeNow = System.nanoTime();
            delta += (timeNow - lastTime) / ns;
            lastTime = timeNow;

            while (delta >= 1)
            {
                tickGame();
                delta--;
            }

            if (isRunning)
            {
                renderGame();
            }

            fps++;

            if (System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + fps);
                fps = 0;
            }
        }

        stop();
    }

    private void tickGame()
    {
        handler.tickGame();
    }

    private void renderGame()
    {
        BufferStrategy buffer = this.getBufferStrategy();

        if (buffer == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics gfx = buffer.getDrawGraphics();

        gfx.setColor(Color.black);
        gfx.fillRect(0, 0, WIDTH, HEIGHT);

        handler.renderGame(gfx);
        gfx.dispose();
        buffer.show();
    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        isRunning = true;
        System.out.println("Running Game");
    }

    public synchronized void stop()
    {
        try
        {
            thread.join();
            isRunning = false;
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
