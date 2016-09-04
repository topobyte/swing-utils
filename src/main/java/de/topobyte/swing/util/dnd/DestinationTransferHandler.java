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

package de.topobyte.swing.util.dnd;

import javax.swing.TransferHandler.TransferSupport;

/**
 * An interface that should be implemented to design a destination for drag
 * operations.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public interface DestinationTransferHandler
{

	/**
	 * Method from TransferHandler
	 * 
	 * @param ts
	 *            the TransferSupport this drag is about.
	 * @return whether an import is possible.
	 */
	public boolean canImport(TransferSupport ts);

	/**
	 * Method from TransferHandler
	 * 
	 * @param ts
	 *            the TransferSupport this drag is about.
	 * @return whether the data has been successfully imported.
	 */
	public boolean importData(TransferSupport ts);

}
