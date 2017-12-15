package ru.danileyko;

import org.junit.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.danileyko.dao.DeviceDao;
import ru.danileyko.model.Device;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Runnet1Application.class)
public class Runnet1ApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private DeviceDao deviceDao;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void getAlldevTest() throws Exception{
		final ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/alldev")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		List<Device> devices = deviceDao.getAllDevices();
		assertTrue(devices.size() >0);
	}
}
