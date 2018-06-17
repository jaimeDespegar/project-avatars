package control;

public class OperatorScrollLastValue implements OperatorScroll {

	private Integer init; 
	private Integer secondValue;
	private Integer initSize;
	private Integer secondSize;
	
	public OperatorScrollLastValue(Integer initValue, Integer secondValue,Integer initSize,Integer secondSize) {
		this.init = initValue - 1;
		this.secondValue = secondValue - 1;
		this.initSize = initSize;
		this.secondSize = secondSize;
	}
	
	@Override
	public Integer getFirstInit() {
		return init;
	}
	
	@Override
	public Integer getSecondInit() {
		return secondValue;
	}
	
	@Override
	public Integer getOperation(Integer value) {
		value = value - 1;
		return value;
	}

	@Override
	public boolean isFinish(Integer size, Integer value) {
		return value >= size;
	}

	public Integer getInitSize() {
		return initSize;
	}
	
	public Integer getSecondSize() {
		return secondSize;
	}

}
