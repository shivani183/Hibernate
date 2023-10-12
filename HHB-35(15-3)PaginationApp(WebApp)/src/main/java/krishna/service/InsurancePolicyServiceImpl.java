package krishna.service;

import java.util.ArrayList;

import java.util.List;

import krishna.dao.InsurancePolicyDao;
import krishna.dao.InsurancePolicyDaoImpl;
import krishna.dto.InsurancePolicyDTO;
import krishna.model.InsurancePolicy;

public class InsurancePolicyServiceImpl implements InsurancePolicyService {

	InsurancePolicyDao dao;

	public InsurancePolicyServiceImpl() {
		dao = new InsurancePolicyDaoImpl();
	}

	@Override
	public long fetchPagesCount(int pageSize) {
		Long totalRecords = dao.getTotalRecordsCount();
		Long pagesCount = totalRecords / pageSize; // => 8/3 = 2
		if (totalRecords % pageSize != 0)
			pagesCount++;
		return pagesCount;// pagesCount = 3
	}

	@Override
	public List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo) {
		
		int startPos = 0;
		startPos = (pageNo * pageSize) - pageSize;
		
		List<InsurancePolicyDTO> list = new ArrayList<InsurancePolicyDTO>();
		List<InsurancePolicy> entities = dao.getPageData(pageSize, startPos);

		entities.forEach(entity -> {
			InsurancePolicyDTO dto = new InsurancePolicyDTO();
			dto.setPolicyId(entity.getPolicyId());
			dto.setPolicyName(entity.getPolicyName());
			dto.setPolicyType(entity.getPolicyType());
			dto.setTenure(entity.getTenure());
			list.add(dto);
		});

		return list;
	}

}
