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
import javax.swing.TransferHandler;

/**
 * A class that combines a drag source and a drag destination to a fully
 * functional TransferHandler.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class DestinationSourceTransferHandler extends TransferHandler
{

	private static final long serialVersionUID = -7375752251790523942L;

	private DestinationTransferHandler destHandler;
	private SourceTransferHandler sourceHandler;

	/**
	 * The instance to use as a drag destination.
	 * 
	 * @param destHandler
	 *            the destination handler.
	 */
	public void setDestinationHandler(DestinationTransferHandler destHandler)
	{
		this.destHandler = destHandler;
	}

	/**
	 * The instance to use as a drag source.
	 * 
	 * @param sourceHandler
	 *            the source handler.
	 */
	public void setSourceHandler(SourceTransferHandler sourceHandler)
	{
		this.sourceHandler = sourceHandler;
	}

	@Override
	public boolean canImport(TransferSupport ts)
	{
		return destHandler.canImport(ts);
	}

	@Override
	public boolean importData(TransferSupport ts)
	{
		return destHandler.importData(ts);
	}

	@Override
	public int getSourceActions(JComponent c)
	{
		return sourceHandler.getSourceActions(c);
	}

	@Override
	public Transferable createTransferable(JComponent c)
	{
		return sourceHandler.createTransferable(c);
	}

	@Override
	public void exportDone(JComponent c, Transferable t, int action)
	{
		sourceHandler.exportDone(c, t, action);
	}

}
