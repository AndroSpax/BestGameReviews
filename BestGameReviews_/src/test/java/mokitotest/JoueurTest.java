package mokitotest;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.bestgamesreviews.entity.Joueur;

public class JoueurTest {
	
	@Mock
	private Joueur joueur;
	
	@Test
	void not_implement() {
		fail("Not implement");
	}
	
	
}
