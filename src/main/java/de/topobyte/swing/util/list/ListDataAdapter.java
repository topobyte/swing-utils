// Copyright 2018 Sebastian Kuerten
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

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * A convenience adapter that delegates all three different event of a
 * ListDataListener to a single update method. It allows implementing a
 * ListDataListener by implementing a single method.
 *
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public abstract class ListDataAdapter implements ListDataListener
{

	/**
	 * A general event that will be triggered by any of the ListDataListener's
	 * events.
	 * 
	 * @param e
	 *            the event that occurred.
	 */
	public abstract void update(ListDataEvent e);

	@Override
	public void intervalAdded(ListDataEvent e)
	{
		update(e);
	}

	@Override
	public void intervalRemoved(ListDataEvent e)
	{
		update(e);
	}

	@Override
	public void contentsChanged(ListDataEvent e)
	{
		update(e);
	}

}