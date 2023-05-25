package it.pagopa.pn.radd.bff.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@Setter
@ToString
public class DocumentPageable implements Pageable {
	private Integer limit;
	private String lastEvaluatedId;
	private String lastEvaluatedName;


	@Override
	public boolean isPage () {
		return StringUtils.hasText(lastEvaluatedId);
	}


	public boolean isPageByName () {
		return isPage() && StringUtils.hasText(lastEvaluatedName);
	}


	@Override
	public boolean hasLimit () {
		return limit != null && limit > 0;
	}
}
