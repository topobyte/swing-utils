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

package de.topobyte.swing.util.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.AbstractListModel;

import de.topobyte.swing.util.DefaultElementWrapper;
import de.topobyte.swing.util.ElementWrapper;

/**
 * @param <T>
 *            the type of elements
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public abstract class AbstractArrayListModel<T> extends
		AbstractListModel<ElementWrapper<T>>
{

	private static final long serialVersionUID = -6068825149839399789L;

	private List<ElementWrapperImpl> elements = new ArrayList<>();

	/**
	 * Get a String representation of the denoted element that should be shown
	 * within the list.
	 * 
	 * @param element
	 *            an element.
	 * @return the string to show within the list.
	 */
	public abstract String getValue(T element);

	/**
	 * Default constructor
	 */
	public AbstractArrayListModel()
	{
		// default constructor
	}

	/**
	 * Add the given element to the model.
	 * 
	 * @param element
	 *            the element to add.
	 * @param index
	 *            the index where to insert.
	 */
	public void add(T element, int index)
	{
		elements.add(index, new ElementWrapperImpl(element));
		fireIntervalAdded(this, index, index);
	}

	/**
	 * Remove the element at the denoted index from the model.
	 * 
	 * @param index
	 *            the index of the element to remove.
	 */
	public void remove(int index)
	{
		elements.remove(index);
		fireIntervalRemoved(this, index, index);
	}

	/**
	 * Add the given elements to the model
	 * 
	 * @param insElements
	 *            the elements to add.
	 * @param index
	 *            the index where to insert.
	 */
	public void addAll(Collection<T> insElements, int index)
	{
		int i = index;
		for (T element : insElements) {
			elements.add(i++, new ElementWrapperImpl(element));
		}
		fireContentsChanged(this, 0, 0);
	}

	@Override
	public int getSize()
	{
		return elements.size();
	}

	@Override
	public ElementWrapper<T> getElementAt(int index)
	{
		return elements.get(index);
	}

	/**
	 * Retrieve the real element (not the wrapper element retrieved with
	 * getElementAt) for the denoted position.
	 * 
	 * @param index
	 *            the position.
	 * @return the real element
	 */
	public T getRealElementAt(int index)
	{
		return getElementAt(index).getElement();
	}

	private class ElementWrapperImpl extends DefaultElementWrapper<T>
	{

		public ElementWrapperImpl(T element)
		{
			super(element);
		}

		@Override
		public String toString()
		{
			return getValue(element);
		}

	}

}
