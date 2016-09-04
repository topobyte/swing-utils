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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Subclasses have to delegate calls of createTransferable and exportDone to
 * these methods to ensure that isDragWithinSameComponent can work properly.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class SourceAwareTransferHandler extends TransferHandler
{

	private static final long serialVersionUID = -8338665701896075432L;

	final static Logger logger = LoggerFactory
			.getLogger(SourceAwareTransferHandler.class);

	private JComponent source;

	@Override
	public Transferable createTransferable(JComponent c)
	{
		logger.debug("createTransferable");
		this.source = c;
		return null;
	}

	@Override
	public void exportDone(JComponent c, Transferable t, int action)
	{
		this.source = null;
	}

	/**
	 * @return whether the drag is currently within a single component.
	 */
	public boolean isDragWithinSameComponent()
	{
		return source != null;
	}

}
