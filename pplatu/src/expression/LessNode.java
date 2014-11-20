package  expression;

import java.util.HashMap;
import java.util.HashSet;

public class LessNode implements ExpressionNode {
	ExpressionNode LeftOperand = null;
	ExpressionNode RightOperand = null;
	
	public LessNode(ExpressionNode leftOperand, ExpressionNode rightOperand){
		this.LeftOperand = leftOperand;
		this.RightOperand = rightOperand;
	}
	
	public int evaluate(int[] stateVector, ExpressionError errorCode){
		if(LeftOperand.evaluate(stateVector, errorCode) < RightOperand.evaluate(stateVector, errorCode))
			return 1;
		
		return 0;
	}
	
	public void addVariables(HashSet<VarNode> variables){
		LeftOperand.addVariables(variables);
		RightOperand.addVariables(variables);
	}
	
	@Override
	public String toString(){
		return LeftOperand.toString() + "<" + RightOperand.toString();
	}
	
	public ExpressionNode copy(HashMap<String, VarNode> variables){
		return new LessNode(this.LeftOperand.copy(variables), this.RightOperand.copy(variables));
	}
}
