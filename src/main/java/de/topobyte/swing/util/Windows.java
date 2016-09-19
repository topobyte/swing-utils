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

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.RootPaneContainer;

/**
 * Helper methods for {@link Window}s.
 *
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class Windows
{

	/**
	 * Adds an action to a window's root pane that closes the window when the
	 * user presses the escape key.
	 * 
	 * @param window
	 *            the window to use.
	 */
	public static <T extends Window & RootPaneContainer> void setCloseOnEscape(
			final T window)
	{
		JRootPane root = window.getRootPane();

		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escape");

		root.getActionMap().put("escape", new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent event)
			{
				window.dispatchEvent(new WindowEvent(window,
						WindowEvent.WINDOW_CLOSING));
			}

		});
	}

}
