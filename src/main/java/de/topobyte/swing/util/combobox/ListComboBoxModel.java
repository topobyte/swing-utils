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

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import de.topobyte.swing.util.DefaultElementWrapper;
import de.topobyte.swing.util.ElementWrapper;

/**
 * @param <T>
 *            the type of elements in the list.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public abstract class ListComboBoxModel<T> implements
		ComboBoxModel<ElementWrapper<T>>
{

	private final List<ElementWrapperImpl> list;
	private int selectedIndex = 0;

	/**
	 * This method defines the appearance of the elements.
	 * 
	 * @param element
	 *            the element displayed
	 * @return the string representing the element.
	 */
	public abstract String toString(T element);

	/**
	 * Create a new ComboBoxModel backed by the given list of items.
	 * 
	 * @param list
	 *            the list that backs this model.
	 */
	public ListComboBoxModel(List<T> list)
	{
		this.list = new ArrayList<>();
		for (T element : list) {
			ElementWrapperImpl wrapper = new ElementWrapperImpl(element);
			this.list.add(wrapper);
		}
	}

	@Override
	public int getSize()
	{
		return list.size();
	}

	@Override
	public ElementWrapper<T> getElementAt(int index)
	{
		return list.get(index);
	}

	private List<ListDataListener> listeners = new ArrayList<>();

	@Override
	public void addListDataListener(ListDataListener l)
	{
		listeners.add(l);
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
		listeners.remove(l);
	}

	@Override
	public void setSelectedItem(Object anItem)
	{
		for (int i = 0; i < list.size(); i++) {
			ElementWrapperImpl wrapper = list.get(i);
			if (wrapper.equals(anItem)) {
				selectedIndex = i;
				break;
			}
		}
	}

	@Override
	public Object getSelectedItem()
	{
		return list.get(selectedIndex);
	}

	/**
	 * @return the currently selected element
	 */
	public T getSelectedElement()
	{
		return list.get(selectedIndex).getElement();
	}

	private class ElementWrapperImpl extends DefaultElementWrapper<T>
	{

		ElementWrapperImpl(T element)
		{
			super(element);
		}

		@Override
		public String toString()
		{
			return ListComboBoxModel.this.toString(element);
		}

	}

}
