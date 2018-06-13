package control;

public interface OperatorScroll {

	public abstract Integer getFirstInit() ;
	public abstract Integer getSecondInit() ;
	public abstract Integer getInitSize();
	public abstract Integer getSecondSize();
	public abstract Integer getOperation(Integer value);
	public abstract boolean isFinish(Integer size, Integer value);
	
}
