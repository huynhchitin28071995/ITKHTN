package controllers;

public class PaginationHelper {

	public static int computeStart(String pageFromRequest, int numOfProductsPerPage) {
		int page;
		if (pageFromRequest != null) {
			page = Integer.parseInt(pageFromRequest);
		} else {
			page = 1;
		}
		return (page - 1) * numOfProductsPerPage;
	}

}
