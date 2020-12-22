package Utils;

import java.time.DateTimeException;

public class MyException extends Exception {
	public String message;
	public String reason;
	public StackTraceElement StackTrace;
	public DateTimeException time;
	
}
