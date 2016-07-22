package com.flipturnapps.jatohotkey;

public abstract class ConjunctiveTest implements Test 
{
	private Test second;
	private Test first;
	public ConjunctiveTest(Test firstTest, Test secondTest) 
	{
		first = firstTest;
		second = secondTest;
	}
	
	public Test getSecond() {
		return second;
	}

	public void setSecond(Test second) {
		this.second = second;
	}

	public Test getFirst() {
		return first;
	}

	public void setFirst(Test first) {
		this.first = first;
	}
}
