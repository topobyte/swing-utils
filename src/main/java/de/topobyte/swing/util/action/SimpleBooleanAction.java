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

package de.topobyte.swing.util.action;

import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.Icon;

/**
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public abstract class SimpleBooleanAction extends SimpleAction
{

	private static final long serialVersionUID = 7648212308884524179L;

	/**
	 * @return whether this action is enabled.
	 */
	public abstract boolean getState();

	/**
	 * implement what happens when the state is toggled.
	 */
	public abstract void toggleState();

	/**
	 * Create a SimpleBooleanAction that provides name and description
	 * 
	 * @param name
	 *            the name of the action
	 * @param description
	 *            the short description of the action
	 */
	public SimpleBooleanAction(String name, String description)
	{
		super(name, description);
	}

	/**
	 * Create a SimpleBooleanAction that provides name, description and an icon
	 * 
	 * @param name
	 *            the name of the action
	 * @param description
	 *            the short description of the action
	 * @param icon
	 *            the icon used in menus
	 */
	public SimpleBooleanAction(String name, String description, Icon icon)
	{
		super(name, description, icon);
	}

	/**
	 * Create a SimpleBooleanAction that provides name, description and an icon
	 * 
	 * @param name
	 *            the name of the action
	 * @param description
	 *            the short description of the action
	 * @param resourceIcon
	 *            a resource to decode the icon used in menus from
	 */
	public SimpleBooleanAction(String name, String description,
			String resourceIcon)
	{
		super(name, description, resourceIcon);
	}

	@Override
	public Object getValue(String key)
	{
		if (key.equals(Action.SELECTED_KEY)) {
			return getState();
		}
		return super.getValue(key);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		toggleState();
		firePropertyChange(Action.SELECTED_KEY, null, null);
	}

}
