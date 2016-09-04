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

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.TransferHandler.TransferSupport;

/**
 * @param <T>
 *            the type of represented data.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public abstract class SimpleDndPanel<T> extends StringDndPanel<T>
{

	private static final long serialVersionUID = -5651983538515318609L;

	private final DataFlavor flavor;

	/**
	 * Create an instance of the simple DndPanel that only supports a single
	 * data flavor.
	 * 
	 * @param flavor
	 *            the flavor to support.
	 * @param data
	 *            the data to show initially.
	 * @param isSource
	 *            whether this panel can be used as a source for dragging.
	 * @param isDestination
	 *            whether this panel can be used as a destination for dragging.
	 */
	public SimpleDndPanel(DataFlavor flavor, T data, boolean isSource,
			boolean isDestination)
	{
		super(data, isSource, isDestination);
		this.flavor = flavor;
	}

	@Override
	public List<DataFlavor> getSupportedFlavors()
	{
		ArrayList<DataFlavor> flavors = new ArrayList<>();
		flavors.add(flavor);
		return flavors;
	}

	@Override
	public Object getTransferData(DataFlavor requestedFlavor, T t)
	{
		if (flavor.equals(requestedFlavor)) {
			return getTransferData(t);
		}
		return null;
	}

	@Override
	public boolean importData(TransferSupport ts)
	{
		for (DataFlavor f : ts.getDataFlavors()) {
			if (!f.equals(flavor)) {
				continue;
			}
			try {
				Object transferData = ts.getTransferable().getTransferData(
						flavor);
				return importData(transferData);
			} catch (UnsupportedFlavorException e) {
				logger.debug("flavor not supported though it should be");
			} catch (IOException e) {
				logger.debug("IOException while fetching transfer data: "
						+ e.getMessage());
			}
		}
		return false;
	}

	/**
	 * Override this to provide the transferable data for the denoted instance.
	 * 
	 * @param t
	 *            the instance to retrieve a representation for.
	 * @return the transferable object.
	 */
	public abstract Object getTransferData(T t);

	/**
	 * Override this to handle importing data.
	 * 
	 * @param transferData
	 *            the data to import.
	 * @return whether the import succeeded.
	 */
	public abstract boolean importData(Object transferData);

}
