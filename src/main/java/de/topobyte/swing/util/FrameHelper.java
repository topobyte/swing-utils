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

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Utilities for working with {@link Frame}s.
 *
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class FrameHelper
{

	/**
	 * Show the specified component in a JFrame.
	 * 
	 * @param title
	 *            the title of the frame.
	 * @param component
	 *            the component to show.
	 * @param width
	 *            the width of the frame.
	 * @param height
	 *            the height of the frame.
	 * @param x
	 *            the x position on screen.
	 * @param y
	 *            the y position on screen.
	 * @param show
	 *            whether to show the frame.
	 * @return the created JFrame.
	 */
	public static JFrame showFrameWithComponent(String title,
			JComponent component, int width, int height, int x, int y,
			boolean show)
	{
		JFrame frame = new JFrame(title);
		frame.setSize(new Dimension(width, height));
		frame.setLocation(x, y);
		frame.setContentPane(component);
		if (show) {
			frame.setVisible(true);
		}
		return frame;
	}

}
