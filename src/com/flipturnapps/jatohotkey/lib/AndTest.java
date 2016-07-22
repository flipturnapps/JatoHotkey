package com.flipturnapps.jatohotkey.lib;

public class AndTest extends ConjunctiveTest {

	public AndTest(Test firstTest, Test secondTest) 
	{
		super(firstTest, secondTest);
	}

	@Override
	public boolean isPassing() 
	{
		return getFirst().isPassing() && getSecond().isPassing();
	}

}
