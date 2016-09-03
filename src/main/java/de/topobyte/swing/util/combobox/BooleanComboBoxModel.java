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

package de.topobyte.swing.util.combobox;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * A combo box model for combo boxes that allow the user to select true or
 * false.
 *
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class BooleanComboBoxModel extends AbstractListModel<Boolean> implements
		ComboBoxModel<Boolean>
{

	private static final long serialVersionUID = 1380002002136339388L;

	private boolean selected = false;

	/**
	 * Create a new combo box model for boolean values.
	 * 
	 * @param selected
	 *            which item is selected at beginning
	 */
	public BooleanComboBoxModel(boolean selected)
	{
		this.selected = selected;
	}

	@Override
	public int getSize()
	{
		return 2;
	}

	@Override
	public Boolean getElementAt(int index)
	{
		return index == 0;
	}

	@Override
	public void setSelectedItem(Object anItem)
	{
		if (anItem instanceof Boolean) {
			boolean s = (Boolean) anItem;
			selected = s;
		}
	}

	@Override
	public Object getSelectedItem()
	{
		return selected;
	}

}
