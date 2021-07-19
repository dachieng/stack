public class Stack {
    int[] candy_dispenser;

    public Stack() {
        this.candy_dispenser = new int[5];
    }

    public int countStack() {
        // count the number of items in the stack
        int count = 0;
        for (int i = 0; i < this.candy_dispenser.length; i++) {
            // if stack item is not empty increment
            if (this.candy_dispenser[i] == 1) {
                count += 1;
            }
        }
        return count;
    }

    public boolean isEmpty() {
        if (this.candy_dispenser[0] == 1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isFull() {
        if (this.candy_dispenser[4] == 0) {
            return false;
        } else {
            return true;
        }
    }

    // add item to stack

    public void push() {
        // if stack is not full add element
        if (!this.isFull()) {
            this.candy_dispenser[this.countStack()] = 1;
        } else {
            System.out.println("Stack is Full");
        }
    }

    public void pop() {
        if (!this.isEmpty()) {
            this.candy_dispenser[this.countStack() - 1] = 0;
        } else {
            System.out.println("Stack is empty");
        }
    }

}