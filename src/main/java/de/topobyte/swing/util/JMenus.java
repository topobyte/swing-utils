// Copyright 2017 Sebastian Kuerten
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

import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class JMenus
{

	public static void addItem(JMenu menu, Action action)
	{
		menu.add(new JMenuItem(action));
	}

	public static void addItem(JMenu menu, Action action, KeyStroke keyStroke)
	{
		JMenuItem item = new JMenuItem(action);
		item.setAccelerator(keyStroke);
		menu.add(item);
	}

	public static void addItem(JMenu menu, Action action, int modifiers,
			int keyCode)
	{
		KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, modifiers);
		addItem(menu, action, keyStroke);
	}

	public static void addCheckbox(JMenu menu, Action action)
	{
		menu.add(new JCheckBoxMenuItem(action));
	}

	public static void addCheckbox(JMenu menu, Action action,
			KeyStroke keyStroke)
	{
		JCheckBoxMenuItem item = new JCheckBoxMenuItem(action);
		item.setAccelerator(keyStroke);
		menu.add(item);
	}

	public static void addCheckbox(JMenu menu, Action action, int keyCode)
	{
		KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, 0);
		addCheckbox(menu, action, keyStroke);
	}

	public static void addCheckbox(JMenu menu, Action action, int modifiers,
			int keyCode)
	{
		KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, modifiers);
		addCheckbox(menu, action, keyStroke);
	}

}
