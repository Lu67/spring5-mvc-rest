package guru.springfamework.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

	CustomerService customerService;
	
	@Mock
	CustomerRepository customerRepository;
	
	@Mock 
	CustomerMapper customerMapper;
	
	private static Long ID = 123L;
	
	@Before
	public void setUp() {
		customerService = new CustomerServiceImpl(customerRepository, customerMapper);
	}
	
	@Test
	public void getAllCustomers() {
		List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());
		
		when(customerRepository.findAll()).thenReturn(customers);
		
		List<CustomerDTO> found = customerService.getAllCustomers();
		
		assertThat(found.size()).isEqualTo(customers.size());
	}
	
	@Test
	public void getCustomerById() {
		Customer customer = new Customer();
		customer.setId(ID);
		
		when(customerRepository.getOne(ID)).thenReturn(customer);
		
		CustomerDTO found = customerService.getCustomerById(ID);
		
		assertThat(found.getId()).isEqualTo(ID);
		
	}
	
	
	
	
	
	
	
}
