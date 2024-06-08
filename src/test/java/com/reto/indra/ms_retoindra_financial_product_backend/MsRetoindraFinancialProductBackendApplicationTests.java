package com.reto.indra.ms_retoindra_financial_product_backend;

import com.reto.indra.ms_retoindra_financial_product_backend.controller.FinancialProductController;
import com.reto.indra.ms_retoindra_financial_product_backend.model.CheckingAccount;
import com.reto.indra.ms_retoindra_financial_product_backend.model.CreditCard;
import com.reto.indra.ms_retoindra_financial_product_backend.model.FinancialProduct;
import com.reto.indra.ms_retoindra_financial_product_backend.model.SavingsAccount;
import com.reto.indra.ms_retoindra_financial_product_backend.service.FinancialProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(FinancialProductController.class)
public class MsRetoindraFinancialProductBackendApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@MockBean
	private FinancialProductService financialProductService;

	@InjectMocks
	private FinancialProductController financialProductController;

	private CheckingAccount checkingAccount;
	private SavingsAccount savingsAccount;
	private CreditCard creditCard;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);

		checkingAccount = new CheckingAccount();
		checkingAccount.setOverdraftLimit(0.0);
		checkingAccount.setUniqueCode("QeCVfZKCyo+UFXLvrwmpVw==");
		checkingAccount.setCoinType("USD");
		checkingAccount.setTypeAndName();

		savingsAccount = new SavingsAccount();
		savingsAccount.setInterestRate(1.5);
		savingsAccount.setUniqueCode("QeCVfZKCyo+UFXLvrwmpVw==");
		savingsAccount.setCoinType("USD");
		savingsAccount.setTypeAndName();

		creditCard = new CreditCard();
		creditCard.setCreditLimit(0.0);
		creditCard.setUniqueCode("QeCVfZKCyo+UFXLvrwmpVw==");
		creditCard.setCoinType("USD");
		creditCard.setTypeAndName();
	}

	@Test
	public void testListFinancialProduct() {
		when(financialProductService.listFinancialProduct()).thenReturn(Flux.just(checkingAccount, savingsAccount, creditCard));

		webTestClient.get().uri("/api/financialProducts/")
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(FinancialProduct.class)
				.hasSize(3)
				.contains(checkingAccount, savingsAccount, creditCard);
	}

	@Test
	public void testFindByUniqueCode() {
		String encodedUniqueCode = "QeCVfZKCyo+UFXLvrwmpVw==";
		when(financialProductService.listFinancialProductByUniqueCode(encodedUniqueCode)).thenReturn(Flux.just(checkingAccount, savingsAccount, creditCard));

		webTestClient.get().uri(uriBuilder ->
						uriBuilder.path("/api/financialProducts/findByUniqueCode")
								.queryParam("uniqueCode", encodedUniqueCode)
								.build())
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(FinancialProduct.class)
				.hasSize(3)
				.contains(checkingAccount, savingsAccount, creditCard);
	}

	@Test
	public void testCreateFinancialProduct() {
		when(financialProductService.createFinancialProduct(any(FinancialProduct.class))).thenReturn(Mono.just(checkingAccount));

		webTestClient.post().uri("/api/financialProducts/create")
				.bodyValue(checkingAccount)
				.exchange()
				.expectStatus().isOk()
				.expectBody(FinancialProduct.class)
				.isEqualTo(checkingAccount);
	}
}