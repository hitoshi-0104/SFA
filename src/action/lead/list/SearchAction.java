package action.lead.list;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;

public class SearchAction extends ListAction {

	public SearchAction(HttpServletRequest request, HttpServletResponse response)
			throws SalesManagementSystemException {
		super(request, response);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	protected String handle() throws ServletException, IOException, SalesManagementApplicationException,
			SalesManagementSystemException, SalesManagementRuntimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
