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

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A {@link JPanel} that contains a {@link JTextField} in a {@link BorderLayout}
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class JPanelTextField extends JPanel
{

	private static final long serialVersionUID = -6427281494288257975L;

	private JTextField textField;

	/**
	 * Creates an empty {@link JTextField} placed in the {@link JPanel} using
	 * the {@link BorderLayout#CENTER} constraint.
	 */
	public JPanelTextField()
	{
		this("");
	}

	/**
	 * Creates a {@link JTextField} with the specified text placed in the
	 * {@link JPanel} using the {@link BorderLayout#CENTER} constraint.
	 */
	public JPanelTextField(String text)
	{
		this("", BorderLayout.CENTER);
	}

	/**
	 * Creates a {@link JTextField} with the specified text placed in the
	 * {@link JPanel} using the specified constraint.
	 */
	public JPanelTextField(String text, String constraint)
	{
		setLayout(new BorderLayout());
		textField = new JTextField(text);
		add(textField, constraint);
	}

	public JTextField getTextField()
	{
		return textField;
	}

	public String getText()
	{
		return textField.getText();
	}

	public void setText(String text)
	{
		textField.setText(text);
	}

}
