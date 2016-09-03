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

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class ButtonPane extends JPanel
{

	private static final long serialVersionUID = -3827513568340197064L;

	private JPanel panel = new JPanel();

	/**
	 * Create a new ButtonPane
	 * 
	 * @param buttons
	 *            the buttons to display
	 */
	public ButtonPane(List<JButton> buttons)
	{
		add(panel);
		panel.setLayout(new GridLayout());
		for (JButton button : buttons) {
			panel.add(button);
		}
	}

}
