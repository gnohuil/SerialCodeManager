package util;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8531586026935392480L;
	
	private int currentPage;
	private int totalPage;
	private long totalRecords;
	private int maxResults = 10;
	private int firstResult;

	private List results;

	public Page(){
		
	}
	public Page(Integer currentPage, Integer maxResults) {
		this.currentPage = currentPage;
		this.maxResults = maxResults;
	}

	public Page(Integer count, Integer currentPage, long total) {
		this.maxResults = count;
		this.currentPage = currentPage;
		this.totalRecords = total;
		this.totalPage = (int)(totalRecords + maxResults - 1) / maxResults;
	}

	public Page(Integer count, Integer currentPage, long total,List results) {
		this.maxResults = count;
		this.currentPage = currentPage;
		this.totalRecords = total;
		this.results = results;
	}
	
	public boolean hasNextPage() {
		if (totalPage - 1 > currentPage) {
			return true;
		} else {
			return false;
		}
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if (currentPage >= 0) {
			this.currentPage = currentPage;
		}
	}

	public long getTotalPage() {
		// this.totalPage = (totalRecords + maxResults - 1) / maxResults;
		return totalPage;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		if (0 < maxResults && maxResults <= 80) {
			this.maxResults = maxResults;
		}
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
		this.totalPage = (totalRecords + maxResults - 1) / maxResults;
	}

	public int getFirstResult() {
		if (currentPage > 0) {
			firstResult = (int) currentPage * maxResults;
		}
		return firstResult;
	}

	public List getResults() {
		return results;
	}

	public void setResults(List results) {
		this.results = results;
	}
}
