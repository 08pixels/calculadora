package calculadora;

import java.util.ArrayList;

public class Calculadora {

	ArrayList<Integer> operator = new ArrayList<Integer>();
	ArrayList<Integer> operand = new ArrayList<Integer>();
	
	public static final int PLUS = 1;
	public static final int MINUS = 2;
	public static final int TIMES = 3;
	public static final int DIVIDE = 4;
	
	public void addOperand(int e, boolean op) {
		if(op)
			operand.add(0, e);
		else
			operand.add(0, -e);
	}
	
	public void addOperator(int operator) {
		this.operator.add(operator);
	}
	
	public int calcula(int pos, int op){
		int answer;
		
		if(op == TIMES)
			answer = operand.get(pos) * operand.get(pos+1);
		else
			answer = operand.get(pos) / operand.get(pos+1);
		
		operand.remove(pos); operand.remove(pos);
		operator.remove(pos);
		return answer;
	}
	
	public void precedencia(){
		int answer = 0;
		int pos_TIMES = -1;
		int pos_DIVIDE= -1;
		
		while(true)
		{
			if(operator.contains(TIMES))
				pos_TIMES = operator.indexOf(TIMES);
			if(operator.contains(DIVIDE))
				pos_DIVIDE = operator.indexOf(DIVIDE);
			
			if((pos_TIMES == -1 && pos_DIVIDE == -1) || operand.size() == 0)
				return;
			
			if(pos_TIMES != -1 && pos_DIVIDE != -1)
				if(pos_TIMES < pos_DIVIDE)
					operand.add(pos_TIMES, calcula(pos_TIMES, TIMES));
				else
					operand.add(pos_DIVIDE, calcula(pos_DIVIDE, DIVIDE));
				
			else if (pos_TIMES != -1)
				operand.add(pos_TIMES, calcula(pos_TIMES, TIMES));
			else
				operand.add(pos_DIVIDE, calcula(pos_DIVIDE, DIVIDE));
			
			pos_TIMES = pos_DIVIDE = -1;
			
		}
		
	}
	
	public int imprime() {
		precedencia();
		int answer = operand.get(0);
		
		for(int i = 1; i < operand.size(); i++) {
			switch(operator.get(i-1)) {
				case PLUS:	answer += operand.get(i); break;
				case MINUS:	answer -= operand.get(i);;
			}
		}
		
		operand.clear(); operator.clear();
		return answer;
	}
}
