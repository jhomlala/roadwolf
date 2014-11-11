package roadwolf;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.jhomlala.spring.controller.Startup;
import com.jhomlala.spring.model.Voivodeship;

public class VoivodeshipListTest {

	List <Voivodeship> voivodeshipList = Startup.getTerritorialMapper().getVoivodeshipList();
	@Test
	public void countVoivodeships()
	{
		int count=0;
		for (int k=0;k<voivodeshipList.size();k++)
		{
			count++;
		}
		assertEquals(19,count);
	}
}
