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

/**
 * @param <T>
 *            the type of wrapped elements
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class DefaultElementWrapper<T> implements ElementWrapper<T>
{

	protected T element;

	public DefaultElementWrapper(T element)
	{
		this.element = element;
	}

	@Override
	public T getElement()
	{
		return element;
	}

	@Override
	public String toString()
	{
		return element.toString();
	}

	@Override
	public int hashCode()
	{
		return element.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		if (!getClass().getName().equals(o.getClass().getName())) {
			return false;
		}
		DefaultElementWrapper<T> other = (DefaultElementWrapper<T>) o;
		return element.equals(other.element);
	}

}
