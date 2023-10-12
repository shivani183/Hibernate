package krishna.service;

import java.util.List;


import krishna.dto.InsurancePolicyDTO;

public interface InsurancePolicyService {
	public long fetchPagesCount(int pageSize);

	public List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo);

}
