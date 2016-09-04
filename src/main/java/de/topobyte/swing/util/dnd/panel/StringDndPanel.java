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

package de.topobyte.swing.util.dnd.panel;

import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * @param <T>
 *            the type of objects to represent.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public abstract class StringDndPanel<T> extends DndPanel<T>
{

	private static final long serialVersionUID = -3746515359425504010L;

	private JLabel label;

	/**
	 * @param data
	 *            the data to represent initially.
	 * @param isSource
	 *            whether this panel can be used as a source for dragging.
	 * @param isDestination
	 *            whether this panel can be used as a destination for dragging.
	 */
	public StringDndPanel(T data, boolean isSource, boolean isDestination)
	{
		super(data, isSource, isDestination);
	}

	@Override
	public JComponent getComponent()
	{
		return label;
	}

	@Override
	public void setup(T data)
	{
		setData(data);
		if (label == null) {
			label = new JLabel();
		}
		label.setText(getLabelString(data));
	}

	/**
	 * Implement this to decide about the information displayed by the label.
	 * 
	 * @param t
	 *            the data to represent.
	 * @return the String to represent the denoted data.
	 */
	public abstract String getLabelString(T t);

}
