// Copyright 2014 Sebastian Kuerten
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

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 * A combo box that displays a list of values using a corresponding list of
 * names.
 *
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class KeyValueComboBox<K, V> extends
		JComboBox<KeyValueComboBox.Data<K, V>>
{

	private static final long serialVersionUID = -1L;

	public KeyValueComboBox(K[] names, V[] values, Integer selectedValue)
	{
		super(buildValues(names, values));

		setRenderer(new Renderer());
		setEditable(false);

		setSelectedIndex(-1);
		for (int i = 0; i < values.length; i++) {
			if (values[i] == selectedValue) {
				setSelectedIndex(i);
				break;
			}
		}
	}

	public void setMinPreferredWidth(int minWidth)
	{
		Dimension ps = getPreferredSize();
		if (ps.width < minWidth) {
			setPreferredSize(new Dimension(minWidth, ps.height));
		}
	}

	private static <K, V> Data<K, V>[] buildValues(K[] names, V[] values)
	{
		Data<K, V>[] data = new Data[names.length];
		for (int i = 0; i < names.length; i++) {
			data[i] = new Data<>(names[i], values[i]);
		}
		return data;
	}

	private class Renderer extends BasicComboBoxRenderer
	{
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus)
		{
			super.getListCellRendererComponent(list, value, index, isSelected,
					cellHasFocus);

			if (value != null) {
				Data<K, V> item = (Data<K, V>) value;
				setText(item.name.toString());
			} else {
				setText("default");
			}

			return this;
		}
	}

	public V getSelectedValue()
	{
		int index = getSelectedIndex();
		if (index < 0) {
			return null;
		}
		Data<K, V> data = getItemAt(index);
		if (data == null) {
			return null;
		}
		return data.value;
	}

	public static class Data<K, V>
	{
		K name;
		V value;

		public Data(K name, V value)
		{
			this.name = name;
			this.value = value;
		}

		public K getName()
		{
			return name;
		}

		public V getValue()
		{
			return value;
		}

	}

}
