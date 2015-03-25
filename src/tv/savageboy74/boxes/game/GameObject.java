package tv.savageboy74.boxes.game;

/*
 * GameObject.java
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

import java.awt.*;

public abstract class GameObject
{
    protected int x;
    protected int y;
    protected int velX;
    protected int velY;

    protected ObjectId id;

    public GameObject(int x, int y, ObjectId id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tickGame();
    public abstract void renderGame(Graphics gfx);

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setId(ObjectId id)
    {
        this.id = id;
    }

    public void setVelocityX(int velocityX)
    {
        this.velX = velocityX;
    }

    public void setVelocityY(int velocityY)
    {
        this.velY = velocityY;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public ObjectId getId()
    {
        return id;
    }

    public int getVelocityX()
    {
        return velX;
    }

    public int getVelocityY()
    {
        return velY;
    }

}

