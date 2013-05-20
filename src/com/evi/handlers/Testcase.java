package com.evi.handlers;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.evi.utils.Timer;

									
@XmlType(propOrder={"question", "expectedAnswer" , "executionTime", "maxTimeOut", "resultReturnedInTime","resultOfQuestion" })
@XmlRootElement
public class Testcase {
	private int timeOut;
	private long start;
	private long end;
	private Timer time = new Timer();
	private String question;
	private String answer;
	private long duration;
	private boolean testResult;
	private boolean withinTime;

	private String response;
	public Testcase(){
		
	}
	public Testcase(String question, String answer, String timeOut) {
		this.question = question;
		this.answer = answer;
		this.timeOut = Integer.parseInt(timeOut);
	}
	@XmlElement(name="Question")
	public void setQuestion(String value) {
		this.question = value;
	}

	
	public String getQuestion() {
		return this.question;
	}
	@XmlElement(name="ExpectedAnswer")
	public void setExpectedAnswer(String value) {
		this.answer = value;
	}

	public String getExpectedAnswer() {
		return this.answer;
	}
	@XmlAttribute(name="ExecutionTime")
	public void setExecutionTime(long duration) {
		this.duration = duration;
	}
	
	public long getExecutionTime() {
		duration = time.getDuration();
		return duration;
	}
	@XmlAttribute(name="MaxTimeOut")
	public void setMaxTimeOut(int value) {
		timeOut = value;
	}

	public int getMaxTimeOut() {
		return timeOut;
	}

	public void startTimer() {
		time.start();
	}

	public void endTimer() {
		time.stop();
	}
	public boolean workOutWhetherWithinTime(){
		return time.withinTime(timeOut);
	}
	
	@XmlElement(name="AnsweredWithinTime", required=true)
	public void setResultReturnedInTime(boolean withinTime){
		this.withinTime = withinTime;
		 
	}
	public boolean getResultReturnedInTime() {
		return withinTime;
	}
	@XmlTransient
	public void setResponse(String response) {
		this.response = response;

	}
	public String getResponse() {
		return this.response;
	}
	@XmlElement(name="CorrectAnswerReturned", required=true)
	public void setResultOfQuestion(boolean result) {
		testResult = result;
	}

	public boolean getResultOfQuestion() {
		return testResult;
	}


}
