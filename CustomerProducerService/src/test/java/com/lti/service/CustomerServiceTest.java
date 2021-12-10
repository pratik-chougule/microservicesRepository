package com.lti.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
{
	
	//private static final int id=1;
	/*
	
	@Mock
	private CustomerRepository customerRepository; 
    
	@Autowired
	CustomerService customerService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		//this.customerService=new CustomerService(this.customerRepository);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllCustomers() {

		
		customerService.getAllCustomers();
		verify(customerRepository).findAll();

		
	}

	@Test
	void testFindById() {
		
		
		
		 //customerService.findById(id); verify(customerRepository).findById(id);
		 
		
		
	}

	@Test
	void testSaveCustomer() {


		
		  Customer customer = mock(Customer.class);
		  customerService.saveCustomer(customer);
		 verify(customerRepository).save(customer);
		 

		Customer customer = new Customer();
		customer.setId(101);
		//customer.setName("Pratik");
		customer.setAge(25);
		customer.setTypeOfAccount("saving");
		customer.setAddress(new Address());
		
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		assertThat(customerService.saveCustomer(customer)).isEqualTo(customer);

	}

	@Test
	void testUpdateCustomer() {

//		Customer customer = mock(Customer.class);
//		when(customer.getId()).thenReturn(id);
//		when(customer.getName()).thenReturn("pratik");
//		when(customer.getAge()).thenReturn(25);
//		when(customer.getTypeOfAccount()).thenReturn("saving");
//		//when(customer.getAddress()).thenReturn("");
//		when(customerRepository.findOne(id)).thenReturn(customer);
//		customerService.updateCustomer(customer);
//		verify(customerRepository.save(customer));
		
		
	}

	@Test
	void testDeleteById() {

		/*
		 * customerService.deleteById(id); verify(customerRepository).deleteById(id);
		 */

		
	
		
	}
	
	
}
