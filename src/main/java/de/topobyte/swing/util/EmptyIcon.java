// Copyright 2016 Sebastian Kuerten
//
// This file is part of swing-utils.
//
// swing-utils is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// swing-utils is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with swing-utils. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.swing.util;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class EmptyIcon implements Icon
{

	private int width;
	private int height;

	public EmptyIcon(int size)
	{
		this(size, size);
	}

	public EmptyIcon(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	@Override
	public int getIconWidth()
	{
		return width;
	}

	@Override
	public int getIconHeight()
	{
		return height;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		// do nothing
	}

}