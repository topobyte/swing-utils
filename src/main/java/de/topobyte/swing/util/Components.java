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
import java.awt.Container;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Helper methods for {@link Component}s.
 *
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class Components
{

	/**
	 * Get the containing {@link Window} of the given component.
	 * 
	 * @param component
	 *            the component to find the frame for
	 * @return the containing dialog
	 */
	public static Window getContainingWindow(Component component)
	{
		Container parent = component.getParent();
		while (!(parent == null || parent instanceof Window)) {
			parent = parent.getParent();
		}
		return (Window) parent;
	}

	/**
	 * Get the containing {@link JFrame} of the given component.
	 * 
	 * @param component
	 *            the component to find the frame for
	 * @return the containing frame
	 */
	public static JFrame getContainingFrame(Component component)
	{
		Container parent = component.getParent();
		while (!(parent == null || parent instanceof JFrame)) {
			parent = parent.getParent();
		}
		return (JFrame) parent;
	}

	/**
	 * Get the containing {@link JDialog} of the given component.
	 * 
	 * @param component
	 *            the component to find the frame for
	 * @return the containing dialog
	 */
	public static JDialog getContainingDialog(Component component)
	{
		Container parent = component.getParent();
		while (!(parent == null || parent instanceof JDialog)) {
			parent = parent.getParent();
		}
		return (JDialog) parent;
	}

}
