package krishna.dao;

import java.util.List;


import krishna.model.InsurancePolicy;

public interface InsurancePolicyDao {
	public List<InsurancePolicy> getPageData(int pageSize,int startPos);
	public Long getTotalRecordsCount();
}
