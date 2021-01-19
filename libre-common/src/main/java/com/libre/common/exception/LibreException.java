package com.libre.common.exception;


import com.libre.common.tookit.result.IResultCode;
import com.libre.common.tookit.result.R;
import org.springframework.lang.Nullable;

/**
 * 业务异常
 *
 * @author L.cm
 */
public class LibreException extends RuntimeException {
	private static final long serialVersionUID = 2359767895161832954L;

	@Nullable
	private final R<?> result;

	public LibreException(R<?> result) {
		super(result.getMsg());
		this.result = result;
	}

	public LibreException(IResultCode rCode) {
		this(rCode, rCode.getMsg());
	}

	public LibreException(IResultCode rCode, String message) {
		super(message);
		this.result = R.fail(rCode, message);
	}

	public LibreException(String message) {
		super(message);
		this.result = null;
	}

	public LibreException(Throwable cause) {
		this(cause.getMessage(), cause);
	}

	public LibreException(String message, Throwable cause) {
		super(message, cause);
		doFillInStackTrace();
		this.result = null;
	}

	@Nullable
	@SuppressWarnings("unchecked")
	public <T> R<T> getResult() {
		return (R<T>) result;
	}

	/**
	 * 提高性能
	 * @return Throwable
	 */
	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}

	public Throwable doFillInStackTrace() {
		return super.fillInStackTrace();
	}

}
