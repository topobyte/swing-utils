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
import java.awt.datatransfer.Transferable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Transferable implementation used during transfers from the DndPanel.
 * 
 * @param <T>
 *            the type of objects.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public abstract class PanelTransferable<T> implements Transferable
{

	final static Logger logger = LoggerFactory
			.getLogger(PanelTransferable.class);

	T data;
	List<DataFlavor> flavorList;

	/**
	 * Override this to provide the transferable data object.
	 * 
	 * @param flavor
	 *            the flavor to get the representation of the denoted data
	 *            object of.
	 * @param t
	 *            the data to retrieve a representation for.
	 * @return the transferable instance.
	 */
	public abstract Object getTransferData(DataFlavor flavor, T t);

	/**
	 * Create an instance of the transferable.
	 * 
	 * @param data
	 *            the data to wrap.
	 * @param flavorList
	 *            the list of supported flavors.
	 */
	public PanelTransferable(T data, List<DataFlavor> flavorList)
	{
		this.data = data;
		this.flavorList = flavorList;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors()
	{
		logger.debug("getTransferDataFlavors()");
		return flavorList.toArray(new DataFlavor[0]);
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor)
	{
		for (DataFlavor accepted : flavorList) {
			if (flavor.equals(accepted)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object getTransferData(DataFlavor flavor)
	{
		for (DataFlavor accepted : flavorList) {
			if (flavor.equals(accepted)) {
				return getTransferData(flavor, data);
			}
		}
		return null;
	}

}
