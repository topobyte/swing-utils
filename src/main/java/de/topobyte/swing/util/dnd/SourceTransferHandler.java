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

import java.awt.datatransfer.Transferable;

import javax.swing.JComponent;

/**
 * An interface that should be implemented to design a source for drag
 * operations.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public interface SourceTransferHandler
{

	/**
	 * Method from TransferHandler
	 * 
	 * @param c
	 *            the source component
	 * @return the actions available for this component.
	 */
	public int getSourceActions(JComponent c);

	/**
	 * Method from TransferHandler
	 * 
	 * @param c
	 *            the component to create a transferable for.
	 * @return the Transferable instance.
	 */
	public Transferable createTransferable(JComponent c);

	/**
	 * Method from TransferHandler
	 * 
	 * @param c
	 *            the source component.
	 * @param t
	 *            the Transferable instance.
	 * @param action
	 *            the action undertaken.
	 */
	public void exportDone(JComponent c, Transferable t, int action);

}
