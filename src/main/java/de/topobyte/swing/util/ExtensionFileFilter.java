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

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * A simple file filter implementation based on file extensions.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class ExtensionFileFilter extends FileFilter
{

	private final String extension;
	private final String info;

	/**
	 * Create an ExtensionFileFilter instance accepting files with the extension
	 * and information denoted.
	 * 
	 * @param extension
	 *            the extension to accept.
	 * @param info
	 *            the information to display, e.g. in dialogs.
	 */
	public ExtensionFileFilter(String extension, String info)
	{
		this.extension = extension;
		this.info = info;
	}

	@Override
	public boolean accept(File f)
	{
		if (f.isDirectory()) {
			return true;
		}
		return f.getName().endsWith("." + extension);
	}

	@Override
	public String getDescription()
	{
		return "(." + extension + ") " + info;
	}

	/**
	 * @return the extension accepted.
	 */
	public String getExtension()
	{
		return extension;
	}

	/**
	 * @return the information attached.
	 */
	public String getInfo()
	{
		return info;
	}

}