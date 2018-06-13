package control;

public class OperatorScrollFirstValue implements OperatorScroll {

	private Integer initSize;
	private Integer secondSize;
	
	public OperatorScrollFirstValue(Integer initSize, Integer secondSize) {
		this.initSize = initSize;
		this.secondSize = secondSize;
	}
	
	@Override
	public Integer getFirstInit() {
		return 0;
	}
	
	@Override
	public Integer getSecondInit() {
		return 0;
	}
	
	@Override
	public Integer getOperation(Integer value) {
		value = value + 1;
		return value;
	}

	@Override
	public boolean isFinish(Integer size, Integer value) {
		return value < size;
	}

	@Override
	public Integer getInitSize() {
		return initSize;
	}

	@Override
	public Integer getSecondSize() {
		return secondSize;
	}

}
