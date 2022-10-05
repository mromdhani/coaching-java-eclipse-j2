package lu.cronos.service.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import lu.cronos.domain.Product;
import lu.cronos.repository.IProductsRepository;
import lu.cronos.service.ProductsServiceImpl;

public class ProductsServiceImplTest {

	private ProductsServiceImpl underTest;
	private IProductsRepository my_mock;

	@Before
	public void setUp() throws Exception {

		underTest = new ProductsServiceImpl();
		my_mock = mock(IProductsRepository.class);
	}

	@After
	public void tearDown() throws Exception {
		underTest = null;
	}

	@Test
	public final void testCalculerMontantFacture() {

		// Given
		when(my_mock.findAll()).thenReturn(
				Arrays.asList(new Product("P100", "Café", 10), new Product(
						"P200", "Thé", 20),
						new Product("P300", "Coca Cola", 30), new Product(
								"P400", "Jus d'orange", 40)));
		underTest.setRepo(my_mock);

		double expected = 90;

		// When -Then
		assertEquals(expected, underTest.calculerMontantFacture(), 0.01);

	}

}
