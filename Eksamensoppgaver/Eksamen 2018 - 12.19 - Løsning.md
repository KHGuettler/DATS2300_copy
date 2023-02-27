# Eksamen 2018

## Oppgave 1

### c)

public void printInOrder() {
    if (this.left_child != null) {
        this.left_child.printInOrder()
    }

    system.out.println(this.value);

    if (this.right_child != null) {
        this.right_child.printInOrder()
    }

} 


## Oppgave 5

### b)

void remove(Node q) {
    if (q == head == tail) {
        head = tail = null;
    }

    if (q.next != null) {
        q.next.prev = q.prev;
    }

    if (q.prev != null) {
        q.prev.next = q.next;
    }
} 

### c)

void remove(int index) {
    throw new UnsupportedOperationException("Ikke kodet ennå!");
} 