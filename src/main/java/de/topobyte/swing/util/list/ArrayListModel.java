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

/**
 * @param <T>
 *            the type of elements
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class ArrayListModel<T> extends AbstractListModel<T>
{

	private static final long serialVersionUID = -6068825149839399789L;

	private List<T> elements = new ArrayList<>();

	/**
	 * Default constructor
	 */
	public ArrayListModel()
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
		elements.add(index, element);
		fireIntervalAdded(this, index, index);
	}

	/**
	 * Add the given elements to the model
	 * 
	 * @param insElements
	 *            the elements to add.
	 * @param index
	 *            the index where to insert.
	 */
	public void addAll(Collection<? extends T> insElements, int index)
	{
		int i = index;
		for (T element : insElements) {
			elements.add(i++, element);
		}
		fireContentsChanged(this, 0, 0);
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

	@Override
	public int getSize()
	{
		return elements.size();
	}

	@Override
	public T getElementAt(int index)
	{
		return elements.get(index);
	}

}
