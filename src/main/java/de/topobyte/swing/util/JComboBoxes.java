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

import javax.swing.JComboBox;

/**
 * Helper methods for {@link JComboBox}es.
 *
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class JComboBoxes
{

	/**
	 * Method to get the selected item of a {@link JComboBox} without casting.
	 * 
	 * @param comboBox
	 *            the combo box to get the selected item from.
	 * @return the selected element.
	 */
	public static <E> E getSelectedItem(JComboBox<E> comboBox)
	{
		int index = comboBox.getSelectedIndex();
		return comboBox.getItemAt(index);
	}

}
