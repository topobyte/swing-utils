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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.TransferHandler.TransferSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.topobyte.swing.util.dnd.DestinationSourceTransferHandler;
import de.topobyte.swing.util.dnd.DestinationTransferHandler;
import de.topobyte.swing.util.dnd.SourceAwareTransferHandler;
import de.topobyte.swing.util.dnd.SourceTransferHandler;

/**
 * @param <T>
 *            the type of data to represent.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public abstract class DndPanel<T> extends JPanel implements DragGestureListener
{

	private static final long serialVersionUID = 735894929836107251L;

	final static Logger logger = LoggerFactory.getLogger(DndPanel.class);

	private T data;

	private boolean isSource;
	private boolean isDestination;

	/**
	 * Create a new DndPanel representing the denoted data.
	 * 
	 * @param data
	 *            the data to represent.
	 * @param isSource
	 *            whether this panel is a source for drags.
	 * @param isDestination
	 *            whether this panel is a destination for drags.
	 */
	public DndPanel(T data, boolean isSource, boolean isDestination)
	{
		this.isSource = isSource;
		this.isDestination = isDestination;
		setupDragndrop();

		this.data = data;
		setup(data);
		JComponent component = getComponent();

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 0, 0), 0, 0);

		add(component, c);
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge)
	{
		logger.debug("drag gesture");
		TransferHandler handler = this.getTransferHandler();
		handler.exportAsDrag(this, dge.getTriggerEvent(), TransferHandler.COPY);
	}

	private void setupDragndrop()
	{
		SourceTransferhandler sourceHandler = new SourceTransferhandler();
		DestinationTransferhandler destHandler = new DestinationTransferhandler();
		DestinationSourceTransferHandler transferHandler = new DestinationSourceTransferHandler();

		transferHandler.setSourceHandler(sourceHandler);
		transferHandler.setDestinationHandler(destHandler);
		setTransferHandler(transferHandler);

		DragSource dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(this,
				TransferHandler.COPY, this);
	}

	class DestinationTransferhandler implements DestinationTransferHandler
	{

		@Override
		public boolean canImport(TransferSupport ts)
		{
			if (!isDestination()) {
				return false;
			}
			DataFlavor[] flavors = ts.getDataFlavors();
			List<DataFlavor> supportedFlavors = getSupportedFlavors();
			for (DataFlavor flavor : flavors) {
				if (supportedFlavors.contains(flavor)) {
					return true;
				}
			}
			return false;
		}

		@Override
		public boolean importData(TransferSupport ts)
		{
			if (!isDestination()) {
				return false;
			}
			return DndPanel.this.importData(ts);
		}

	}

	class SourceTransferhandler extends SourceAwareTransferHandler implements
			SourceTransferHandler
	{

		private static final long serialVersionUID = 1320181642257143993L;

		@Override
		public int getSourceActions(JComponent c)
		{
			if (!isSource()) {
				return NONE;
			}
			return COPY;
		}

		@Override
		public Transferable createTransferable(JComponent c)
		{
			if (!isSource()) {
				return null;
			}
			super.createTransferable(c);
			logger.debug("createTransferable");
			PanelTransferable<T> transferable = new PanelTransferable<T>(
					getData(), getSupportedFlavors()) {

				@Override
				public Object getTransferData(DataFlavor flavor, T t)
				{
					return DndPanel.this.getTransferData(flavor, t);
				}

			};

			return transferable;
		}

		@Override
		public void exportDone(JComponent c, Transferable t, int action)
		{
			if (!isSource()) {
				return;
			}
			super.exportDone(c, t, action);
		}
	}

	/**
	 * Setup the panel to represent the denoted geometryIndex.
	 * 
	 * @param data
	 *            the data to represent.
	 */
	public abstract void setup(T data);

	/**
	 * @return the geometryIndex this panel represents.
	 */
	public T getData()
	{
		return data;
	}

	/**
	 * Set the data to represent.
	 * 
	 * @param data
	 *            the data to represent.
	 */
	public void setData(T data)
	{
		this.data = data;
	}

	/**
	 * Find out whether this panel is a drag destination.
	 * 
	 * @return whether this panel is a drag destination.
	 */
	public boolean isDestination()
	{
		return isDestination;
	}

	/**
	 * Find out whether this panel is a drag source.
	 * 
	 * @return whether this panel is a drag source.
	 */
	public boolean isSource()
	{
		return isSource;
	}

	/**
	 * Override this method to provide the list of supported DataFlavors. The
	 * order within this list is important and represents the priority of the
	 * DataFlavors. Lower indices get used first.
	 * 
	 * @return the list of supported DataFlavors.
	 */
	public abstract List<DataFlavor> getSupportedFlavors();

	/**
	 * Override this method to provide the TransferData for the represented
	 * instance.
	 * 
	 * @param flavor
	 *            the flavor to retrieve a TransferData instance for.
	 * @param t
	 *            the data to retrieve a representation for.
	 * @return transferable object.
	 */
	public abstract Object getTransferData(DataFlavor flavor, T t);

	/**
	 * Override this method to handle the import of data.
	 * 
	 * @param ts
	 *            the TransferSupport involved.
	 * @return whether the transfer succeeded.
	 */
	public abstract boolean importData(TransferSupport ts);

	/**
	 * Override this method to provide a component to visualize the data
	 * represented.
	 * 
	 * @return the component displayed within this panel.
	 */
	public abstract JComponent getComponent();

}
