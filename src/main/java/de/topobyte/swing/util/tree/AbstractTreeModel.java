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

package de.topobyte.swing.util.tree;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;

/**
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public abstract class AbstractTreeModel implements TreeModel
{

	private TreeModelListenerList listeners = new TreeModelListenerList();

	@Override
	public void addTreeModelListener(TreeModelListener l)
	{
		listeners.addTreeModelListener(l);
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l)
	{
		listeners.removeTreeModelListener(l);
	}

	/**
	 * For each registered listener, call the method treeStructureChanged with
	 * the denoted event.
	 * 
	 * @param event
	 *            the event to deliver.
	 */
	public void triggerTreeStructureChanged(TreeModelEvent event)
	{
		listeners.triggerTreeStructureChanged(event);
	}

	/**
	 * For each registered listener, call the method treeNodesChanged with the
	 * denoted event.
	 * 
	 * @param event
	 *            the event to deliver.
	 */
	public void triggerTreeNodesChanged(TreeModelEvent event)
	{
		listeners.triggerTreeNodesChanged(event);
	}

	/**
	 * For each registered listener, call the method treeNodesInserted with the
	 * denoted event.
	 * 
	 * @param event
	 *            the event to deliver.
	 */
	public void triggerTreeNodesInserted(TreeModelEvent event)
	{
		listeners.triggerTreeNodesInserted(event);
	}

	/**
	 * For each registered listener, call the method treeNodesRemoved with the
	 * denoted event.
	 * 
	 * @param event
	 *            the event to deliver.
	 */
	public void triggerTreeNodesRemoved(TreeModelEvent event)
	{
		listeners.triggerTreeNodesRemoved(event);
	}

}
