/**
 * HasQuestionOperation.java
 *
 * Version information :
 *
 * Date:Mar 1, 2012
 *
 * Copyright notice :
 * 本文件及其附带的相关文件包含机密信息，仅限瀚特盛科技有限公司指定的，与本项目有关的内部人员和客户联络人员查阅和使用。 
 * 如果您不是本保密声明中指定的收件者，请立即销毁本文件，禁止对本文件或根据本文件中的内容采取任何其他行动， 
 * 包括但不限于：泄露本文件中的信息、以任何方式制作本文件全部或部分内容之副本、将本文件或其相关副本提供给任何其他人。
 */
package net.heartsome.cat.ts.ui.xliffeditor.nattable.undoable;

import java.util.List;
import java.util.Map;

import net.heartsome.cat.ts.core.file.XLFHandler;
import net.sourceforge.nattable.NatTable;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * @author  Jason
 * @version 
 * @since   JDK1.6
 */
public class NeedsReviewOperation extends AbstractOperation {
	
	private List<String> rowIdList;

	private NatTable table;

	private XLFHandler handler;

	private String state;

	private Map<String, String> oldState;
	
	public NeedsReviewOperation(String label, NatTable natTable, List<String> rowIdList, XLFHandler handler, String state) {
		super(label);
		IUndoContext context = (IUndoContext) natTable.getData(IUndoContext.class.getName());
		addContext(context);
		this.table = natTable;
		this.rowIdList = rowIdList;
		this.handler = handler;
		this.state = state;
		this.oldState = handler.getTuPropValue(rowIdList, "hs:needs-review");
	}

	@Override
	public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (rowIdList != null && rowIdList.size() > 0) {
			if("yes".equals(state)){
				handler.changeTuPropValue(rowIdList, "hs:needs-review", state);				
			}else{
				handler.deleteTuProp(rowIdList, "hs:needs-review");
			}
			table.redraw();
		}
		return Status.OK_STATUS;
	}

	@Override
	public IStatus redo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		return execute(monitor, info);
	}

	@Override
	public IStatus undo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (oldState != null && oldState.size() > 0) {
			handler.changeTuPropValue(oldState, "hs:needs-review");
			table.redraw();
		}
		return Status.OK_STATUS;
	}

}
