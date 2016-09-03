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

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

/**
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class SelectFolderWidget extends JPanel
{

	private static final long serialVersionUID = 4065990233323219436L;

	private JTextField inputLocation;

	public SelectFolderWidget(File location)
	{
		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		inputLocation = new JTextField();
		inputLocation.setText(location.getAbsolutePath());
		JButton buttonPickLocation = new JButton("select");

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		add(inputLocation, c);
		c.weightx = 0.0;
		add(buttonPickLocation, c);

		buttonPickLocation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				pickFolder();
			}
		});
	}

	@Override
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		for (Component c : getComponents()) {
			c.setEnabled(enabled);
		}
	}

	public File getSelectedFolder()
	{
		return new File(inputLocation.getText());
	}

	protected void pickFolder()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription()
			{
				return "directories";
			}

			@Override
			public boolean accept(File f)
			{
				return f.isDirectory();
			}
		});
		int ret = chooser.showOpenDialog(this);
		if (ret != JFileChooser.APPROVE_OPTION) {
			return;
		}
		File file = chooser.getSelectedFile();
		inputLocation.setText(file.getAbsolutePath());
	}

}
