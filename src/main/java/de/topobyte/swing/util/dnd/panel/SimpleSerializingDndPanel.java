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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @param <T>
 *            the type of objects to represent.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public abstract class SimpleSerializingDndPanel<T> extends SimpleDndPanel<T>
{

	private static final long serialVersionUID = -7876181099458735610L;

	/**
	 * Create an instance of a simple DndPanel that transports data via JDK
	 * serialization.
	 * 
	 * @param flavor
	 *            the data flavor to use.
	 * @param data
	 *            the data to represent initially.
	 * @param isSource
	 *            whether this panel can be used as a source for dragging.
	 * @param isDestination
	 *            whether this panel can be used as a destination for dragging.
	 */
	public SimpleSerializingDndPanel(DataFlavor flavor, T data,
			boolean isSource, boolean isDestination)
	{
		super(flavor, data, isSource, isDestination);
	}

	@Override
	public Object getTransferData(T t)
	{
		logger.debug("returning serialized flavor");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(t);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] bytes = baos.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		return bais;
	}

	@Override
	public boolean importData(Object transferData)
	{
		try {
			InputStream is = (InputStream) transferData;
			ObjectInputStream ois = new ObjectInputStream(is);
			T data = (T) ois.readObject();
			setup(data);
			return true;
		} catch (IOException e) {
			logger.debug("unable to get transfer data: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.debug("unable to read from object input stream: "
					+ e.getMessage());
		}
		return false;
	}

}
