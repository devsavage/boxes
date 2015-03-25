package tv.savageboy74.boxes.handlers;

/*
 * GameHandler.java
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

import tv.savageboy74.boxes.game.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class GameHandler
{
    LinkedList<GameObject> gameObj = new LinkedList<GameObject>();

    public void tickGame()
    {
        for (int i = 0; i < gameObj.size(); i++)
        {
            GameObject object = gameObj.get(i);

            object.tickGame();
        }
    }

    public void renderGame(Graphics gfx)
    {
        for (int i = 0; i < gameObj.size(); i++)
        {
            GameObject object = gameObj.get(i);

            object.renderGame(gfx);
        }
    }

    public void addGameObject(GameObject object)
    {
        this.gameObj.add(object);
    }

    public void removeGameObject(GameObject object)
    {
        this.gameObj.remove(object);
    }
}
