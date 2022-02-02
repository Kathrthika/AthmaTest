package com.athma.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsTest {
	@BeforeTest
	public void beforetest() {
		System.out.println("beforetest");
	}
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("beforeclass");
	}

	@BeforeMethod
	public void beforemethod() {
		System.out.println("beforemethod");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	

	@Test
	public void test2() {
		System.out.println("test2");
	}
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("aftermethod");
	}

	@AfterClass
	public void afterclass() {
		System.out.println("afterclass");
	}
	@AfterTest
	public void aftertest() {
		System.out.println("aftertest");
	}
	
	@BeforeGroups
	public void beforegroup() {
		System.out.println("beforegroup");
	}
	
	@AfterGroups
	public void aftergroups() {
		System.out.println("aftergroup");
	}
	
}
