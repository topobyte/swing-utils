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

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A {@link JPanel} that contains a single {@link Component} in a
 * {@link BorderLayout}. This is generally useful for settings borders on
 * components such as {@link JTextField}s or {@link JButton}s. Without a
 * surrounding panel, setting a border will not work properly. While wrapping
 * components inside panels is easy, it does require some boilerplate code. This
 * class exists to reduce additional code to a minimum.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class ComponentPanel<T extends Component> extends JPanel
{

	private static final long serialVersionUID = -4783027097378277287L;

	private T component;

	public ComponentPanel(T component)
	{
		super(new BorderLayout());
		this.component = component;
		add(component, BorderLayout.CENTER);
	}

	public T getComponent()
	{
		return component;
	}

	@Override
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		component.setEnabled(enabled);
	}

}
