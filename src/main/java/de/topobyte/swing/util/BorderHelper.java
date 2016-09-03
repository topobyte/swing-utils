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

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

/**
 * Utilities for adding {@link Border}s to {@link JComponent}s.
 *
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class BorderHelper
{

	/**
	 * Add an empty border to the specified component by creating a
	 * {@link CompoundBorder} from the old border of the component and a new
	 * empty border.
	 * 
	 * @param c
	 *            the component to add a border to
	 * @param s
	 *            the size for all four directions
	 */
	public static void addEmptyBorder(JComponent c, int s)
	{
		addEmptyBorder(c, s, s, s, s);
	}

	/**
	 * Add an empty border to the specified component by creating a
	 * {@link CompoundBorder} from the old border of the component and a new
	 * empty border.
	 * 
	 * @param c
	 *            the component to add a border to
	 * @param top
	 *            the top size
	 * @param left
	 *            the left size
	 * @param bottom
	 *            the bottom size
	 * @param right
	 *            the right size
	 */
	public static void addEmptyBorder(JComponent c, int top, int left,
			int bottom, int right)
	{
		Border oldBorder = c.getBorder();
		Border newBorder = BorderFactory.createEmptyBorder(top, left, bottom,
				right);
		CompoundBorder compound = BorderFactory.createCompoundBorder(newBorder,
				oldBorder);
		c.setBorder(compound);
	}

}
