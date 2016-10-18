package ci.innovlabs.PoissonnerieCore;

public class ResponseData {
	public static final int SUCCESS = 0;
	public static final int ERROR = -1;
	public static final int ERROR_EXCEPTION = -2;
	public static final String MESSAGE_OK = "OK";
	
	private int responseCode;
	private String message;
	private Object data;
	
	public ResponseData() {}
	
	public ResponseData(Object data) {
		this.responseCode = SUCCESS;
		this.message = MESSAGE_OK;
		this.data = data;
	}
	
	public ResponseData(String message, Object data) {
		this.responseCode = SUCCESS;
		this.message = message;
		this.data = data;
	}
	
	public ResponseData(int responseCode, String message) {
		this.responseCode = responseCode;
		this.message = message;
	}
	
	public ResponseData(int responseCode, String message, Object data) {
		this.responseCode = responseCode;
		this.message = message;
		this.data = data;
	}
	
	public static ResponseData exceptionMessage(String message){
		return new ResponseData(ERROR_EXCEPTION, message, null);
	}
	
	public static ResponseData standardErrorMessage(String message){
		return new ResponseData(ERROR, message, null);
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
