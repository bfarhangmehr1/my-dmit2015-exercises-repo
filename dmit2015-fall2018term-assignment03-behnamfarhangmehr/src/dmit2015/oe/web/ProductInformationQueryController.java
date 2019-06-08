package dmit2015.oe.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dmit2015.oe.entity.ProductDescription;
import dmit2015.oe.entity.ProductInformation;
import dmit2015.oe.service.OrderEntryService;

@Named
@ViewScoped
public class ProductInformationQueryController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private OrderEntryService oeService;
	
	private Long queryProductId;											// +getter +setter
	private ProductInformation queryProductInformationSingleResult;			// +getter
	private String selectedLanguageId = "US";								// +getter +setter

	private String queryPattern;											// +getter +setter
	private List<ProductInformation> queryProductInformationResultList;		// +getter
	
	public Long getQueryProductId() {
		return queryProductId;
	}
	public void setQueryProductId(Long queryProductId) {
		this.queryProductId = queryProductId;
	}
	public String getSelectedLanguageId() {
		return selectedLanguageId;
	}

	public void setSelectedLanguageId(String selectedLanguageId) {
		this.selectedLanguageId = selectedLanguageId;
	}

	public ProductInformation getQueryProductInformationSingleResult() {
		return queryProductInformationSingleResult;
	}
	public String getQueryPattern() {
		return queryPattern;
	}
	public void setQueryPattern(String queryPattern) {
		this.queryPattern = queryPattern;
	}
	public List<ProductInformation> getQueryProductInformationResultList() {
		return queryProductInformationResultList;
	}
	
	
	public void findProduct() {
		try {
			queryProductInformationSingleResult = oeService.findOneProductInformation(queryProductId);
			if( queryProductInformationSingleResult == null) {
				Messages.addGlobalWarn("Unknown prodcutId \"{0}\". We found 0 results", queryProductId);
			} else {
				Messages.addGlobalInfo("We found 1 result.");
			}			
		} catch (Exception e) {
			Messages.addGlobalError("Unable to perform search.");
		}
		
		
	}
	
	public void findProduct(Long productId) {
		queryProductId = productId;
		findProduct();
	}
	
	public void findProductsByTerm() {
		try {
			queryProductInformationResultList = oeService.findAllProductInformationByPattern(queryPattern);
			if( queryProductInformationResultList == null) {
				Messages.addGlobalWarn("Unknown pattern \"{0}\". We found 0 results", queryPattern);
			} else {
				Messages.addGlobalInfo("We found 1 result.");
			}			
		} catch (Exception e) {
			Messages.addGlobalError("Unable to perform search.");
		}
		
	}
	
	public void changeLanguage() {
		if (queryProductInformationSingleResult != null) {
			queryProductInformationSingleResult.setProductName(oeService.findOneProductDescription(queryProductId, selectedLanguageId).getTranslatedName());
			queryProductInformationSingleResult.setProductDescription(oeService.findOneProductDescription(queryProductId, selectedLanguageId).getTranslatedDescription());
		}
	}
	
	public void cancel() {
		queryProductId = null;
		queryProductInformationSingleResult = null;
		queryProductInformationResultList = null;
		selectedLanguageId = "US";
	}
	
}
