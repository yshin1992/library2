package com.library.criteria;

import com.library.domain.Manager;

public class ManagerQueryCriteria extends
		AbstractPaginationQueryCriteria<Manager> {

	private static final long serialVersionUID = 2196966485820310136L;
	private Manager model;

	public ManagerQueryCriteria() {
    }
	
	public ManagerQueryCriteria(Manager model) {
		this.model = model;
	}

	@Override
	public Manager getModel() {
		return model;
	}

	@Override
	public void setModel(Manager model) {
		this.model = model;
	}

}
