package com.bestgamesreviewstest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bestgamesreviews.dao.AvisDAO;
import com.bestgamesreviews.entity.Avis;
import com.bestgamesreviews.service.AvisServiceImpl;

public class AvisTest {

	@Mock
	AvisDAO avisDAO;

	@Mock
	AvisServiceImpl avisServiceImpl;
	
	@Mock
	Avis avis = new Avis();

//	@Test
//	void should_Fail() {
//		fail();
//	}
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		avisServiceImpl = new AvisServiceImpl();
		avisServiceImpl.setDAO(avisDAO);
	}
	
	@Test
	void should_not_return_null_avis() {
		when(avisDAO.save(avis)).thenReturn(avis);
		boolean result = avisServiceImpl.addAvis(avis).equals(null);
		assertFalse(result);
		verify(avisDAO).save(avis);
	}
	
	/*
	@Test
	void should_not_return_same_item_avis () {
		Avis avis = new Avis();
		when(avisDAO.save(avis)).thenReturn();
		boolean result = avisServiceImpl.addAvis(avis).getId().equals(avis.getId());
		assertFalse(result);
		verify(avisDAO).save(avis);
	}
	*/
}
