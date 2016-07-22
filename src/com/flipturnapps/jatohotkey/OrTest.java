package com.flipturnapps.jatohotkey;

public class OrTest extends ConjunctiveTest {

	public OrTest(Test firstTest, Test secondTest) 
	{
		super(firstTest, secondTest);
	}

	@Override
	public boolean isPassing() 
	{
		return getFirst().isPassing() || getSecond().isPassing();
	}

}
