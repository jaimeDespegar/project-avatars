package control;

public class OperatorScrollFirstValue implements OperatorScroll {

	private Integer initSize;
	private Integer secondSize;
	
	public OperatorScrollFirstValue(Integer initSize, Integer secondSize) {
		this.initSize = initSize;
		this.secondSize = secondSize;
	}
	
	public Integer getFirstInit() {
		return 0;
	}
	
	public Integer getSecondInit() {
		return 0;
	}
	
	public Integer getOperation(Integer value) {
		value = value + 1;
		return value;
	}

	public boolean isFinish(Integer size, Integer value) {
		return value < size;
	}

	public Integer getInitSize() {
		return initSize;
	}

	public Integer getSecondSize() {
		return secondSize;
	}

}
