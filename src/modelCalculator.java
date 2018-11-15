import java.util.Stack;

public class modelCalculator {

    private RPN rpn = new RPN();

    public void setBuffor(String a) {
        rpn.setBuffor(a);
    }

    public String getCalculation() {

        rpn.doRNP();
        return rpn.countRPN();
    }

    /*public void change()
    {
        rpn.change();
    }*/
    public void clearCorrectBuffer() {
        rpn.correctBuffor.clear();
    }

    private static class RPN {
        private Stack<String> output;
        private Stack<String> stack;
        private Stack<String> calculation;
        private Stack<String> correctBuffor;


        private Stack<String> utility;
        private String[] buffor;


        public String[] getBuffor() {
            return buffor;
        }

        public void setBuffor(String buffor) {
            this.buffor = buffor.split("");
            this.change();


        }

        public void change() {
            //System.out.println("XD");

            String buf = new String("");
            for (String a : this.buffor) {
                //System.out.println(a);
                if (!isOperator(a)) {
                    buf += a;
                    //System.out.println("C");

                } else {
                    if (!buf.equals("")) {

                        correctBuffor.push(buf);
                        //System.out.println("A");
                        buf = "";
                    }
                    //System.out.println("B");

                    correctBuffor.push(a);
                }


            }
            if (!buf.equals("")) {
                correctBuffor.push(buf);
            }


        }

        /*public RPN(String buf)
        {
            output = new Stack();
            stack = new Stack();
            calculation = new Stack();
            this.buffor = buf.split("");




        }*/
        public RPN() {
            output = new Stack();
            stack = new Stack();
            calculation = new Stack();
            correctBuffor = new Stack();
        }


        private void doRNP() {
            System.out.println(correctBuffor.toString());
            for (String a : correctBuffor) {
                if (!isOperator(a)) {

                    output.push(a);
                } else if (a.equals("(")) {
                    stack.push(a);
                } else if (a.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        output.push(stack.pop());
                    }
                    stack.pop();
                } else if (isOperator(a)) {
                    if (stack.empty() || (priority(a) > priority(stack.peek()))) {
                        stack.push(a);
                    } else {
                        output.push(stack.pop());
                        stack.push(a);
                    }
                }
            }
            while (!stack.empty()) {
                output.push(stack.pop());
            }

            /*for(String a: output)
            {
                System.out.println(a);
            }*/
        }

        public String countRPN() {
            String temp = new String();

            for (String a : output) {
                if (!isOperator(a)) {
                    calculation.push(a);
                    //System.out.println(calculation.peek());

                } else {
                    switch (a) {
                        case "+":
                            temp = calculation.pop();
                            temp = Double.toString(Double.parseDouble(calculation.pop()) + Double.parseDouble(temp));
                            calculation.push(temp);

                            break;
                        case "-":
                            temp = calculation.pop();
                            temp = Double.toString(Double.parseDouble(calculation.pop()) - Double.parseDouble(temp));
                            calculation.push(temp);

                            break;
                        case "*":
                            temp = calculation.pop();
                            temp = Double.toString(Double.parseDouble(calculation.pop()) * Double.parseDouble(temp));
                            calculation.push(temp);
                            //System.out.println(calculation.peek());

                            break;
                        case "/":
                            temp = calculation.pop();
                            temp = Double.toString(Double.parseDouble(calculation.pop()) / Double.parseDouble(temp));
                            calculation.push(temp);

                            break;
                        case "^":
                            temp = calculation.pop();
                            temp = Double.toString(Math.pow(Double.parseDouble(calculation.pop()), Double.parseDouble(temp)));
                            calculation.push(temp);

                            break;

                        case "#":
                            temp = calculation.pop();
                            temp = Double.toString(Math.pow(Double.parseDouble(calculation.pop()), (1 / Double.parseDouble(temp))));
                            calculation.push(temp);

                            break;
                        /*case "=":

                            return calculation.pop();*/

                        default:

                            return "Eroor";


                    }
                }
            }
            //System.out.println("WYNIK");

            this.correctBuffor.clear();

            return calculation.pop();

        }


        private boolean isOperator(String v) {
            switch (v) {
                case "=":
                case "/":
                case "*":
                case ")":
                case "-":
                case "+":
                case "(":
                case "^":
                case "#":
                    return true;
                default:
                    return false;

            }
        }

        private int priority(String v) {
            switch (v) {
                case "(":
                    return 0;
                case "+":
                case "-":
                case ")":
                    return 1;
                case "*":
                case "/":
                    return 2;
                case "^":
                case "#":
                    return 3;
                case "=":
                    return 1;
                default:
                    return 99;
            }
        }

    }
}
