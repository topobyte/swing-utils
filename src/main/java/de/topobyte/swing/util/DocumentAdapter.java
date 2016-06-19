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

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * A convenience adapter that delegates all three different event of a
 * DocumentListener to a single update method. It allows implementing a
 * DocumentListener by implementing a single method.
 *
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public abstract class DocumentAdapter implements DocumentListener
{

	/**
	 * A general event that will be triggered by any of the DocumentListener's
	 * events.
	 * 
	 * @param e
	 *            the event that occurred.
	 */
	public abstract void update(DocumentEvent e);

	@Override
	public void changedUpdate(DocumentEvent e)
	{
		update(e);
	}

	@Override
	public void insertUpdate(DocumentEvent e)
	{
		update(e);
	}

	@Override
	public void removeUpdate(DocumentEvent e)
	{
		update(e);
	}

}