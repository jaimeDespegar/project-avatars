package control;

public interface OperatorScroll {

	Integer getFirstInit() ;
	Integer getSecondInit() ;
	Integer getInitSize();
	Integer getSecondSize();
	Integer getOperation(Integer value);
	boolean isFinish(Integer size, Integer value);
	
}
